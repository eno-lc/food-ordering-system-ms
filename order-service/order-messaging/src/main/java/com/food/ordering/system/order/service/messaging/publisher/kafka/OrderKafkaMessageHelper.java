package com.food.ordering.system.order.service.messaging.publisher.kafka;


import com.food.ordering.system.kafka.order.avro.model.PaymentRequestAvroModel;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFutureCallback;

@Slf4j
@Component
public class OrderKafkaMessageHelper {

    public <T> ListenableFutureCallback<SendResult<String, T>> getKafkaCallback(String respontAvroModel, T requestAvroModel, String orderId, String requestAvroModelName) {
        return new ListenableFutureCallback<SendResult<String, T>>() {
            @Override
            public void onFailure(Throwable ex) {
                log.error("Error sending " + requestAvroModelName + " to topic: {}, message: {}", respontAvroModel, requestAvroModel.toString(), ex);
            }

            @Override
            public void onSuccess(SendResult<String, T> result) {
                RecordMetadata recordMetadata = result.getRecordMetadata();
                log.info("Successfully sent " + requestAvroModelName + " for order id {}, to topic: {}, partition: {}, offset: {}, message: {}, timestamp: {}", orderId, recordMetadata.topic(), recordMetadata.partition(), recordMetadata.offset(), requestAvroModel.toString(), recordMetadata.timestamp());
            }
        };
    }
}
