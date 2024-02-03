package com.springexamp.events.api;

import com.springexamp.events.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/book")
public class BookingApi {
    @Autowired
    private ReservationService reservationService;

    @PostMapping
    public void bookHotel(@RequestBody HotelBookRequest hotelBookRequest){
        reservationService.publishReservationEvent(hotelBookRequest);
        System.out.println("Kullanıcı istegi isleme alindi.");
    }
    public class HotelBookRequest{
        private String userId;
        private String hotelId;

        public String getUserId() {
            return userId;
        }

        public void setUserId(String userId) {
            this.userId = userId;
        }

        public String getHotelId() {
            return hotelId;
        }

        public void setHotelId(String hotelId) {
            this.hotelId = hotelId;
        }

        @Override
        public String toString() {
            return "HotelBookRequest{" +
                    "userId='" + userId + '\'' +
                    ", hotelId='" + hotelId + '\'' +
                    '}';
        }
    }
}
