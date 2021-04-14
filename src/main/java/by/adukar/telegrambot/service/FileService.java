package by.adukar.telegrambot.service;

import by.adukar.telegrambot.model.User;
import lombok.SneakyThrows;

import java.io.FileWriter;
import java.io.IOException;

public class FileService {

     @SneakyThrows
     public void writeUserToFile(User user) {
         try (FileWriter writer = new FileWriter("users.txt", true)) {
             writer.write(user.toString() + "\n");
             writer.flush();
         } catch (IOException ex) {
             System.out.println(ex.getMessage());
         }
     }
}
