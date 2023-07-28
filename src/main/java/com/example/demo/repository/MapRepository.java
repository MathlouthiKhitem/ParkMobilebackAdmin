package com.example.demo.repository;


import com.example.demo.Module.Map;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * Spring Data MongoDB repository for the Map entity.
 */
@SuppressWarnings("unused")
@Repository
public interface MapRepository extends MongoRepository<Map, String> {}
