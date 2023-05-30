package co.za.entelect.dtos.whatsapp.generic;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class InteractiveDto {
    private String type;
    private HBFDto body;
    private HBFDto footer;
    private ActionDto action;
}
