package com.springexamp.events.service;

import com.springexamp.events.api.BookingApi;
import com.springexamp.events.event.ReservationCreatedEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class ReservationService {
    @Autowired
    ApplicationEventPublisher applicationEventPublisher;
    @Async
    public void publishReservationEvent(BookingApi.HotelBookRequest hotelBookRequest){
        applicationEventPublisher.publishEvent(new ReservationCreatedEvent(hotelBookRequest));
    }
}
