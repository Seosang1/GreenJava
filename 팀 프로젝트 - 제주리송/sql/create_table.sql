-- create schema jejurisong;

use jejurisong;

-- (ok) --
create table t_admin_info ( 				-- 관리자 정보 등 
	ai_idx	int auto_increment unique,		-- 관리자 번호
	ai_id	varchar(20)	primary key,		-- 관리자 아이디
	ai_pwd	varchar(20)	NOT NULL,			-- 비밀번호
	ai_name	varchar(20)	NOT NULL,			-- 이름
	ai_isrun	char(1)	default 'y',		-- 사용여부(y:사용,n:사용불가)
	ai_regdate	datetime default now()		-- 등록일자
);

-- (ok) --
create table t_photo_list (   					-- 공통 사진 리스트 테이블
	photo_idx int auto_increment primary key, 	-- 번호
	photo_cate char(1) not null,     			-- 지점 종류(t:관광지, a:숙박, r:음식점)
	photo_code char(5) not null,    		 	-- FK입력 필요함 코드, 각 테이블의 코드값
	photo_name varchar(50) not null,   			-- 파일(사진)명
	photo_main_yn char(1) default 'n',    		-- 대표이미지 여부(Y:대표이미지 , n: 일반이미지)
	photo_reg_date datetime default now(),  	-- 등록일자
	phote_reg_id varchar(20) not null,    		-- 등록자(관리자아이디)
	photo_del_yn char(1) default 'n',    		-- 삭제유무 (Y: 삭제, N:미삭제)
	photo_del_date datetime default now(),  	-- 삭제일자
	photo_del_id varchar(20),       			-- 삭제처리자(관리자아이디)
	constraint fk_photo_reg_id foreign key (phote_reg_id) references t_admin_info(ai_id),
	constraint fk_photo_del_id foreign key (photo_del_id) references t_admin_info(ai_id)
); 


select * from t_food_info where food_code = food_code and food_name = food_name and food_isview = 'y' ;


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
    food_isadd char(1) default 'n'				-- 등록여부(고객센터 통해 신청 후 등록된지 여부)
);

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

-- (ok) --
create table t_hotel_info (						-- 숙박지 정보 테이블
	hotel_idx int auto_increment primary key,	-- 호텔 번호	
	hotel_code char(5) not null,				-- 숙박 코드 (H+인덱스)	
	hotel_area char(1) not null,				-- 지역	
	hotel_type varchar(5) not null,				-- 숙박 유형	
	hotel_name varchar(50) not null,			-- 숙박지명	
	hotel_addr varchar(150) not null,			-- 주소	
	hotel_zip varchar(5) not null,				-- 우편번호	
	hotel_tel varchar(15) not null,				-- 숙박 연락처	
	hotel_detail text,							-- 상세내용	
	hotel_stime varchar(5),						-- 체크인(HH:MM 형태)	
	hotel_etime varchar(5),						-- 체크아웃	
	hotel_park_yn char(1) default 'y',			-- 주차여부 (Y: 가능, N:불가능)	
	hotel_score int default 0.0,				-- 평점	
	hotel_review_cnt int default 0,				-- 리뷰 수	
	hotel_open_yn char(1) default 'n',			-- 운영여부 (Y:운영중, N:미운영)	
	hotel_reg_date datetime default now(),		-- 등록일자	
	hotel_reg_id varchar(20) not null,			-- 등록처리자 (관리자아이디)	
	hotel_del_yn char(1) default 'n',			-- 삭제유무 (Y: 삭제, N:미삭제)	
	hotel_del_date datetime default now(),		-- 삭제일자	
	hotel_del_id varchar(20),					-- 삭제처리자 (관리자아이디)
    hotel_img1 varchar(50) not null,			-- 호텔 이미지
    hotel_img2 varchar(50),						-- 호텔 이미지
    hotel_img3 varchar(50),						-- 호텔 이미지
	constraint fk_hotel_info_reg_id foreign key (hotel_reg_id) references t_admin_info(ai_id),
	constraint fk_hotel_info_del_id foreign key (hotel_del_id) references t_admin_info(ai_id)
);			

create table t_room_info (		-- 방 정보 테이블
	room_idx int auto_increment,				-- 방 번호
	room_code varchar(5) primary key,			-- 방코드 (R+인덱스)
    hotel_code varchar(5) not null,				-- 숙박코드 FK
	room_type varchar(5) not null,				-- 방종류
    room_number int not null,					-- 방 호수
    room_eq varchar(50),			   			-- 객실구성
    room_svc text,								-- 객실 추가제공 서비스
	room_min_cnt int not null,					-- 최소 인원
    room_max_cnt int not null,					-- 최대 인원
    room_price int not null,					-- 금액
    room_discount int not null,					-- 할인율
    room_dis_price int not null,				-- 할인금액
    room_score float default 0.0,				-- 평점평균 
    room_open_yn char(1) default 'n',			-- 운영여부 (Y:운영중 N:미운영)
	room_reg_date datetime default now(),		-- 등록일자      
	room_reg_id varchar(20) not null,			-- 등록처리자 (관리자아이디)	
    room_del_yn	char(1) default 'n',			-- 삭제유무(Y: 삭제 N:미삭제)
    room_del_date datetime,						-- 삭제일자          
	room_del_id varchar(20),					-- 삭제처리자 (관리자아이디)	
    room_img varchar(50) not null,				-- 객실 사진
	constraint fk_room_info_reg_id foreign key (room_reg_id) references t_admin_info(ai_id),
	constraint fk_room_info_del_id foreign key (room_del_id) references t_admin_info(ai_id),  
	constraint fk_room_info_hotel_code foreign key (hotel_code) references t_hotel_info(hotel_code)
);

create table t_reserve_info (		-- 예약 관련 테이블
	hotel_idx int auto_increment,				-- 호텔번호
	rv_code varchar(11) primary key,			-- 예약번호(YYYYMMDD + 001)
    hotel_code char(5),				 			-- 숙박 코드
    room_code char(5),							-- 방 코드
    rv_sdate datetime,							-- 투숙시작일
    rv_edate datetime,							-- 투숙종료일
    rv_cnt int,									-- 투숙인원
    rv_price int,								-- 금액
    rv_sale int,								-- 할인율
    rv_sale_price int,							-- 결제금액
    rv_name varchar(20) ,						-- 예약자이름
    rv_email varchar(50),						-- 예약자 이메일주소
    rv_phone varchar(15),						-- 예약자 연락처
    rv_content text,							-- 요청사항
    rv_payment char(1) default 'c',				-- 결제정보 (C: 카드)
    rv_agree char(1) default 'y',				-- 동의여부(Y: 동의, N:비동의)
    rv_date datetime default now(),				-- 예약일자
    rv_state char(1) default 'a',				-- 상태(A: 예약확정, B:예약취소, C: 여행종료)
    rv_cancel_date datetime,					-- 취소일자
    ai_id varchar(20),							-- 취소한 관리자 아이디 
	constraint fk_reserve_info_ai_id foreign key (ai_id) references t_admin_info(ai_id),
	constraint fk_reserve_info_hotel_code foreign key (hotel_code) references t_hotel_info(hotel_code),
	constraint fk_reserve_info_room_code foreign key (room_code) references t_room_info(room_code)
);

create table t_room_reply (		-- 방 후기 테이블
	room_re_idx int auto_increment,				-- 번호
    room_code varchar(5),						-- 방코드
    mem_id varchar(20),						-- 유저아이디
	room_re_content text,						-- 후기내용
    room_re_score int,							-- 평점
    room_re_date datetime default now(),		-- 등록일
    room_re_del_yn char(1) default 'n',			-- 삭제유무 (Y: 삭졔 , N:미삭제)
    ai_id varchar(20),							-- 삭제한 관리자 
	constraint fk_room_reply_ai_id foreign key (ai_id) references t_admin_info(ai_id),
	constraint fk_room_reply_mem_id foreign key (mem_id) references t_mem_info(mem_id),
	constraint fk_room_reply_room_code foreign key (room_code) references t_room_info(room_code)
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
	constraint fk_brd_faq_mem_id foreign key (mem_id) references t_mem_info(mem_id) 
);