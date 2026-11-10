package ru.diasoft.example.stream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MessageListener {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @StreamListener(ConsumerChannels.DEMO_INPUT)
    public void demoListener(String message) {
        logger.debug("Received from topic 'demo': {}", message);
    }
}
