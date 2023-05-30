package co.za.entelect.dtos;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SessionDto {
    private String phoneNumber;
    private String startFlow;
    private String endFlow;
    private String currentFlow;
    private String previousFlow;

    public void ClearSession(){
        this.currentFlow = startFlow;
        this.previousFlow = startFlow;
    }
}
