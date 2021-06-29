use jejurisong;
 
create table t_food_info (		-- 음식점 정보 테이블
	food_idx int auto_increment unique,			-- 번호
    food_code char(5) primary key,				-- 식당코드
    food_name varchar(30) not null,				-- 상호명 
    food_addr varchar(150) not null, 			-- 상호주소
    food_zip varchar(5) not null,				-- 우편번호
    food_tel varchar(15) ,						-- 매장 연락처
    food_type varchar(6) not null,				-- 매장타입 (한식 양식 등)
    food_area char(1) not null, 				-- 매장 지역 
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
select * from t_food_info;

insert into t_food_reply (food_code, mem_id, food_re_content, food_re_score) values ('FD001', 'test1', '맛있어요', '3');
insert into t_food_reply (food_code, mem_id, food_re_content, food_re_score) values ('FD001', 'test1', '맛있어요', '4');
insert into t_food_reply (food_code, mem_id, food_re_content, food_re_score) values ('FD001', 'test1', '맛있어요', '2');
insert into t_food_reply (food_code, mem_id, food_re_content, food_re_score) values ('FD001', 'test1', '맛있어요', '5');
insert into t_food_reply (food_code, mem_id, food_re_content, food_re_score) values ('FD001', 'test1', '맛있어요', '3');

SELECT a.food_code, b.food_code, ROUND(AVG(b.food_re_score),1) , c.mem_id, b.mem_id
FROM t_food_info a, t_food_reply b, t_member_info c
where a.food_code = b.food_code and c.mem_id = b.mem_id;
 
 
 update t_food_info set food_name = '제주김만복' , food_addr = '제주특별자치도 제주시 오라로 41', food_zip = '63190', 
 food_tel = '064-759-8582', food_type = 'KFR', food_area = 'N', food_open = '08:00', food_close='20:30', 
 food_detail ='전복김밥, 제주김밥 제주도 맛집', food_img1 = '002_01.jpg', food_img2='002_02.jpg', food_img3='002_03.jpg', food_desc='002_desc.jpg' where food_code = 'FD002';

insert into t_food_info (food_code, food_name, food_addr, food_zip, food_tel, food_type, food_area, food_open, food_close, food_detail, food_img1, food_img2, food_img3, food_desc) values
	('FD001', '은희네해장국', '제주특별자치도 서귀포시 516로 84(1층 토평동)', '63604', '064-767-0039', 'KFR', 'S', '06:00', '15:00', '제주도 1등 해장국맛집 은희네입니다.', '001_01.jpg', '001_02.jpg', null, '001_desc.jpg');
insert into t_food_info (food_code, food_name, food_addr, food_zip, food_tel, food_type, food_area, food_open, food_close, food_detail, food_img1, food_img2, food_img3, food_desc) values
	('FD002', '은희네해장국', '제주특별자치도 서귀포시 516로 84(1층 토평동)', '63604', '064-767-0039', 'KFR', 'S', '06:00', '15:00', '제주도 1등 해장국맛집 은희네입니다.', '001_01.jpg', '001_02.jpg', null, '001_desc.jpg');
insert into t_food_info (food_code, food_name, food_addr, food_zip, food_tel, food_type, food_area, food_open, food_close, food_detail, food_img1, food_img2, food_img3, food_desc) values
	('FD003', '은희네해장국', '제주특별자치도 서귀포시 516로 84(1층 토평동)', '63604', '064-767-0039', 'KFR', 'S', '06:00', '15:00', '제주도 1등 해장국맛집 은희네입니다.', '001_01.jpg', '001_02.jpg', null, '001_desc.jpg');
insert into t_food_info (food_code, food_name, food_addr, food_zip, food_tel, food_type, food_area, food_open, food_close, food_detail, food_img1, food_img2, food_img3, food_desc) values
	('FD004', '은희네해장국', '제주특별자치도 서귀포시 516로 84(1층 토평동)', '63604', '064-767-0039', 'KFR', 'S', '06:00', '15:00', '제주도 1등 해장국맛집 은희네입니다.', '001_01.jpg', '001_02.jpg', null, '001_desc.jpg');
insert into t_food_info (food_code, food_name, food_addr, food_zip, food_tel, food_type, food_area, food_open, food_close, food_detail, food_img1, food_img2, food_img3, food_desc) values
	('FD005', '은희네해장국', '제주특별자치도 서귀포시 516로 84(1층 토평동)', '63604', '064-767-0039', 'KFR', 'S', '06:00', '15:00', '제주도 1등 해장국맛집 은희네입니다.', '001_01.jpg', '001_02.jpg', null, '001_desc.jpg');
insert into t_food_info (food_code, food_name, food_addr, food_zip, food_tel, food_type, food_area, food_open, food_close, food_detail, food_img1, food_img2, food_img3, food_desc) values
	('FD006', '은희네해장국', '제주특별자치도 서귀포시 516로 84(1층 토평동)', '63604', '064-767-0039', 'KFR', 'S', '06:00', '15:00', '제주도 1등 해장국맛집 은희네입니다.', '001_01.jpg', '001_02.jpg', null, '001_desc.jpg');
insert into t_food_info (food_code, food_name, food_addr, food_zip, food_tel, food_type, food_area, food_open, food_close, food_detail, food_img1, food_img2, food_img3, food_desc) values
	('FD007', '은희네해장국', '제주특별자치도 서귀포시 516로 84(1층 토평동)', '63604', '064-767-0039', 'KFR', 'S', '06:00', '15:00', '제주도 1등 해장국맛집 은희네입니다.', '001_01.jpg', '001_02.jpg', null, '001_desc.jpg');
insert into t_food_info (food_code, food_name, food_addr, food_zip, food_tel, food_type, food_area, food_open, food_close, food_detail, food_img1, food_img2, food_img3, food_desc) values
	('FD008', '은희네해장국', '제주특별자치도 서귀포시 516로 84(1층 토평동)', '63604', '064-767-0039', 'KFR', 'S', '06:00', '15:00', '제주도 1등 해장국맛집 은희네입니다.', '001_01.jpg', '001_02.jpg', null, '001_desc.jpg');
insert into t_food_info (food_code, food_name, food_addr, food_zip, food_tel, food_type, food_area, food_open, food_close, food_detail, food_img1, food_img2, food_img3, food_desc) values
	('FD009', '은희네해장국', '제주특별자치도 서귀포시 516로 84(1층 토평동)', '63604', '064-767-0039', 'KFR', 'S', '06:00', '15:00', '제주도 1등 해장국맛집 은희네입니다.', '001_01.jpg', '001_02.jpg', null, '001_desc.jpg');
insert into t_food_info (food_code, food_name, food_addr, food_zip, food_tel, food_type, food_area, food_open, food_close, food_detail, food_img1, food_img2, food_img3, food_desc) values
	('FD010', '은희네해장국', '제주특별자치도 서귀포시 516로 84(1층 토평동)', '63604', '064-767-0039', 'KFR', 'S', '06:00', '15:00', '제주도 1등 해장국맛집 은희네입니다.', '001_01.jpg', '001_02.jpg', null, '001_desc.jpg');
insert into t_food_info (food_code, food_name, food_addr, food_zip, food_tel, food_type, food_area, food_open, food_close, food_detail, food_img1, food_img2, food_img3, food_desc) values
	('FD011', '은희네해장국', '제주특별자치도 서귀포시 516로 84(1층 토평동)', '63604', '064-767-0039', 'KFR', 'S', '06:00', '15:00', '제주도 1등 해장국맛집 은희네입니다.', '001_01.jpg', '001_02.jpg', null, '001_desc.jpg');
insert into t_food_info (food_code, food_name, food_addr, food_zip, food_tel, food_type, food_area, food_open, food_close, food_detail, food_img1, food_img2, food_img3, food_desc) values
	('FD012', '은희네해장국', '제주특별자치도 서귀포시 516로 84(1층 토평동)', '63604', '064-767-0039', 'KFR', 'S', '06:00', '15:00', '제주도 1등 해장국맛집 은희네입니다.', '001_01.jpg', '001_02.jpg', null, '001_desc.jpg');

