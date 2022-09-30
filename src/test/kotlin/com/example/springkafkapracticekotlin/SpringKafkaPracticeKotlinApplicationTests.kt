package com.example.springkafkapracticekotlin

import org.apache.kafka.clients.consumer.ConsumerConfig
import org.apache.kafka.clients.producer.ProducerConfig
import org.apache.kafka.common.serialization.StringSerializer
import org.junit.jupiter.api.Test
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.kafka.core.DefaultKafkaProducerFactory
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.kafka.core.ProducerFactory

@SpringBootTest
class SpringKafkaPracticeKotlinApplicationTests {

    @Test
    fun produce() {
        val kafkaTemplate = KafkaTemplate(producerFactory())
        kafkaTemplate.send(
            "test_topic",
            "group_id",
            "{\n" +
                "    \"id\": \"123\",\n" +
                "    \"value\": \"456\"\n" +
                "}")
    }

    fun producerFactory(): ProducerFactory<String, String> {
        val config: MutableMap<String, Any> = HashMap()
        config[ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG] = "127.0.0.1:9092"
        config[ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG] = StringSerializer::class.java
        config[ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG] = StringSerializer::class.java
        return DefaultKafkaProducerFactory(config)
    }
}
