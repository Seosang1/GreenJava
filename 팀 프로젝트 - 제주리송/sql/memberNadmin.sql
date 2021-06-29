-- create schema jejurisong;

use jejurisong;
 
create table t_admin_info ( 				-- 관리자 정보 등 
	ai_idx	int auto_increment unique,		-- 관리자 번호
	ai_id	varchar(20)	primary key,		-- 관리자 아이디
	ai_pwd	varchar(20)	NOT NULL,			-- 비밀번호
	ai_name	varchar(20)	NOT NULL,			-- 이름
	ai_isrun	char(1)	default 'y',		-- 사용여부(y:사용,n:사용불가)
	ai_regdate	datetime default now()		-- 등록일자
);

insert into t_admin_info values(1, 'sa', '1234', '관리자', 'y', now());

create table t_member_info (		-- 회원정보 테이블
    mem_id varchar(20) primary key,			-- 회원 아이디
	mem_idx int auto_increment unique,		-- 회원번호
    mem_type char(1) not null,				-- sns 타입(N:네이버, K:카카오)
    mem_name varchar(20) not null,			-- 이름
    mem_pic varchar(100),					-- 프로필 사진
    mem_email varchar(50) not null,			-- 이메일
    mem_birth char(10) not null,			-- 생년월일
    mem_gender char(1) not null,			-- 성별(F:여자, M:남자)
    mem_phone varchar(15) not null,			-- 전화번호
    mem_regi_date datetime default now()		-- 가입일자 
);
