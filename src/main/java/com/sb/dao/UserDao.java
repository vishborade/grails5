package com.sb.dao;
import com.sb.model.User;
import java.util.List;

public interface UserDao {
    void save(User user);
    List<User> list();
}