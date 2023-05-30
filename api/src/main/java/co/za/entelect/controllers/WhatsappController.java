package co.za.entelect.controllers;

import co.za.entelect.dtos.UserMessageRequest;
import co.za.entelect.dtos.whatsapp.messages.requests.PlainTextDto;
import co.za.entelect.dtos.whatsapp.messages.responses.MessageResponseDto;
import co.za.entelect.services.WhatsappService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/whatsapp")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class WhatsappController {
    private final WhatsappService whatsappService;

    @Autowired
    public WhatsappController(WhatsappService whatsappService) {
        this.whatsappService = whatsappService;
    }

//    @PostMapping
//    public MessageResponseDto sendMessage(@RequestBody PlainTextDto messageRequest){
//        return whatsappService.sendMessage(messageRequest);
//    }

    @PostMapping
    public MessageResponseDto test(@RequestBody UserMessageRequest userMessageRequest){
        System.out.println("1");
        return whatsappService.processMessage(userMessageRequest.getPhoneNumber(), userMessageRequest.getText());
    }
}
