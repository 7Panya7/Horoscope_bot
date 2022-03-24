package ru.telegram.horoscope.service;

import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import ru.telegram.horoscope.config.BotState;

public interface HoroscopeService {
    SendMessage handle(Message message);

    BotState getHandlerName();
}
