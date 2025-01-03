package com.Rent.Service.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.Rent.Service.model.Company;
import com.Rent.Service.model.Resource;
import com.Rent.Service.service.CompanyService;

@RestController
@RequestMapping("/companies")
public class CompanyController {

    @Autowired
    private CompanyService companyService;

    /**
     * Get all companies.
     * 
     * @return List of all companies.
     */
    @GetMapping("/all")
    public List<Company> getAllCompanies() {
        return companyService.getAllCompanies();
    }

    /**
     * Create a new resource for a company.
     * 
     * @param companyId          ID of the company.
     * @param resourceName       Name of the resource.
     * @param resourceType       Type of the resource.
     * @param resourceDescription Description of the resource.
     * @param resourcePrice      Price of the resource.
     * @return The created Resource object or error message.
     */

    @PostMapping("/resources")
    public Resource createResourceOfCompany(@RequestParam Long companyId,
            @RequestParam String resourceName,
            @RequestParam String resourceType,
            @RequestParam String resourceDescription,
            @RequestParam Double resourcePrice) {
        return companyService.createResourceOfCompany(companyId, resourceName, resourceType, resourceDescription,
                resourcePrice);
    }

     /**
     * Register a new company.
     * 
     * @param company The company object to be registered.
     * @return Success or failure message.
     */

    @PostMapping("/register")
    public String registerCompany(@RequestBody Company company) {
        boolean success = companyService.registerCompany(company);
        if (success) {
            return "Company registered successfully.";
        } else {
            return "Company registration failed. Please try again.";
        }
    }

}
