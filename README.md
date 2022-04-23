# Телеграм Бот Гороскоп
<p align="center"><img src="https://cdn-icons.flaticon.com/png/512/3924/premium/3924420.png?token=exp=1650561574~hmac=b6c3c333c9294f3f0128b54fd6ec818b" 
                       alt="horoscope" height="80"   /><img src="https://upload.wikimedia.org/wikipedia/commons/thumb/8/82/Telegram_logo.svg/1024px-Telegram_logo.svg.png?20220101141644" 
                       alt="horoscope" height="80"   />
  
## Описание
  Данный бот был написан для мессенджера телеграм. С помощью данного ботаБ вы можете узнать свой гороскоп на сегодня.
  Используется Spring Framework <img src="https://upload.wikimedia.org/wikipedia/commons/thumb/4/44/Spring_Framework_Logo_2018.svg/1280px-Spring_Framework_Logo_2018.svg.png" 
 alt="Spring"  height="20"/>
  
## Разработка
  * Язык разработки: **Java 17**
  * Фреймворк: 
      - <img src="https://upload.wikimedia.org/wikipedia/commons/thumb/4/44/Spring_Framework_Logo_2018.svg/1280px-Spring_Framework_Logo_2018.svg.png" 
 alt="Spring"  height="15"/> **Boot 3.0.0-M1** 
      - <img src="https://upload.wikimedia.org/wikipedia/commons/thumb/4/44/Spring_Framework_Logo_2018.svg/1280px-Spring_Framework_Logo_2018.svg.png" 
 alt="Spring"  height="15"/> **Cloud OpenFeign**
  
  * Библиотеки: 
    - **Lombok**
    - **Jsoup**
  * Внешнее API: [Mail Horoscope](https://horo.mail.ru/prediction/capricorn/today),[Telegram API](https://github.com/rubenlagus/TelegramBots/tree/master/telegrambots-spring-boot-starter)
  ## Как запустить
  1. Написать команду в консоли, находясь внутри проекта:
  ```console
    ./gradlew bootrun
  ```
  ## Запуск телеграм бота на локальном компьютере
  1. Скачать [ngrok](https://ngrok.com/download)
  2. Запустить в консоли ngrok с командой:
  ```console
    ./ngrok http 5000
  ```
  3. Установить webhook в Браузере, где:
  * url - ваш url ngrok. 
  
  Пример: 
  ```console
    https://4201-82-198-187-161.ngrok.io
  ```
  * mytoken - токен вашего бота. 
  
  Пример : 
  ```console
    https://api.telegram.org/bot(mytoken)/setWebhook?url=https://4201-82-198-187-161.ngrok.io/mymethod
  ```
