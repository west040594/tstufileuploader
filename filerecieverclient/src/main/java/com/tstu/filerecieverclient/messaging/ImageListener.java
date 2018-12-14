package com.tstu.filerecieverclient.messaging;

import com.tstu.filerecieverclient.service.filestorage.FileStorageService;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor

public class ImageListener {

    private final FileStorageService fileStorageService;

    @KafkaListener(topics="images")
    public void handle(String imageUrl) {
        fileStorageService.storeFileFromUrl(imageUrl);
    }
}
