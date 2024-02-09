package com.springexamp.aop.api;

import com.springexamp.aop.service.MessageService;
import com.springexamp.aop.service.SecondMessageService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/message")
public class MessageApi {
    @Autowired
    private MessageService messageService;
    @Autowired
    private SecondMessageService secondMessageService;

    @PostMapping
    public ResponseEntity<String> ornekMethod(@RequestBody String message) {
        secondMessageService.mesaj(message);
        return ResponseEntity.ok(messageService.mesajVer(message));
    }
}
