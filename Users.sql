USE myDatabase;

-- remove table if it already exists and start from scratch
DROP TABLE IF EXISTS users;

CREATE TABLE users (
    user_name CHAR(64),
    quiz_taken INTEGER
);

INSERT INTO users VALUES
('Mariam', 20),
('Ani', 50),
('Nini', 70),
('Luka', 90),
('Elene', 91)