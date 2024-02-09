package com.example.ILService.repository;

import com.example.ILService.model.Il;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface IlRepository extends MongoRepository<Il, String> {
}
