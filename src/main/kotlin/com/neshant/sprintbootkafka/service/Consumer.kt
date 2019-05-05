package com.neshant.sprintbootkafka.service

import mu.KotlinLogging
import org.springframework.kafka.annotation.KafkaListener
import org.springframework.kafka.support.KafkaHeaders
import org.springframework.messaging.handler.annotation.Header
import org.springframework.messaging.handler.annotation.Payload
import org.springframework.stereotype.Service

const val NEW_CUSTOMER_TOPIC_CONSUMER = "com.neshant.springbootkafka.event"

@Service
class Consumer {

    val logger = KotlinLogging.logger { }

    @KafkaListener(topics = [NEW_CUSTOMER_TOPIC_CONSUMER])
    fun processMessage(
        @Payload message: String,
        @Header(KafkaHeaders.RECEIVED_PARTITION_ID) partitions: List<Int>,
        @Header(KafkaHeaders.RECEIVED_TOPIC) topics: List<String>,
        @Header(KafkaHeaders.OFFSET) offsets: List<Long>
    ) {
        logger.info("{}-{}[{}] \"{}\"\n", topics[0], partitions[0], offsets[0], message)
    }
}