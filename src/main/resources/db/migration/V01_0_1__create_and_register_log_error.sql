
CREATE TABLE log_error (
  id SERIAL PRIMARY KEY,
  title VARCHAR(100) NOT NULL,
  number_events BIGINT,
  level_log VARCHAR(100) NOT NULL,
  status VARCHAR(100) NOT NULL,
  environment VARCHAR(100) NOT NULL,
  description VARCHAR(100) NOT NULL,
  details VARCHAR(100),
  ip VARCHAR(45) NOT NULL,
  stack_trace VARCHAR(100) NOT NULL,
  user_id BIGINT,
  source_application VARCHAR(100),
  created_at TIMESTAMP NOT NULL default CURRENT_TIMESTAMP
);

INSERT INTO log_error (title, number_events, level_log, status, environment, description, details, ip, stack_trace, user_id, source_application) values ('LoggerExample', '1', 'WARNING', 'ACTIVE', 'DEV', 'Can cause ArrayIndexOutOfBoundsException', 'log details', '192.168.15.42', 'br.com.quintolog', '1', 'API Example')