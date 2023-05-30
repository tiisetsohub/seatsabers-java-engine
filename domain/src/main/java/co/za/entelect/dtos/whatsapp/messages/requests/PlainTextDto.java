package co.za.entelect.dtos.whatsapp.messages.requests;

import co.za.entelect.dtos.whatsapp.generic.TemplateDto;
import co.za.entelect.dtos.whatsapp.generic.TextDto;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@NoArgsConstructor
@SuperBuilder
@ToString
public class PlainTextDto extends TemplateMessageDto {
    private TextDto text;

    public PlainTextDto(String messaging_product, String to, String type, TextDto text) {
        super(messaging_product, to, type);
        this.text = text;
    }

    public PlainTextDto(TextDto text) {
        this.text = text;
    }
}
