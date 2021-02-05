package com.example.test.kafka;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;

import java.util.Arrays;

public class KafkaReciever {
    public static void main(String[] args) {

        new Thread(()->{
            KafkaReciever.startConsumer("test","test","消费者1");
        }).start();
        new Thread(()->{
            KafkaReciever.startConsumer("test","test","消费者2");
        }).start();
    }
    public static void startConsumer(String group ,String topic,String consumerName){
        KafkaConsumer<String,String> consumer = KafkaTest.getConsumer(group);
        consumer.subscribe(Arrays.asList(topic));
        while(true){
            ConsumerRecords<String, String> records = consumer.poll(100);
            for (ConsumerRecord<String, String> record : records) {
                System.out.println("-----------------");
                System.out.printf("consumer="+consumerName+" ,offset = %d, value = %s", record.offset(), record.value());
                System.out.println();
            }

        }
    }

}
