package com.example.demo.repository;


import com.example.demo.Module.Car;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * Spring Data MongoDB repository for the Car entity.
 */
@SuppressWarnings("unused")
@Repository
public interface CarRepository extends MongoRepository<Car, String> {}
