CREATE TABLE candidates (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    firstname VARCHAR(255),
    lastname VARCHAR(255),
    email VARCHAR(255) UNIQUE NOT NULL,
    password VARCHAR(255),
    gender VARCHAR(10),
    salary_expected DECIMAL(19, 2),
    integration_date DATE
);