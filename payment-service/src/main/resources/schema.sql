CREATE TABLE payment (
    payment_id int AUTO_INCREMENT PRIMARY KEY,
    order_id int,
    payment_type VARCHAR(50)
);