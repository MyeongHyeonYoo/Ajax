CREATE SEQUENCE seq_board;

CREATE TABLE tbl_board (
    bno NUMBER(10, 0),
    title VARCHAR2(200) NOT NULL,
    content VARCHAR2(2000) NOT NULL,
    writer VARCHAR2(50) NOT NULL,
    regdate date default sysdate,
    updatedate DATA DEFAULT sysdate
    );

ALTER TABLE tbl_board ADD CONSTRAINT pk_board PRIMARY KEY (bno);

INSERT INTO tbl_board (bno, title, content, writer)
VALUES (seq_board.nextval, '테스트 제목', '테스트 내용', 'user00');

COMMIT;
    
