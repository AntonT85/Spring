package ru.diasoft.example.stream;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

public interface ConsumerChannels {

    String DEMO_INPUT = "demoInput";

    @Input(DEMO_INPUT)
    SubscribableChannel demoInput();
}
