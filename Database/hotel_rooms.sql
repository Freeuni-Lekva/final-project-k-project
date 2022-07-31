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
    (1, 'Single Room', 300, 335, 400, '+', '+', '-', 'Hotel garden', '+'),
    (2, 'Single Room', 300, 335, 400, '+', '+', '-', 'Hotel garden', '+'),
    (3, 'Single Room', 300, 335, 400, '+', '+', '-', 'Hotel garden', '+'),
    (4, 'Single Room', 300, 335, 400, '+', '+', '-', 'Hotel garden', '+'),
    (5, 'Single Room', 300, 335, 400, '+', '+', '-', 'Hotel garden', '+'),
    (6, 'Single Room', 300, 335, 400, '+', '+', '-', 'Woods', '+'),
    (7, 'Single Room', 300, 335, 400, '+', '+', '-', 'Woods', '+'),
    (8, 'Single Room', 300, 335, 400, '+', '+', '-', 'Woods', '+'),
    (9, 'Single Room', 300, 335, 400, '+', '+', '-', 'Woods', '+'),
    (10, 'Single Room', 300, 335, 400, '+', '+', '-', 'Woods', '+'),
    (11, 'Double Room', 400, 435, 500, '+', '+', '+', 'Hotel garden', '+'),
    (12, 'Double Room', 400, 435, 500, '+', '+', '+', 'Hotel garden', '+'),
    (13, 'Double Room', 400, 435, 500, '+', '+', '+', 'Hotel garden', '+'),
    (14, 'Double Room', 400, 435, 500, '+', '+', '+', 'Hotel garden', '+'),
    (15, 'Double Room', 400, 435, 500, '+', '+', '+', 'Hotel garden', '+'),
    (16, 'Double Room', 400, 435, 500, '+', '+', '+', 'Woods', '+'),
    (17, 'Double Room', 400, 435, 500, '+', '+', '+', 'Woods', '+'),
    (18, 'Double Room', 400, 435, 500, '+', '+', '+', 'Woods', '+'),
    (19, 'Double Room', 400, 435, 500, '+', '+', '+', 'Woods', '+'),
    (20, 'Double Room', 400, 435, 500, '+', '+', '+', 'Woods', '+'),
    (21, 'Twin Room', 500, 535, 600, '+', '+', '+', 'Hotel garden', '+'),
    (22, 'Twin Room', 500, 535, 600, '+', '+', '+', 'Hotel garden', '+'),
    (23, 'Twin Room', 500, 535, 600, '+', '+', '+', 'Hotel garden', '+'),
    (24, 'Twin Room', 500, 535, 600, '+', '+', '+', 'Hotel garden', '+'),
    (25, 'Twin Room', 500, 535, 600, '+', '+', '+', 'Hotel garden', '+'),
    (26, 'Twin Room', 500, 535, 600, '+', '+', '+', 'Woods', '+'),
    (27, 'Twin Room', 500, 535, 600, '+', '+', '+', 'Woods', '+'),
    (28, 'Twin Room', 500, 535, 600, '+', '+', '+', 'Woods', '+'),
    (29, 'Twin Room', 500, 535, 600, '+', '+', '+', 'Woods', '+'),
    (30, 'Twin Room', 500, 535, 600, '+', '+', '+', 'Woods', '+'),
    (31, 'Deluxe Room', 1000, 1100, 1300, '+', '+', '+', 'Hotel garden', '+'),
    (32, 'Deluxe Room', 1000, 1100, 1300, '+', '+', '+', 'Hotel garden', '+'),
    (33, 'Deluxe Room', 1000, 1100, 1300, '+', '+', '+', 'Woods', '+'),
    (34, 'Deluxe Room', 1000, 1100, 1300, '+', '+', '+', 'Woods', '+');