DROP TABLE IF EXISTS USER;
DROP TABLE IF EXISTS WORD;
DROP TABLE IF EXISTS ASSOCIATION;

CREATE TABLE USER (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  first_name VARCHAR(250) NOT NULL,
  last_name VARCHAR(250) NOT NULL,
  mail_address VARCHAR(250) NOT NULL,
  password VARCHAR(250) NOT NULL,
  language VARCHAR(2) NOT NULL,
  UNIQUE KEY user_constraint (mail_address)
);
 
CREATE TABLE WORD (
  id INT AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR(250) NOT NULL,
  language VARCHAR(2) NOT NULL,
  UNIQUE KEY word_constraint (name, language)
);

CREATE TABLE ASSOCIATION (
 id INT AUTO_INCREMENT PRIMARY KEY,
 user_id INT NOT NULL,
 word_id INT NOT NULL,
 association VARCHAR(250) NOT NULL,
 association_date DATE NOT NULL,
 FOREIGN KEY (user_id) REFERENCES USER(id),
 FOREIGN KEY (word_id) REFERENCES WORD(id),
 UNIQUE KEY association_constraint (user_id, word_id, association)
 );