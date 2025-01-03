package com.Rent.Service.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Rent.Service.model.Resource;
@Repository
public interface ResourceRepository extends JpaRepository<Resource, Long>{
    List<Resource> findByAvailabilityTrue(); 
}
