-- 빛고을 BOOKS
CREATE DATABASE rbookDB;
USE rbookDB;
DROP TABLE tbl_books;
CREATE TABLE tbl_books(
	b_code	VARCHAR(6)		PRIMARY KEY,
	b_name	VARCHAR(125)	NOT NULL,	
	b_auther	VARCHAR(125)	NOT NULL,	
	b_comp	VARCHAR(125),		
	b_year	VARCHAR(15)	NOT NULL,	
	b_iprice	INT,		
	b_rprice	INT	NOT NULL,
    b_stop	VARCHAR(1) NOT NULL
);

DROP TABLE tbl_users;
CREATE TABLE tbl_users(
	u_code	VARCHAR(6)		PRIMARY KEY,
	u_name	VARCHAR(125)	NOT NULL,	
	u_tel	VARCHAR(125),		
	u_addr	VARCHAR(125),	
	u_stop VARCHAR(1) NOT NULL
);

CREATE TABLE tbl_rent_book(
	rent_seq	BIGINT		PRIMARY KEY	AUTO_INCREMENT,
	rent_date	VARCHAR(30)	NOT NULL,		
	rent_return_date	VARCHAR(10)	NOT NULL,		
	rent_bcode	VARCHAR(6)	NOT NULL,		
	rent_ucode	VARCHAR(6)	NOT NULL,		
	rent_return_yn	VARCHAR(1),			
	rent_point	INT			
);
ALTER TABLE tbl_rent_book ADD CONSTRAINT FK_USERS
FOREIGN KEY (rent_ucode) REFERENCES tbl_users(u_code);
ALTER TABLE tbl_rent_book ADD CONSTRAINT FK_USERS
FOREIGN KEY (rent_bcode) REFERENCES tbl_books(b_code);

INSERT INTO tbl_books(
b_code,
b_name,
b_auther,
b_comp,
b_year,
b_iprice,
b_rprice,
b_stop
)
VALUES(
	"000003", "학교가자", "학생", "저세상", "2023-07-21", 10000, 100, "Y"
);
commit;

SELECT * FROM tbl_books;
WHERE b_name = "우리금쪽이" OR b_auther = "오은영";

SELECT count(*) FROM tbl_books
WHERE b_name = "우리금쪽이";
commit;
SELECT * FROM tbl_books
WHERE b_code = "000001";

SELECT * FROM tbl_users WHERE u_stop = "Y";
INSERT INTO tbl_users(u_code,u_name,u_tel,u_addr,u_stop)
VALUES("000001","홍길자", "010-1111-1111", "서울시 관악구", "Y");

SELECT * FROM tbl_users WHERE u_code = "000001";
SELECT * FROM tbl_users;
SELECT * FROM tbl_users 
 		WHERE u_name = "홍길동" AND u_tel = "111";
