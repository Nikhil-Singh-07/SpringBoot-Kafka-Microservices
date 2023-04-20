package com.project.realworld.springboot;

import com.launchdarkly.eventsource.EventHandler;
import com.launchdarkly.eventsource.MessageEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;

public class WikimediaChangesHandler implements EventHandler{

    private static final Logger logger = LoggerFactory.getLogger(WikimediaChangesHandler.class);
    private KafkaTemplate<String, String>kafkaTemplate;
    private String topic;

    //$ bin/kafka-console-consumer.sh --topic wikimedia_recentchange --from-beginning --bootstrap-server localhost:9092

    public WikimediaChangesHandler(KafkaTemplate<String, String>kafkaTemplate, String topic){
        this.kafkaTemplate = kafkaTemplate;
        this.topic = topic;
    }


    @Override
    public void onOpen() throws Exception {

    }

    @Override
    public void onClosed() throws Exception {

    }

    @Override
    public void onMessage(String s, MessageEvent messageEvent) throws Exception {
        logger.info(String.format("Message Sent Receive -> ", messageEvent.getData()));
        kafkaTemplate.send(topic, messageEvent.getData());
    }

    @Override
    public void onComment(String s) throws Exception {

    }

    @Override
    public void onError(Throwable throwable) {

    }
}
