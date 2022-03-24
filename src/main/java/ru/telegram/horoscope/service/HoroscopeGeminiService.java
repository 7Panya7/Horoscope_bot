package ru.telegram.horoscope.service;

import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;

public interface HoroscopeGeminiService extends HoroscopeService{
    SendMessage handle(final long chatId, Message message);
}
