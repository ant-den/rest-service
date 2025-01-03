CREATE DATABASE renting_service;
USE renting_service;

CREATE TABLE resources (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    type VARCHAR(100),
    description VARCHAR(500),
    price DOUBLE NOT NULL,
    availability BOOLEAN DEFAULT TRUE,
    company_id BIGINT NOT NULL,
    CONSTRAINT fk_company_id FOREIGN KEY (company_id) REFERENCES companies (id)

);

INSERT INTO resources (name, type, description, price, availability)
VALUES ('Projector', 'Electronics', 'High-definition projector for meetings or events.', 150.0, TRUE,1),
       ('Laptop', 'Electronics', 'Laptop with Intel i7 processor and 16GB RAM.', 75.0, FALSE,1);

USE renting_service;

CREATE TABLE users (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    first_name VARCHAR(255) NOT NULL,
    last_name VARCHAR(255) NOT NULL,
    user_email VARCHAR(255) NOT NULL,
    user_phone BIGINT NOT NULL
);

INSERT INTO users (first_name, last_name, user_email, user_phone)
VALUES ('Artjom', 'Rump', 'ar@gmail.com', 23325267),
       ('Igor', 'Good', 'ig@gmail.com', 43342312);

USE renting_service;

CREATE TABLE companies (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    description TEXT,
    email VARCHAR(255) NOT NULL
);

INSERT INTO companies (name, description, email)
VALUES ('Tech Innovations', 'A company focused on technology solutions.', 'contact@techinnovations.com');