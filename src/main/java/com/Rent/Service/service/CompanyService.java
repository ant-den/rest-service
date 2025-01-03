package com.Rent.Service.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Rent.Service.model.Company;
import com.Rent.Service.model.Resource;
import com.Rent.Service.repository.CompanyRepository;
import com.Rent.Service.repository.ResourceRepository;

@Service
public class CompanyService {

    @Autowired
    private CompanyRepository companyRepository;
    @Autowired
    private ResourceRepository resourceRepository;
    
    public Resource createResourceOfCompany(Long companyId, String resourceName, String resourceType,
            String resourceDescription, Double resourcePrice) {
        Company company = companyRepository.findById(companyId).orElse(null);
        if (company != null) {
            Resource resource = new Resource();
            resource.setName(resourceName);
            resource.setType(resourceType);
            resource.setDescription(resourceDescription);
            resource.setPrice(resourcePrice);
            resource.setAvailability(true);
            resource.setCompany(company);
            return resourceRepository.save(resource);
        }
        return null; 
    }

    public List<Company> getAllCompanies() {
        return companyRepository.findAll();
    }

    public boolean registerCompany(Company company) {
        try {
            companyRepository.save(company);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
