INSERT INTO category (id, classification1, classification2)
VALUES (1, '호밀빵', '100%');
INSERT INTO category (id, classification1, classification2)
VALUES (2, '호밀빵', '65%');
INSERT INTO category (id, classification1, classification2)
VALUES (3, '호밀빵', '35%');
INSERT INTO category (id, classification1, classification2)
VALUES (4, '통밀빵', '100%');
INSERT INTO category (id, classification1, classification2)
VALUES (5, '통밀빵', '70%');
INSERT INTO category (id, classification1, classification2)
VALUES (6, '통밀빵', '35%');
INSERT INTO category (id, classification1, classification2)
VALUES (7, '밀빵', '식빵');
INSERT INTO category (id, classification1, classification2)
VALUES (8, '밀빵', '스콘');

INSERT INTO product (id, name, price, point_rate, nutrient, cutting, regdate, category_id)
VALUES (1, '100% 호밀빵', 10800, 2, '100%호밀빵 플레인 : 927kcal/450g', true, now(), 1);
INSERT INTO product (id, name, price, point_rate, nutrient, cutting, regdate, category_id)
VALUES (2, '65% 호두 호밀빵', 7600, 2, '100g당 열량 : 222kcal', true, now(), 2);
INSERT INTO product (id, name, price, point_rate, nutrient, cutting, regdate, category_id)
VALUES (3, '65% 자연발효 호밀빵', 9200, 2, '100g당 열량 : 209kcal', true, now(), 2);
INSERT INTO product (id, name, price, point_rate, nutrient, cutting, regdate, category_id)
VALUES (4, '65% 크랜베리 호밀빵', 8200, 2, '100g당 열량 : 220kcal', true, now(), 2);
INSERT INTO product (id, name, price, point_rate, nutrient, cutting, regdate, category_id)
VALUES (5, '35% 호두 호밀빵', 6400, 2, '100g당 열량 : 222kcal', true, now(), 3);
INSERT INTO product (id, name, price, point_rate, nutrient, cutting, regdate, category_id)
VALUES (6, '35% 고구마 호밀빵', 6200, 2, '100g당 열량 : 198kcal', true, now(), 3);
INSERT INTO product (id, name, price, point_rate, nutrient, cutting, regdate, category_id)
VALUES (7, '35% 크랜베리 호밀빵', 7200, 2, '100g당 열량 : 200kcal', true, now(), 3);
INSERT INTO product (id, name, price, point_rate, nutrient, cutting, regdate, category_id)
VALUES (8, '35% 호두 호밀 베이글(5개묶음)', 11800, 2, '100g당 열량 : 226kcal', true, now(), 3);
INSERT INTO product (id, name, price, point_rate, nutrient, cutting, regdate, category_id)
VALUES (9, '소프트 소보로 호밀빵', 3800, 2, '100g당 열량 : 268kcal', true, now(), 3);
-- INSERT INTO product (id, name, price, point_rate, nutrient, cutting, regdate, category_id)
-- VALUES (10, '35% 크랜베리 호밀 베이글(5개묶음)', 13000, 2, '100g당 열량 : 226kcal', true, now(), 3);