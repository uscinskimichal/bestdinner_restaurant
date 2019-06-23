start transaction;

ALTER DATABASE best CHARACTER SET utf8 COLLATE utf8_general_ci;

ALTER TABLE best.restaurant_account CONVERT TO CHARACTER SET utf8 COLLATE utf8_general_ci;
ALTER TABLE best.address CONVERT TO CHARACTER SET utf8 COLLATE utf8_general_ci;
ALTER TABLE best.changed_dish CONVERT TO CHARACTER SET utf8 COLLATE utf8_general_ci;
ALTER TABLE best.changed_dish_ingredient CONVERT TO CHARACTER SET utf8 COLLATE utf8_general_ci;
ALTER TABLE best.client CONVERT TO CHARACTER SET utf8 COLLATE utf8_general_ci;
ALTER TABLE best.client_order CONVERT TO CHARACTER SET utf8 COLLATE utf8_general_ci;
ALTER TABLE best.dish CONVERT TO CHARACTER SET utf8 COLLATE utf8_general_ci;
ALTER TABLE best.dish_ingredient CONVERT TO CHARACTER SET utf8 COLLATE utf8_general_ci;
ALTER TABLE best.dish_type CONVERT TO CHARACTER SET utf8 COLLATE utf8_general_ci;
ALTER TABLE best.employee CONVERT TO CHARACTER SET utf8 COLLATE utf8_general_ci;
ALTER TABLE best.ingredient CONVERT TO CHARACTER SET utf8 COLLATE utf8_general_ci;
ALTER TABLE best.measurement_unit CONVERT TO CHARACTER SET utf8 COLLATE utf8_general_ci;
ALTER TABLE best.order_history CONVERT TO CHARACTER SET utf8 COLLATE utf8_general_ci;
ALTER TABLE best.order_item CONVERT TO CHARACTER SET utf8 COLLATE utf8_general_ci;
ALTER TABLE best.order_item_history CONVERT TO CHARACTER SET utf8 COLLATE utf8_general_ci;
ALTER TABLE best.orders CONVERT TO CHARACTER SET utf8 COLLATE utf8_general_ci;
ALTER TABLE best.rooms CONVERT TO CHARACTER SET utf8 COLLATE utf8_general_ci;
ALTER TABLE best.status CONVERT TO CHARACTER SET utf8 COLLATE utf8_general_ci;
ALTER TABLE best.tables CONVERT TO CHARACTER SET utf8 COLLATE utf8_general_ci;
ALTER TABLE best.warehouse_order CONVERT TO CHARACTER SET utf8 COLLATE utf8_general_ci;
ALTER TABLE best.warehouse_order_item CONVERT TO CHARACTER SET utf8 COLLATE utf8_general_ci;


delete from address;
insert into address (address_id, apartment_number, building_number, city, street) values
    (1, 14, 24, 'Pruszków', 'Laskowa'),
    (2, 6, 67, 'Rzeszów', 'Piękna'),
    (3, 134, 11, 'Baranów', 'Stankiewicza'),
    (4, 34, 236, 'Łódź', 'Piotrowska'),
    (5, 7, 184, 'Kraków', 'Bracka');

delete from client;
insert into client (client_id, name, last_name, login, email, password, address_id, balance) values
    (1, 'Jan', 'Rokita', 'janrok', 'janekroki@wp.pl', 'haslo123', 2, 10.50),
    (2, 'Anna', 'Warmińska', 'aniaw', 'aniaw20@o2.pl', 'admin1', 4, 20.50),
    (3, 'Janusz', 'Pastor', 'pastorianus', 'pastorianusz@wp.pl', 'haslo123', 2, 20.50),
    (4, 'Borys', 'Marny', 'mamabo', 'mamabo@wp.pl', 'haslo123', 5, 20.50),
    (5, 'Martyna', 'Szyc', 'szyc', 'szyc@o2.pl', 'admin1', 1, 20.50),
    (6, 'Wiesław', 'Kiński', 'kinskiwies', 'wiesio@wp.pl', 'admin1', 3, 20.50);

delete from ingredient;
insert into ingredient (ingredient_id, client_price, is_sold_to_client, measurement_unit_id, name, warehouse_price, warehouse_quantity)
values
    (1, 10, 0, 1, 'mąka', 13, 10000),
    (2, 29, 0, 1, 'woda', 12, 100000),
    (3, 13, 0, 1, 'jajka', 12, 10000),
    (4, 16, 0, 1, 'przecier pomidorowy', 12, 10000),
    (5, 12, 1, 1, 'ser', 17, 10000),
    (6, 18, 1, 1, 'szynka', 23, 10000),
    (7, 29, 1, 1, 'ananas', 12, 10000);

delete from dish;
insert into dish (dish_id, name, price, dishType_id) values
    (1, 'pizza', 12, 1),
    (2, 'hawajska dla kazdego', 33, 1),
    (3, 'caprichosa', 25, 2),
    (4, 'margherita', 20, 1);

delete from dish_ingredient;
insert into dish_ingredient (dish_ingredient_id, quantity, dish_id, ingredient_id) values
    (1, 2, 1, 1),
    (2, 2, 1, 2),
    (3, 2, 1, 3),
    (4, 5, 1, 4),
    (5, 2, 2, 1),
    (6, 1, 2, 2),
    (7, 2, 2, 3),
    (8, 1, 2, 4),
    (9, 2, 2, 7),
    (10, 2, 4, 1),
    (11, 3, 4, 2),
    (12, 2, 4, 3),
    (13, 2, 4, 4),
    (14, 3, 4, 5),
    (15, 2, 3, 1),
    (16, 2, 3, 2),
    (17, 2, 3, 3),
    (18, 2, 3, 4),
    (19, 2, 3, 5),
    (20, 2, 3, 6);

delete from rooms;
insert into rooms (room_id, width, height) values
    (1, 200, 200),
    (2, 400, 200),
    (3, 200, 400),
    (4, 100, 300);

delete from tables;
insert into tables (table_id, width, height, x, y, occupied, name, room_id) values
    (1, 2, 2, 10, 10, 0, 'd2', 1),
    (2, 3, 3, 10, 18, 0, 'ad', 2),
    (3, 2, 3, 15, 10, 0, 'ed', 3),
    (4, 3, 2, 10, 17, 0, 'jk', 3);

delete from employee;
insert into employee (employee_id, name, last_name, login, email, password, role) values
    (1, 'Julian', 'Szczery', 'julszcze', 'julo@wp.pl', 'admin1', 'kelner'),
    (2, 'Zenon', 'Martyniuk', 'zenek', 'zenio@o2.pl', 'haslo123', 'kelner'),
    (3, 'Jerzy', 'Donigiewicz', 'diggy', 'diggy@wp.pl', 'admin1', 'menadżer'),
    (4, 'Karol', 'Karolak', 'kkarol', 'krll@gmail.com', 'qwerty', 'kucharz'),
    (5, 'Jan', 'Nowak', 'jowak', 'jnowak@o2.pl', 'kawoj', 'kucharz'),
    (6, 'Tomasz', 'Szybki', 'szomasz', 'szomasz@wp.pl', 'tom123', 'dostawca'),
    (7, 'Bogdan', 'Szmyks', 'bogusxx', 'bog24@gmail.com', 'bogdan1955', 'kucharz'),
    (8, 'Paweł', 'Tępak', 'pętak', 'pawel.tepak@poczta.onet.pl', 'paw77', 'dostawca'),
    (9, 'Halina', 'Grzyb', 'halynka', 'halinaxd@o2.pl', 'qazWSX123', 'dostawca');


delete from orders;
insert into orders (order_id, comment, date, status_id, type, address_id, employee_id, table_id) values
    (1, 'na cienkim', '2019-06-11 00:00:01', 2, 'wlokalu', 1, 2, 1),
    (2, 'na grubym', '2019-06-12 16:00:01', 2, 'zdostawa', 2, 3, null),
    (3, 'do 30 minut', '2015-07-21 10:40:01', 4, 'zdostawa', 3, null, null),
    (4, 'bez sosu', '2012-12-13 21:07:01', 4, 'zdostawa', 3, null, null),
    (5, '-ser +pieczarki', '2019-06-21 22:24:01', 2, 'wlokalu', 1, 5, 4),
    (6, null, '2017-09-11 14:24:01', 3, 'wlokalu', 1, 3, 4),
    (7, null, '2019-11-11 11:11:01', 4, 'zdostawa', 1, 7, null),
    (8, 'na cienkim', '2016-09-30 20:21:01', 5, 'wlokalu', 2, 6, 1),
    (9, 'na grubym', '2019-01-11 13:35:01', 7, 'wlokalu', 3, 9, 3),
    (10, 'na cienkim', '2019-06-20 00:00:01', 4, 'zdostawa', 1, null, null),
    (11, 'na grubym', '2019-06-21 16:00:01', 4, 'zdostawa', 2, null, null),
    (12, 'do 30 minut', '2015-06-22 10:40:01', 4, 'zdostawa', 3, null, null),
    (13, 'bez sosu', '2012-12-23 23:07:01', 4, 'zdostawa', 3, null, null);


delete from warehouse_order;
insert into warehouse_order(warehouse_order_id, date, employee_id) values
    (1, '2017-09-11 14:24:01', 1),
    (2, '2019-11-11 11:11:01', 4),
    (3, '2019-06-11 00:00:01', 5),
    (4, '2015-07-21 10:40:01', 2),
    (5, '2019-01-11 13:35:01', 6);

delete from warehouse_order_item;
insert into warehouse_order_item(warehouse_order_item_id,quantity, ingredient_id, warehouse_order_id) values
    (1,11, 5, 1),
    (2,42, 6, 1),
    (3,21, 2, 2),
    (4,53, 1, 3),
    (5,1, 5, 4),
    (6,52, 6, 4),
    (7,15, 7, 4),
    (8,76, 5, 5),
    (9,22, 4, 5),
    (10,42, 4, 2),
    (11,54, 2, 2),
    (12,65, 1, 3),
    (13,18, 5, 3),
    (14,7, 4, 1);

delete from order_item_history;
insert into order_item_history(date, status, employee_id, order_item_id) values
('2012-01-11 13:35:01', 1, 1, 1),
('2019-12-21 21:53:01', 1, 1, 2),
('2019-08-11 18:42:11', 1, 2, 1);

delete from order_item;
insert into order_item (changed_dish_id, dish_id, order_id, status_id) VALUES
(1, null, 1, 2),
(2, null, 2, 2),
(3, null, 3, 2),
(1, null, 1, 2),
(null, 1, 1, 2),
(null, 2, 2, 2),
(null, 3, 3, 2),
(null, 1, 1, 2),
(null, 1, 1, 2);

delete from order_history;
insert into order_history (date, status, employee_id, order_id) VALUES
('2015-11-21 17:54:01', 1, 1, 1),
('2014-10-11 11:24:01', 1, 1, 2),
('2013-09-01 15:35:01', 1, 2, 2),
('2012-08-15 19:09:01', 1, 1, 1);

delete from client_order;
insert into client_order (client_id, order_id) VALUES
(1, 1),
(2, 1),
(3, 2);

delete from changed_dish_ingredient;
insert into changed_dish_ingredient (changed_dish_ingredient_id, quantity, changed_dish_id, ingredient_id) VALUES
(1, 10, 1, 1),
(2, 10, 1, 1),
(3, 10, 2, 1),
(4, 10, 3, 2),
(5, 10, 2, 1);

delete from changed_dish;
insert into changed_dish (changed_dish_id, dish_id) VALUES
(1, 1),
(2, 1),
(3, 2);

delete from restaurant_account;
insert into restaurant_account (restaurant_id, balance) VALUES
(1,100000);
-- SELECT CONCAT('ALTER TABLE ',TABLE_SCHEMA,'.',TABLE_NAME,' CONVERT TO CHARACTER SET utf8 COLLATE utf8_general_ci;') FROM information_schema.TABLES WHERE TABLE_SCHEMA = 'best';

-- Słowniki:

delete from measurement_unit;
insert into measurement_unit (measurement_unit_id, name, must_be_integer) values
(1, 'Miligram', 0),
(2, 'Gram', 0),
(3, 'Dekagram', 0),
(4, 'Kilogram', 0),
(5, 'Mililitr', 0),
(6, 'Litr', 0),
(7, 'Szczypta', 1);


delete from status;
insert into status(status_id, name) values
(1, 'W realizacji'),
(2, 'Zrealizowane'),
(3, 'Dostarczone do stolika'),
(4, 'Gotowe do odbioru'),
(5, 'Odebrane przez klienta'),
(6, 'W drodze'),
(7, 'Dostarczone do klienta');

delete from dish_type;
insert into dish_type (dishType_id, name) values
(1,	'Pizza'),
(2,	'Przystawki'),
(3,	'Makarony'),
(4,	'Zupy'),
(5,	'Sałatki'),
(6,	'Dodatki do dań'),
(7,	'Desery'),
(8,	'Napoje');

commit;
