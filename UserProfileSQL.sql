USE mystore_servlet;

DROP TABLE IF EXISTS UserProfile;
CREATE TABLE UserProfile (
	firstname VARCHAR(255) NOT NULL,
    lastname VARCHAR(255) NOT NULL,
    username VARCHAR(255) NOT NULL,
    password VARCHAR(255) NOT NULL,
    cartProducts VARCHAR(255) NULL,
    email VARCHAR(255) NULL
);

select * from UserProfile;