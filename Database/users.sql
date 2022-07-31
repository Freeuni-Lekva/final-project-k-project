USE myDatabase;

SET FOREIGN_KEY_CHECKS = 0;

DROP TABLE IF EXISTS users;

CREATE TABLE users (
    user_mail CHAR(64) NOT NULL,
    user_name CHAR(64) NOT NULL,
    user_surname CHAR(64) NOT NULL,
    PRIMARY KEY (user_mail)
);

INSERT INTO users VALUES
    ('00000000000', 'Ani', 'Odishelidze');