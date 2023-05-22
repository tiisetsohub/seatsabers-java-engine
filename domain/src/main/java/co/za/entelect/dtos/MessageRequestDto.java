package co.za.entelect.dtos;

import co.za.entelect.entities.MessageRequest;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class MessageRequestDto {
    private String messaging_product;
    private String to;
    private String type;
    private TemplateDto template;

    public static MessageRequestDto fromEntity(MessageRequest messageRequest){
        return MessageRequestDto.builder()
                .messaging_product(messageRequest.getMessaging_product())
                .to(messageRequest.getTo())
                .type(messageRequest.getType())
                .template(messageRequest.getTemplate())
                .build();
    }
}
