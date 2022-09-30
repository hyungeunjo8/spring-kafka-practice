package com.example.springkafkapracticekotlin

import org.springframework.kafka.annotation.KafkaHandler
import org.springframework.kafka.annotation.KafkaListener
import org.springframework.stereotype.Component

@Component
@KafkaListener(
    containerFactory = "concurrentKafkaListenerContainerFactory",
    groupId = "group_id",
    topics = ["test_topic"]
)
class Listener {
    @KafkaHandler
    fun consume(consumeObject: ConsumeObject) {
        println(consumeObject.id)
        println(consumeObject.value)
    }

    @KafkaHandler(isDefault = true)
    fun unknown(unknown: Any?) {
        println(unknown)
    }
}
