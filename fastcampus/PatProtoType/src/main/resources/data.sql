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

-- 유저 권한
INSERT INTO role (name)
VALUES ('admin');
INSERT INTO role (name)
VALUES ('user');
-- 유저 권한 끝

-- 유저
INSERT INTO user (email, password, nickname, phone)
VALUES ('admin@naver.com', '1234', 'admin', '01077777777');
INSERT INTO user_role (user_id, role_id)
VALUES (1, 1);
INSERT INTO user_role (user_id, role_id)
VALUES (1, 2);

INSERT INTO user (email, password, nickname, phone)
VALUES ('user1234@naver.com', '1234', '김유저', '01012345678');
INSERT INTO user_role (user_id, role_id)
VALUES (2, 2);
-- 유저 끝

-- 문제, 지문, 보기
INSERT INTO question (category_id, book_content_id, book_number, query)
VALUES (4, 6, 1, '다음 지문을 보고 밑줄에 해당되는 유의어를 고르시오');
INSERT INTO passage (type, content)
VALUES ('text',
        '동해물과 백두산이 마르고 닳도록 하나님이 보우하사 우리 나라만세 무궁화 삼천리 화려 강산 <u>대한</u>사람 대한으로 길이 보전하세 남산 위에 저 나무 철갑을 두른 듯 바람 서리 불변함은 우리 기상일세 무궁화 삼천리 화려 강산 대한 사람 대한으로 길이 보전하세');
INSERT INTO choice (question_id, content, correct)
VALUES (1, '이건 정답이 아님 그렇습니다 정답이 아닙니다. 정답이 아니라구요', false);
INSERT INTO choice (question_id, content, correct)
VALUES (1, '이것도 정답이 아닐껄? 이렇게 까지 말하는데 이걸 찍지마세요. 제발요.', false);
INSERT INTO choice (question_id, content, correct)
VALUES (1, '정답 아닙니다. 오늘 먹은 볶음밥 너무 맛이 없었어. 다시는 안가야지 흑흑', false);
INSERT INTO choice (question_id, content, correct)
VALUES (1, '이것이 오답입니다! 하하하 오답입니다 오답 오답!! 덩실덩실', false);
INSERT INTO choice (question_id, content, correct)
VALUES (1, '이건 정답입니다. 샘플데이터 넣기 너무 힘드네요.', true);

INSERT INTO question (category_id, book_content_id, book_number, query)
VALUES (4, 6, 2, '다음 지문을 보고 밑줄에 해당되는 유의어를 고르시오');
INSERT INTO passage (type, content)
VALUES ('text',
        '저번에 말이야 객체와 인스턴스의 차이점이 뭔지아냐고 병수가 물어보더라고, 아주 재밌었어, 결국 <u>객체</u>도 영어로는 오브젝트니까 별개의 단어인데 우리는 혼용해서 쓰고 있자나? 인스턴스는 특정 클래스로 부터 나온 객체임을 강조하고 싶을때 사용한다고 자바의 정석에서는 그렇게 써있었어, 내가 이런말을 왜하냐면 아무말이나 써야하니까 갑자기 생각나는 내용을 써봤어 복습도 되고 좋다.');
INSERT INTO choice (question_id, content, correct)
VALUES (2, '이건 정답이 아님 그렇습니다 정답이 아닙니다. 정답이 아니라구요', false);
INSERT INTO choice (question_id, content, correct)
VALUES (2, '이것도 정답이 아닐껄? 이렇게 까지 말하는데 이걸 찍지마세요. 제발요.', false);
INSERT INTO choice (question_id, content, correct)
VALUES (2, '정답 아닙니다. 오늘 먹은 볶음밥 너무 맛이 없었어. 다시는 안가야지 흑흑', false);
INSERT INTO choice (question_id, content, correct)
VALUES (2, '이건 정답입니다. 샘플데이터 넣기 너무 힘드네요.', true);
INSERT INTO choice (question_id, content, correct)
VALUES (2, '이것이 오답입니다! 하하하 오답입니다 오답 오답!! 덩실덩실', false);

INSERT INTO question (category_id, book_content_id, book_number, query)
VALUES (4, 6, 3, '다음 지문을 보고 밑줄에 해당되는 유의어를 고르시오');
INSERT INTO passage (type, content)
VALUES ('text',
        'JPA를 쓰면서도 너무 어려워 그리고 스프링에서 JPA셋팅을 직접 해줘야한다며? 우리 스프링으로 할꺼잖아 근데 <u>프로토타입</u>은 그냥 부트로 해보고 있어 셋팅하기가 넘 무서워서 해보긴 해야하는데 JPA 넘 어렵다. 이번에 꼭 마스터 해보자 화이팅 짱짱맨');
INSERT INTO choice (question_id, content, correct)
VALUES (3, '이건 정답이 아님 그렇습니다 정답이 아닙니다. 정답이 아니라구요', false);
INSERT INTO choice (question_id, content, correct)
VALUES (3, '이건 정답입니다. 샘플데이터 넣기 너무 힘드네요.', true);
INSERT INTO choice (question_id, content, correct)
VALUES (3, '이것도 정답이 아닐껄? 이렇게 까지 말하는데 이걸 찍지마세요. 제발요.', false);
INSERT INTO choice (question_id, content, correct)
VALUES (3, '정답 아닙니다. 오늘 먹은 볶음밥 너무 맛이 없었어. 다시는 안가야지 흑흑', false);
INSERT INTO choice (question_id, content, correct)
VALUES (3, '이것이 오답입니다! 하하하 오답입니다 오답 오답!! 덩실덩실', false);
-- 문제, 지문, 보기 끝



