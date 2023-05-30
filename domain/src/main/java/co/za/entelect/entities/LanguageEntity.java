package co.za.entelect.entities;

import lombok.*;

import javax.persistence.Entity;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class LanguageEntity {
    private String code;
}
