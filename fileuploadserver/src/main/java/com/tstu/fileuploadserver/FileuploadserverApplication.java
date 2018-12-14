package com.tstu.fileuploadserver;

import com.tstu.fileuploadserver.property.FileStorageProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties({
        FileStorageProperties.class
})
public class FileuploadserverApplication {

    public static void main(String[] args) {

        System.out.println("NORM");
        SpringApplication.run(FileuploadserverApplication.class, args);
    }

}

