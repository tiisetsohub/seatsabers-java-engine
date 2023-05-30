package co.za.entelect.dtos.whatsapp.messages.requests;

import lombok.*;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class TemplateMessageDto {
    private String messaging_product;
    private String to;
    private String type;
}
