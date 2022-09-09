-- CATEGORY
INSERT INTO category(name)
VALUES
    ('Computer'),
    ('Mobile Phone'),
    ('Laptop'),
    ('Accessory');

-- PRODUCT
INSERT INTO product(name, price, rating, category_id)
VALUES
    ('Product-name-1', 20, 4, 1),
    ('Product-name-2', 30, 5, 1),
    ('Product-name-3', 40, 6, 1),
    ('Product-name-4', 50, 4, 1),
    ('Product-name-5', 30.3, 1, 1),
    ('Product-name-6', 20, 4, 2),
    ('Product-name-7', 30, 5, 2),
    ('Product-name-8', 40, 6, 2),
    ('Product-name-9', 50, 4, 2),
    ('Product-name-10', 30.3, 1, 2);

-- ADDRESS
INSERT INTO address(street, city, zip)
VALUES
    ('Street 1', 'City 1', '56551'),
    ('Street 2', 'City 2', '56552'),
    ('Street 3', 'City 3', '56553'),
    ('Street 4', 'City 4', '56554'),
    ('Street 5', 'City 5', '56555'),
    ('Street 6', 'City 6', '56556');

-- USERS
INSERT INTO users(email, first_name, last_name, address_id)
VALUES
    ('phat@gmail.com', 'Phat', 'Nguyen', 1),
    ('john@gmail.com', 'John', 'Smith', 2),
    ('david@gmail.com', 'David', 'Nguyen', 3),
    ('smith@gmail.com', 'Smith', 'Nguyen', 4),
    ('adam@gmail.com', 'Adam', 'John', 5),
    ('michael@gmail.com', 'Michael', 'Mike', 6);


-- REVIEWS
INSERT INTO review(comment, user_id)
VALUES
    ('Comment 1', 1),
    ('Comment 2', 1),
    ('Comment 3', 1),
    ('Comment 4', 2),
    ('Comment 5', 2),
    ('Comment 6', 3),
    ('Comment 7', 4),
    ('Comment 8', 4),
    ('Comment 9', 4),
    ('Comment 10', 5),
    ('Comment 11', 5),
    ('Comment 12', 5),
    ('Comment 13', 6),
    ('Comment 14', 6),
    ('Comment 15', 6),
    ('Comment 16', 6);