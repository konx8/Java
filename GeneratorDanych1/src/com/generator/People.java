package com.generator;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name = "People")
@XmlAccessorType (XmlAccessType.FIELD)

public class People {

    List<User> users = new ArrayList<>();

    public List<User> getUsers() {
        return users;
    }

    public void setUser(List<User> users) {
        this.users = users;
    }

    private static int ID = 0;

    public void addUser(String n, String s, String l) {
        User user = new User(n, s, l, getNextId());

        users.add(user);

    }

    public void addUser(String n, String s, String l, String email,int accountNum, int money) {
        User user = new User(n, s, l, getNextId());
        user.createAccount(accountNum,money);
        if (emailAdress(email)){
            user.setEmail(email);
        }
        else {
            user.setEmail("brak emaila");
        }
        users.add(user);

    }

    public void addUser(String n, String s, String l, String email) {
        User user = new User(n, s, l, getNextId());
        if (emailAdress(email)){
            user.setEmail(email);
        }
        else {
            user.setEmail("brak emaila");
        }
        users.add(user);

    }

    public void delUser(String name) {
        users.removeIf(user -> user.getName().equals(name));
    }

    public void upDate(int x, String n, String s, String l) {
        users.get(x).setName(n);
        users.get(x).setSurname(s);
        users.get(x).setLogin(l);
    }

    public User readData(String name) {
        for (User user : users) {
            if (user.getName().equals(name)) {
                return user;
            }
        }
        return null;
    }

    public int getNextId() {
        ID++;
        return ID;
    }

    public void addUser(User user) {
        user.setID(getNextId());
        users.add(user);
    }

    public boolean emailAdress(String email) {
        if ((email.contains("@"))) {
            System.out.println("email poprawny");
            return true;
        } else {
            System.out.println("email niepoprawny");
        }
        return false;
    }


}


