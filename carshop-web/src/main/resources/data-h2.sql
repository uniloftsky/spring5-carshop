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
INSERT INTO color (color_name)
VALUES ('Чорний');
INSERT INTO color (color_name)
VALUES ('Білий');
INSERT INTO color (color_name)
VALUES ('Червоний');
INSERT INTO color (color_name)
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
INSERT INTO car (engine_id, car_type_id, brand_id, model_id, body_id, color_id, price, test_price, image, sub_description, description)
VALUES (1, 1, 1, 15, 1, 1, 5376, 250, 'resources/images/cars/7e932653-0e38-4b0e-90e6-b6df078f7089-901601.jpg', 'Тільки в новому GLS ви можете відчути максимальний простір і комфорт. Максимальний комфорт.', 'Максимальний комфорт. Привабливий мінімалістичний дизайн. Класичні пропорції, видовжений капот і колісні диски розміром до 23 дюймів підкреслюють потужність та індивідуальність автомобіля. Чіткі поверхні та витончені лінії роблять ваш кросовер легким та елегантним.<br><br> Перевищує ваші очікування. На кожному сидінні нового GLS ви отримуєте максимальний комфорт і можете скористатися найкращою цифровою інформаційно-командною системою серед усіх кросоверів.<br><br> Безпека вищого рівня. Оснащений інтелектуальними допоміжними системами новий GLS допомагає вам управляти автомобілем краще, ніж коли-небудь. Таким чином,  дістатися місця призначення стає ще легше та безпечніше.');
INSERT INTO car (engine_id, car_type_id, brand_id, model_id, body_id, color_id, price, test_price, image, sub_description, description)
VALUES (2, 1, 3, 3, 5, 2, 3964, 250, 'resources/images/cars/fe325a16-9781-4871-85c0-e642c350fab5-s170.jpg', 'Найбільш статусний седан, який японський бренд може запропонувати на європейському ринку - Toyota Camry, яку певною мірою можна назвати демократичним автомобілем.', 'Минулої осені Crown п`ятнадцятого покоління став однією з головних новинок токійського мотор-шоу, але тоді тойотовци показали машину в статусі концепт-кара і були скупі на подробиці. І ось настало літо 2018 го - час, коли машина за планом повинна встати на конвеєр. Як і очікувалося, серійна Toyota Crown нічим не відрізняється від «концепту». А ось різниця з колишньою моделлю велика!<br><br> Вперше за всю історію чотирьохдверний Crown обзавівся додатковими віконцями в задніх стійках даху, через що в профіль машина виглядає респектабельнее. Габарити зі зміною поколінь майже не змінилися: довжина - 4910 мм (на 15 мм більше, ніж у що йде моделі), ширина - 1800 мм, висота - 1455 мм. Зате колісна база виросла відразу на 70 мм до 2920 мм. Як і раніше, в гамі будуть «спортивна» версія Athlete і «розкішна» Royal, які відрізняються декором і обробкою.');
INSERT INTO car (engine_id, car_type_id, brand_id, model_id, body_id, color_id, price, test_price, image, sub_description, description)
VALUES (3, 1, 2, 4, 6, 4, 2523, 75, 'resources/images/cars/965b049f-95ab-4593-bb0a-8db1102aea81-e34.jpg', 'У жовтні 1987 року BMW почали виробництво сімейства Е34. У порівнянні з Е28, кузов став більш обтічним, з`явилися вертикальні покажчики повороту спереду, протитуманні фари під бампером.', 'У порівнянні з попередньою моделлю п`ятої серії - BMW E28, висхідній до розробок початку 1970-х років - автомобілі нового сімейства були кроком вперед. Значно розширився набір базового і опціонального обладнання, підвищився загальний технічний рівень автомобіля. Прогрес був і в області безпеки<br><br>Налаштування ходової частини забезпечувала поєднання комфорту і керованості (проте, перевага віддавалася останньому). Версії з двигунами великого робочого об`єму відрізнялися хорошими динамічними характеристиками, поряд з ними випускалися і економічні чотирициліндрові модифікації, зазвичай зі спрощеним оформленням інтер`єру.<br><br>Трохи тісний салон з низькою лінією даху орієнтований на зручність водія: консоль панелі приладів (доступною в чорному, синьому, сірому, коричневому, бежевому і червоному (дуже рідкісному кольорі)) розгорнута в його сторону, сидіння водія має п`ять електрорегулювань; все скомпоновано так, щоб забезпечити простору посадку саме на передніх сидіннях. Для Е34 була характерна ергономіка органів управління. ');
INSERT INTO car (engine_id, car_type_id, brand_id, model_id, body_id, color_id, price, test_price, image, sub_description, description)
VALUES (3, 1, 1, 2, 2, 4, 2523, 150, 'resources/images/cars/8d772a64-9e3a-4644-adc1-372ac7846ab3-e200.jpg', 'Серія легкових автомобілів бізнес-класу німецької торгової марки Mercedes-Benz, офіційно представлена з 1993 року і в даний час складається з п`яти поколінь.', 'Mercedes-Benz W123 був одним з успішних автомобілів фірми, але до середини 1980-х років ситуація різко змінилася: покупцям потрібний автомобіль, який не тільки міг би доїхати з точки А в точку Б, але при цьому був би доступним і стильним. Поява автомобіля 190 в 1982 році ізолював W123, у якого не було ні престижу W126 S-класу, ні спортивності 190-го. Тому дизайнер обох автомобілів Бруно Сакко відразу приступив до розробки нового автомобіля середнього класу, і в листопаді 1984 року машина була готова. Для свого часу вона мала один з кращих показників з аеродинаміки. <br><br>Mercedes-Benz W124 є один з найулюбленіших народом Мерседесів. На ньому вперше з`явилися повний привід 4Matic і потужні двигуни V8. <br><br>Найпотужнішою модифікацією була E 500 з двигуном потужністю 326 к.с. До речі, саме W124 вперше — з 1993 року — назвали E-класом. Випускалася і версія купе.Всього було виготовлено 2.583.470 екземплярів Mercedes W124.');
INSERT INTO car (engine_id, car_type_id, brand_id, model_id, body_id, color_id, price, test_price, image, sub_description, description)
VALUES (3, 1, 4, 5, 7, 4, 2523, 150, 'resources/images/cars/24036cdb-d126-4ddd-b82c-861445b00db1-gtr35.jpg', 'Спортивний автомобіль, що випускається компанією Nissan Motor.', 'Великий спойлер, повітрозабірники і повітропроводи не просто прикрашають спорткар Nissan GT-R - у кожного з них своя особлива роль. Спойлер створює силу притиснення. Гострі грані і отвори повітропроводів на задньому бампері управляють потоком повітря. Повітроводи, розташовані за переднім бампером, охолоджують гальма і створюють додаткову силу притиску, тоді як повітрозабірники на капоті разом з гратами забезпечують охолодження двигуна.<br><br>У звичайних автомобілях розташовані знизу механічні частини нічим не закриті. Вони перешкоджають вільному потоку повітря, створюють підйомну силу і затримують рух вашого автомобіля. Але суперкар Nissan GT-R - не звичайна машина. Основу кузова практично повністю закриті композитними панелями, які надають йому більш обтічну форму і збільшують аеродинамічний ефект.');

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

