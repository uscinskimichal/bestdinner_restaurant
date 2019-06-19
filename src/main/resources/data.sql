start transaction;

delete from address;
insert into address (address_id, apartment_number, building_number, city, street) values
    (1, 14, 24, 'Pruszków', 'Laskowa'),
    (2, 6, 67, 'Rzeszów', 'Piękna'),
    (3, 134, 11, 'Baranów', 'Stankiewicza'),
    (4, 34, 236, 'Łódź', 'Piotrowska'),
    (5, 7, 184, 'Kraków', 'Bracka');

delete from measurement_unit;
insert into measurement_unit (measurement_unit_id, name, must_be_integer) values
    (1, 'sztuka', 1);

delete from client;
insert into client (client_id, name, last_name, login, email, password, address_id) values
    (1, 'Jan', 'Rokita', 'janrok', 'janekroki@wp.pl', 'haslo123', 2),
    (2, 'Anna', 'Warmińska', 'aniaw', 'aniaw20@o2.pl', 'admin1', 4),
    (3, 'Janusz', 'Pastor', 'pastorianus', 'pastorianusz@wp.pl', 'haslo123', 2),
    (4, 'Borys', 'Marny', 'mamabo', 'mamabo@wp.pl', 'haslo123', 5),
    (5, 'Martyna', 'Szyc', 'szyc', 'szyc@o2.pl', 'admin1', 1),
    (6, 'Wiesław', 'Kiński', 'kinskiwies', 'wiesio@wp.pl', 'admin1', 3);

delete from ingredient;
insert into ingredient (ingredient_id, client_price, is_sold_to_client, measurement_unit_id, name, warehouse_price, warehouse_quantity)
values
    (1, 10, 0, 1, 'mąka', 13, 10000),
    (2, 29, 0, 1, 'woda', 12, 100000),
    (3, 13, 0, 1, 'jajka', 12, 10000),
    (4, 16, 0, 1, 'przecier pomidorowy', 12, 10000),
    (5, 12, 1, 1, 'ser', 17, 10000),
    (6, 18, 0, 1, 'szynka', 23, 10000),
    (7, 29, 0, 1, 'ananas', 12, 10000);

delete from dish;
insert into dish (dish_id, name, price, dish_type_id) values
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
    (3, 'Jerzy', 'Donigiewicz', 'diggy', 'diggy@wp.pl', 'admin1', 'menadżer');

delete from orders;
insert into orders (order_id, comment, date, status_id, type, address_id, employee_id, table_id) values
    (1, 'na cienkim', '2019-06-11', null, 'namiejscu', 1, 2, 2),
    (2, 'na grubym', '2019-06-12', null, 'nawynos', 2, 3, 4);

delete from dish_type;
insert into dish_type (dish_type_id, name) values
    (1,	Napój),
    (2,	Pizza);


commit;
