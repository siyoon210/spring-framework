INSERT INTO category (id, classification1, classification2) VALUES (1, '빵', '작은빵');

INSERT INTO product (id, name, price, point_rate, nutrient, cutting, quantity, regdate,category_id) VALUES (1, '단팥빵', 1000, 2, '단팥 성분 짠짠짠', true, 100, now(),1);
INSERT INTO product (id, name, price, point_rate, nutrient, cutting, quantity, regdate,category_id) VALUES (2, '소보로빵', 1500, 2, '소보로빵 날 위한 성분 짠짠짠', false , 200, now(),1);
