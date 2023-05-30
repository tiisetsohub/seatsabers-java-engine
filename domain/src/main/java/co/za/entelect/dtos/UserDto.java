package co.za.entelect.dtos;

import co.za.entelect.entities.UserEntity;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDto {
    private Long id;
    private String phoneNumber;
    private String accessToken;
    private String refreshToken;
    private String idToken;

    public static UserDto fromEntity(UserEntity userEntity){
        return UserDto.builder()
                .id(userEntity.getId())
                .phoneNumber(userEntity.getPhoneNumber())
                .accessToken(userEntity.getAccessToken())
                .refreshToken(userEntity.getRefreshToken())
                .idToken(userEntity.getIdToken())
                .build();
    }
}
