package co.za.entelect.services;

import co.za.entelect.dtos.whatsapp.messages.requests.ConfirmBookingsButtonsDto;
import co.za.entelect.dtos.whatsapp.messages.requests.HQLocationDto;
import co.za.entelect.dtos.whatsapp.messages.requests.OfficeListDto;
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
    private final RestTemplate restTemplate;
    private final UserRepository userRepository;
    private final MessageBuilderService messageBuilderService;

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
        String json;

        //CHECK USER EXISTS IN DATABASE
//        if (validateUser(phoneNumber)){
//            text = text.toLowerCase();
//        }
//        else {
//
//        }
        System.out.println("2");
        //FOR TESTING PURPOSE
        PlainTextDto response = messageBuilderService.buildPlainTextMessage(phoneNumber, text);
//        ConfirmBookingsButtonsDto response = messageBuilderService.buildConfirmBookingsButtonsMessage(phoneNumber);
//        HQLocationDto response = messageBuilderService.buildHQLocationMessage(phoneNumber);
//        OfficeListDto response = messageBuilderService.buildOfficeListMessage(phoneNumber);

        System.out.println("4");
        System.out.println(response.toString());
        System.out.println("5");
        try {
            json = new ObjectMapper().writeValueAsString(response);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        return sendMessage(json);
    }
    public MessageResponseDto sendMessage(String json){

        System.out.println("6");

        HttpEntity<String> entity = utilService.generateWhatsappEntity(json);
        return restTemplate.exchange(WHATSAPP_MESSAGE_URL, HttpMethod.POST, entity, MessageResponseDto.class).getBody();
    }
}
