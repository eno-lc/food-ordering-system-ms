package com.food.ordering.system.kafka.producer.service.impl;

import com.food.ordering.system.kafka.producer.exception.KafkaProducerException;
import com.food.ordering.system.kafka.producer.service.KafkaProducer;
import lombok.extern.slf4j.Slf4j;
import org.apache.avro.specific.SpecificRecordBase;
import org.springframework.kafka.KafkaException;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

import javax.annotation.PreDestroy;
import java.io.Serializable;

@Slf4j
@Component
public class KafkaProducerImpl<K extends Serializable, V extends SpecificRecordBase> implements KafkaProducer<K,V> {

    private final KafkaTemplate<Serializable, SpecificRecordBase> kafkaTemplate;

    public KafkaProducerImpl(KafkaTemplate<Serializable, SpecificRecordBase> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @Override
    public void send(String topicName, Serializable key, SpecificRecordBase message, ListenableFutureCallback callback) {

        log.info("Sending message '{}' to topic '{}'", message, topicName);
        try {
            ListenableFuture<SendResult<Serializable, SpecificRecordBase>> kafkaResultFuture =  kafkaTemplate.send(topicName, key, message);
            kafkaResultFuture.addCallback(callback);
        } catch (KafkaException e) {
            log.error("Error on kafka producer with key '{}', message '{}' and exception {}", key, message, e.getMessage());
            throw new KafkaProducerException("Error on kafka producer with key '" + key + "', message '" + message + "' and exception " + e.getMessage());
        }
    }

    @PreDestroy
    public void close(){

        if(kafkaTemplate != null){
            log.info("Closing kafka producer");
            kafkaTemplate.destroy();
        }

    }
}
