package by.adukar.telegrambot;

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
import org.telegram.telegrambots.api.methods.send.*;
import org.telegram.telegrambots.api.objects.Message;
import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.exceptions.TelegramApiException;


public class Bot extends TelegramLongPollingBot {

    ReplyButtons replyButtons = new ReplyButtons();

    UserService userService = new UserService();
    TextService textService = new TextService();
    FileService fileService = new FileService();

    @Override
    @SneakyThrows
    public void onUpdateReceived(Update update) {
        sendAnswerFromBot(update);
    }

    @SneakyThrows
    public void sendAnswerFromBot(Update update) {
        Long chatId = update.getMessage().getChatId();
        if (update.getMessage().getText().equals("/start")) {
            sendMsg("kjbkj", chatId);
            sendMsgWithButtons("nbgj ibah", replyButtons.keyboardMarkupForSelectStudentOrTeacher(), chatId);
        }
        if (update.getMessage().getText().equals("/myusername")) {
            sendMsg("1743091433:AAGo6nzVVm5QRYPJ9XcouuiGCgnnsxsUvzc", chatId);
        }
        if (update.getMessage().getText().equals("/javasnula")) {
            sendMsg("https://vertex-academy.com/tutorials/ru/sozdanie-peremennyx-i-tipy-peremenny/", chatId);
        }
        if (update.getMessage().getText().equals("/slovar")) {
            sendMsg("https://translate.google.com/?hl=ru", chatId);
        }
        if (update.getMessage().getText().equals("/mesta")) {
            sendMsg("https://ru.wikipedia.org/wiki/%D0%91%D0%B5%D0%BB%D0%BE%D0%B2%D0%B5%D0%B6%D1%81%D0%BA%D0%B0%D1%8F_%D0%BF%D1%83%D1%89%D0%B0", chatId);
        }
        if (update.getMessage().getText().equals("/mesta")) {
            sendMsg("https://ru.wikipedia.org/wiki/%D0%91%D1%80%D0%B5%D1%81%D1%82%D1%81%D0%BA%D0%B0%D1%8F_%D0%BA%D1%80%D0%B5%D0%BF%D0%BE%D1%81%D1%82%D1%8C", chatId);
        }
        if (update.getMessage().getText().equals("/bustroformului")) {
            sendMsg("https://educon.by/", chatId);
        }

        if (update.getMessage().getText().equals("reactor")) {
            sendPhoto("https://eenergy.media/wp-content/uploads/2019/10/ITER11.jpg", chatId);
        }
        if (update.getMessage().getText().equals("locacia")) {
            sendLocation(chatId);
        }
        if (update.getMessage().getText().equals("номер")) {
            sendContact( chatId);
        }
        if (update.getMessage().getText().equals("помощь")) {
            sendMsg("чтобы получать информацию, надо вводить итуетивно понятные комманды", chatId);
        }
        if (update.getMessage().getText().equals("информоция по боту")) {
            sendMsg("какой-то текст", chatId);
        }
    }
    public synchronized void sendMsg(String message, Long chatId) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(chatId);
        sendMessage.setText(message);
        try {
            execute(sendMessage);
        } catch (TelegramApiException e) {
            System.out.println( "Exception: " + e.toString());
        }
    }

    public synchronized void sendContact(Long chatId) {
        SendContact sendContact = new SendContact();
        sendContact.setPhoneNumber("+441228935384");
        sendContact.setFirstName("пасхалка");
        sendContact.setLastName("сталкер 2");
        sendContact.setChatId(chatId);
        try {
            execute(sendContact);
        } catch (TelegramApiException e) {
            System.out.println( "Exception: " + e.toString());
        }
    }

  /*  public synchronized void sendDocument(Long chatId) {
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

    public synchronized void sendPhoto(String pathToPhoto, Long chatId) {
        SendPhoto sendPhotoRequest = new SendPhoto();
        sendPhotoRequest.setChatId(chatId);
        sendPhotoRequest.setPhoto(pathToPhoto);
        try {
            sendPhoto(sendPhotoRequest);
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


    @Override
    public String getBotUsername() {
        return "Yan";
    }

    @Override
    public String getBotToken() {
        return "1743091433:AAGo6nzVVm5QRYPJ9XcouuiGCgnnsxsUvzc";
    }
}