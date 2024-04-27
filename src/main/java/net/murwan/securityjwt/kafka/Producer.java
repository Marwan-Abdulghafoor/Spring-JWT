package net.murwan.securityjwt.kafka;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import net.murwan.securityjwt.dto.RegisterRequestDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class Producer {
    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    private static final String TOPIC = "FIEPHRS_TOPIC";

    public void sendMessage(RegisterRequestDTO requestDTO) {
        ObjectMapper objectMapper = new ObjectMapper();
        String jsonRequest = null;
        try {
            jsonRequest = objectMapper.writeValueAsString(requestDTO);


            kafkaTemplate.send(TOPIC, jsonRequest);


        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }


}
