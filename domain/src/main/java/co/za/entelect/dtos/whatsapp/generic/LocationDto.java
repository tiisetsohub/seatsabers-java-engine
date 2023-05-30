package co.za.entelect.dtos.whatsapp.generic;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LocationDto {
    private String latitude;
    private String longitude;
    private String name;
    private String address;
}
