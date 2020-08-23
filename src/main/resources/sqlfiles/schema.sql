DROP TABLE IF EXISTS USER;
DROP TABLE IF EXISTS WORD;
DROP TABLE IF EXISTS ASSOCIATION;

CREATE TABLE USER (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  first_name VARCHAR(250) NOT NULL,
  last_name VARCHAR(250) NOT NULL,
  mail_address VARCHAR(250) NOT NULL,
  password VARCHAR(250) NOT NULL
);
 
CREATE TABLE WORD (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  name VARCHAR(250) NOT NULL
);

CREATE TABLE ASSOCIATION (
 id INT AUTO_INCREMENT PRIMARY KEY,
 user_id INT NOT NULL,
 word VARCHAR(250) NOT NULL,
 associations VARCHAR(250) NOT NULL,
 association_date DATE NOT NULL,
 FOREIGN KEY (user_id) REFERENCES USER(id)
);