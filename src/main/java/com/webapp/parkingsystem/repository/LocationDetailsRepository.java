package com.webapp.parkingsystem.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.webapp.parkingsystem.domain.Location;

@Repository
public interface LocationDetailsRepository extends MongoRepository<Location, String> {
}
