package co.za.entelect.dtos.whatsapp.messages.requests;

import co.za.entelect.dtos.whatsapp.generic.InteractiveDto;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@NoArgsConstructor
@SuperBuilder
@ToString
public class ButtonsMessageModelDto extends TemplateMessageDto {
    private InteractiveDto interactive;

    public ButtonsMessageModelDto(String messaging_product, String to, String type, InteractiveDto interactive) {
        super(messaging_product, to, type);
        this.interactive = interactive;
    }

    public ButtonsMessageModelDto(InteractiveDto interactive) {
        this.interactive = interactive;
    }

    public ButtonsMessageModelDto(TemplateMessageDtoBuilder<?, ?> b, InteractiveDto interactive) {
        super(b);
        this.interactive = interactive;
    }
}
