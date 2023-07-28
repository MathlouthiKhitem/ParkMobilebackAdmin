package com.example.demo.repository;
import  com.example.demo.Module.Parkings;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Spring Data MongoDB repository for the Parkings entity.
 */
@Repository
public interface ParkingsRepository extends MongoRepository<Parkings, String> {
    Optional<Parkings> findBySessionsId(String sessionId);
    //    Parkings findByNumeroParkingAndZoneTitle(String numeroParking, String title);
    List<Parkings> findByNumeroParkingAndZoneTitleIn(String numeroParking, List<String> titles);


    @Query("{}")
    Page<Parkings> findAllWithEagerRelationships(Pageable pageable);

    @Query("{}")
    List<Parkings> findAllWithEagerRelationships();

    @Query("{'id': ?0}")
    Optional<Parkings> findOneWithEagerRelationships(String id);


}
