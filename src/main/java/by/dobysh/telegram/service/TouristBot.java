package by.dobysh.telegram.service;

import by.dobysh.telegram.model.City;
import by.dobysh.telegram.repository.CityRepo;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.experimental.FieldDefaults;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.List;

@Component
@Log4j2
@FieldDefaults(level = AccessLevel.PRIVATE)
public class TouristBot extends TelegramLongPollingBot {

    @Getter
    @Value("${bot.tourist.username}")
    String botUsername;
    @Getter
    @Value("${bot.tourist.token}")
    String botToken;

    private CityRepo cityRepo;

    @Autowired
    public TouristBot(CityRepo cityRepo) {
        this.cityRepo = cityRepo;
    }


    @Override
    public void onUpdateReceived(Update update) {

        Message message = update.getMessage();
        if (message != null && message.hasText()) {
            try {
                sendTextMessage(message, getInformation(message.getText()));
            } catch (Exception e) {
                sendTextMessage(message, "Город не найден!");
            }
        }

    }

    private String getInformation(String nameCity) {
        City city = cityRepo.findFirstByName(nameCity);
//        List<City> cityList = cityRepo.findFirstByName(nameCity); // findByName(nameCity);
//        return cityList.stream().findFirst().get().getInformation();           //.get(0).getInformation();
        return city.getInformation();
    }

    public void sendTextMessage(Message message, String text) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.enableMarkdown(true);
        sendMessage.setChatId(message.getChatId().toString());
        sendMessage.setReplyToMessageId(message.getMessageId());

        sendMessage.setText(text);
        try {
            execute(sendMessage);
        } catch (TelegramApiException e) {
            log.error(e);
        }
    }


}
