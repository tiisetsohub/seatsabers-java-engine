package co.za.entelect.services;

import co.za.entelect.dtos.whatsapp.generic.*;
import co.za.entelect.dtos.whatsapp.messages.requests.ButtonsMessageModelDto;
import co.za.entelect.dtos.whatsapp.messages.requests.HQLocationDto;
import co.za.entelect.dtos.whatsapp.messages.requests.OfficeListDto;
import co.za.entelect.dtos.whatsapp.messages.requests.PlainTextDto;
import org.springframework.stereotype.Service;

@Service
public class MessageBuilderService {

    public PlainTextDto buildPlainTextMessage(String phoneNumber, String textBody){
        PlainTextDto plainText = PlainTextDto.builder()
                .text(
                        TextDto.builder()
                                .body(textBody)
                                .build()
                )
                .messaging_product("whatsapp")
                .to(phoneNumber)
                .type("text")
                .build();
        System.out.println("3");

        return plainText;
    }

    public ButtonsMessageModelDto buildConfirmBookingsButtonsMessage(String phoneNumber){
        ButtonsMessageModelDto confirmBookingsButtons = ButtonsMessageModelDto.builder()
                .messaging_product("whatsapp")
                .to(phoneNumber)
                .type("interactive")
                .interactive(
                        InteractiveDto.builder()
                                .type("button")
                                .body(
                                        HBFDto.builder()
                                                .text("Are you okay with this?")
                                                .build()
                                ).action(
                                        ActionDto.builder()
                                                .buttons(new ButtonDto[]{
                                                        ButtonDto.builder()
                                                                .type("reply")
                                                                .reply(
                                                                        ReplyDto.builder()
                                                                                .id("001")
                                                                                .title("✅Yes")
                                                                                .build()
                                                                )
                                                                .build(),
                                                        ButtonDto.builder()
                                                                .type("reply")
                                                                .reply(
                                                                        ReplyDto.builder()
                                                                                .id("002")
                                                                                .title("Future Date")
                                                                                .build()
                                                                )
                                                                .build()
                                                })
                                                .build()
                                )
                                .build()

                )
                .build();
        System.out.println("3");

        return confirmBookingsButtons;
    }

    public ButtonDto[] createButtons(String[] buttonTexts){
        ButtonDto[] buttons = new ButtonDto[buttonTexts.length];
        for (int i = 0;i < buttons.length; i++) {
            buttons[i] = ButtonDto.builder()
                    .type("reply")
                    .reply(
                            ReplyDto.builder()
                                    .id(String.valueOf(i))
                                    .title(buttonTexts[i])
                                    .build()
                    )
                    .build();
        }
        System.out.println(buttons[0].getReply().getTitle());
        return buttons;
    }

    public ButtonsMessageModelDto buildButtonMessageModel(String bodyText, String[] buttonTexts, String phoneNumber){
        ButtonsMessageModelDto confirmBookingsButtons = ButtonsMessageModelDto.builder()
                .messaging_product("whatsapp")
                .to(phoneNumber)
                .type("interactive")
                .interactive(
                        InteractiveDto.builder()
                                .type("button")
                                .body(
                                        HBFDto.builder()
                                                .text(bodyText)
                                                .build()
                                ).action(
                                        ActionDto.builder()
                                                .buttons(createButtons(buttonTexts))
                                                .build()
                                )
                                .build()

                )
                .build();
        System.out.println("3");

        return confirmBookingsButtons;
    }

    public OfficeListDto buildOfficeListMessage(String phoneNumber){
        OfficeListDto officeList = OfficeListDto.builder()
                .messaging_product("whatsapp")
                .to(phoneNumber)
                .type("interactive")
                .interactive(
                        InteractiveDto.builder()
                                .type("list")
                                .body(
                                        HBFDto.builder()
                                                .text("Which office do you want to go in to?")
                                                .build()
                                )
                                .footer(HBFDto.builder()
                                        .text("_Choose Wisely_\uD83E\uDDD9")
                                        .build())
                                .action(
                                        ActionDto.builder()
                                                .button("Office Locations")
                                                .sections(new SectionDto[]{
                                                        SectionDto.builder()
                                                                .title("Office?")
                                                                .rows(new RowDto[]{
                                                                        RowDto.builder()
                                                                                .id("Melrose Office")
                                                                                .title("Entelect HQ")
                                                                                .description("_Where all the cool Joburg boets go_\uD83D\uDE0E")
                                                                                .build(),
                                                                        RowDto.builder()
                                                                                .id("Pretoria Office")
                                                                                .title("Entelect Pretoria")
                                                                                .description("_Lekker!! Ons gan nou braai_\uD83E\uDD69")
                                                                                .build(),
                                                                        RowDto.builder()
                                                                                .id("Durban Office")
                                                                                .title("Entelect Durban")
                                                                                .description("_Wat kind Ekse?_\uD83E\uDD80")
                                                                                .build(),
                                                                        RowDto.builder()
                                                                                .id("Cape Town Office")
                                                                                .title("Entelect Cape Town")
                                                                                .description("_like... let's go surfing bru_\uD83D\uDC2C")
                                                                                .build()

                                                                })
                                                                .build()
                                                })
                                                .build()
                                )
                                .build()
                )
                .build();
        System.out.println("3");

        return officeList;
    }

    public HQLocationDto buildHQLocationMessage(String phoneNumber){
        HQLocationDto hqLocationDto = HQLocationDto.builder()
                .messaging_product("whatsapp")
                .to(phoneNumber)
                .type("location")
                .location(
                        LocationDto.builder()
                                .latitude("-26.135002211623977")
                                .longitude("28.068343008698303")
                                .name("Entelect HQ - Melrose")
                                .address("Unit 13, 3 Melrose Blvd, Melrose, Johannesburg, 2196")
                                .build()
                )
                .build();
        System.out.println("3");

        return hqLocationDto;
    }
}
