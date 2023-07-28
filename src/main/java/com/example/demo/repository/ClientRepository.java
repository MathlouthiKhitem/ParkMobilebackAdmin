package com.example.demo.repository;

import com.example.demo.Module.Client;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Spring Data MongoDB repository for the Client entity.
 */
@Repository
public interface ClientRepository extends MongoRepository<Client, String> {
    @Query("{}")
    Page<Client> findAllWithEagerRelationships(Pageable pageable);

    @Query("{}")
    List<Client> findAllWithEagerRelationships();

    @Query("{'id': ?0}")
    Optional<Client> findOneWithEagerRelationships(String id);
    Client findByUsersId(String userId);
}
