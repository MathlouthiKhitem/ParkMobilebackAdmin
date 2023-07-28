package com.example.demo.repository;

import  com.example.demo.Module.Users;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Spring Data MongoDB repository for the Users entity.
 */
@SuppressWarnings("unused")
@Repository
public interface UsersRepository extends MongoRepository<Users, String> {
    List<Users> findByEmail(String email);

    List<Users> findByType(String type);


}
