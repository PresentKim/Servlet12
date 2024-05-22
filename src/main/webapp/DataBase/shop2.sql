-- 회원 입력
INSERT INTO member(userid, pwd, name, zip_num, address1, address2, phone, email)
VALUES ('one', '1111', '김나리', '133-110', '서울시 성동구 성수동1가', '1번지21호', '017-777-7777', 'acc@abc.com'),
       ('two', '2222', '김길동', '130-120', '서울시 송파구 잠실2동', '리센츠아파트 201-505', '011-123-4567', 'acc@abc.com');

-- 상품 입력
INSERT INTO product(name, kind, price1, price2, price3, content, image, savefilename, bestyn)
VALUES ('크로그다일부츠', '2', 40000, 50000, 10000, '오리지날 크로그다일부츠 입니다.', 'w2.jpg', 'w2.jpg', 'Y'),
       ('롱부츠', '2', 40000, 50000, 10000, '따뜻한 롱부츠 입니다.', 'w-28.jpg', 'w-28.jpg', 'N'),
       ('힐', '1', 10000, 12000, 2000, '여성용전용 힐', 'w-14.jpg', 'w-14.jpg', 'N'),
       ('슬리퍼', '4', 5000, 5500, 500, '편안한 슬리퍼입니다.', 'w-25.jpg', 'w-25.jpg', 'Y'),
       ('회색힐', '1', 10000, 12000, 2000, '여성용전용 힐', 'w-23.jpg', 'w-23.jpg', 'Y'),
       ('여성부츠', '2', 12000, 18000, 6000, '여성용 부츠', 'w4.jpg', 'w4.jpg', 'Y'),
       ('핑크샌달', '3', 5000, 5500, 500, '사계절용 샌달입니다.', 'w-24.jpg', 'w-24.jpg', 'Y'),
       ('슬리퍼', '3', 5000, 5500, 500, '편안한 슬리퍼입니다.', 'w11.jpg', 'w11.jpg', 'Y'),
       ('스니커즈', '4', 15000, 20000, 5000, '활동성이 좋은 스니커즈입니다.', 'w-13.jpg', 'w-13.jpg', 'Y'),
       ('샌달', '3', 5000, 5500, 500, '사계절용 샌달입니다.', 'w-09.jpg', 'w-09.jpg', 'N'),
       ('스니커즈', '5', 15000, 20000, 5000, '활동성이 좋은 스니커즈입니다.', 'w-05.jpg', 'w-05.jpg', 'N');

-- cart
INSERT INTO cart (userid, pseq, quantity)
VALUES ('one', 2, 1),
       ('two', 3, 1);

-- orders 와 order_detail
INSERT INTO orders (userid)
VALUES ('one'),
       ('two'),
       ('one');

INSERT INTO order_detail (oseq, pseq, quantity)
VALUES (1, 2, 1),
       (1, 3, 2),
       (2, 4, 3),
       (2, 5, 2),
       (3, 3, 1),
       (3, 2, 1);


INSERT INTO qna (subject, content, userid)
VALUES ('배송관련 문의입니다', '현재 배송상태와 예상 배송일을 답변 부탁합니다', 'one'),
       ('환불관련', '환불절차 안내부탁드려요.... 배송사 선택은 어떻게 되는지도...', 'two'),
       ('사이즈 교환 하고 싶어요', '사이즈가 예상보다 작습니다. 교환절차를 안내부탁드려요', 'one'),
       ('배송이 많이 지연되고 있습니다', '언제 받을 수 있나요', 'two'),
       ('불량품 교환 문의', '교환 또는 환불 등의 안내가 필요합니다. 유선안내부탁드려요', 'one'),
       ('배송관련 문의입니다', '현재 배송상태와 예상 배송일을 답변 부탁합니다', 'one'),
       ('환불관련', '환불절차 안내부탁드려요.... 배송사 선택은 어떻게 되는지도...', 'two'),
       ('사이즈 교환 하고 싶어요', '사이즈가 예상보다 작습니다. 교환절차를 안내부탁드려요', 'one'),
       ('배송이 많이 지연되고 있습니다', '언제 받을 수 있나요', 'two'),
       ('불량품 교환 문의', '교환 또는 환불 등의 안내가 필요합니다. 유선안내부탁드려요', 'one');

-- cart 안의 pseq로 상품이름과  그리고 userid로 사용자 이름을 함꼐 조회하는  view를 생성합니다
CREATE OR REPLACE view cart_view AS
SELECT c.cseq,
       c.userid,
       m.name AS mname,
       c.pseq,
       p.name AS pname,
       c.quantity,
       p.price2,
       c.indate
FROM cart c,
     product p,
     member m
WHERE c.pseq = p.pseq
  AND c.userid = m.userid;

-- orders 와 order_detail 의 join 으로
-- 1. 주문번호(oseq)에 따른 주문상품들의 표시 
-- 2. 상품번호에 따른 상품 이름과 가격 등의 정보 표시
-- 3. 아이디에 따른 고객 이름과 배송주소 등의 정보 표시
CREATE OR REPLACE view order_view AS
SELECT d.odseq,
       o.oseq,
       o.indate,
       o.userid,
       m.name AS mname,
       m.zip_num,
       m.address1,
       m.address2,
       m.phone,
       d.pseq,
       p.name AS pname,
       p.price2,
       d.quantity,
       d.result
FROM orders o,
     order_detail d,
     product p,
     member m
WHERE o.oseq = d.oseq
  AND o.userid = m.userid
  AND d.pseq = p.pseq;

-- 신상품  View 생성
CREATE OR REPLACE view new_pro_view AS
SELECT pseq, name, price2, image, savefilename
FROM product
WHERE useyn = 'Y'
ORDER BY indate DESC
LIMIT 4;

-- 베스트 상품 view 생성
CREATE OR REPLACE view best_pro_view AS
SELECT pseq, name, price2, image, savefilename
FROM product
WHERE bestyn = 'Y'
ORDER BY indate DESC
LIMIT 4;