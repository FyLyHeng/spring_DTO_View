package com.example.springCaches.configuration

import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.beans.factory.FactoryBean
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.converter.HttpMessageConverter
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder
import org.springframework.web.servlet.config.annotation.EnableWebMvc
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter


@Configuration
@EnableWebMvc
class DispatcherConfiguration : WebMvcConfigurerAdapter() {

//    @Bean
//    fun jacksonObjectMapperFactory(): FactoryBean<ObjectMapper?> {
//        // Normal Jackson configuration
//         return  Jackson2ObjectMapperBuilder().serializers(LOCAL_DATETIME_SERIALIZER)
//            .serializationInclusion(JsonInclude.Include.NON_NULL);
//    }
//
//    @Bean
//    fun antpathJacksonConverter(): HttpMessageConverter<*>? {
//        return AntPathMappingJackson2HttpMessageConverter(jacksonObjectMapperFactory().getObject())
//    }
//
//    override fun extendMessageConverters(converters: MutableList<HttpMessageConverter<*>?>) {
//        converters.add(0, antpathJacksonConverter())
//    }
}