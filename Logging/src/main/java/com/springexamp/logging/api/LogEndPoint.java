package com.springexamp.logging.api;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/log")
public class LogEndPoint {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @GetMapping
    public String getDetails(){
         log.info("get details method basladi");
         return internalLogDetail();
    }


    private String internalLogDetail(){
        try {
            log.debug("get details method basladi");
            Thread.sleep(1000);
            return "API Mesaj";

        }catch (InterruptedException e){
            log.error("Hata : {}", e);
        }
        return "";
    }

    /*
    - Loglama Asenkron Olmalıdır.
    - printStackTrace ve System.out.printler kullanılmamalı. (Format açısından aykırı)
    - Sensitive data olmalıdır.
    - Tum loglar merkezi bir yerde toplanmalıdır, belli formatta
    */
}
