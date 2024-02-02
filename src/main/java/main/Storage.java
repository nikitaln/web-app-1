package main;

import java.util.ArrayList;
import java.util.List;

public class Storage {

    private final List<User> users = new ArrayList<>();
    private int idUser = 0;



    public List<User> getAllUsers() {
        return users;
    }


    //add user
    public void addUser(User user) {
        idUser = idUser + 1;
        user.setId(idUser);
        users.add(user);
        System.out.println("добавили в коллекцию юзера: " + user.getUsername() + " c ИД=" + user.getId());
    }


    //remove user
    public boolean removeUser(Integer userIdToRemove) {
        System.out.println("зашли в метод удаления");
        for (User user : getAllUsers()) {
            if (user.getId().equals(userIdToRemove)) {
                users.remove(user);
                System.out.println("удалили юзера: '" + user.getUsername() + "'");
                return true;
            }
        }
    return false;
    }



}
