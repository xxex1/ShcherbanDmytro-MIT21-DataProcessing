package com.example.phonecatalog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.example.phonecatalog")

public class PhoneCatalogApplication {

    public static void main(String[] args) {
        SpringApplication.run(PhoneCatalogApplication.class, args);
    }
}
