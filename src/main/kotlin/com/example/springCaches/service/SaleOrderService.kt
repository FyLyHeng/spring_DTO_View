package com.example.springCaches.service

import ch.mfrey.jackson.antpathfilter.AntPathFilterMixin
import ch.mfrey.jackson.antpathfilter.AntPathPropertyFilter
import com.example.springCaches.configuration.AntPathFilterMappingJacksonValue
import com.example.springCaches.model.DTO.*
import com.example.springCaches.model.SaleOrder
import com.example.springCaches.repo.SaleOrderDTORepository
import com.example.springCaches.repo.SaleOrderRepository
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.databind.ser.FilterProvider
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider
import org.modelmapper.ModelMapper
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Sort
import org.springframework.stereotype.Service
import java.util.*
import java.util.stream.Collectors
import javax.persistence.criteria.Join
import javax.persistence.criteria.JoinType
import javax.persistence.criteria.Predicate


@Service
class SaleOrderService {

    @Autowired
    lateinit var saleOrderRepository : SaleOrderRepository
    @Autowired
    lateinit var saleOrderDTORepository: SaleOrderDTORepository
    @Autowired
    lateinit var modelMapper : ModelMapper


    fun findAllByOBJMapping (): MutableList<OBJMappingDTO>? {
        return saleOrderRepository.findAll().stream().map { saleOrder -> modelMapper.map(saleOrder, OBJMappingDTO::class.java) }
            .collect(Collectors.toList())
    }

    fun findAllByDTOClass (): List<SaleOrder> {
//        return saleOrderDTORepository.findAll(SaleOrderDTO::class.java)
        return saleOrderDTORepository.findAll()
    }

    fun findAllByDTOInterface (): List<SaleOrder> {
//        return saleOrderDTORepository.findAll(SaleOrderView::class.java)
        return saleOrderDTORepository.findAll()
    }

    fun findAllByRawDTO (): MutableList<RawDTO> {
        return saleOrderDTORepository.rawFindAll()
    }


    fun findAllByJsonConfig (): ObjectMapper {

        val filter = arrayOf("*", "*.*", "!saleOrderDetail")

        val objectMapper = ObjectMapper()
        objectMapper.addMixIn(SaleOrder::class.java, AntPathFilterMixin::class.java)

        val filterProvider: FilterProvider = SimpleFilterProvider().addFilter("antPathFilter", AntPathPropertyFilter(*filter))
        objectMapper.setFilters(filterProvider)

        objectMapper.writeValueAsString(saleOrderRepository.findAll())

        return objectMapper
    }

    fun getSomeObject(): AntPathFilterMappingJacksonValue<List<SaleOrder>>? {
        return AntPathFilterMappingJacksonValue(saleOrderRepository.findAll(), "*", "*.*", "!saleOrderDetail")
    }


    /**
     * Query + DTO + cricture
     */
    fun findAllByUsingCustomAPI(): Page<SaleOrderDTOCustomAPI> {

        val totalQty = 10

        val rs = saleOrderRepository.findAll({ root, cq, cb ->
            val predicates = ArrayList<Predicate>()
            val saleDetail: Join<Objects, Objects> = root.join("saleOrderDetail", JoinType.LEFT)
            cq.multiselect(root, saleDetail)
            cq.distinct(true)

            totalQty.let {
                val cusId = cb.equal(root.get<String>("totalQty"), totalQty)
                predicates.add(cusId)
            }

            cb.and(*predicates.toTypedArray())
        }, SaleOrderDTOCustomAPI::class.java, PageRequest.of(0, 10, Sort.by(Sort.Direction.DESC, "id")))
        return rs
    }
}