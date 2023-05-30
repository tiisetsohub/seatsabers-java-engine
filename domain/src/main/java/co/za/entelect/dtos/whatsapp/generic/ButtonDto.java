package co.za.entelect.dtos.whatsapp.generic;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ButtonDto {
    private String type;
    private ReplyDto reply;
}
