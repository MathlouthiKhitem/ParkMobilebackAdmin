package com.example.demo.repository;


import com.example.demo.Module.Zone;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Spring Data MongoDB repository for the Zone entity.
 */
@SuppressWarnings("unused")
@Repository
public interface ZoneRepository extends MongoRepository<Zone, String> {
    Optional<Zone> findByNameZone(String nameZone);
}
