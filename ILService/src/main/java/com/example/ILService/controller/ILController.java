package com.example.ILService.controller;

import com.example.ILService.model.Il;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/iller")
public class ILController {

    public static final List<Il> iller = new ArrayList<>();

    public ILController(){

        if (iller.isEmpty()){

            Il il1 = new Il("06", "Ankara", new Date());
            Il il2 = new Il("66", "Yozgat", new Date());

            iller.add(il1);
            iller.add(il2);}
    }

    @GetMapping
    public ResponseEntity<List<Il>> getIller() {

        return new ResponseEntity<>(iller, OK);

    }
    @GetMapping("/{id}")
    public ResponseEntity<Il> getIl(@PathVariable String id){
        Il result = getIlNoutFound(id);
        return new ResponseEntity<>(result, OK);
    }


    @PostMapping
    public ResponseEntity<Il> createIl(@RequestBody Il newIl) {
        newIl.setCreateDate(new Date());
        iller.add(newIl);
        return new ResponseEntity<>(newIl, CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Il> upgradeIl(@PathVariable String id, @RequestBody Il newIl){
        Il oldIl = getIlNoutFound(id);
        oldIl.setName(newIl.getName());
        oldIl.setCreateDate(new Date());

        return new ResponseEntity<>(OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteIl(@PathVariable String id){
        Il il = getIlNoutFound(id);
        iller.remove(il);

        return new ResponseEntity<>(OK);
    }

    private static Il getIlNoutFound(String id) {
        return iller.stream()
                .filter(il -> il.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Il nout found"));
    }
}
