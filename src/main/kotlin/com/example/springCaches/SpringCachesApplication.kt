package com.example.springCaches

import org.modelmapper.ModelMapper
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean
import org.springframework.data.jpa.repository.config.EnableJpaRepositories
import org.springframework.scheduling.annotation.EnableScheduling
import org.springframework.transaction.annotation.EnableTransactionManagement
import th.co.geniustree.springdata.jpa.repository.support.JpaSpecificationExecutorWithProjectionImpl

@EnableJpaRepositories(repositoryBaseClass = JpaSpecificationExecutorWithProjectionImpl::class)
@SpringBootApplication
@EnableScheduling
@EnableTransactionManagement
class SpringCachesApplication{
	@Qualifier
	@Bean
	fun modelMapper(): ModelMapper {
		return ModelMapper()
	}
}

fun main(args: Array<String>) {
	runApplication<SpringCachesApplication>(*args)
}
