package com.example.demo.repository;

import com.example.demo.Module.Admin;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * Spring Data MongoDB repository for the Admin entity.
 */
@SuppressWarnings("unused")
@Repository
public interface AdminRepository extends MongoRepository<Admin, String> {}
