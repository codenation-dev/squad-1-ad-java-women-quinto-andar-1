CREATE TABLE log_user (
  id SERIAL PRIMARY KEY,
  name VARCHAR(100) NOT NULL,
  email VARCHAR(100) NOT NULL,
  password VARCHAR(100) NOT NULL,
  securityQuestion BIGINT,
  securityAnswer VARCHAR(100) NOT NULL
);

INSERT INTO log_user (name, email, password, securityQuestion, securityAnswer) values ('Bruna', 'bruna.iriz@gmail.com', 'test@123', '1', 'Helena')
