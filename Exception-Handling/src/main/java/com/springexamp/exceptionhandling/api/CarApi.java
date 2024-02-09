package com.springexamp.exceptionhandling.api;

import com.springexamp.exceptionhandling.dto.Car;
import com.springexamp.exceptionhandling.exception.EntityNotFoundException;
import com.springexamp.exceptionhandling.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/car")
public class CarApi {
    @Autowired
    private CarService carService;

    @GetMapping
    public ResponseEntity<Car> getCar(@RequestParam String name) {
        return ResponseEntity.ok(carService.getCar(name));
    }

//    @ExceptionHandler({EntityNotFoundException.class})
//    public String entityNotFound() {
//        return "Report not found";
//  }
}
