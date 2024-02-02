package com.springexamp.aop.service;

import org.springframework.stereotype.Service;

@Service
public class MessageService {

    public String mesajVer(String param){
        System.out.println("Metod Mesaj verdi param :" + param);
        return param;
    }
}
