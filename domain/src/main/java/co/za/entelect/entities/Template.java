package co.za.entelect.entities;

import co.za.entelect.dtos.whatsapp.generic.LanguageDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Template {
    private String name;
    private LanguageDto language;
}
