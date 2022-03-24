package ru.telegram.horoscope.config;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.CallbackQuery;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;

import java.util.Optional;

@Component
@Slf4j
@RequiredArgsConstructor
public class TelegramFacade {
    private final BotStateContext botStateContext;

    public Optional<BotApiMethod<?>> handleUpdate(Update update) {
        Message message = update.getMessage();
        if (update.hasCallbackQuery()) {
            CallbackQuery callbackQuery = update.getCallbackQuery();
            log.info("New callbackQuery from User: {}, userId: {}, with data: {}",
                    update.getCallbackQuery().getFrom().getUserName(),
                    callbackQuery.getFrom().getId(),
                    update.getCallbackQuery().getData());
            return processCallbackQuery(callbackQuery);
        } else if (message != null && message.hasText()) {
            log.info("New callbackQuery from User: {}, userId: {}, with text: {}",
                    message.getFrom().getUserName(),message.getChatId(),message.getText());
            Optional<SendMessage> optionalSendMessage = handleInputMessage(message);
            if (optionalSendMessage.isPresent()) {
                return Optional.of(optionalSendMessage.get());
            }
        }
        return Optional.empty();
    }

    private Optional<BotApiMethod<?>> processCallbackQuery(CallbackQuery callbackQuery) {

        final long chatId = callbackQuery.getMessage().getChatId();

        Message message = callbackQuery.getMessage();
        message.getFrom().setId(message.getChatId());
        message.getFrom().setFirstName(message.getChat().getFirstName());
        message.getFrom().setLastName(message.getChat().getLastName());
        message.getFrom().setUserName(message.getChat().getUserName());

        SendMessage replyMessage;
        switch (callbackQuery.getData()) {
            case "buttonPisces":
                replyMessage = botStateContext.processButton(BotState.PISCES, chatId, message);
                return Optional.of(replyMessage);
            case "buttonAries":
                replyMessage = botStateContext.processButton(BotState.ARIES, chatId, message);
                return Optional.of(replyMessage);
            case "buttonTaurus":
                replyMessage = botStateContext.processButton(BotState.TAURUS, chatId, message);
                return Optional.of(replyMessage);
            case "buttonGemini":
                replyMessage = botStateContext.processButton(BotState.GEMINI, chatId, message);
                return Optional.of(replyMessage);
            case "buttonCancer":
                replyMessage = botStateContext.processButton(BotState.CANCER, chatId, message);
                return Optional.of(replyMessage);
            case "buttonLeo":
                replyMessage = botStateContext.processButton(BotState.LEO, chatId,
                        message);
                return Optional.of(replyMessage);
            case "buttonVirgo":
                replyMessage = botStateContext.processButton(BotState.VIRGO, chatId, message);
                return Optional.of(replyMessage);
            case "buttonLibra":
                replyMessage = botStateContext.processButton(BotState.LIBRA, chatId, message);
                return Optional.of(replyMessage);
            case "buttonScorpio":
                replyMessage = botStateContext.processButton(BotState.SCORPIO, chatId, message);
                return Optional.of(replyMessage);
            case "buttonSagittarius":
                replyMessage = botStateContext.processButton(BotState.SAGITTARIUS, chatId,
                        message);
                return Optional.of(replyMessage);
            case "buttonCapricorn":
                replyMessage = botStateContext.processButton(BotState.CAPRICORN, chatId, message);
                return Optional.of(replyMessage);
            case "buttonAquarius":
                replyMessage = botStateContext.processButton(BotState.AQUARIUS, chatId, message);
                return Optional.of(replyMessage);
        }

        return Optional.empty();
    }

    private Optional<SendMessage> handleInputMessage(Message message) {
        String inputMsg = message.getText();
        BotState botState;
        SendMessage sendMessage;

        switch (inputMsg) {
            case "/start":
                botState = BotState.START;
                break;
            case "/capricorn":
            case "/Capricorn":
                botState = BotState.CAPRICORN;
                break;
            case "/pisces":
            case "/Pisces":
                botState = BotState.PISCES;
                break;
            case "/aries":
            case "/Aries":
                botState = BotState.ARIES;
                break;
            case "/taurus":
            case "/Taurus":
                botState = BotState.TAURUS;
                break;
            case "/gemini":
            case "/Gemini":
                botState = BotState.GEMINI;
                break;
            case "/cancer":
            case "/Cancer":
                botState = BotState.CANCER;
                break;
            case "/leo":
            case "/Leo":
                botState = BotState.LEO;
                break;
            case "/virgo":
            case "/Virgo":
                botState = BotState.VIRGO;
                break;
            case "/libra":
            case "/Libra":
                botState = BotState.LIBRA;
                break;
            case "/scorpio":
            case "/Scorpio":
                botState = BotState.SCORPIO;
                break;
            case "/sagittarius":
            case "/Sagittarius":
                botState = BotState.SAGITTARIUS;
                break;
            case "/aquarius":
            case "/Aquarius":
                botState = BotState.AQUARIUS;
                break;
            default:
                return Optional.empty();
        }
        sendMessage = botStateContext.processInputMessage(botState,message);
        return Optional.of(sendMessage);
    }
}
