package com.example.BLPS;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;

@SpringBootApplication
public class StartApplication {
    public static void main(String[] args) throws IOException {

        SpringApplication.run(StartApplication.class, args);
    }
}