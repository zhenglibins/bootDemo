package com.example.test.kafka;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;

public class KafkaSender {
    public static void main(String[] args) {
        //KafkaTest.getProducer().send(new ProducerRecord<>("test","test msg"));
        KafkaProducer<String,String> sender= KafkaTest.getProducer();
        for(int i = 0;i<100000;i++){
            sender.send(new ProducerRecord<>("test","test msg"+i));
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        sender.close();
    }
}
