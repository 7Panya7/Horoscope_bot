package ru.telegram.horoscope.config;

import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import ru.telegram.horoscope.service.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class BotStateContext {
    private Map<BotState, HoroscopeService> messageHandlers = new HashMap<>();

    public BotStateContext(List<HoroscopeService> messageHandlers) {
        messageHandlers.forEach(handler -> this.messageHandlers.put(handler.getHandlerName(),handler));
    }

    public SendMessage processInputMessage(BotState botState, Message message) {
        HoroscopeService horoscopeService = findService(botState);
        return horoscopeService.handle(message);
    }

    public SendMessage processButton(BotState currentState, long chatId, Message message) {
        HoroscopeService horoscopeService = findService(currentState);
        if (currentState.equals(BotState.CAPRICORN)) {
            HoroscopeCapricornService horoscopeCapricornService = (HoroscopeCapricornService) horoscopeService;
            return horoscopeCapricornService.handle(chatId,message);
        } else if (currentState.equals(BotState.PISCES)) {
            HoroscopePiscesService horoscopePiscesService = (HoroscopePiscesService) horoscopeService;
            return horoscopePiscesService.handle(chatId,message);
        } else if (currentState.equals(BotState.ARIES)) {
            HoroscopeAriesService horoscopeAriesService = (HoroscopeAriesService) horoscopeService;
            return horoscopeAriesService.handle(chatId,message);
        } else if (currentState.equals(BotState.TAURUS)) {
            HoroscopeTaurusService horoscopeTaurusService = (HoroscopeTaurusService) horoscopeService;
            return horoscopeTaurusService.handle(chatId,message);
        } else if (currentState.equals(BotState.GEMINI)) {
            HoroscopeGeminiService horoscopeGeminiService = (HoroscopeGeminiService) horoscopeService;
            return horoscopeGeminiService.handle(chatId, message);
        } else if (currentState.equals(BotState.CANCER)) {
            HoroscopeCancerService horoscopeCancerService = (HoroscopeCancerService) horoscopeService;
            return horoscopeCancerService.handle(chatId,message);
        } else if (currentState.equals(BotState.LEO)) {
            HoroscopeLeoService horoscopeLeoService = (HoroscopeLeoService) horoscopeService;
            return horoscopeLeoService.handle(chatId,message);
        } else if (currentState.equals(BotState.VIRGO)) {
            HoroscopeVirgoService horoscopeVirgoService = (HoroscopeVirgoService) horoscopeService;
            return horoscopeVirgoService.handle(chatId,message);
        } else if (currentState.equals(BotState.LIBRA)) {
            HoroscopeLibraService horoscopeLibraService = (HoroscopeLibraService) horoscopeService;
            return horoscopeLibraService.handle(chatId,message);
        } else if (currentState.equals(BotState.SCORPIO)) {
            HoroscopeScorpioService horoscopeScorpioService = (HoroscopeScorpioService) horoscopeService;
            return horoscopeScorpioService.handle(chatId,message);
        } else if (currentState.equals(BotState.SAGITTARIUS)) {
            HoroscopeSagittariusService horoscopeSagittariusService = (HoroscopeSagittariusService) horoscopeService;
            return horoscopeSagittariusService.handle(chatId,message);
        } else if (currentState.equals(BotState.AQUARIUS)) {
            HoroscopeAquariusService horoscopeAquariusService = (HoroscopeAquariusService) horoscopeService;
            return horoscopeAquariusService.handle(chatId,message);
        } else return null;
    }

    private HoroscopeService findService(BotState botState) {
        if (isUserTelegramState(botState)) {
            return messageHandlers.get(BotState.CAPRICORN);
        }
        return messageHandlers.get(botState);
    }

    private boolean isUserTelegramState(BotState botState) {
        switch (botState) {
            case CAPRICORN:
                return true;
            default:
                return false;
        }
    }
}
