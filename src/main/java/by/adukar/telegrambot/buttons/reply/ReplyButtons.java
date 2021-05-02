package by.adukar.telegrambot.buttons.reply;

import by.adukar.telegrambot.consts.Paths;
import by.adukar.telegrambot.service.TextService;
import org.telegram.telegrambots.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.api.objects.replykeyboard.buttons.KeyboardRow;

import java.io.IOException;
import java.util.ArrayList;

public class ReplyButtons {

    TextService textService = new TextService();

    public ReplyKeyboardMarkup keyboardMarkupForSelectStudentOrTeacher() {

        ArrayList<KeyboardRow> keyboard = new ArrayList<>();
        KeyboardRow keyboardFirstRow = new KeyboardRow();
        KeyboardRow keyboardSecondRow = new KeyboardRow();
        ReplyKeyboardMarkup keyboardMarkup = new ReplyKeyboardMarkup();
        keyboardMarkup.setSelective(true);
        keyboardMarkup.setResizeKeyboard(true);
        keyboardMarkup.setOneTimeKeyboard(false);
            keyboardFirstRow.add("номер");
            keyboardFirstRow.add("помощь");
            keyboardFirstRow.add("информация по боту");


            keyboardSecondRow.add("b1");
            keyboardSecondRow.add("b2");
            keyboardSecondRow.add("b3");



        keyboard.add(keyboardFirstRow);
        keyboard.add(keyboardSecondRow);


        keyboardMarkup.setKeyboard(keyboard);
        return keyboardMarkup;

    }
}
