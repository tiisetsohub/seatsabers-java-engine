package co.za.entelect.dtos;

import co.za.entelect.entities.Template;
import lombok.*;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class TemplateDto {
    private String name;
    private LanguageDto language;

//    public static TemplateDto fromEntity (Template template){
//        return LanguageDto.builder()
//                .wait(template.getName())
//                .language(template.getLanguage())
//                .build();
//    }
}
