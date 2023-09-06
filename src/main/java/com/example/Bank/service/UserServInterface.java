package com.example.Bank.service;

import com.example.Bank.Model.User;

import java.util.List;

public interface UserServInterface {

    void create(User user);

    List<User> readAll();
    User read(int id);

    boolean update(User user, int id);

    boolean delete(int id);
}
