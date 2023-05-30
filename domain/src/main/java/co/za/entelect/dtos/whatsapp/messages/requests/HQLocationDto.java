package co.za.entelect.dtos.whatsapp.messages.requests;

import co.za.entelect.dtos.whatsapp.generic.LocationDto;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@NoArgsConstructor
@SuperBuilder
public class HQLocationDto extends TemplateMessageDto {
    private LocationDto location;

    public HQLocationDto(String messaging_product, String to, String type, LocationDto location) {
        super(messaging_product, to, type);
        this.location = location;
    }

    public HQLocationDto(LocationDto location) {
        this.location = location;
    }

    public HQLocationDto(TemplateMessageDtoBuilder<?, ?> b, LocationDto location) {
        super(b);
        this.location = location;
    }
}
