CREATE DATABASE Test;

USE Test;

CREATE TABLE Users (
    ID INT(6) UNSIGNED PRIMARY KEY,
    Username VARCHAR(20) NOT NULL,
    Password VARCHAR(30) NOT NULL,
    Name VARCHAR(30) NOT NULL,
    Phone_number CHAR(15) NOT NULL
);