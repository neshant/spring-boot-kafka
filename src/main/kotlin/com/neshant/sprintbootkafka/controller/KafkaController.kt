package com.neshant.sprintbootkafka.controller

import com.neshant.sprintbootkafka.service.Producer
import mu.KotlinLogging
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/kafka")
class KafkaController(private val producer: Producer) {

    private val logger = KotlinLogging.logger { }

    @PostMapping("/publish")
    fun sendMessageToKafkaTopic(@RequestParam("message") message: String) {
        logger.info("received $message")
        producer.test(message)
    }
}