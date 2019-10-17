-- noinspection SqlNoDataSourceInspectionForFile

CREATE TABLE cellphones(
id int not null AUTO_Increment,
vendor VARCHAR (45) not null,
model VARCHAR (45) not null,
screen_diagonal double not null,
charge_port VARCHAR (10) not null,
PRIMARY KEY (id));

CREATE TABLE laptops(
id int not null AUTO_Increment,
vendor VARCHAR (45) not null,
model VARCHAR (45) not null,
operating_system VARCHAR (45) not null,
processor VARCHAR (45) not null,
PRIMARY KEY (id));

CREATE TABLE monitors(
id int not null AUTO_Increment,
vendor VARCHAR (45) not null,
model VARCHAR (45) not null,
diagonal double not null,
buttons_type VARCHAR (10) not null,
PRIMARY KEY (id));

CREATE TABLE orders(
id int not null AUTO_Increment,
date DATETIME not null,
address VARCHAR (45) not null,
shipping_type VARCHAR (45) not null,
sent bit not null,
PRIMARY KEY (id));

CREATE TABLE orders_cellphones(
order_id int not null,
cellphone_id int not null,
PRIMARY KEY (order_id, cellphone_id));

CREATE TABLE orders_laptops(
order_id int not null,
laptop_id int not null,
PRIMARY KEY (order_id, laptop_id));

CREATE TABLE orders_monitors(
order_id int not null,
monitor_id int not null,
PRIMARY KEY (order_id, monitor_id));


Insert into cellphones (vendor, model, screen_diagonal, charge_port) Values ("Apple", "Iphone 4", 3.5, "lighting");
Insert into cellphones (vendor, model, screen_diagonal, charge_port) Values ("Apple", "Iphone 5", 4.0, "lighting");
Insert into cellphones (vendor, model, screen_diagonal, charge_port) Values ("Apple", "Iphone 6", 4.7, "lighting");
Insert into cellphones (vendor, model, screen_diagonal, charge_port) Values ("Apple", "Iphone 7", 4.7, "lighting");
Insert into cellphones (vendor, model, screen_diagonal, charge_port) Values ("Apple", "Iphone 8", 4.7, "lighting");
Insert into cellphones (vendor, model, screen_diagonal, charge_port) Values ("Xiaomi", "Mi 8", 6.21, "Type-C");
Insert into cellphones (vendor, model, screen_diagonal, charge_port) Values ("Xiaomi", "Redmi 5 plus", 5, "micro-USB");
Insert into cellphones (vendor, model, screen_diagonal, charge_port) Values ("Huawei", "P20 Pro", 6.1, "Type-C");
Insert into cellphones (vendor, model, screen_diagonal, charge_port) Values ("Honor", "8X", 5, "micro-USB");
Insert into cellphones (vendor, model, screen_diagonal, charge_port) Values ("Honor", "10", 5.84, "Type-C");
Insert into cellphones (vendor, model, screen_diagonal, charge_port) Values ("Samsung", "Galaxy S8", 5.8, "lighting");
Insert into cellphones (vendor, model, screen_diagonal, charge_port) Values ("Samsung", "Galaxy J5", 5.2, "micro-USB");

Insert into laptops (vendor, model, operating_system, processor) Values ("Lenovo", "IdeaPad 320", "Windows 10", "AMD A12-9720P");
Insert into laptops (vendor, model, operating_system, processor) Values ("Lenovo", "Yoga 720", "Windows 8", "Intel Core i5-7200U");
Insert into laptops (vendor, model, operating_system, processor) Values ("Lenovo", "ThinkPad X1 Carbon", "Windows 10", "Intel Core i7-8650U");
Insert into laptops (vendor, model, operating_system, processor) Values ("HP", "ProBook 445 G6", "Windows 10", "AMD Ryzen 3 APU");
Insert into laptops (vendor, model, operating_system, processor) Values ("HP", "EliteBook x360", "Windows 10", "7th Generation Intel Core i5 processor");
Insert into laptops (vendor, model, operating_system, processor) Values ("Apple", "iMac Pro", "macOS", "Intel Xeon W");

Insert into monitors (vendor, model, diagonal, buttons_type) Values ("Lenovo", "LI2264d", 21.5, "sensor");
Insert into monitors (vendor, model, diagonal, buttons_type) Values ("Lenovo", "ThinkVision 60E3GAT1EU", 27, "mechanical");
Insert into monitors (vendor, model, diagonal, buttons_type) Values ("Lenovo", "C22-10", 21.5, "mechanical");
Insert into monitors (vendor, model, diagonal, buttons_type) Values ("HP", "EliteDisplay S270n", 27.5, "sensor");
Insert into monitors (vendor, model, diagonal, buttons_type) Values ("HP", "DreamColor Z27x G2 Studio Display", 27, "sensor");
Insert into monitors (vendor, model, diagonal, buttons_type) Values ("LG", "34WK95C-W", 34, "sensor");
Insert into monitors (vendor, model, diagonal, buttons_type) Values ("LG", "27MK600M-W", 27, "mechanical");


Insert into orders (date, address, shipping_type, sent) Values ("2019-03-03T22:00:00", "A.Russo 15", "Truck", 0);
Insert into orders (date, address, shipping_type, sent) Values ("2019-04-07T09:01:00", "A.Russo 1", "Truck", 0);


Insert into orders_cellphones (order_id, cellphone_id) Values (1, 1);
Insert into orders_cellphones (order_id, cellphone_id) Values (1, 3);
Insert into orders_cellphones (order_id, cellphone_id) Values (1, 3);
Insert into orders_laptops (order_id, laptop_id) Values (1, 2);
Insert into orders_laptops (order_id, laptop_id) Values (1, 3);
Insert into orders_laptops (order_id, laptop_id) Values (1, 4);
Insert into orders_monitors (order_id, monitor_id) Values (1, 1);
Insert into orders_monitors (order_id, monitor_id) Values (1, 2);





