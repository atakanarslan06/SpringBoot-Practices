package com.example.ILService.controller;

import com.example.ILService.model.Il;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Date;
import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/iller")
@AllArgsConstructor
public class ILController {

    private final ILService  ilService;

    @GetMapping
    public ResponseEntity<List<Il>> getIller() {

        return new ResponseEntity<>(ilService.getIller(), OK);

    }
    @GetMapping("/{id}")
    public ResponseEntity<Il> getIl(@PathVariable String id){
        return new ResponseEntity<>(getIlNotFound(id), OK);
    }


    @PostMapping
    public ResponseEntity<Il> createIl(@RequestBody Il newIl) {
        return new ResponseEntity<>(ilService.createIl(newIl), CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Il> upgradeIl(@PathVariable String id, @RequestBody Il newIl){
        Il oldIl = getIlNotFound(id);
        oldIl.setName(newIl.getName());
        oldIl.setCreateDate(new Date());

        return new ResponseEntity<>(OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteIl(@PathVariable String id){
        ilService.deleteIl(id);
        return new ResponseEntity<>(OK);
    }

    private  Il getIlNotFound(String id) {
       return ilService.getIlNotFound(id);
    }
}
