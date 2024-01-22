package com.cortadai;

import com.cortadai.entity.WikimediaData;
import com.cortadai.repository.WikimediaDataRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaDatabaseConsumer {
    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaDatabaseConsumer.class);

    private WikimediaDataRepository repository;

    public KafkaDatabaseConsumer(WikimediaDataRepository repository) {
        this.repository = repository;
    }

    @KafkaListener(topics = "${spring.kafka.topic}", groupId = "${spring.kafka.consumer.group-id}")
    public void consume(String eventMessage){
        LOGGER.info(String.format("Event message received -> %s", eventMessage));
        WikimediaData data = new WikimediaData();
        data.setWikiEventData(eventMessage);
        repository.save(data);
    }

}
