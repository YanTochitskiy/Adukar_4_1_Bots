package by.adukar.telegrambot;

import by.adukar.telegrambot.buttons.inline.InlineButtons;
import by.adukar.telegrambot.buttons.reply.ReplyButtons;
import by.adukar.telegrambot.consts.Commands;
import by.adukar.telegrambot.consts.Paths;
import by.adukar.telegrambot.consts.Photos;
import by.adukar.telegrambot.consts.Text;
import by.adukar.telegrambot.enums.Color;
import by.adukar.telegrambot.service.FileService;
import by.adukar.telegrambot.service.TextService;
import by.adukar.telegrambot.service.UserService;
import lombok.SneakyThrows;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;

import org.telegram.telegrambots.meta.api.methods.polls.SendPoll;
import org.telegram.telegrambots.meta.api.methods.send.*;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.List;


public class Bot extends TelegramLongPollingBot {

    ReplyButtons replyButtons = new ReplyButtons();

    UserService userService = new UserService();
    TextService textService = new TextService();
    FileService fileService = new FileService();
    InlineButtons inlineButtons = new InlineButtons();

    @Override
    @SneakyThrows
    public void onUpdateReceived(Update update) {
        sendAnswerFromBot(update);
    }

    @SneakyThrows
    public void sendAnswerFromBot(Update update) {
        Long chatId = update.getMessage().getChatId();
        if (update.hasCallbackQuery()) {
            if (update.getCallbackQuery().getData().equals("Интересные места")) {
                Long chatIdFromCallBack = update.getCallbackQuery().getFrom().getId().longValue();
                sendMsg("https://vandruy.by/40-samyh-krasivyh-mest-na-zemle/", chatIdFromCallBack);
            }
            if (update.getCallbackQuery().getData().equals("Другое")) {
                Long chatIdFromCallBack = update.getCallbackQuery().getFrom().getId().longValue();
                sendMsg("https://sergeydolya.livejournal.com/1304062.html", chatIdFromCallBack);
            }
            if (update.getCallbackQuery().getData().equals("trc2342n")) {
                Long chatIdFromCallBack = update.getCallbackQuery().getFrom().getId().longValue();
                sendMsg("chatIdFr23423omCallBack", chatIdFromCallBack);
            }
            if (update.getCallbackQuery().getData().equals("Для туризма")) {
                Long chatIdFromCallBack = update.getCallbackQuery().getFrom().getId().longValue();
                sendMsg("https://34travel.me/post/best-in-travel-2020", chatIdFromCallBack);
            }
            if (update.getCallbackQuery().getData().equals("Для туризма, но подешевле")) {
                Long chatIdFromCallBack = update.getCallbackQuery().getFrom().getId().longValue();
                sendMsg("https://www.skyscanner.ru/news/deshevye-strany-dlia-puteshestvii", chatIdFromCallBack);
            }
        }
        else {

            if ((update.getMessage().getText().equals("Куда поехать дёшево")))
                sendPoll(chatId);
        }
        if (update.getMessage().getText().equals("Интересные места")) {
            sendMsgWithButtons("Интересные места", inlineButtons.keyboardMarkup("Интересные места"), chatId);
        }
        if (update.getMessage().getText().equals("Другое")) {
            sendMsgWithButtons("Другое", inlineButtons.keyboardMarkup("Другое"), chatId);
        }
        if (update.getMessage().getText().equals("Туризм")) {
            sendMsgWithButtons("Для туризма", inlineButtons.keyboardMarkup("Для туризма"), chatId);
        }
        if (update.getMessage().getText().equals("Дешевле")) {
            sendMsgWithButtons("Для туризма, но подешевле", inlineButtons.keyboardMarkup("Для туризма, но подешевле"), chatId);
        }
        if (update.getMessage().getText().equals("locacia")) {
            sendLocation(chatId);
        }
        if (update.getMessage().getText().equals("Минск")) {
            sendLocation(chatId, "53.8843138", "27.3131922");
            System.out.println("qwer");
        }
        if (update.getMessage().getText().equals("Ереван")) {
            sendLocation(chatId, "40.1533693", "44.4185271");
            System.out.println("лщш");
        }
        if (update.getMessage().getText().equals("/start")) {
            sendMsgWithButtons("Вводи эти команды, чтобы бот работал:Интересные места, Туризм, Другое, Дешевле", replyButtons.keyboardMarkup(), chatId);
        }
        if (update.getMessage().getText().equals("Дополнительная информация")) {
            sendMsgWithButtons("Если хочешь узнать что-то про интересующие тебя города-просто напиши их название в чат", replyButtons.keyboardMarkup(), chatId);
        }
    }



    public synchronized void sendMsg(String pathToPhoto, Long chatId) {
        SendMessage sendPhotoRequest = new SendMessage();
        sendPhotoRequest.setChatId(chatId);
        sendPhotoRequest.setText(pathToPhoto);
        try {
            execute(sendPhotoRequest);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }


    public synchronized void sendContact(Long chatId) {
        SendContact sendContact = new SendContact();
        sendContact.setPhoneNumber("щ");
        sendContact.setFirstName("з");
        sendContact.setLastName("с");
        sendContact.setChatId(chatId);
        try {
            execute(sendContact);
        } catch (TelegramApiException e) {
            System.out.println( "Exception: " + e.toString());
        }
    }

    /*public synchronized void sendDocument(Long chatId) {
        SendDocument sendDocument = new SendDocument();
        sendDocument.setChatId(chatId);
        sendDocument.setDocument("http://www.africau.edu/images/default/sample.pdf");
        sendDocument.setCaption("Текст к документу");
        try {
            execute(sendDocument);
        } catch (TelegramApiException e) {
            System.out.println( "Exception: " + e.toString());
        }
    }*/

    public synchronized void sendLocation(Long chatId){
        SendLocation sendLocation = new SendLocation();
        sendLocation.setChatId(chatId);
        sendLocation.setLatitude(Float.valueOf("-22.9647172"));
        sendLocation.setLongitude(Float.valueOf("-43.5746972"));

        try {
            execute(sendLocation);
        } catch (TelegramApiException e) {
            System.out.println( "Exception: " + e.toString());
        }
    }
    public synchronized void sendLocation(Long chatId, String value1, String value2){
        SendLocation sendLocation1 = new SendLocation();
        sendLocation1.setChatId(chatId);
        sendLocation1.setLatitude(Float.valueOf(value1));
        sendLocation1.setLongitude(Float.valueOf(value1));

        try {
            execute(sendLocation1);
        } catch (TelegramApiException e) {
            System.out.println( "Exception: " + e.toString());
        }
    }

    public synchronized void sendPhoto(String pathToPhoto, Long chatId) {
        SendPhoto sendPhotoRequest = new SendPhoto();
        sendPhotoRequest.setChatId(chatId);
        sendPhotoRequest.setPhoto(pathToPhoto);
        try {
            execute(sendPhotoRequest);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    public synchronized void sendMsgWithButtons(String message, ReplyKeyboardMarkup replyKeyboardMarkup, Long chatId) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(chatId);
        sendMessage.setText(message);
        sendMessage.setReplyMarkup(replyKeyboardMarkup);
        try {
            execute(sendMessage);
        } catch (TelegramApiException e) {
            System.out.println( "Exception: " + e.toString());
        }
    }

    public synchronized void sendPoll(Long chatId){
        SendPoll sendPoll = new SendPoll();
        sendPoll.enableNotification();
        sendPoll.setQuestion("Куда поехать");
        sendPoll.setAnonymous(true);
        sendPoll.setOptions(List.of("Беларусь", "Абхазия", "Турция"));
        sendPoll.setChatId(chatId);
        sendPoll.setType("quiz");
        sendPoll.setCorrectOptionId(2);
        try {
            execute(sendPoll);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }
    public synchronized void sendMsgWithButtons(String message, InlineKeyboardMarkup replyKeyboardMarkup, Long chatId) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(chatId);
        sendMessage.setText(message);
        sendMessage.setReplyMarkup(replyKeyboardMarkup);
        try {
            execute(sendMessage);
        } catch (TelegramApiException e) {
            System.out.println( "Exception: " + e.toString());
        }
    }


    @Override
    public String getBotUsername() {
        return "Yangid";
    }

    @Override
    public String getBotToken() {
        return "1743091433:AAGo6nzVVm5QRYPJ9XcouuiGCgnnsxsUvzc";
    }
}


