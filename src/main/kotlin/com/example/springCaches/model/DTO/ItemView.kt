package com.example.springCaches.model.DTO

import org.springframework.beans.factory.annotation.Value


/**
 * cont: it perform all relational from DB: make api slow.
 *
 * pros: posiable to custom field with bind value to that new field
 *      but: need to write hard code of field name.
 */
interface ItemView {

    @get:Value("#{target.itemName + ' ' + target.cost}")
    var itemFullName : String

    var cost:Double
}