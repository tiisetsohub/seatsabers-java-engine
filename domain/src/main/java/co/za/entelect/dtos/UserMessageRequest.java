package co.za.entelect.dtos;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserMessageRequest {
    private String phoneNumber;
    private String text;
}
