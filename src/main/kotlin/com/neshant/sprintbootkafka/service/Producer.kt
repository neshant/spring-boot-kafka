package com.neshant.sprintbootkafka.service

import org.springframework.kafka.core.KafkaTemplate
import org.springframework.stereotype.Service

@Service
class Producer(private val kafkaTemplate: KafkaTemplate<String, String>) {
    fun test(message: String) {
        kafkaTemplate.send("com.neshant.springbootkafka.event", message)
    }
}