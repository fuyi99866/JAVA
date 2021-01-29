package com.example.consumer.client;

import com.example.consumer.pojo.User;
import org.springframework.stereotype.Component;

@Component
public class UserClientFailBack implements UserClient {
    @Override
    public User queryUserById(Long id) {
        User user = new User();
        user.setUserName("服务器正忙，请稍后再试!");
        return user;
    }
}
