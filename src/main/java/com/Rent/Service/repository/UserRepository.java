package com.Rent.Service.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Rent.Service.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    List<User>findAll();
}
