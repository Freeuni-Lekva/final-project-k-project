USE mydatabase;

SET FOREIGN_KEY_CHECKS = 0;

DROP TABLE IF EXISTS bookings;

CREATE TABLE bookings (
    booking_id INTEGER NOT NULL,
    room_id INTEGER NOT NULL,
    user_mail CHAR(64) NOT NULL,
    check_in_date DATE,
    check_out_date DATE,
    price_per_day INTEGER,
    total_price INTEGER,
    PRIMARY KEY (booking_id),
    FOREIGN KEY (user_mail) REFERENCES users(user_mail),
    FOREIGN KEY (room_id) REFERENCES hotel_rooms(room_id)
);

INSERT INTO bookings VALUES
    (1,1,'00000000000','2022-07-30','2022-08-05', 335, 2010);

