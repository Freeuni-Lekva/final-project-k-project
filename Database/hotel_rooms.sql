USE myDatabase;

SET FOREIGN_KEY_CHECKS = 0;

DROP TABLE IF EXISTS hotel_rooms;

CREATE TABLE hotel_rooms (
    room_id INTEGER NOT NULL,
    room_type CHAR(64),
    price_per_day INTEGER,
    meal_included_price INTEGER,
    pool_gym_included_price INTEGER,
    air_conditioning CHAR(64),
    television CHAR(64),
    balcony CHAR(64),
    view CHAR(64),
    free_wifi CHAR(64),
    PRIMARY KEY (room_id)
);

INSERT INTO hotel_rooms VALUES
    (1, 'Single room', 300, 335, 400, '+', '+', '-', 'Hotel garden', '+'),
    (2, 'Single room', 300, 335, 400, '+', '+', '-', 'Hotel garden', '+'),
    (3, 'Single room', 300, 335, 400, '+', '+', '-', 'Hotel garden', '+'),
    (4, 'Single room', 300, 335, 400, '+', '+', '-', 'Hotel garden', '+'),
    (5, 'Single room', 300, 335, 400, '+', '+', '-', 'Hotel garden', '+'),
    (6, 'Single room', 300, 335, 400, '+', '+', '-', 'Woods', '+'),
    (7, 'Single room', 300, 335, 400, '+', '+', '-', 'Woods', '+'),
    (8, 'Single room', 300, 335, 400, '+', '+', '-', 'Woods', '+'),
    (9, 'Single room', 300, 335, 400, '+', '+', '-', 'Woods', '+'),
    (10, 'Single room', 300, 335, 400, '+', '+', '-', 'Woods', '+'),
    (11, 'Double room', 400, 435, 500, '+', '+', '+', 'Hotel garden', '+'),
    (12, 'Double room', 400, 435, 500, '+', '+', '+', 'Hotel garden', '+'),
    (13, 'Double room', 400, 435, 500, '+', '+', '+', 'Hotel garden', '+'),
    (14, 'Double room', 400, 435, 500, '+', '+', '+', 'Hotel garden', '+'),
    (15, 'Double room', 400, 435, 500, '+', '+', '+', 'Hotel garden', '+'),
    (16, 'Double room', 400, 435, 500, '+', '+', '+', 'Woods', '+'),
    (17, 'Double room', 400, 435, 500, '+', '+', '+', 'Woods', '+'),
    (18, 'Double room', 400, 435, 500, '+', '+', '+', 'Woods', '+'),
    (19, 'Double room', 400, 435, 500, '+', '+', '+', 'Woods', '+'),
    (20, 'Double room', 400, 435, 500, '+', '+', '+', 'Woods', '+'),
    (21, 'Triple room', 500, 535, 600, '+', '+', '+', 'Hotel garden', '+'),
    (22, 'Triple room', 500, 535, 600, '+', '+', '+', 'Hotel garden', '+'),
    (23, 'Triple room', 500, 535, 600, '+', '+', '+', 'Hotel garden', '+'),
    (24, 'Triple room', 500, 535, 600, '+', '+', '+', 'Hotel garden', '+'),
    (25, 'Triple room', 500, 535, 600, '+', '+', '+', 'Hotel garden', '+'),
    (26, 'Triple room', 500, 535, 600, '+', '+', '+', 'Woods', '+'),
    (27, 'Triple room', 500, 535, 600, '+', '+', '+', 'Woods', '+'),
    (28, 'Triple room', 500, 535, 600, '+', '+', '+', 'Woods', '+'),
    (29, 'Triple room', 500, 535, 600, '+', '+', '+', 'Woods', '+'),
    (30, 'Triple room', 500, 535, 600, '+', '+', '+', 'Woods', '+'),
    (31, 'Lux room', 1000, 1100, 1300, '+', '+', '+', 'Hotel garden', '+'),
    (32, 'Lux room', 1000, 1100, 1300, '+', '+', '+', 'Hotel garden', '+'),
    (33, 'Lux room', 1000, 1100, 1300, '+', '+', '+', 'Woods', '+'),
    (34, 'Lux room', 1000, 1100, 1300, '+', '+', '+', 'Woods', '+');