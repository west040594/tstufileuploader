package com.tstu.filerecieverclient.messaging;

import com.tstu.filerecieverclient.service.filestorage.FileStorageService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class ImageListener {

    private final FileStorageService fileStorageService;

    @KafkaListener(topics="images")
    public void handle(String imageUrl) {
        log.info("Доступно новое изображение по ссылке {}. Начинается скачивание...", imageUrl);
        fileStorageService.storeFileFromUrl(imageUrl);
    }
}
