package com.tstu.filerecieverclient;

import com.tstu.filerecieverclient.property.FileStorageProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties({
        FileStorageProperties.class
})
public class FilerecieverclientApplication {

    public static void main(String[] args) {
        SpringApplication.run(FilerecieverclientApplication.class, args);
    }

}

