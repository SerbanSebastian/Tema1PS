CREATE SCHEMA IF NOT EXISTS muzeu;

SET NAMES 'utf8mb4';
SET TIME_ZONE = '+2:00';

USE muzeu;

DROP TABLE IF EXISTS Users;

CREATE TABLE IF NOT EXISTS Users(
	first_name VARCHAR(100) NOT NULL, 
    last_name VARCHAR(100) NOT NULL, 
    email VARCHAR(100) NOT NULL PRIMARY KEY, 
    password VARCHAR(255) NOT NULL, 
    address VARCHAR(255) DEFAULT NULL, 
    phone VARCHAR(10) DEFAULT NULL, 
    creation_date DATETIME DEFAULT current_timestamp
);

DROP TABLE IF EXISTS Roles;

CREATE TABLE Roles(
	id BIGINT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY, 
    role_name VARCHAR(50) NOT NULL, 
    role_permissions VARCHAR(255), 
    CONSTRAINT UQ_Roles_Name UNIQUE (role_name)
);

DROP TABLE IF EXISTS UserRoles;

CREATE TABLE IF NOT EXISTS UserRoles
(
	id      BIGINT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
    user_id VARCHAR(100) NOT NULL,
    role_id BIGINT UNSIGNED NOT NULL,
    FOREIGN KEY (user_id) REFERENCES  Users (email) ON DELETE CASCADE  ON UPDATE CASCADE,
    FOREIGN KEY (role_id) REFERENCES  Roles (id) ON DELETE RESTRICT ON UPDATE CASCADE,
    CONSTRAINT UQ_UserRoles_User_Id UNIQUE (user_id)
);

DROP TABLE IF EXISTS Items;

CREATE TABLE Items
(
	id BIGINT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    artist VARCHAR(255) NOT NULL,
    art_type VARCHAR(255) NOT NULL,
    year_of_creation INT NOT NULL,
    country_of_origin VARCHAR(255)
);

INSERT INTO Items(title, artist, art_type, year_of_creation, country_of_origin) 
VALUES('Monalisa', 'Leonardo da Vinci', 'Renaissance', 1503, 'Italy');

SELECT * FROM Items;