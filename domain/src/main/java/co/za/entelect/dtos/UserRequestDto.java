package co.za.entelect.dtos;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserRequestDto {
    private String phoneNumber;
    private String accessToken;
    private String refreshToken;
    private String idToken;
}
