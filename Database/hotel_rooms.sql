USE mydatabase;

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
    is_booked CHAR(64),
    check_in_date DATE,
    check_out_date DATE,
    booked_by CHAR(64),
    PRIMARY KEY (room_id)
);

INSERT INTO hotel_rooms VALUES
    (1, 'Single room', 300, 335, 400, '+', '+', '-', 'Hotel garden', '+', '-', null , null , null ),
    (2, 'Single room', 300, 335, 400, '+', '+', '-', 'Hotel garden', '+', '-', null , null , null ),
    (3, 'Single room', 300, 335, 400, '+', '+', '-', 'Hotel garden', '+', '-', null , null , null ),
    (4, 'Single room', 300, 335, 400, '+', '+', '-', 'Hotel garden', '+', '-', null , null , null ),
    (5, 'Single room', 300, 335, 400, '+', '+', '-', 'Hotel garden', '+', '-', null , null , null ),
    (6, 'Single room', 300, 335, 400, '+', '+', '-', 'Woods', '+', '-', null , null , null ),
    (7, 'Single room', 300, 335, 400, '+', '+', '-', 'Woods', '+', '-', null , null , null ),
    (8, 'Single room', 300, 335, 400, '+', '+', '-', 'Woods', '+', '-', null , null , null ),
    (9, 'Single room', 300, 335, 400, '+', '+', '-', 'Woods', '+', '-', null , null , null ),
    (10, 'Single room', 300, 335, 400, '+', '+', '-', 'Woods', '+', '-', null , null , null ),
    (11, 'Double room', 400, 435, 500, '+', '+', '+', 'Hotel garden', '+', '-', null , null , null ),
    (12, 'Double room', 400, 435, 500, '+', '+', '+', 'Hotel garden', '+', '-', null , null , null ),
    (13, 'Double room', 400, 435, 500, '+', '+', '+', 'Hotel garden', '+', '-', null , null , null ),
    (14, 'Double room', 400, 435, 500, '+', '+', '+', 'Hotel garden', '+', '-', null , null , null ),
    (15, 'Double room', 400, 435, 500, '+', '+', '+', 'Hotel garden', '+', '-', null , null , null ),
    (16, 'Double room', 400, 435, 500, '+', '+', '+', 'Woods', '+', '-', null , null , null ),
    (17, 'Double room', 400, 435, 500, '+', '+', '+', 'Woods', '+', '-', null , null , null ),
    (18, 'Double room', 400, 435, 500, '+', '+', '+', 'Woods', '+', '-', null , null , null ),
    (19, 'Double room', 400, 435, 500, '+', '+', '+', 'Woods', '+', '-', null , null , null ),
    (20, 'Double room', 400, 435, 500, '+', '+', '+', 'Woods', '+', '-', null , null , null ),
    (21, 'Triple room', 500, 535, 600, '+', '+', '+', 'Hotel garden', '+', '-', null , null , null ),
    (22, 'Triple room', 500, 535, 600, '+', '+', '+', 'Hotel garden', '+', '-', null , null , null ),
    (23, 'Triple room', 500, 535, 600, '+', '+', '+', 'Hotel garden', '+', '-', null , null , null ),
    (24, 'Triple room', 500, 535, 600, '+', '+', '+', 'Hotel garden', '+', '-', null , null , null ),
    (25, 'Triple room', 500, 535, 600, '+', '+', '+', 'Hotel garden', '+', '-', null , null , null ),
    (26, 'Triple room', 500, 535, 600, '+', '+', '+', 'Woods', '+', '-', null , null , null ),
    (27, 'Triple room', 500, 535, 600, '+', '+', '+', 'Woods', '+', '-', null , null , null ),
    (28, 'Triple room', 500, 535, 600, '+', '+', '+', 'Woods', '+', '-', null , null , null ),
    (29, 'Triple room', 500, 535, 600, '+', '+', '+', 'Woods', '+', '-', null , null , null ),
    (30, 'Triple room', 500, 535, 600, '+', '+', '+', 'Woods', '+', '-', null , null , null ),
    (31, 'Lux room', 1000, 1100, 1300, '+', '+', '+', 'Hotel garden', '+', '-', null , null , null ),
    (32, 'Lux room', 1000, 1100, 1300, '+', '+', '+', 'Hotel garden', '+', '-', null , null , null ),
    (33, 'Lux room', 1000, 1100, 1300, '+', '+', '+', 'Woods', '+', '-', null , null , null ),
    (34, 'Lux room', 1000, 1100, 1300, '+', '+', '+', 'Woods', '+', '-', null , null , null );

ALTER TABLE hotel_rooms ADD CONSTRAINT Reservation FOREIGN KEY (booked_by) REFERENCES users(user_id);