package com.springexamp.dockerization;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/mesaj")

public class MessageApi {
    @GetMapping
    public String mesajVer(){
        return "Docker Image inin icerisinden merhaba";
    }
}
