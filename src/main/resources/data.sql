start transaction;

delete from address;
insert into address (address_id, appartment_number, building_number, city, street) values
    (1, 14, 24, 'Prószków', 'Laskowa'),
    (2, 6, 67, 'Rzeszów', 'Piękna'),
    (3, 134, 11, 'Baranów', 'Stankiewicza'),
    (4, 34, 236, 'Łódź', 'Piotrowska'),
    (5, 7, 184, 'Kraków', 'Bracka');

delete from client;
insert into client (client_id, name, last_name, login, email, password, address_id) values
    (1, 'Jan', 'Rokita', 'janrok', 'janekroki@wp.pl', 'haslo123', 2),
    (2, 'Anna', 'Warmińska', 'aniaw', 'aniaw20@o2.pl', 'admin1', 4),
    (3, 'Janusz', 'Pastor', 'pastorianus', 'pastorianusz@wp.pl', 'haslo123', 2),
    (4, 'Borys', 'Marny', 'mamabo', 'mamabo@wp.pl', 'haslo123', 5),
    (5, 'Martyna', 'Szyc', 'szyc', 'szyc@o2.pl', 'admin1', 1),
    (6, 'Wiesław', 'Kiński', 'kinskiwies', 'wiesio@wp.pl', 'admin1', 3);

delete from ingredient;
insert into ingredient (ingredient_id, client_price, is_sold_to_client, measurement_unit, name, warehouse_price, warehouse_quantity)
values
    (1, 10, 0, 'g', 'mąka', 13, 10000),
    (2, 29, 0, 'ml', 'woda', 12, 100000),
    (3, 13, 0, 'g', 'jajka', 12, 10000),
    (4, 16, 0, 'ml', 'przecier pomidorowy', 12, 10000),
    (5, 12, 1, 'g', 'ser', 17, 10000),
    (6, 18, 0, 'g', 'szynka', 23, 10000),
    (7, 29, 0, 'g', 'ananas', 12, 10000);

delete from dish;
insert into dish (dish_id, name, price) values
    (1, 'pizza', 12),
    (2, 'hawajska dla kazdego', 33),
    (3, 'caprichosa', 25),
    (4, 'margherita', 20);

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
insert into tables (table_id, width, height, x, y, status, name, room_id) values
    (1, 2, 2, 10, 10, 0, 'd2', 1),
    (2, 3, 3, 10, 18, 0, 'ad', 2),
    (3, 2, 3, 15, 10, 0, 'ed', 3),
    (4, 3, 2, 10, 17, 0, 'jk', 3);

commit;
