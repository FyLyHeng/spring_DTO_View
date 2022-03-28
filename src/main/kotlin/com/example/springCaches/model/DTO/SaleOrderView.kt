package com.example.springCaches.model.DTO

import com.fasterxml.jackson.annotation.JsonInclude
import org.springframework.beans.factory.annotation.Value
import org.springframework.data.annotation.Immutable
import org.springframework.stereotype.Component

@Immutable
@JsonInclude(JsonInclude.Include.NON_DEFAULT)
interface SaleOrderView {
    var id: Long
    var totalQty: Int


//    @get:Value("#{@authorMapper.buildAuthorDto(target.barcode)}")
//    var barcodeSale : AuthorClassDto

}


    /**
     * Child DTOs custom field
     */
/*    interface BarcodeSaleView {
        var barcode : String
    }

    interface SaleOrderSaleDetailView {
        var id: Long
        var qty: Float
        var amount: Double
    }
}*/

//class AuthorClassDto {
//    lateinit var barcode : String
//}

data class AuthorClassDto (var barcode:String)

@Component
class AuthorMapper {
    fun buildAuthorDto(barcode: String?): AuthorClassDto {
        val authorClassDto = AuthorClassDto(barcode?:"")
        //authorClassDto.barcode = barcode?:""
        return authorClassDto
    }
}