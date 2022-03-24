package ru.telegram.horoscope.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class InlineKeyboardMarkupConfig {
    @Bean
    public InlineKeyboardMarkup inlineMessageButton() {
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();

        InlineKeyboardButton buttonAquarius = new InlineKeyboardButton();
        buttonAquarius.setText("Водолей");
        buttonAquarius.setCallbackData("buttonAquarius");

        InlineKeyboardButton buttonAries = new InlineKeyboardButton();
        buttonAries.setText("Овен");
        buttonAries.setCallbackData("buttonAries");

        InlineKeyboardButton buttonCancer = new InlineKeyboardButton();
        buttonCancer.setText("Рак");
        buttonCancer.setCallbackData("buttonCancer");

        InlineKeyboardButton buttonCapricorn = new InlineKeyboardButton();
        buttonCapricorn.setText("Козерог");
        buttonCapricorn.setCallbackData("buttonCapricorn");

        InlineKeyboardButton buttonGemini = new InlineKeyboardButton();
        buttonGemini.setText("Близнецы");
        buttonGemini.setCallbackData("buttonGemini");

        InlineKeyboardButton buttonLeo = new InlineKeyboardButton();
        buttonLeo.setText("Лев");
        buttonLeo.setCallbackData("buttonLeo");

        InlineKeyboardButton buttonLibra = new InlineKeyboardButton();
        buttonLibra.setText("Весы");
        buttonLibra.setCallbackData("buttonLibra");

        InlineKeyboardButton buttonPisces = new InlineKeyboardButton();
        buttonPisces.setText("Рыба");
        buttonPisces.setCallbackData("buttonPisces");

        InlineKeyboardButton buttonSagittarius = new InlineKeyboardButton();
        buttonSagittarius.setText("Стрелец");
        buttonSagittarius.setCallbackData("buttonSagittarius");

        InlineKeyboardButton buttonScorpio = new InlineKeyboardButton();
        buttonScorpio.setText("Скорпион");
        buttonScorpio.setCallbackData("buttonScorpio");

        InlineKeyboardButton buttonTaurus = new InlineKeyboardButton();
        buttonTaurus.setText("Телец");
        buttonTaurus.setCallbackData("buttonTaurus");

        InlineKeyboardButton buttonVirgo = new InlineKeyboardButton();
        buttonVirgo.setText("Дева");
        buttonVirgo.setCallbackData("buttonVirgo");

        List<InlineKeyboardButton> keyboardButtonsRow1 = new ArrayList<>();
        keyboardButtonsRow1.add(buttonPisces);
        keyboardButtonsRow1.add(buttonAries);
        keyboardButtonsRow1.add(buttonTaurus);
        keyboardButtonsRow1.add(buttonGemini);

        List<InlineKeyboardButton> keyboardButtonsRow2 = new ArrayList<>();
        keyboardButtonsRow2.add(buttonCancer);
        keyboardButtonsRow2.add(buttonLeo);
        keyboardButtonsRow2.add(buttonVirgo);
        keyboardButtonsRow2.add(buttonLibra);

        List<InlineKeyboardButton> keyboardButtonsRow3 = new ArrayList<>();
        keyboardButtonsRow3.add(buttonScorpio);
        keyboardButtonsRow3.add(buttonSagittarius);
        keyboardButtonsRow3.add(buttonCapricorn);
        keyboardButtonsRow3.add(buttonAquarius);

        List<List<InlineKeyboardButton>> rowList = new ArrayList<>();
        rowList.add(keyboardButtonsRow1);
        rowList.add(keyboardButtonsRow2);
        rowList.add(keyboardButtonsRow3);

        inlineKeyboardMarkup.setKeyboard(rowList);
        return inlineKeyboardMarkup;
    }
}
