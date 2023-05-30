package co.za.entelect.entities;

import lombok.*;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@AttributeOverride(name = "id", column = @Column(name = "id"))
@Table(name = "Users", schema = "dbo")
@Entity
public class UserEntity extends IIdentifiableEntity{
    private String phoneNumber;
    private String accessToken;
    private String refreshToken;
    private String idToken;
}
