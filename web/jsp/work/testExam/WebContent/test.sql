use test;

create table t_board (
		bn_idx int auto_increment primary key,   		-- 글번호 
		bn_pwd varchar(20),   				-- 비밀번호
		bn_writer varchar(20) not null,  	-- 작성자
		bn_title varchar(100) not null,  	-- 제목
		bn_content text not null,   		-- 내용
		bn_reply int default 0,   			-- 댓글 수 
		bn_read int default 0,   			-- 조회수
		bn_date datetime default now()   	-- 작성일
);
 
 insert into t_board (bn_writer, bn_pwd, bn_title, bn_content) values ('ㅇㅇ', '1234', '제목', '안녕');
 
 select * from t_board;