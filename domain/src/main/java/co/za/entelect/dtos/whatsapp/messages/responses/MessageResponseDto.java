package co.za.entelect.dtos.whatsapp.messages.responses;

import co.za.entelect.dtos.whatsapp.generic.ContactDto;
import co.za.entelect.dtos.whatsapp.generic.MessageDto;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MessageResponseDto {
    private String messaging_product;
    private ContactDto[] contacts;
    private MessageDto[] messages;
}
