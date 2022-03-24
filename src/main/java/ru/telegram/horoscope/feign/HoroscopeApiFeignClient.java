package ru.telegram.horoscope.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "horoscope", url = "https://horo.mail.ru/prediction/")
public interface HoroscopeApiFeignClient {

    @GetMapping("{animal}/today")
    String getHoroscopeToday(@PathVariable(name = "animal") String animal);
}
