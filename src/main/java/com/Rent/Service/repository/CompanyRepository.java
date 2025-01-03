package com.Rent.Service.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Rent.Service.model.Company;

public interface CompanyRepository extends JpaRepository<Company,Long>{
}
