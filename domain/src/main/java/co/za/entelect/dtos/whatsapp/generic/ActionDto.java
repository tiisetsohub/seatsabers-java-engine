package co.za.entelect.dtos.whatsapp.generic;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ActionDto {
    private String button;
    private ButtonDto[] buttons;
    private SectionDto[] sections;
}
