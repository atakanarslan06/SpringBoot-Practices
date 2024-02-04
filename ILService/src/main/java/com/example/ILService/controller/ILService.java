package com.example.ILService.controller;

import com.example.ILService.model.Il;
import com.example.ILService.repository.IlRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@AllArgsConstructor
public class ILService {

    private final IlRepository ilRepository;

    public List<Il> getIller() {
        return ilRepository.findAll();
    }

    public Il createIl(Il newIl) {
        newIl.setCreateDate(new Date());
        return ilRepository.save(newIl);
    }

    public void deleteIl(String id) {
        ilRepository.deleteById(id);
    }

    public Il getIlNotFound(String id) {
        return ilRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("Il not found"));
    }
}
