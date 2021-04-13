package by.adukar.telegrambot.buttons.reply;

import org.telegram.telegrambots.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.api.objects.replykeyboard.buttons.KeyboardRow;

import java.util.ArrayList;

public class ReplyButtons {


    public ReplyKeyboardMarkup keyboardMarkupForSelectStudentOrTeacher() {
        ArrayList<KeyboardRow> keyboard = new ArrayList<>();
        KeyboardRow keyboardFirstRow = new KeyboardRow();

        ReplyKeyboardMarkup keyboardMarkup = new ReplyKeyboardMarkup();
        keyboardMarkup.setSelective(true);
        keyboardMarkup.setResizeKeyboard(true);
        keyboardMarkup.setOneTimeKeyboard(false);

        keyboardFirstRow.add("Студент");
        keyboardFirstRow.add("Преподаватель");

        keyboard.add(keyboardFirstRow);

        keyboardMarkup.setKeyboard(keyboard);
        return keyboardMarkup;
    }
}
