package com.sb.service;

import com.sb.model.User;
import java.util.List;

public interface UserService {
    void save(User user);

    List<User> list();
}