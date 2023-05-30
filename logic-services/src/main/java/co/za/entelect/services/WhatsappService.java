package co.za.entelect.services;

import co.za.entelect.dtos.whatsapp.messages.requests.PlainTextDto;
import co.za.entelect.dtos.whatsapp.messages.responses.MessageResponseDto;
import co.za.entelect.repositories.UserRepository;
import co.za.entelect.utils.UtilService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import static co.za.entelect.constants.WhatsappConstants.WHATSAPP_MESSAGE_URL;

@Service
public class WhatsappService {
    private final UtilService utilService;
    private RestTemplate restTemplate;
    private UserRepository userRepository;
    private MessageBuilderService messageBuilderService;

    @Autowired
    public WhatsappService(UtilService utilService, RestTemplate restTemplate, UserRepository userRepository, MessageBuilderService messageBuilderService) {
        this.utilService = utilService;
        this.restTemplate = restTemplate;
        this.userRepository = userRepository;
        this.messageBuilderService = messageBuilderService;
    }

    public boolean validateUser(String phoneNumber){
        var user = userRepository.findUserByPhoneNumber(phoneNumber);
        return user.isPresent();
    }

    public MessageResponseDto processMessage(String phoneNumber, String text ){
//        if (validateUser(phoneNumber)){
//            text = text.toLowerCase();
//        }
//        else {
//
//        }
        System.out.println("2");
        PlainTextDto response = messageBuilderService.buildPlainTextMessage(phoneNumber, text);
        System.out.println("4");
        System.out.println(response.toString());
        System.out.println("5");
        return sendMessage(response);
    }
    public MessageResponseDto sendMessage(PlainTextDto messageRequest){
        String json;
        try {
            json = new ObjectMapper().writeValueAsString(messageRequest);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

        HttpEntity<String> entity = utilService.generateWhatsappEntity(json);
        MessageResponseDto messageResponse = restTemplate.exchange(WHATSAPP_MESSAGE_URL, HttpMethod.POST, entity, MessageResponseDto.class).getBody();
        return messageResponse;
    }
}
