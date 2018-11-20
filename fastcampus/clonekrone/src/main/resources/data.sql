-- 카테고리
INSERT INTO category (id, name)
VALUES (1, '호밀빵');
INSERT INTO category (id, name, superior_id)
VALUES (2, '100%', 1);
INSERT INTO category (id, name, superior_id)
VALUES (3, '65%', 1);
INSERT INTO category (id, name, superior_id)
VALUES (4, '35%', 1);

INSERT INTO category (id, name)
VALUES (5, '통밀빵');
INSERT INTO category (id, name, superior_id)
VALUES (6, '100%', 5);
INSERT INTO category (id, name, superior_id)
VALUES (7, '70%', 5);
INSERT INTO category (id, name, superior_id)
VALUES (8, '35%', 5);

INSERT INTO category (id, name)
VALUES (9, '밀빵');
INSERT INTO category (id, name, superior_id)
VALUES (10, '식빵', 9);
INSERT INTO category (id, name, superior_id)
VALUES (11, '스콘', 9);

INSERT INTO category (id, name)
VALUES (12, '보리빵');
INSERT INTO category (id, name, superior_id)
VALUES (13, '35%', 12);

INSERT INTO category (id, name)
VALUES (14, '디저트');
INSERT INTO category (id, name, superior_id)
VALUES (15, '파운드', 14);
INSERT INTO category (id, name, superior_id)
VALUES (16, '타르트', 14);
INSERT INTO category (id, name, superior_id)
VALUES (17, '쿠키', 14);

INSERT INTO category (id, name)
VALUES (18, '기타');
INSERT INTO category (id, name, superior_id)
VALUES (19, '저당도 수제잼', 14);
-- 카테고리 끝

-- 품목과 해당 옵션
INSERT INTO product (id, name, price, point_rate, nutrient, cutting_option, quantity, regdate, category_id)
VALUES (1, '100% 호밀빵', 10800, 2, '100%호밀빵 플레인 : 927kcal/450g', true, 200, now(), 2);
INSERT INTO product_option (id, name, extra_price, product_id)
VALUES (1, '호밀빵 100% 플레인', 0, 1);
INSERT INTO product_option (id, name, extra_price, product_id)
VALUES (2, '호밀빵 100% 무화과', 2100, 1);
INSERT INTO product_option (id, name, extra_price, product_id)
VALUES (3, '호밀빵 100% 고구마', 2000, 1);

INSERT INTO product (id, name, price, point_rate, nutrient, cutting_option, quantity, regdate, category_id)
VALUES (2, '65% 호두 호밀빵', 7600, 2, '100g당 열량 : 222kcal', true, 200, now(), 3);

INSERT INTO product (id, name, price, point_rate, nutrient, cutting_option, quantity, regdate, category_id)
VALUES (3, '65% 자연발효 호밀빵', 9200, 2, '100g당 열량 : 209kcal', true, 200, now(), 3);

INSERT INTO product (id, name, price, point_rate, nutrient, cutting_option, quantity, regdate, category_id)
VALUES (4, '65% 크랜베리 호밀빵', 8200, 2, '100g당 열량 : 220kcal', true, 200, now(), 3);

INSERT INTO product (id, name, price, point_rate, nutrient, cutting_option, quantity, regdate, category_id)
VALUES (5, '35% 호두 호밀빵', 6400, 2, '100g당 열량 : 222kcal', true, 200, now(), 4);

INSERT INTO product (id, name, price, point_rate, nutrient, cutting_option, quantity, regdate, category_id)
VALUES (6, '35% 고구마 호밀빵', 6400, 2, '100g당 열량 : 198kcal', true, 200, now(), 4);

INSERT INTO product (id, name, price, point_rate, nutrient, cutting_option, quantity, regdate, category_id)
VALUES (7, '35% 크랜베리 호밀빵', 7200, 2, '100g당 열량 : 200kcal', true, 200, now(), 4);

INSERT INTO product (id, name, price, point_rate, nutrient, cutting_option, quantity, regdate, category_id)
VALUES (8, '35% 호두 호밀 베이글(5개묶음)', 11800, 2, '100g당 열량 : 226kcal', true, 200, now(), 4);

INSERT INTO product (id, name, price, point_rate, nutrient, cutting_option, quantity, regdate, category_id)
VALUES (9, '소프트 소보로 호밀빵', 3800, 2, '100g당 열량 : 268kcal', false, 200, now(), 4);

INSERT INTO product (id, name, price, point_rate, nutrient, cutting_option, quantity, regdate, category_id)
VALUES (10, '35% 크랜베리 호밀 베이글(5개묶음)', 13000, 2, '100g당 열량 : 226kcal', true, 200, now(), 4);

INSERT INTO product (id, name, price, point_rate, nutrient, cutting_option, quantity, regdate, category_id)
VALUES (11, '100% 검은콩 통밀 베이글(8개 한세트)', 13500, 2, '1개당 열량 : 174kcal', true, 200, now(), 6);

INSERT INTO product (id, name, price, point_rate, nutrient, cutting_option, quantity, regdate, category_id)
VALUES (12, '100% 통밀 식빵', 6800, 2, '열량: 200kcal/100g', true, 200, now(), 6);

INSERT INTO product (id, name, price, point_rate, nutrient, cutting_option, quantity, regdate, category_id)
VALUES (13, '100% 양파 통밀 베이글(8개 한세트)', 13500, 2, '열량: 230kcal/100g', true, 200, now(), 6);

INSERT INTO product (id, name, price, point_rate, nutrient, cutting_option, quantity, regdate, category_id)
VALUES (14, '100% 크랜베리 통밀 베이글(8개 한세트)', 16800, 2, '열량: 211kcal/100g', true, 200, now(), 6);