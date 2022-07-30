USE mydatabase;

DROP TABLE IF EXISTS users;

CREATE TABLE users (
    user_id CHAR(64) NOT NULL,
    user_name CHAR(64) NOT NULL,
    user_surname CHAR(64) NOT NULL,
    room_number INTEGER NOT NULL,
    PRIMARY KEY (user_id)
);

INSERT INTO users VALUES
    ('00000000000', 'Ani', 'Odishelidze', 1);