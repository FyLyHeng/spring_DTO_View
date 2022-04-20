package com.example.springCaches.configuration

import ch.mfrey.jackson.antpathfilter.AntPathPropertyFilter
import com.fasterxml.jackson.annotation.JsonFilter
import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter
import org.springframework.http.converter.json.MappingJacksonValue
import java.awt.PageAttributes


class AntPathMappingJackson2HttpMessageConverter(objectMapper: ObjectMapper?) : MappingJackson2HttpMessageConverter() {
    fun AntPathMappingJackson2HttpMessageConverter(originalObjectMapper: ObjectMapper) {
        (originalObjectMapper.copy().addMixIn(Any::class.java, HibernateAwareAntPathFilterMixin::class.java))
    }

    fun canWrite(clazz: Class<*>?, mediaType: PageAttributes.MediaType
    ?): Boolean {
        return AntPathFilterMappingJacksonValue::class.java.isAssignableFrom(clazz)
    }

    @JsonFilter("antPathFilter")
    @JsonIgnoreProperties("hibernateLazyInitializer", "handler")
    class HibernateAwareAntPathFilterMixin
}

class AntPathFilterMappingJacksonValue<T>(value: T, vararg filters: String?) :
    MappingJacksonValue(value!!) {
    init {
        setFilters(SimpleFilterProvider().addFilter("antPathFilter", AntPathPropertyFilter(*filters)))
    }
}