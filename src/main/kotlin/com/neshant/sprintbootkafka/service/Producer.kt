package com.neshant.sprintbootkafka.service

import com.fasterxml.jackson.databind.ObjectMapper
import com.github.javafaker.Faker
import com.neshant.sprintbootkafka.request.Address
import com.neshant.sprintbootkafka.request.Customer
import mu.KotlinLogging
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.scheduling.annotation.Scheduled
import org.springframework.stereotype.Service

const val NEW_CUSTOMER_TOPIC = "com.neshant.springbootkafka.event"

@Service
class Producer(
    private val kafkaTemplate: KafkaTemplate<String, String>,
    private val mapper: ObjectMapper,
    private val faker: Faker
) {

    val logger = KotlinLogging.logger { }

    fun sendNewCustomerDetails() {
        for (i in 1..5) {
            val customer = Customer(
                customerName = faker.name().firstName(),
                address = Address(
                    aptNo = faker.address().buildingNumber(),
                    streetName = faker.address().streetName(),
                    city = faker.address().city(),
                    isHomeAddress = true
                ),
                email = faker.internet().emailAddress()
            )
            logger.info("sending customer details {}", customer)

            kafkaTemplate.send(NEW_CUSTOMER_TOPIC, mapper.writeValueAsString(customer))
        }
    }

    fun createNewCustomer(customer: Customer) {
        kafkaTemplate.send(NEW_CUSTOMER_TOPIC, mapper.writeValueAsString(customer))
    }

    @Scheduled(fixedDelay = 1000L)
    fun autoGenerateAndSendNewCustomers() {
        sendNewCustomerDetails()
    }
}