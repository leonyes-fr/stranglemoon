CREATE TABLE users
(
 userId SERIAL PRIMARY KEY,
 username varchar(100) DEFAULT NULL,
 password varchar(100) DEFAULT NULL,
 email varchar(100) DEFAULT NULL
);