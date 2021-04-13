package by.adukar.telegrambot.buttons.reply;

import by.adukar.telegrambot.service.TextService;
import org.telegram.telegrambots.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.api.objects.replykeyboard.buttons.KeyboardRow;

import java.io.IOException;
import java.util.ArrayList;

public class ReplyButtons {

    TextService textService = new TextService();
    String pathToButtonsStringProperties = "message.buttonsString.properties";

    public ReplyKeyboardMarkup keyboardMarkupForSelectStudentOrTeacher() {

        ArrayList<KeyboardRow> keyboard = new ArrayList<>();
        KeyboardRow keyboardFirstRow = new KeyboardRow();

        ReplyKeyboardMarkup keyboardMarkup = new ReplyKeyboardMarkup();
        keyboardMarkup.setSelective(true);
        keyboardMarkup.setResizeKeyboard(true);
        keyboardMarkup.setOneTimeKeyboard(false);
        try {
            keyboardFirstRow.add(textService.getPropValues(pathToButtonsStringProperties, "reply.messageForButton.Student"));
            keyboardFirstRow.add(textService.getPropValues(pathToButtonsStringProperties, "reply.messageForButton.Teacher"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        keyboard.add(keyboardFirstRow);
        keyboardMarkup.setKeyboard(keyboard);
        return keyboardMarkup;

    }
}
