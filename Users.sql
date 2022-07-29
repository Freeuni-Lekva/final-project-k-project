USE myDatabase;

DROP TABLE IF EXISTS users;

CREATE TABLE users (
    user_name CHAR(64),
    user_password CHAR(64),
    quiz_taken BIGINT
);

INSERT INTO users VALUES
('Mariam', 'password1', 20),
('Ani', 'password2', 50)