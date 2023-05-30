package co.za.entelect.dtos.whatsapp.generic;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class HBFDto {
    //interchangeable class for Header, Body and Footer text
    private String text;
}
