-- create schema jejurisong;

use jejurisong;
 
create table t_hotel_info (						-- 숙박지 정보 테이블
	hotel_idx int auto_increment unique,		-- 호텔 번호	
	hotel_code char(5) not null primary key,	-- 숙박 코드 (H+인덱스)	
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
    hotel_img1 varchar(50) not null,			-- 호텔 이미지
    hotel_img2 varchar(50),						-- 호텔 이미지
    hotel_img3 varchar(50),						-- 호텔 이미지
	hotel_score int default 0.0,				-- 평점	
	hotel_review_cnt int default 0,				-- 리뷰 수	
	hotel_open_yn char(1) default 'n',			-- 운영여부 (Y:운영중, N:미운영)	
	hotel_reg_date datetime default now(),		-- 등록일자	
	hotel_reg_id varchar(20) not null,			-- 등록처리자 (관리자아이디)	
	hotel_del_yn char(1) default 'n',			-- 삭제유무 (Y: 삭제, N:미삭제)	
	hotel_del_date datetime,					-- 삭제일자	
	hotel_del_id varchar(20),					-- 삭제처리자 (관리자아이디)
	constraint fk_hotel_info_reg_id foreign key (hotel_reg_id) references t_admin_info(ai_id),
	constraint fk_hotel_info_del_id foreign key (hotel_del_id) references t_admin_info(ai_id)
);			

select * from t_hotel_info;
 
-- hotel_list query 
select * from t_hotel_info hotel left join 
(select hotel_code, count(hotel_code) as room_cnt from t_room_info group by hotel_code) room
on hotel.hotel_code = room.hotel_code; 
select count(*) from t_room_info  where hotel_code in ( '', 'A0001') ;
update t_hotel_info set  hotel_del_yn ='y',  hotel_open_yn ='n',  hotel_del_date = now(),  hotel_del_id = 'sa' where hotel_code in ( '', 'A0001') ;
select * from t_hotel_info hotel left join 	(select hotel_code, count(hotel_code) as room_cnt from t_room_info group by hotel_code) room
	on hotel.hotel_code = room.hotel_code  where  hotel_area = 'N' and hotel_type = 'PNS' and hotel_open_yn = 'n' and hotel_name like '%숙박%' order by hotel_idx desc  limit 0, 10;
    select * from t_hotel_info ;

INSERT INTO jejurisong.t_hotel_info(hotel_code, hotel_area, hotel_type, hotel_name, hotel_addr, hotel_zip, hotel_tel, hotel_detail, hotel_stime, hotel_etime, hotel_park_yn, hotel_img1, hotel_img2, hotel_img3, hotel_open_yn, hotel_reg_id) 
 VALUES ('A0003', 'E', 'GHS', '숙박명_테스트', '제주시 주소 테스트', '13101', '000-1111', '이 호텔은 좋다.', '14:00', '11:00', 'y', 'btn_pg_last.png', '', '', 'n', 'sa');
 INSERT INTO jejurisong.t_hotel_info(hotel_code, hotel_area, hotel_type, hotel_name, hotel_addr, hotel_zip, hotel_tel, hotel_detail, hotel_stime, hotel_etime, hotel_park_yn, hotel_img1, hotel_img2, hotel_img3, hotel_open_yn, hotel_reg_id) 
 VALUES ('A0004', 'E', 'GHS', '숙박명_테스트', '제주시 주소 테스트', '13101', '000-1111', '이 호텔은 좋다.', '14:00', '11:00', 'y', 'btn_pg_last.png', '', '', 'n', 'sa');
 INSERT INTO jejurisong.t_hotel_info(hotel_code, hotel_area, hotel_type, hotel_name, hotel_addr, hotel_zip, hotel_tel, hotel_detail, hotel_stime, hotel_etime, hotel_park_yn, hotel_img1, hotel_img2, hotel_img3, hotel_open_yn, hotel_reg_id) 
 VALUES ('A0005', 'E', 'GHS', '숙박명_테스트', '제주시 주소 테스트', '13101', '000-1111', '이 호텔은 좋다.', '14:00', '11:00', 'y', 'btn_pg_last.png', '', '', 'n', 'sa');
 INSERT INTO jejurisong.t_hotel_info(hotel_code, hotel_area, hotel_type, hotel_name, hotel_addr, hotel_zip, hotel_tel, hotel_detail, hotel_stime, hotel_etime, hotel_park_yn, hotel_img1, hotel_img2, hotel_img3, hotel_open_yn, hotel_reg_id) 
 VALUES ('A0006', 'E', 'GHS', '숙박명_테스트', '제주시 주소 테스트', '13101', '000-1111', '이 호텔은 좋다.', '14:00', '11:00', 'y', 'btn_pg_last.png', '', '', 'n', 'sa');
 INSERT INTO jejurisong.t_hotel_info(hotel_code, hotel_area, hotel_type, hotel_name, hotel_addr, hotel_zip, hotel_tel, hotel_detail, hotel_stime, hotel_etime, hotel_park_yn, hotel_img1, hotel_img2, hotel_img3, hotel_open_yn, hotel_reg_id) 
 VALUES ('A0007', 'E', 'GHS', '숙박명_테스트', '제주시 주소 테스트', '13101', '000-1111', '이 호텔은 좋다.', '14:00', '11:00', 'y', 'btn_pg_last.png', '', '', 'n', 'sa');
 INSERT INTO jejurisong.t_hotel_info(hotel_code, hotel_area, hotel_type, hotel_name, hotel_addr, hotel_zip, hotel_tel, hotel_detail, hotel_stime, hotel_etime, hotel_park_yn, hotel_img1, hotel_img2, hotel_img3, hotel_open_yn, hotel_reg_id) 
 VALUES ('A0008', 'E', 'GHS', '숙박명_테스트', '제주시 주소 테스트', '13101', '000-1111', '이 호텔은 좋다.', '14:00', '11:00', 'y', 'btn_pg_last.png', '', '', 'n', 'sa');
 INSERT INTO jejurisong.t_hotel_info(hotel_code, hotel_area, hotel_type, hotel_name, hotel_addr, hotel_zip, hotel_tel, hotel_detail, hotel_stime, hotel_etime, hotel_park_yn, hotel_img1, hotel_img2, hotel_img3, hotel_open_yn, hotel_reg_id) 
 VALUES ('A0009', 'E', 'GHS', '숙박명_테스트', '제주시 주소 테스트', '13101', '000-1111', '이 호텔은 좋다.', '14:00', '11:00', 'y', 'btn_pg_last.png', '', '', 'n', 'sa');
INSERT INTO jejurisong.t_hotel_info(hotel_code, hotel_area, hotel_type, hotel_name, hotel_addr, hotel_zip, hotel_tel, hotel_detail, hotel_stime, hotel_etime, hotel_park_yn, hotel_img1, hotel_img2, hotel_img3, hotel_open_yn, hotel_reg_id) 
 VALUES ('A0010', 'E', 'GHS', '숙박명_테스트', '제주시 주소 테스트', '13101', '000-1111', '이 호텔은 좋다.', '14:00', '11:00', 'y', 'btn_pg_last.png', '', '', 'n', 'sa');
INSERT INTO jejurisong.t_hotel_info(hotel_code, hotel_area, hotel_type, hotel_name, hotel_addr, hotel_zip, hotel_tel, hotel_detail, hotel_stime, hotel_etime, hotel_park_yn, hotel_img1, hotel_img2, hotel_img3, hotel_open_yn, hotel_reg_id) 
 VALUES ('A0011', 'E', 'GHS', '숙박명_테스트', '제주시 주소 테스트', '13101', '000-1111', '이 호텔은 좋다.', '14:00', '11:00', 'y', 'btn_pg_last.png', '', '', 'n', 'sa');
INSERT INTO jejurisong.t_hotel_info(hotel_code, hotel_area, hotel_type, hotel_name, hotel_addr, hotel_zip, hotel_tel, hotel_detail, hotel_stime, hotel_etime, hotel_park_yn, hotel_img1, hotel_img2, hotel_img3, hotel_open_yn, hotel_reg_id) 
 VALUES ('A0012', 'E', 'GHS', '숙박명_테스트', '제주시 주소 테스트', '13101', '000-1111', '이 호텔은 좋다.', '14:00', '11:00', 'y', 'btn_pg_last.png', '', '', 'n', 'sa');
INSERT INTO jejurisong.t_hotel_info(hotel_code, hotel_area, hotel_type, hotel_name, hotel_addr, hotel_zip, hotel_tel, hotel_detail, hotel_stime, hotel_etime, hotel_park_yn, hotel_img1, hotel_img2, hotel_img3, hotel_open_yn, hotel_reg_id) 
 VALUES ('A0013', 'E', 'GHS', '숙박명_테스트', '제주시 주소 테스트', '13101', '000-1111', '이 호텔은 좋다.', '14:00', '11:00', 'y', 'btn_pg_last.png', '', '', 'n', 'sa');
INSERT INTO jejurisong.t_hotel_info(hotel_code, hotel_area, hotel_type, hotel_name, hotel_addr, hotel_zip, hotel_tel, hotel_detail, hotel_stime, hotel_etime, hotel_park_yn, hotel_img1, hotel_img2, hotel_img3, hotel_open_yn, hotel_reg_id) 
 VALUES ('A0014', 'E', 'GHS', '숙박명_테스트', '제주시 주소 테스트', '13101', '000-1111', '이 호텔은 좋다.', '14:00', '11:00', 'y', 'btn_pg_last.png', '', '', 'n', 'sa');
INSERT INTO jejurisong.t_hotel_info(hotel_code, hotel_area, hotel_type, hotel_name, hotel_addr, hotel_zip, hotel_tel, hotel_detail, hotel_stime, hotel_etime, hotel_park_yn, hotel_img1, hotel_img2, hotel_img3, hotel_open_yn, hotel_reg_id) 
 VALUES ('A0015', 'E', 'GHS', '숙박명_테스트', '제주시 주소 테스트', '13101', '000-1111', '이 호텔은 좋다.', '14:00', '11:00', 'y', 'btn_pg_last.png', '', '', 'n', 'sa');
INSERT INTO jejurisong.t_hotel_info(hotel_code, hotel_area, hotel_type, hotel_name, hotel_addr, hotel_zip, hotel_tel, hotel_detail, hotel_stime, hotel_etime, hotel_park_yn, hotel_img1, hotel_img2, hotel_img3, hotel_open_yn, hotel_reg_id) 
 VALUES ('A0016', 'E', 'GHS', '숙박명_테스트', '제주시 주소 테스트', '13101', '000-1111', '이 호텔은 좋다.', '14:00', '11:00', 'y', 'btn_pg_last.png', '', '', 'n', 'sa');
INSERT INTO jejurisong.t_hotel_info(hotel_code, hotel_area, hotel_type, hotel_name, hotel_addr, hotel_zip, hotel_tel, hotel_detail, hotel_stime, hotel_etime, hotel_park_yn, hotel_img1, hotel_img2, hotel_img3, hotel_open_yn, hotel_reg_id) 
 VALUES ('A0017', 'E', 'GHS', '숙박명_테스트', '제주시 주소 테스트', '13101', '000-1111', '이 호텔은 좋다.', '14:00', '11:00', 'y', 'btn_pg_last.png', '', '', 'n', 'sa');
INSERT INTO jejurisong.t_hotel_info(hotel_code, hotel_area, hotel_type, hotel_name, hotel_addr, hotel_zip, hotel_tel, hotel_detail, hotel_stime, hotel_etime, hotel_park_yn, hotel_img1, hotel_img2, hotel_img3, hotel_open_yn, hotel_reg_id) 
 VALUES ('A0018', 'E', 'GHS', '숙박명_테스트', '제주시 주소 테스트', '13101', '000-1111', '이 호텔은 좋다.', '14:00', '11:00', 'y', 'btn_pg_last.png', '', '', 'n', 'sa');
INSERT INTO jejurisong.t_hotel_info(hotel_code, hotel_area, hotel_type, hotel_name, hotel_addr, hotel_zip, hotel_tel, hotel_detail, hotel_stime, hotel_etime, hotel_park_yn, hotel_img1, hotel_img2, hotel_img3, hotel_open_yn, hotel_reg_id) 
 VALUES ('A0019', 'E', 'GHS', '숙박명_테스트', '제주시 주소 테스트', '13101', '000-1111', '이 호텔은 좋다.', '14:00', '11:00', 'y', 'btn_pg_last.png', '', '', 'n', 'sa');
INSERT INTO jejurisong.t_hotel_info(hotel_code, hotel_area, hotel_type, hotel_name, hotel_addr, hotel_zip, hotel_tel, hotel_detail, hotel_stime, hotel_etime, hotel_park_yn, hotel_img1, hotel_img2, hotel_img3, hotel_open_yn, hotel_reg_id) 
 VALUES ('A0020', 'E', 'GHS', '숙박명_테스트', '제주시 주소 테스트', '13101', '000-1111', '이 호텔은 좋다.', '14:00', '11:00', 'y', 'btn_pg_last.png', '', '', 'n', 'sa');

INSERT INTO jejurisong.t_hotel_info(hotel_code, hotel_area, hotel_type, hotel_name, hotel_addr, hotel_zip, hotel_tel, hotel_detail, hotel_stime, hotel_etime, hotel_park_yn, hotel_img1, hotel_img2, hotel_img3, 
hotel_open_yn, hotel_reg_id) VALUES ('A0021', 'S', 'RST', '서귀포 리조트!', '제주시 주소 테스트', '13101', '000-1111', '이 호텔은 좋다.', '14:00', '11:00', 'y', 'btn_login14.png', '', '', 'y', 'sa');

create table t_room_info (			-- 방 정보 테이블
	room_idx int auto_increment unique,			-- 방 번호
	room_code varchar(5) primary key,			-- 방코드 (R+인덱스)
    hotel_code varchar(5) not null,				-- 숙박코드 FK
	room_type varchar(5) not null,				-- 방종류
    room_number int not null,					-- 방 호수
    room_eq varchar(50),			   			-- 객실구성
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
    room_img varchar(50) not null,				-- 객실 사진
	constraint fk_room_info_reg_id foreign key (room_reg_id) references t_admin_info(ai_id),
	constraint fk_room_info_del_id foreign key (room_del_id) references t_admin_info(ai_id),  
	constraint fk_room_info_hotel_code foreign key (hotel_code) references t_hotel_info(hotel_code)
);

create table t_reserve_info (				-- 예약 관련 테이블
	rv_idx int auto_increment unique,			-- 예약번호
	rv_code varchar(11) primary key,			-- 예약번호(YYYYMMDD + 001)
    hotel_code char(5),				 			-- 숙박 코드
    room_code char(5),							-- 방 코드
   	mem_id varchar(20) not null,				-- 유저 아이디 
    rv_sdate datetime not null,					-- 투숙시작일
    rv_edate datetime not null,					-- 투숙종료일
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
    ai_id varchar(20),							-- 취소한 관리자 아이디 
	constraint fk_reserve_info_mem_id foreign key (mem_id) references t_member_info(mem_id),
	constraint fk_reserve_info_ai_id foreign key (ai_id) references t_admin_info(ai_id),
	constraint fk_reserve_info_hotel_code foreign key (hotel_code) references t_hotel_info(hotel_code),
	constraint fk_reserve_info_room_code foreign key (room_code) references t_room_info(room_code)
);

create table t_room_reply (		-- 방 후기 테이블
	room_re_idx int auto_increment unique,		-- 번호
    hotel_code varchar(5) not null,				-- 호텔코드
    room_code varchar(5) not null,				-- 방코드
    mem_id varchar(20) not null,				-- 유저아이디
	room_re_content text not null,				-- 후기내용
    room_re_score float default 0.0,			-- 평점
    room_re_date datetime default now(),		-- 등록일
    room_re_del_yn char(1) default 'n',			-- 삭제유무 (Y: 삭졔 , N:미삭제)
    room_re_del datetime ,						-- 삭제일
    room_re_del_id varchar(20),					-- 삭제처리자 (작성자 회원 or 삭제관리자)  
	constraint fk_room_reply_mem_id foreign key (mem_id) references t_member_info(mem_id),
	constraint fk_room_reply_hotel_code foreign key (hotel_code) references t_hotel_info(hotel_code),
	constraint fk_room_reply_room_code foreign key (room_code) references t_room_info(room_code)
);