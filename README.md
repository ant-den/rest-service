# Rental Service Project

## Description
This repository contains a RESTful service for renting various items. This project was created as a practice exercise, so the code is not perfect and still requires improvements. It is a simple rental service where users can rent items listed by companies.

The service includes:
- A **User** model that represents the system's users.
- A **Resource** model for items that can be rented.
- A **Company** model that owns and manages the resources.

### Core Features:
1. **Resource Creation**: Companies can create new resources (items) and associate them with their company. This allows companies to manage the items they offer for rent.
2. **Resource Reservation**: Users can reserve items from the available resources. When a user reserves an item, the **availability** of that item is updated in the database, marking it as unavailable for others until the reservation is canceled or expires.

All data, including users, resources, and companies, are stored in a database running on localhost. The **Resource** table is associated with the **Company** model, meaning only companies can create new resources.

## API Testing

As for the user interface, I have not implemented a front-end but have used **Swagger UI** for easy API testing. This allows you to test the service endpoints without needing a separate UI, making it convenient to interact with and verify functionality.

## Planned Improvements

While the project works successfully as a first-time effort, there are still areas for improvement:
- Add automated testing for the service.
- Introduce **DTO (Data Transfer Object)** classes for better data handling.
- Improve data persistence to make database interactions more efficient.
- Create a **User-Rented-Items** table to track the items rented by each user.

## Database Structure

The project uses a local database, and its structure can be found in the `RentingService.sql` file. This file includes all the tables necessary for users, resources, and companies.


