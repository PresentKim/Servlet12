SET SESSION FOREIGN_KEY_CHECKS = 0;

/*
 * Drop Tables
 */
DROP TABLE IF EXISTS address;
DROP TABLE IF EXISTS cart;
DROP TABLE IF EXISTS order_detail;
DROP TABLE IF EXISTS orders;
DROP TABLE IF EXISTS qna;
DROP TABLE IF EXISTS member;
DROP TABLE IF EXISTS product;


/*
 * Create Tables
 */
CREATE TABLE IF NOT EXISTS address
(
    zip_num  varchar(15) NOT NULL COMMENT '우편번호',
    sido     varchar(30) NOT NULL COMMENT '시도',
    gugun    varchar(30) NOT NULL COMMENT '구군',
    dong     varchar(30) NOT NULL COMMENT '동',
    bunji    varchar(20) COMMENT '번지',
    zip_code varchar(30) COMMENT '우편번호'
);


CREATE TABLE IF NOT EXISTS cart
(
    cseq     int PRIMARY KEY        NOT NULL AUTO_INCREMENT COMMENT '장바구니 일련번호',
    quantity int                    NOT NULL COMMENT '수량',
    indate   datetime DEFAULT now() NOT NULL COMMENT '장바구니에 담은 날짜',
    userid   varchar(45)            NOT NULL COMMENT '사용자 아이디',
    pseq     int                    NOT NULL COMMENT '상품 일련번호'
);


CREATE TABLE IF NOT EXISTS member
(
    userid   varchar(45) PRIMARY KEY NOT NULL COMMENT '사용자 아이디',
    pwd      varchar(45)             NOT NULL COMMENT '비밀번호',
    name     varchar(45)             NOT NULL COMMENT '이름',
    phone    varchar(45)             NOT NULL COMMENT '전화번호',
    email    varchar(100)            NOT NULL COMMENT '이메일',
    zip_num  varchar(15) COMMENT '우편번호',
    address1 varchar(100) COMMENT '주소1',
    address2 varchar(100) COMMENT '주소2',
    indate   datetime DEFAULT now()  NOT NULL COMMENT '가입일',
    useyn    char(1)  DEFAULT 'Y'    NOT NULL COMMENT '사용여부'
);


CREATE TABLE IF NOT EXISTS orders
(
    oseq   int PRIMARY KEY        NOT NULL AUTO_INCREMENT COMMENT '주문 일련번호',
    indate datetime DEFAULT now() NOT NULL COMMENT '주문 날짜',
    userid varchar(45)            NOT NULL COMMENT '사용자 아이디'
);


CREATE TABLE IF NOT EXISTS order_detail
(
    odseq    int PRIMARY KEY     NOT NULL AUTO_INCREMENT COMMENT '주문 상세 일련번호',
    oseq     int                 NOT NULL COMMENT '주문 일련번호',
    pseq     int                 NOT NULL COMMENT '상품 일련번호',
    quantity int                 NOT NULL COMMENT '수량',
    result   char(1) DEFAULT '1' NOT NULL COMMENT '결과'
);


CREATE TABLE IF NOT EXISTS product
(
    pseq         int PRIMARY KEY        NOT NULL AUTO_INCREMENT COMMENT '상품 일련번호',
    name         varchar(100)           NOT NULL COMMENT '상품명',
    kind         char(1)                NOT NULL COMMENT '상품 종류',
    price1       int                    NOT NULL COMMENT '가격1',
    price2       int                    NOT NULL COMMENT '가격2',
    price3       int                    NOT NULL COMMENT '가격3',
    content      varchar(500)           NOT NULL COMMENT '설명',
    image        varchar(100)           NOT NULL COMMENT '이미지 파일명',
    savefilename varchar(200)           NOT NULL COMMENT '저장된 파일명',
    bestyn       char(1)  DEFAULT 'N'   NOT NULL COMMENT '베스트 상품 여부',
    useyn        char(1)  DEFAULT 'Y'   NOT NULL COMMENT '사용 여부',
    indate       datetime DEFAULT now() NOT NULL COMMENT '등록일'
);


CREATE TABLE IF NOT EXISTS qna
(
    qseq    int PRIMARY KEY        NOT NULL AUTO_INCREMENT COMMENT '질문 일련번호',
    userid  varchar(45)            NOT NULL COMMENT '사용자 아이디',
    subject varchar(100)           NOT NULL COMMENT '제목',
    content varchar(1000)          NOT NULL COMMENT '내용',
    reply   varchar(1000) COMMENT '답변',
    indate  datetime DEFAULT now() NOT NULL COMMENT '작성일'
);


/*
 *Add Foreign Key
 */
ALTER TABLE cart
    ADD FOREIGN KEY (userid)
        REFERENCES member (userid)
        ON UPDATE RESTRICT
        ON DELETE RESTRICT;


ALTER TABLE orders
    ADD FOREIGN KEY (userid)
        REFERENCES member (userid)
        ON UPDATE RESTRICT
        ON DELETE RESTRICT;


ALTER TABLE qna
    ADD FOREIGN KEY (userid)
        REFERENCES member (userid)
        ON UPDATE RESTRICT
        ON DELETE RESTRICT;


ALTER TABLE order_detail
    ADD FOREIGN KEY (oseq)
        REFERENCES orders (oseq)
        ON UPDATE RESTRICT
        ON DELETE RESTRICT;


ALTER TABLE cart
    ADD FOREIGN KEY (pseq)
        REFERENCES product (pseq)
        ON UPDATE RESTRICT
        ON DELETE RESTRICT;


ALTER TABLE order_detail
    ADD FOREIGN KEY (pseq)
        REFERENCES product (pseq)
        ON UPDATE RESTRICT
        ON DELETE RESTRICT;
