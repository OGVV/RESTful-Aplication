package com.example.Bank.service;

import com.example.Bank.Model.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class UserServ implements UserServInterface {

    public static final Map<Integer,User> USERS = new HashMap<>();
    private static final AtomicInteger USER_ID_HOLDER = new AtomicInteger();
    @Override
    public void create(User user) {
        final int userId = USER_ID_HOLDER.incrementAndGet();
        user.setId(userId);
        USERS.put(userId,user);

    }

    @Override
    public List<User> readAll() {

        return new ArrayList<>(USERS.values());
    }

    @Override
    public User read(int id) {

        return USERS.get(id);
    }

    @Override
    public boolean update(User user, int id) {
        if (USERS.containsKey(id)) {
            user.setId(id);
            USERS.put(id, user);
            return true;
        }
        return false;
    }

    @Override
    public boolean delete(int id) {
        return USERS.remove(id) != null;
    }

}
