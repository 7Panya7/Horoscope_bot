package ru.telegram.horoscope.parser;

import lombok.RequiredArgsConstructor;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.springframework.stereotype.Component;
import ru.telegram.horoscope.feign.HoroscopeApiFeignClient;

import java.util.Locale;

@Component
@RequiredArgsConstructor
public class Parser implements ParserHoroscopePage {
    private final HoroscopeApiFeignClient horoscopeApiFeignClient;

    public String getPage(String animal) {
        Document page = Jsoup.parse(horoscopeApiFeignClient.getHoroscopeToday(animal.toLowerCase(Locale.ROOT)
                .replaceAll("/","")));
        Element prognose = page.select("div[class = article__item article__item_alignment_left article__item_html]").first();
        String result = prognose.text();
        return result;
    }
}
