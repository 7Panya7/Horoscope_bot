package ru.telegram.horoscope.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.objects.Update;
import ru.telegram.horoscope.config.TelegramBot;

@RestController
@RequiredArgsConstructor
public class TelegranContoller {
    private final TelegramBot telegramBot;

    @PostMapping("/")
    public BotApiMethod<?> getHoroscope(@RequestBody Update update) {
        return telegramBot.onWebhookUpdateReceived(update);
    }
}
