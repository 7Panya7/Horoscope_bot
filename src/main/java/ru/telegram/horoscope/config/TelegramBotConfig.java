package ru.telegram.horoscope.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.telegram.telegrambots.bots.DefaultBotOptions;

@Getter
@Setter
@Configuration
public class TelegramBotConfig {
    @Value("${telegrambot.botUserName}")
    private String botUserName;
    @Value("${telegrambot.botToken}")
    private String botToken;
    @Value("${telegrambot.webHookPath}")
    private String webHookPath;

    @Bean
    public TelegramBot myNewsTelegramBot(TelegramFacade telegramFacade) {
        DefaultBotOptions options = new DefaultBotOptions();
        TelegramBot telegramBot = new TelegramBot(options, telegramFacade);
        telegramBot.setBotToken(botToken);
        telegramBot.setBotUserName(botUserName);
        telegramBot.setWebHookPath(webHookPath);
        return telegramBot;
    }
}
