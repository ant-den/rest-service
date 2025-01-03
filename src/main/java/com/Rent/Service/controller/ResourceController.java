package com.Rent.Service.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.Rent.Service.model.Resource;
import com.Rent.Service.repository.ResourceRepository;
import com.Rent.Service.service.ResourceService;

@RestController
@RequestMapping("/resources")
public class ResourceController {

    @Autowired
    private ResourceRepository resourceRepository;
    @Autowired
    private ResourceService resourceService;

    /**
     * Get all resources.
     * 
     * @return List of all resources.
     */
    @GetMapping("/all")
    public ResponseEntity<List<Resource>> getResources() {
        List<Resource> resources = resourceRepository.findAll();
        return ResponseEntity.ok(resources);
    }

    /**
     * Get all available resources.
     * 
     * @return List of available resources.
     */
    @GetMapping("/available")
    public ResponseEntity<List<Resource>> getAllAvailableResources() {
        List<Resource> availableResources = resourceService.getAllAvailableResources();
        return ResponseEntity.ok(availableResources);
    }

    /**
     * Rent a resource by its ID.
     * 
     * @param id Resource ID to rent.
     * @return Success or failure message.
     */
    @PostMapping("/rent")
    public ResponseEntity<Map<String, String>> rentResource(@RequestParam long id) {
        boolean success = resourceService.rentResource(id);
        Map<String, String> response = new HashMap<>();
        if (success) {
            response.put("status", "success");
            response.put("message", "Item rented successfully.");
            return ResponseEntity.ok(response);
        } else {
            response.put("status", "failure");
            response.put("message", "Item is either already rented or not found.");
            return ResponseEntity.badRequest().body(response);
        }
    }
}
