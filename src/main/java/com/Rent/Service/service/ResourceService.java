package com.Rent.Service.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Rent.Service.model.Resource;
import com.Rent.Service.repository.ResourceRepository;

import jakarta.transaction.Transactional;

@Service
public class ResourceService {
    @Autowired
    private  ResourceRepository resourceRepository;


    public List<Resource> getAllAvailableResources() {
        return resourceRepository.findByAvailabilityTrue();
    }
    @Transactional
    public boolean rentResource(Long id) {
        Resource resource = resourceRepository.findById(id).orElse(null);
        if (resource == null) {
            return false;
        }
        if (!resource.getAvailability()) {
            return false;
        }
        resource.setAvailability(false);
        resourceRepository.save(resource);
        return true;
    }
}
