-- 출판사, 책, 책목차
INSERT INTO publisher (name)
VALUES ('위포트');
INSERT INTO book (publisher_id, name, publication_date, author, ISBN)
VALUES (1, '위포트 인적성 마스터 25대기업 인적성검사 통합 기본서', '20180119', '위포트 연구소', '9791161980140');
INSERT INTO book_content (book_id, name, superior_id, order_by)
VALUES (1, 'PART 1 언어능력', null, 1);
INSERT INTO book_content (book_id, name, superior_id, order_by)
VALUES (1, 'PART 2 수리능력', null, 2);
INSERT INTO book_content (book_id, name, superior_id, order_by)
VALUES (1, 'PART 3 추리능력', null, 3);
INSERT INTO book_content (book_id, name, superior_id, order_by)
VALUES (1, 'CHAPTER 01 어휘', 1, 1);
INSERT INTO book_content (book_id, name, superior_id, order_by)
VALUES (1, 'CHAPTER 02 독해', 1, 2);
INSERT INTO book_content (book_id, name, superior_id, order_by)
VALUES (1, '유형1 유의어', 4, 1);
INSERT INTO book_content (book_id, name, superior_id, order_by)
VALUES (1, '유형2 다의어', 4, 2);
-- 출판사, 책, 책목차 끝

-- 문제 유형 (카테고리)
INSERT INTO category (name, superior_id)
VALUES ('언어능력', null);
INSERT INTO category (name, superior_id)
VALUES ('수리능력', null);
INSERT INTO category (name, superior_id)
VALUES ('추리능력', null);
INSERT INTO category (name, superior_id)
VALUES ('어휘', 1);
INSERT INTO category (name, superior_id)
VALUES ('독해', 1);
-- 문제 유형 (카테고리) 끝

-- 유저
INSERT INTO user (email, password, nickname, phone)
VALUES ('user1234@naver.com', '1234', '김유저', '01012345678');

-- 유저 끝



