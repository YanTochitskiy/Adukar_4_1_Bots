package by.adukar.telegrambot.buttons.inline;
public class InlineButtons {
}
import by.adukar.telegrambot.consts.Paths;
        import by.adukar.telegrambot.service.TextService;
        import lombok.SneakyThrows;
        import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
        import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;
        import java.io.IOException;
        import java.util.ArrayList;
        import java.util.List;
public class InlineButtons {
    @SneakyThrows
    public InlineKeyboardMarkup keyboardMarkup() {
        List<List<InlineKeyboardButton>> listKeyboard = new ArrayList<>();
        List<InlineKeyboardButton> buttonsList = new ArrayList<>();
        InlineKeyboardButton keyboardButton = new InlineKeyboardButton();
        keyboardButton.setCallbackData("Инлайн");
        keyboardButton.setText("Инлайн кнопка");
        buttonsList.add(keyboardButton);
        listKeyboard.add(buttonsList);
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        inlineKeyboardMarkup.setKeyboard(listKeyboard);
        return inlineKeyboardMarkup;
    }
}