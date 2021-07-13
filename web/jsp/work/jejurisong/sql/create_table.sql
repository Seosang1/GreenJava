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


create table t_member_info (		-- 회원정보 테이블
	mem_idx int auto_increment unique,	-- 회원번호
    mem_id varchar(20) primary key,		-- 회원 아이디
    mem_type char(1) not null,			-- sns 타입(N:네이버, K:카카오)
    mem_name varchar(20) not null,		-- 이름
    mem_pic varchar(100),				-- 프로필 사진
    mem_email varchar(50) not null,		-- 이메일
    mem_birth char(10) not null,		-- 생년월일
    mem_gender char(1) not null,		-- 성별(F:여자, M:남자)
    mem_phone varchar(15) not null,		-- 전화번호
    mem_regi_date datetime default now()		-- 가입일자 
); 

insert into t_member_info (mem_id, mem_type, mem_name, mem_email, mem_birth, mem_gender, mem_phone) 
	values ('test1', 'N', '회원', 'test1@naver.com', '1995.02.02', 'M', '010-1234-1234');

create table t_food_info (		-- 음식점 정보 테이블
	food_idx int auto_increment unique,			-- 번호
    food_code char(5) primary key,				-- 식당코드
    food_name varchar(30) not null,				-- 상호명 
    food_addr varchar(150) not null, 			-- 상호주소
    food_zip varchar(5) not null,				-- 우편번호
    food_tel varchar(15) ,						-- 매장 연락처
    food_type varchar(6) not null,				-- 매장타입 (한식 양식 등)
    food_area varchar(5) not null, 				-- 매장 지역 
    food_like int default 0,					-- 찜하기 수
    food_open varchar(5),						-- 오픈시간
    food_close varchar(5), 						-- 닫는시간
    food_img1 varchar(50) not null,				-- 이미지1	
    food_img2 varchar(50),						-- 이미지2
    food_img3 varchar(50),						-- 이미지3
    food_desc varchar(50),						-- 설명이미지
    food_review_cnt int default 0,				-- 리뷰 수
    food_park_yn char(1) default 'n', 			-- 주차여부
    food_open_yn char(1) default 'y',			-- 오픈 여부
    food_detail text not null,					-- 매장 설명
    food_isview char(1) default 'y',			-- 표시 여부
    food_score float default 0,					-- 평점
    food_reg_date datetime default now(),		-- 등록일자
	food_reg_id varchar(20) not null,			-- 등록처리자 (관리자아이디)	
    food_isadd char(1) default 'n',				-- 등록여부(고객센터 통해 신청 후 등록된지 여부)
	food_del_yn char(1) default 'n',			-- 삭제유무 (Y: 삭제, N:미삭제)	
	food_del_date datetime default now(),		-- 삭제일자	 
    food_del_id varchar(20),					-- 삭제처리 관리자
	constraint fk_food_info_reg_id foreign key (food_reg_id) references t_admin_info(ai_id),
	constraint fk_food_info_del_id foreign key (food_del_id) references t_admin_info(ai_id)
); 
select * from t_food_info  
 group by food_code 
 order by food_idx desc  limit 0, 10; 
 
create table t_food_reply (		-- 음식점 후기 테이블
	food_code char(5),							-- 음식점 코드
    food_re_idx int auto_increment primary key,	-- 리뷰 번호  
    mem_id varchar(20),							-- 유저아이디
    food_re_content text,						-- 후기 내용
    food_re_score float not null,				-- 댓글 평점
    food_re_reg_date datetime default now(),	-- 댓글 등록일자
    food_re_del_yn char(1) default 'n',			-- 삭제 여부(Y: 삭제, N:미삭제)
    food_re_del_date datetime default now(),	-- 삭제일자
    ai_id varchar(20),							-- 삭제한 관리자 
	constraint fk_food_reply_food_code foreign key (food_code) references t_food_info(food_code),
	constraint fk_food_reply_mem_id foreign key (mem_id) references t_member_info(mem_id)
);  

create table t_tour_info ( 		-- 관광지 정보 테이블
	tour_idx int auto_increment primary key,	-- 관광지 번호
    tour_code char(5) not null,					-- 코드
    tour_name varchar(30) not null,				-- 장소명
    tour_addr varchar(150) not null,			-- 주소
    tour_zip varchar(5) not null,				-- 우편번호
    tour_tel varchar(15),						-- 관리소 연락처
    tour_type varchar(10) not null,				-- 관광지 타입(자연,문화관광,액티비티)
    tour_area varchar(10) not null,				-- 관광지 지역
    tour_open varchar(5),						-- 관광지 오픈시간
    tour_close varchar(5),						-- 닫는 시간
    tour_park_yn char(1) default 'n',			-- 주차여부
    tour_like int default 0,					-- 찜하기 수
    tour_isview char(1) default 'y', 			-- 표시여부
    tour_isadd char(1) default 'n',				-- 관광지 등록 신청시 등록 여부
    tour_reg_date datetime default now(),		-- 관광지 등록된 일자
    tour_img1 varchar(50) not null,				-- 관광지 사진
    tour_img2 varchar(50),						-- 관광지 사진
    tour_img3 varchar(50)						-- 관광지 사진
);	 


create table t_brd_notice (		-- 공지사항 테이블
	bn_idx int auto_increment primary key,		-- 번호
	bn_title varchar(20) not null,				-- 공지 제목
    bn_content text not null,					-- 공지 내용
    bn_read int default 0,						-- 조회수
    bn_isnotice char(1) default 'n',			-- 공지 여부
    bn_date datetime default now(),				-- 작성일
    ai_id varchar(20),							-- 관리자 아이디
	constraint fk_brd_notice_ai_id foreign key (ai_id) references t_admin_info(ai_id) 
);

create table t_brd_faq (	-- 자주묻는 질문 테이블
	bf_idx int auto_increment primary key,		-- 번호
    bf_cata varchar(10) not null,				-- 분류
    bf_title varchar(20) not null,				-- 제목
    bf_content text not null,					-- 답변
    bf_date datetime default now(),				-- 작성일
    ai_id varchar(20),							-- 관리자 아이디
	constraint fk_brd_faq_ai_id foreign key (ai_id) references t_admin_info(ai_id) 
);

create table t_brd_qna (	-- 1:1 질문 테이블
	bq_idx int auto_increment primary key,		-- 번호
    mem_id varchar(20),						-- 유저아이디
    bq_cata varchar(20) not null,				-- 분류(유형)
    bq_title varchar(20) not null,				-- 질문제목
    bq_content text not null,					-- 질문내용
	bq_qdate datetime default now(),			-- 질문 등록일
    bq_answer text,								-- 답변내용
    ai_id varchar(20),							-- 관리자 아이디
	bq_adate datetime,							-- 답변일
    bq_status char(1) default 'n',				-- 답변상태 (Y: 답변완료 N:미답변
	constraint fk_brd_qna_ai_id foreign key (ai_id) references t_admin_info(ai_id) ,
	constraint fk_brd_faq_mem_id foreign key (mem_id) references t_member_info(mem_id) 
);