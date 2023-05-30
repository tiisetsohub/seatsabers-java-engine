package co.za.entelect.entities;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@AttributeOverride(name = "id", column = @Column(name = "id"))
@Table(name = "Users", schema = "dbo")
@Entity
public class SessionEntity {
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id")
    private UserEntity user;

    private String startFlow;
    private String endFlow;
    private String currentFlow;
    private String previousFlow;
}
