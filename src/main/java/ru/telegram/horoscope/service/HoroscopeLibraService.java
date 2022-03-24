package ru.telegram.horoscope.service;

import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;

public interface HoroscopeLibraService extends HoroscopeService{
    SendMessage handle(final long chatId, Message message);
}
