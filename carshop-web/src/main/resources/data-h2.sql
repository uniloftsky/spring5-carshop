-- Car types
INSERT INTO car_type (type_name)
VALUES ('Седан');
INSERT INTO car_type (type_name)
VALUES ('Універсал');
INSERT INTO car_type (type_name)
VALUES ('Хетчбек');
INSERT INTO car_type (type_name)
VALUES ('Мінівен');
INSERT INTO car_type (type_name)
VALUES ('Позашляховик');
INSERT INTO car_type (type_name)
VALUES ('Купе');
INSERT INTO car_type (type_name)
VALUES ('Кабріолет');
INSERT INTO car_type (type_name)
VALUES ('Пікап');
INSERT INTO car_type (type_name)
VALUES ('Лимузин');

-- Customers
INSERT INTO customer (first_name, last_name, address, telephone)
VALUES ('Антон', 'Кулик', 'вул. Соборна, 18', '12345');
INSERT INTO customer (first_name, last_name, address, telephone)
VALUES ('Лідія', 'Якубовська', 'вул. Сонячна, 26', '54321');
INSERT INTO customer (first_name, last_name, address, telephone)
VALUES ('Дученко', 'Олександр', 'вул. Європейська, 3', '1337');

-- Engines
INSERT INTO engine (name, type, capacity, power, config, cylinders)
VALUES ('S 280', 'PETROL', 2799, 197, 'INLINE', 6);
INSERT INTO engine (name, type, capacity, power, config, cylinders)
VALUES ('1JZ-GE', 'PETROL', 2492, 280, 'INLINE', 6);
INSERT INTO engine (name, type, capacity, power, config, cylinders)
VALUES ('BMW M43', 'PETROL', 1596, 87, 'INLINE', 4);

-- Colors
INSERT INTO color (color)
VALUES ('Чорний');
INSERT INTO color (color)
VALUES ('Білий');
INSERT INTO color (color)
VALUES ('Червоний');
INSERT INTO color (color)
VALUES ('Синій');

-- Car brands
INSERT INTO car_brand (brand_name)
VALUES ('Mercedes-Benz');
INSERT INTO car_brand (brand_name)
VALUES ('BMW');
INSERT INTO car_brand (brand_name)
VALUES ('Toyota');
INSERT INTO car_brand (brand_name)
VALUES ('Nissan');

-- Car models
INSERT INTO car_model (model_name, brand_id)
VALUES ('S500', 1);
INSERT INTO car_model (model_name, brand_id)
VALUES ('E200', 1);
INSERT INTO car_model (model_name, brand_id)
VALUES ('Crown', 3);
INSERT INTO car_model (model_name, brand_id)
VALUES ('518i', 2);
INSERT INTO car_model (model_name, brand_id)
VALUES ('GT-R', 4);
INSERT INTO car_model (model_name, brand_id)
VALUES ('CLK200', 1);
INSERT INTO car_model (model_name, brand_id)
VALUES ('S700', 1);
INSERT INTO car_model (model_name, brand_id)
VALUES ('C300', 1);
INSERT INTO car_model (model_name, brand_id)
VALUES ('S600', 1);
INSERT INTO car_model (model_name, brand_id)
VALUES ('E300', 1);
INSERT INTO car_model (model_name, brand_id)
VALUES ('C63', 1);
INSERT INTO car_model (model_name, brand_id)
VALUES ('G63', 1);
INSERT INTO car_model (model_name, brand_id)
VALUES ('G55', 1);
INSERT INTO car_model (model_name, brand_id)
VALUES ('GL300', 1);
INSERT INTO car_model (model_name, brand_id)
VALUES ('GL500', 1);

-- Car bodies
INSERT INTO car_body (body_name, model_id)
VALUES ('W140', 1);
INSERT INTO car_body (body_name, model_id)
VALUES ('W124', 2);
INSERT INTO car_body (body_name, model_id)
VALUES ('W220', 2);
INSERT INTO car_body (body_name, model_id)
VALUES ('W221', 2);
INSERT INTO car_body (body_name, model_id)
VALUES ('S170', 3);
INSERT INTO car_body (body_name, model_id)
VALUES ('E34', 4);
INSERT INTO car_body (body_name, model_id)
VALUES ('R35', 5);
INSERT INTO car_body (body_name, model_id)
VALUES ('R34', 5);

-- Cars
INSERT INTO car (engine_id, car_type_id, brand_id, model_id, body_id, color_id, price, test_price, image)
VALUES (1, 1, 1, 1, 1, 1, 5376, 250, 'resources/images/s500.jpg');
INSERT INTO car (engine_id, car_type_id, brand_id, model_id, body_id, color_id, price, test_price, image)
VALUES (1, 1, 1, 6, 1, 1, 5376, 250, 'resources/images/s500.jpg');
INSERT INTO car (engine_id, car_type_id, brand_id, model_id, body_id, color_id, price, test_price, image)
VALUES (1, 1, 1, 7, 1, 1, 5376, 250, 'resources/images/s500.jpg');
INSERT INTO car (engine_id, car_type_id, brand_id, model_id, body_id, color_id, price, test_price, image)
VALUES (1, 1, 1, 8, 1, 1, 5376, 250, 'resources/images/s500.jpg');
INSERT INTO car (engine_id, car_type_id, brand_id, model_id, body_id, color_id, price, test_price, image)
VALUES (1, 1, 1, 9, 1, 1, 5376, 250, 'resources/images/s500.jpg');
INSERT INTO car (engine_id, car_type_id, brand_id, model_id, body_id, color_id, price, test_price, image)
VALUES (1, 1, 1, 10, 1, 1, 5376, 250, 'resources/images/s500.jpg');
INSERT INTO car (engine_id, car_type_id, brand_id, model_id, body_id, color_id, price, test_price, image)
VALUES (1, 1, 1, 11, 1, 1, 5376, 250, 'resources/images/s500.jpg');
INSERT INTO car (engine_id, car_type_id, brand_id, model_id, body_id, color_id, price, test_price, image)
VALUES (1, 1, 1, 12, 1, 1, 5376, 250, 'resources/images/s500.jpg');
INSERT INTO car (engine_id, car_type_id, brand_id, model_id, body_id, color_id, price, test_price, image)
VALUES (1, 1, 1, 13, 1, 1, 5376, 250, 'resources/images/s500.jpg');
INSERT INTO car (engine_id, car_type_id, brand_id, model_id, body_id, color_id, price, test_price, image)
VALUES (1, 1, 1, 14, 1, 1, 5376, 250, 'resources/images/s500.jpg');
INSERT INTO car (engine_id, car_type_id, brand_id, model_id, body_id, color_id, price, test_price, image)
VALUES (1, 1, 1, 15, 1, 1, 5376, 250, 'resources/images/s500.jpg');
INSERT INTO car (engine_id, car_type_id, brand_id, model_id, body_id, color_id, price, test_price, image)
VALUES (2, 1, 3, 3, 5, 2, 3964, 250, 'resources/images/s170.jpg');
INSERT INTO car (engine_id, car_type_id, brand_id, model_id, body_id, color_id, price, test_price, image)
VALUES (3, 1, 2, 4, 6, 4, 2523, 75, 'resources/images/e34.jpg');
INSERT INTO car (engine_id, car_type_id, brand_id, model_id, body_id, color_id, price, test_price, image)
VALUES (3, 1, 1, 2, 2, 4, 2523, 150, 'resources/images/e200.jpg');
INSERT INTO car (engine_id, car_type_id, brand_id, model_id, body_id, color_id, price, test_price, image)
VALUES (3, 1, 4, 5, 7, 4, 2523, 150, 'resources/images/gtr35.jpg');
INSERT INTO car (engine_id, car_type_id, brand_id, model_id, body_id, color_id, price, test_price, image)
VALUES (3, 2, 4, 5, 8, 4, 2523, 150, 'resources/images/gtr35.jpg');

-- Car buys
INSERT INTO buy_car (car_id, customer_id, date, count, price)
VALUES (1, 1, '2020-09-20', 1, 5000);
INSERT INTO buy_car (car_id, customer_id, date, count, price)
VALUES (3, 2, '2020-07-13', 1, 3000);
INSERT INTO buy_car (car_id, customer_id, date, count, price)
VALUES (2, 3, '2018-12-09', 1, 2500);

-- Car tests
INSERT INTO test_car (car_id, customer_id, date, count, price)
VALUES (1, 3, '2017-05-28', 1, 250);
INSERT INTO test_car (car_id, customer_id, date, count, price)
VALUES (2, 3, '2019-06-05', 1, 150);
INSERT INTO test_car (car_id, customer_id, date, count, price)
VALUES (1, 3, '2016-10-30', 1, 75);

