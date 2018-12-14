package com.tstu.fileuploadserver.messaging;


import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class KafkaImageMessagingService  implements ImageMessagingService{


    private final KafkaTemplate<String, String> kafkaTemplate;

    @Override
    public void sendImageUrl(String imageUrl) {
        kafkaTemplate.send("images", imageUrl);
    }
}
