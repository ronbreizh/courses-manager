//package fr.pmu.coursesmanager.kafka;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.kafka.annotation.KafkaListener;
//import org.springframework.stereotype.Service;
//
//import java.io.IOException;
//
//@Service
//public class Consumer {
//
//    private static final Logger LOGGER = LoggerFactory.getLogger(Consumer.class);
//
//    @KafkaListener(topics = "users", groupId = "consumer_courses_manager")
//    public void consume(String message) throws IOException {
//        LOGGER.info(String.format("#### -> Consumed message -> %s", message));
//    }
//
//}
