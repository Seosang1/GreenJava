use test; 

create table t_board (                  
   bn_idx   int    auto_increment primary key,   -- 글 번호
   bn_writer   varchar(20)   not null,     	     -- 작성자
   bn_pwd varchar(20) not null,					 -- 비밀번호
   bn_title   varchar(20) not null,              -- 제목
   bn_content   text,                            -- 내용
   bn_read   int   default 0,                    -- 조회수
   bn_date   datetime default now()       	     -- 작성일
);
select * from t_board;

 insert into t_board (bn_writer, bn_title, bn_content) values ('444', 'dd', '123');
 