package com.neshant.sprintbootkafka

import com.github.javafaker.Faker
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean
import org.springframework.scheduling.annotation.EnableScheduling

@EnableScheduling
@SpringBootApplication
class SprintBootKafkaApplication {

    @Bean
    fun faker(): Faker {
        return Faker.instance()
    }
}

fun main(args: Array<String>) {
    runApplication<SprintBootKafkaApplication>(*args)
}