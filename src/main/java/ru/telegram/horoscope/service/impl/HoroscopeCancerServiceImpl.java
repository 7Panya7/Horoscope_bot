package ru.telegram.horoscope.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import ru.telegram.horoscope.config.BotState;
import ru.telegram.horoscope.parser.ParserHoroscopePage;
import ru.telegram.horoscope.service.HoroscopeCancerService;

@Service
@RequiredArgsConstructor
public class HoroscopeCancerServiceImpl implements HoroscopeCancerService {
    private final ParserHoroscopePage parserHoroscopePage;
    private final InlineKeyboardMarkup inlineKeyboardMarkup;

    @Override
    public SendMessage handle(Message message) {
        var text = parserHoroscopePage.getPage(message.getText());
        SendMessage sendMessage = new SendMessage(String.valueOf(message.getChatId()), text);
        sendMessage.setReplyMarkup(inlineKeyboardMarkup);
        return sendMessage;
    }

    @Override
    public SendMessage handle(long chatId, Message message) {
        var text = parserHoroscopePage.getPage("cancer");
        SendMessage sendMessage = new SendMessage(String.valueOf(message.getChatId()), text);
        sendMessage.setReplyMarkup(inlineKeyboardMarkup);
        return sendMessage;
    }

    @Override
    public BotState getHandlerName() {
        return BotState.CANCER;
    }
}


