INSERT INTO Address(street, zip, city) VALUES ('100 1st Street', '52556', 'Iowa'),
                           ('200 1st St', '52556', 'Iowa');

INSERT INTO Category(name) VALUES ('food'),
                                    ('electronics');

INSERT INTO Product(name, price, rating, category_id) VALUES ('candy', 10, 5.0, 1),
                                                             ('bread', 15, 4.5, 1),
                                                             ('ipad', 700, 4.8, 2),
                                                             ('iphone', 900, 4.9, 2);

INSERT INTO Lab_User(email, first_name, last_name, password, address_id) VALUES ('steve@gmail.com', 'Steve', 'Good', '123', 1),
                                                                                ('henry@gmail.com', 'Henry', 'Roll', '234', 2);

INSERT INTO Review(comment, user_id) VALUES ('This is very good', 1),
                                            ('Awesome product', 1),
                                            ('It is ok', 2);