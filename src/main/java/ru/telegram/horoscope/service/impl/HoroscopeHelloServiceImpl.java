package ru.telegram.horoscope.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import ru.telegram.horoscope.config.BotState;
import ru.telegram.horoscope.service.HoroscopeHelloService;

@Service
@RequiredArgsConstructor
public class HoroscopeHelloServiceImpl implements HoroscopeHelloService {
    private final InlineKeyboardMarkup inlineKeyboardMarkup;

    @Override
    public SendMessage handle(Message message) {
        var helloMessage = "Привет! Хочешь узнать свой гороскоп на сегодня? Нажми на одну из этих кнопок:\n" +
                "Козерог, Рыба, Овен, Телец;\nБлизнецы, Рак, Лев, Дева;" +
                "\nВесы, Скорпион, Стрелец, Водолей";
        SendMessage sendMessage = new SendMessage(String.valueOf(message.getChatId()), helloMessage);
        sendMessage.setReplyMarkup(inlineKeyboardMarkup);
        return sendMessage;
    }

    @Override
    public BotState getHandlerName() {
        return BotState.START;
    }
}
