package com.tstu.filerecieverclient.service.filestorage;

import com.tstu.filerecieverclient.exception.FileStorageException;
import com.tstu.filerecieverclient.property.FileStorageProperties;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

@Slf4j
@Service
public class FileStorageServiceImpl implements FileStorageService {

    private final Path fileStorageLocation;

    @Autowired
    public FileStorageServiceImpl(FileStorageProperties fileStorageProperties) {
        this.fileStorageLocation = Paths.get(fileStorageProperties.getUploadDir())
                .toAbsolutePath().normalize();

        try {
            Files.createDirectories(this.fileStorageLocation);
        } catch (Exception ex) {
            throw new FileStorageException("Не удалось создать каталог, в котором будут храниться загруженные файлы", ex);
        }
    }

    @Override
    public String storeFileFromUrl(String imageUrl) {

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<byte[]> response = restTemplate.getForEntity(imageUrl, byte[].class);
        InputStream targetStream = null;
        String fileName = response.getHeaders().getContentDisposition().getFilename();

        if(response.getBody() != null) {
            targetStream = new ByteArrayInputStream(response.getBody());
        } else {
            throw new FileStorageException("Пустое изображение" + fileName);
        }
        try {
            Path targetLocation = this.fileStorageLocation.resolve(fileName);
            Files.copy(targetStream, targetLocation, StandardCopyOption.REPLACE_EXISTING);
            log.info("Файл {} сохранен", fileName);
            return fileName;
        } catch (IOException ex) {
            throw new FileStorageException("Не удалось сохранить файл " + fileName,  ex);
        }
    }

}
