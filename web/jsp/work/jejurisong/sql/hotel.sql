-- create schema jejurisong;

use jejurisong;
 
 /* ========== 호텔정보 ========= */
create table t_hotel_info (						-- 숙박지 정보 테이블
	hotel_idx int auto_increment unique,		-- 호텔 번호	
	hotel_code char(5) not null primary key,	-- 숙박 코드 (H+인덱스)	
	hotel_area char(1) not null,				-- 지역	
	hotel_type varchar(5) not null,				-- 숙박 유형	
	hotel_name varchar(50) not null,			-- 숙박지명	
	hotel_addr varchar(150) not null,			-- 주소	
	hotel_zip varchar(7) not null,				-- 우편번호	
	hotel_tel varchar(15) not null,				-- 숙박 연락처	
	hotel_detail text,							-- 상세내용	
	hotel_stime varchar(5),						-- 체크인(HH:MM 형태)	
	hotel_etime varchar(5),						-- 체크아웃	
	hotel_park_yn char(1) default 'y',			-- 주차여부 (Y: 가능, N:불가능)	
    hotel_img1 varchar(50) not null,			-- 호텔 이미지
    hotel_img2 varchar(50),						-- 호텔 이미지
    hotel_img3 varchar(50),						-- 호텔 이미지
	hotel_score float default 0.0,				-- 평점	
	hotel_review_cnt int default 0,				-- 리뷰 수	
	hotel_open_yn char(1) default 'n',			-- 운영여부 (Y:운영중, N:미운영)	
	hotel_reg_date datetime default now(),		-- 등록일자	
	hotel_reg_id varchar(20) not null,			-- 등록처리자 (관리자아이디)	
	hotel_del_yn char(1) default 'n',			-- 삭제유무 (Y: 삭제, N:미삭제)	
	hotel_del_date datetime,					-- 삭제일자	
	hotel_del_id varchar(20)					-- 삭제처리자 (관리자아이디)
	-- , constraint fk_hotel_info_reg_id foreign key (hotel_reg_id) references t_admin_info(ai_id),
	-- constraint fk_hotel_info_del_id foreign key (hotel_del_id) references t_admin_info(ai_id)
);			
 
/* ======= 방 정보 ========*/
create table t_room_info (			-- 방 정보 테이블
	room_idx int auto_increment unique,			-- 방 번호
	room_code varchar(5) primary key,			-- 방코드 (R+인덱스)
    hotel_code varchar(5) not null,				-- 숙박코드 FK
	room_type varchar(5) not null,				-- 방종류
    room_cnt int not null,						-- 방 개
    room_eq text,			   					-- 객실구성
    room_svc text,								-- 객실 추가제공 서비스
	room_min int not null,						-- 최소 인원
    room_max int not null,						-- 최대 인원
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
    room_img varchar(50) not null				-- 객실 사진
	-- , constraint fk_room_info_reg_id foreign key (room_reg_id) references t_admin_info(ai_id),
	-- constraint fk_room_info_del_id foreign key (room_del_id) references t_admin_info(ai_id),  
	-- constraint fk_room_info_hotel_code foreign key (hotel_code) references t_hotel_info(hotel_code)
); 
 
/* ======= 예약 정보 ========*/
create table t_reserve_info (				-- 예약 관련 테이블
	rv_idx int auto_increment unique,			-- 예약번호
	rv_code varchar(11) primary key,			-- 예약번호(YYYYMMDD + 001)
    hotel_code char(5),				 			-- 숙박 코드
    room_code char(5),							-- 방 코드
   	mem_id varchar(20) not null,				-- 유저 아이디 
    rv_sdate varchar(10) not null,				-- 투숙시작일 (YYYY-MM-DD)
    rv_edate varchar(10) not null,				-- 투숙종료일 (YYYY-MM-DD)t_reserve_info
    rv_cnt int not null,						-- 투숙인원
    rv_price int not null,						-- 금액
    rv_discount int not null,					-- 할인율
    rv_dis_price int not null,					-- 결제금액
    rv_name varchar(20) not null,				-- 예약자이름
    rv_email varchar(50) not null,				-- 예약자 이메일주소
    rv_phone varchar(15) not null,				-- 예약자 연락처
    rv_content text,							-- 요청사항
    rv_payment char(1) default 'c',				-- 결제정보 (C: 카드)
    rv_agree char(1) default 'y',				-- 동의여부(Y: 동의, N:비동의)
    rv_date datetime default now(),				-- 예약일자
    rv_state char(1) default 'a',				-- 상태(A: 예약확정, B:예약취소, C: 여행종료)
    rv_cancel_date datetime,					-- 취소일자
    ai_id varchar(20)							-- 취소한 관리자 아이디 
	-- ,constraint fk_reserve_info_mem_id foreign key (mem_id) references t_member_info(mem_id),
	-- constraint fk_reserve_info_ai_id foreign key (ai_id) references t_admin_info(ai_id),
	-- constraint fk_reserve_info_hotel_code foreign key (hotel_code) references t_hotel_info(hotel_code),
	-- constraint fk_reserve_info_room_code foreign key (room_code) references t_room_info(room_code)
);

/* ======= 후기 정보 ========*/
create table t_room_reply (		-- 방 후기 테이블
	room_re_idx int auto_increment unique,		-- 번호
    rv_code varchar(11) not null,				-- 예약코드
    hotel_code varchar(5) not null,				-- 호텔코드
    room_code varchar(5) not null,				-- 방코드
    mem_id varchar(20) not null,				-- 유저아이디
	room_re_content text not null,				-- 후기내용
    room_re_score float default 0.0,			-- 평점
    room_re_date datetime default now(),		-- 등록일
    room_re_del_yn char(1) default 'n',			-- 삭제유무 (Y: 삭졔 , N:미삭제)
    room_re_del datetime ,						-- 삭제일
    room_re_del_id varchar(20)					-- 삭제처리자 (작성자 회원 or 삭제관리자)  
	-- ,constraint fk_room_reply_mem_id foreign key (mem_id) references t_member_info(mem_id),
	-- constraint fk_room_reply_hotel_code foreign key (hotel_code) references t_hotel_info(hotel_code),
	-- constraint fk_room_reply_room_code foreign key (room_code) references t_room_info(room_code),
	-- constraint fk_room_reply_rv_code foreign key (rv_code) references t_reserve_info(rv_code)
);
 

/* ======= 후기 등록 프로시저 ========*/
drop procedure if exists sp_reply_insert;
delimiter $$
create procedure sp_reply_insert(rvCode varchar(11), hotelCode varchar(5), roomCode varchar(5), memId varchar(20), roomReContent text, roomReScore float)
begin
	-- 1. 후기 등록
	insert into t_room_reply (rv_code, hotel_code, room_code, mem_id, room_re_content, room_re_score) values (rvCode, hotelCode, roomCode, memId, roomReContent, roomReScore);
	-- 2. 방 평점 수정 평점 리로드
	call sp_reply_reload(hotelCode, roomCode);
end $$
delimiter ;
-- call sp_reply_insert('20210621001', 'A0018', 'R0005', 'sora', '방 너무 좋아요', 4.5);

/* ======= 후기 수정 프로시저 ========*/
drop procedure if exists sp_reply_update;
delimiter $$
create procedure sp_reply_update(rvCode varchar(11), hotelCode varchar(5), roomCode varchar(5), roomReContent text, roomReScore float, roomReIdx int)
begin
	-- 1. 후기 등록
    update t_room_reply set 
		room_re_content = roomReContent, 
        room_re_score = roomReScore 
	where rv_code = rvCode;
    
    -- 2. 평점, 리뷰 개수 계산 후 리로드
	call sp_reply_reload(hotelCode, roomCode);
end $$
delimiter ;
-- call sp_reply_update('20210621001', 'A0018', 'R0005', '방 너무 좋아요', 3.5, 1);

/* ======= 후기 삭제 프로시저 ========*/
drop procedure if exists sp_reply_delete;
delimiter $$
create procedure sp_reply_delete(rvCode varchar(11), hotelCode varchar(5), roomCode varchar(5), delId varchar(20))
begin
	-- 1. 후기 등록
    update t_room_reply set room_re_score = 0, room_re_del_yn = 'y', room_re_del = now(), room_re_del_id = delId where rv_code = rvCode;
    
    -- 2. 평점, 리뷰개수 계산 후 리로드
	call sp_reply_reload(hotelCode, roomCode);
end $$
delimiter ;
-- call sp_reply_delete('20210621001', 'A0018', 'R0005', 'sora'); 


/* ======= 평점 다시 계산하는 프로시저 만들어서 돌리기 ========*/
drop procedure if exists sp_reply_reload;
delimiter $$
create procedure sp_reply_reload(hotelCode varchar(5), roomCode varchar(5))
begin
	-- 1. 방 평점 수정 
	update t_room_info set room_score = (select avg(room_re_score) from t_room_reply where room_code = roomCode and room_re_del_yn = 'n') where room_code = roomCode;
    
	-- 2. 호텔 전체 평점 수정 
	update t_hotel_info set hotel_score = (select avg(room_re_score) from t_room_reply where hotel_code = hotelCode and room_re_del_yn = 'n') where hotel_code = hotelCode;
    update t_hotel_info set hotel_review_cnt = (select count(room_re_idx) from t_room_reply where hotel_code = hotelCode and room_re_del_yn = 'n') where hotel_code = hotelCode;
    
end $$
delimiter ;
-- call sp_reply_reload('A0018', 'R0005'); 

 