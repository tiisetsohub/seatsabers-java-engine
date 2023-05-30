package co.za.entelect.services;

import co.za.entelect.dtos.whatsapp.generic.TextDto;
import co.za.entelect.dtos.whatsapp.messages.requests.PlainTextDto;
import org.springframework.stereotype.Service;

@Service
public class MessageBuilderService {

    public PlainTextDto buildPlainTextMessage(String phoneNumber, String textBody){
        PlainTextDto plainText = PlainTextDto.builder()
                .text(
                        TextDto.builder()
                                .body(textBody)
                                .build()
                )
                .messaging_product("whatsapp")
                .to(phoneNumber)
                .type("text")
                .build();
        System.out.println("3");
        System.out.println(plainText.getMessaging_product());
        System.out.println(plainText.getTo());
        System.out.println(plainText.getType());
        System.out.println(plainText.getText());

        return plainText;
    }
}
