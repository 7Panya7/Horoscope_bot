package ru.telegram.horoscope.service;

import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;

public interface HoroscopeAriesService extends HoroscopeService{
    SendMessage handle(final long chatId, Message message);

}
