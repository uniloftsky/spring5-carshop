create table buy_car (id bigint not null auto_increment, count integer not null, date date, price decimal(19,2), car_id bigint, customer_id bigint, primary key (id)) engine=InnoDB;
create table car (id bigint not null auto_increment, description longtext, image longtext, price decimal(19,2), sub_description longtext, test_price decimal(19,2), body_id bigint, brand_id bigint, car_type_id bigint, color_id bigint, engine_id bigint, model_id bigint, primary key (id)) engine=InnoDB;
create table car_body (id bigint not null auto_increment, body_name varchar(255), model_id bigint, primary key (id)) engine=InnoDB;
create table car_brand (id bigint not null auto_increment, brand_name varchar(255), primary key (id)) engine=InnoDB;
create table car_model (id bigint not null auto_increment, model_name varchar(255), brand_id bigint, primary key (id)) engine=InnoDB;
create table car_type (id bigint not null auto_increment, type_name varchar(255), primary key (id)) engine=InnoDB;
create table color (id bigint not null auto_increment, color varchar(255), primary key (id)) engine=InnoDB;
create table customer (id bigint not null auto_increment, address varchar(100), first_name varchar(255), last_name varchar(255), telephone varchar(15), primary key (id)) engine=InnoDB;
create table engine (id bigint not null auto_increment, capacity integer not null, config varchar(255), cylinders integer not null, name varchar(255), power integer not null, type varchar(255), primary key (id)) engine=InnoDB;
create table test_car (id bigint not null auto_increment, count integer not null, date date, price decimal(19,2), car_id bigint, customer_id bigint, primary key (id)) engine=InnoDB;
alter table buy_car add constraint FK15gk189fxugbk35phiv655gi9 foreign key (car_id) references car (id);
alter table buy_car add constraint FKbwapvku7i1db1ufvguhviqk1m foreign key (customer_id) references customer (id);
alter table car add constraint FKeyh73pt6py8jfjlvybtlpiqtx foreign key (body_id) references car_body (id);
alter table car add constraint FKblvyhk82neasdusbglj4s1q7w foreign key (brand_id) references car_brand (id);
alter table car add constraint FKggtv0dpqfowlhobef4e9qrdlm foreign key (car_type_id) references car_type (id);
alter table car add constraint FKg0jvjcwntclcjd9cd2vmta820 foreign key (color_id) references color (id);
alter table car add constraint FKnednv54lgu9rfucgemr5eal0j foreign key (engine_id) references engine (id);
alter table car add constraint FKdr4movr77cm8s34r8jtv9ajvi foreign key (model_id) references car_model (id);
alter table car_body add constraint FKne89axqg98glj9794uv9tmkqb foreign key (model_id) references car_model (id);
alter table car_model add constraint FKkjuahqawslw96v9vehbngtuti foreign key (brand_id) references car_brand (id);
alter table test_car add constraint FK8utrncb1avpmwj82be2lgru0j foreign key (car_id) references car (id);
alter table test_car add constraint FK6oahug9gykixhu1sv20mw5me1 foreign key (customer_id) references customer (id);
create table buy_car (id bigint not null auto_increment, count integer not null, date date not null, price decimal(19,2) not null, car_id bigint, customer_id bigint, primary key (id)) engine=InnoDB
create table car (id bigint not null auto_increment, description longtext, image longtext, price decimal(19,2) not null, sub_description longtext, test_price decimal(19,2) not null, body_id bigint not null, brand_id bigint not null, car_type_id bigint not null, color_id bigint not null, engine_id bigint not null, model_id bigint not null, primary key (id)) engine=InnoDB
create table car_body (id bigint not null auto_increment, body_name varchar(100), model_id bigint not null, primary key (id)) engine=InnoDB
create table car_brand (id bigint not null auto_increment, brand_name varchar(100), primary key (id)) engine=InnoDB
create table car_model (id bigint not null auto_increment, model_name varchar(100), brand_id bigint not null, primary key (id)) engine=InnoDB
create table car_type (id bigint not null auto_increment, type_name varchar(50), primary key (id)) engine=InnoDB
create table color (id bigint not null auto_increment, color_name varchar(50), primary key (id)) engine=InnoDB
create table customer (id bigint not null auto_increment, address varchar(100), first_name varchar(255), last_name varchar(255), telephone varchar(20), primary key (id)) engine=InnoDB
create table engine (id bigint not null auto_increment, capacity integer not null, config varchar(255) not null, cylinders integer not null, name varchar(100), power integer not null, type varchar(255) not null, primary key (id)) engine=InnoDB
create table message (id bigint not null auto_increment, comment varchar(255), email varchar(255), name varchar(255), phone varchar(255), primary key (id)) engine=InnoDB
create table test_car (id bigint not null auto_increment, count integer not null, date date not null, price decimal(19,2) not null, car_id bigint, customer_id bigint, primary key (id)) engine=InnoDB
alter table buy_car add constraint FK15gk189fxugbk35phiv655gi9 foreign key (car_id) references car (id)
alter table buy_car add constraint FKbwapvku7i1db1ufvguhviqk1m foreign key (customer_id) references customer (id)
alter table car add constraint FKeyh73pt6py8jfjlvybtlpiqtx foreign key (body_id) references car_body (id)
alter table car add constraint FKblvyhk82neasdusbglj4s1q7w foreign key (brand_id) references car_brand (id)
alter table car add constraint FKggtv0dpqfowlhobef4e9qrdlm foreign key (car_type_id) references car_type (id)
alter table car add constraint FKg0jvjcwntclcjd9cd2vmta820 foreign key (color_id) references color (id)
alter table car add constraint FKnednv54lgu9rfucgemr5eal0j foreign key (engine_id) references engine (id)
alter table car add constraint FKdr4movr77cm8s34r8jtv9ajvi foreign key (model_id) references car_model (id)
alter table car_body add constraint FKne89axqg98glj9794uv9tmkqb foreign key (model_id) references car_model (id)
alter table car_model add constraint FKkjuahqawslw96v9vehbngtuti foreign key (brand_id) references car_brand (id)
alter table test_car add constraint FK8utrncb1avpmwj82be2lgru0j foreign key (car_id) references car (id)
alter table test_car add constraint FK6oahug9gykixhu1sv20mw5me1 foreign key (customer_id) references customer (id)
