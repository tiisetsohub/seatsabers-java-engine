package co.za.entelect.entities;

import co.za.entelect.dtos.TemplateDto;
import lombok.*;

import javax.persistence.Entity;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class MessageRequest {
    private String messaging_product;
    private String to;
    private String type;
    private TemplateDto template;
}
