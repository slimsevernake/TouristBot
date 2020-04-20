//import org.telegram.telegrambots.ApiContextInitializer;
//import org.telegram.telegrambots.TelegramBotsApi;
//import org.telegram.telegrambots.api.methods.send.SendMessage;
//import org.telegram.telegrambots.api.objects.Message;
//import org.telegram.telegrambots.api.objects.Update;
//import org.telegram.telegrambots.bots.TelegramLongPollingBot;
//import org.telegram.telegrambots.exceptions.TelegramApiException;
//import org.telegram.telegrambots.exceptions.TelegramApiRequestException;
//
//import java.io.IOException;
//import java.util.HashMap;
//import java.util.Map;
//
//public class MyBot extends TelegramLongPollingBot {
//
//    private static Map<String, String> cityDB = new HashMap<String, String>();
//
//    public static void main(String[] args) {
//        ApiContextInitializer.init();
//        cityDB.put("Москва", "Не забудьте посетить Красную Площадь. Ну а в ЦУМ можно и не заходить)))");
//        TelegramBotsApi telegramBotsApi = new TelegramBotsApi();
//        try {
//            telegramBotsApi.registerBot(new MyBot());
//
//        } catch (TelegramApiRequestException e) {
//            e.printStackTrace();
//        }
//    }
//
//    private String getInformation(String city) throws Exception{
//        String information = cityDB.get(city);
//
//        if (information == null) {
//            throw new Exception();
//        }
//
//        return information;
//    }
//
//    public void sendMsg(Message message, String text) {
//        SendMessage sendMessage = new SendMessage();
//        sendMessage.enableMarkdown(true);
//
//        sendMessage.setChatId(message.getChatId().toString());
//
//        sendMessage.setReplyToMessageId(message.getMessageId());
//
//        sendMessage.setText(text);
//        try {
//            sendMessage(sendMessage);
//
//        } catch (TelegramApiException e) {
//            e.printStackTrace();
//        }
//    }
//
//
//    public void onUpdateReceived(Update update) {
//        Message message = update.getMessage();
//        if (message != null && message.hasText()) {
//            try {
//                sendMsg(message, getInformation(message.getText()) );
//            } catch (Exception e) {
//                sendMsg(message, "Город не найден!");
//            }
//        }
//
//    }
//
//
//    public String getBotUsername() {
//        return "MyTouristyTelegramBot";
//    }
//
//    public String getBotToken() {
//        return "1217257255:AAEojOcsfYsZ1MgNjWaDQvB7iyF4CZu0IXc";
//    }
//}