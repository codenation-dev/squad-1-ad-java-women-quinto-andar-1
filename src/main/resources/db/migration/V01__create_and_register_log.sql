CREATE TABLE log (

	id BIGINT(20) PRIMARY KEY AUTO,
	numberEvents BIGINT(20) NOT NULL,
	level ENUM('DEBUG','ERROR','WARNING','OTHERS'),
	status ENUM('ACTIVE','INACTIVE','OTHERS'),
	environment ENUM('PRODUCTION','HOMOLOGATION','DEV'),
	description VARCHAR(100) NOT NULL,
	details VARCHAR(100) NOT NULL,
	date TIMESTAMP NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO log (description) values ('log1');
INSERT INTO log (description) values ('log2');
INSERT INTO log (description) values ('log3');
INSERT INTO log (description) values ('log4');
INSERT INTO log (description) values ('log5');