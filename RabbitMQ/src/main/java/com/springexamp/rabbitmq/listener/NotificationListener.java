package src.main.java.com.springexamp.rabbitmq.listener;

import org.springframework.stereotype.Service;
import src.main.java.com.springexamp.rabbitmq.model.Notification;

@Service
public class NotificationListener {
    @RabbitListener
    public void handleMessage (Notification notification){
        System.out.println(notification.toString());
    }
}
