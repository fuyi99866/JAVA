package com.example.consumer.client;

import com.example.consumer.pojo.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "server-provider",fallback = UserClientFailBack.class)
/*@RequestMapping("user")*/
public interface UserClient {
    @GetMapping("user/{id}")
    public User queryUserById(@PathVariable("id")Long id);
}
