package br.com.consumer

import org.apache.kafka.clients.consumer.KafkaConsumer
import java.time.Duration
import java.util.Collections

class EmailNewOrderConsumer {

    private val topic: String = "ECOMMERCE_EMAIL";
    private val deserializerClass: String = "org.apache.kafka.common.serialization.StringDeserializer";

    fun createConsumer() {
        val properties = ConsumerProperties(
            EmailNewOrderConsumer::class.java.simpleName,
            deserializerClass).createProperties();
        val consumer: KafkaConsumer<String, String> = KafkaConsumer<String, String>(properties as Map<String, Any>?);
        consumer.subscribe(Collections.singletonList(topic));

        while (true) {
            var records = consumer.poll(Duration.ofMillis(100))
            if (!records.isEmpty) {
                for (record in records) {
                    println("item : ${record.value()}")
                    Thread.sleep(2000);
                }
            }
        }
    }
}