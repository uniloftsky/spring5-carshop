-- Car types
INSERT INTO car_type (type_name) VALUES ('Седан');
INSERT INTO car_type (type_name) VALUES ('Універсал');
INSERT INTO car_type (type_name) VALUES ('Хетчбек');
INSERT INTO car_type (type_name) VALUES ('Мінівен');
INSERT INTO car_type (type_name) VALUES ('Позашляховик');
INSERT INTO car_type (type_name) VALUES ('Купе');
INSERT INTO car_type (type_name) VALUES ('Кабріолет');
INSERT INTO car_type (type_name) VALUES ('Пікап');
INSERT INTO car_type (type_name) VALUES ('Лимузин');

-- Customers
INSERT INTO customer (first_name, last_name, address, telephone) VALUES ('Антон', 'Кулик', 'вул. Соборна, 18', '12345');
INSERT INTO customer (first_name, last_name, address, telephone) VALUES ('Лідія', 'Якубовська', 'вул. Сонячна, 26', '54321');
INSERT INTO customer (first_name, last_name, address, telephone) VALUES ('Дученко', 'Олександр', 'вул. Європейська, 3', '1337');

-- Engines
INSERT INTO engine (name, type, capacity, power, config, cylinders) VALUES ('S 280', 'PETROL', 2799, 197, 'INLINE', 6);
INSERT INTO engine (name, type, capacity, power, config, cylinders) VALUES ('1JZ-GE', 'PETROL', 2492, 280, 'INLINE', 6);
INSERT INTO engine (name, type, capacity, power, config, cylinders) VALUES ('BMW M43', 'PETROL', 1596, 87, 'INLINE', 4);

-- Cars
INSERT INTO car (engine_id, car_type_id, brand_name, model_name, body_name, color, buy_price, test_price)
            VALUES (1, 1, 'Mercedes-Benz', 'S500', 'W140', 'black', '5000', '250');
INSERT INTO car (engine_id, car_type_id, brand_name, model_name, body_name, color, buy_price, test_price)
            VALUES (2, 1, 'Toyota', 'Crown', 'S170', 'white', '2500', '75');
INSERT INTO car (engine_id, car_type_id, brand_name, model_name, body_name, color, buy_price, test_price)
            VALUES (3, 1, 'BMW', '518i', 'E34', 'black', '2250', '50');

-- Car buys
INSERT INTO buy_car (car_id, customer_id, date, count) VALUES (1, 1, '2020-09-20', 1);
INSERT INTO buy_car (car_id, customer_id, date, count) VALUES (3, 2, '2020-07-13', 1);
INSERT INTO buy_car (car_id, customer_id, date, count) VALUES (2, 3, '2018-12-09', 1);

-- Car tests
INSERT INTO test_car (car_id, customer_id, date, count) VALUES (1, 3, '2017-05-28', 1);
INSERT INTO test_car (car_id, customer_id, date, count) VALUES (2, 3, '2019-06-05', 1);
INSERT INTO test_car (car_id, customer_id, date, count) VALUES (1, 3, '2016-10-30', 1);

