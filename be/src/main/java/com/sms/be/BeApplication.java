package com.sms.be;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.sms.be.model.Data;
import com.sms.be.service.DataService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@SpringBootApplication
public class BeApplication {

    public static void main(String[] args) {
        SpringApplication.run(BeApplication.class, args);
    }


    @Bean
    CommandLineRunner runner(DataService dataService) {
        return args -> {
            // read JSON and load json
            ObjectMapper mapper = new ObjectMapper();
            mapper.registerModule(new JavaTimeModule());

            TypeReference<List<Data>> typeReference = new TypeReference<List<Data>>() {
            };
            InputStream inputStream = TypeReference.class.getResourceAsStream("/data.json");
            try {
                List<Data> list = mapper.readValue(inputStream, typeReference);
                for (Data object : list) {
                    dataService.saveData(object);
                }
                System.out.println("Users Saved!");
            } catch (IOException e) {
                System.out.println("Unable to save users: " + e.getMessage());
            }
        };
    }
}
