package main;

import java.util.ArrayList;
import java.util.List;

public class Storage {

    public static List<User> users = new ArrayList<>();

    public void addUser(User user) {
        users.add(user);
        System.out.println("Добавили в коллекцию");
    }
}
