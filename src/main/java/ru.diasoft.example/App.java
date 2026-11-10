package ru.diasoft.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import ru.diasoft.example.stream.ConsumerChannels;

@SpringBootApplication
@EnableBinding(ConsumerChannels.class)
public class App {

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }

}
