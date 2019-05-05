package com.neshant.sprintbootkafka.request

import com.fasterxml.jackson.annotation.JsonProperty
import java.util.UUID


data class Customer(
    @JsonProperty("customerId") val customerId: UUID = UUID.randomUUID(),
    @JsonProperty("customerName") val customerName: String,
    @JsonProperty("address") val address: Address,
    @JsonProperty("email") val email: String
)

data class Address(
    @JsonProperty("aptNo") val aptNo: String,
    @JsonProperty("streetName") val streetName: String,
    @JsonProperty("city") val city: String,
    @JsonProperty("isHomeAddress") val isHomeAddress: Boolean
)