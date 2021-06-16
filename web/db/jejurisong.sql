use jejurisong;

create table t_master_code (	-- 공통 마스터 코드 테이블
	master_idx int primary key auto_increment, 	-- 번호
    master_big_code varchar(5) not null,		-- 대분류 코드
    master_big_name varchar(5) not null,		-- 대분류 이름
    master_small_code varchar(5) not null, 		-- 중분류 코드
    master_small_name varchar(5) not null, 		-- 중분류 이름
    master_code varchar(5) not null,			-- 코드
    master_value varchar(20)					-- 값
);

create table t_user_info (		-- 회원정보 테이블
	user_idx int auto_increment primary key,	-- 회원번호
    user_type char(1),							-- sns 타입(N:네이버, K:카카오)
    user_name varchar(20),						-- 이름
    user_pic varchar(100),						-- 프로필 사진
    user_email varchar(50),						-- 이메일
    user_birth char(10),						-- 생년월일
    user_gender char(1),						-- 성별(F:여자, M:남자)
    user_phone varchar(15),						-- 전화번호
    user_regi_date datetime default now()		-- 가입일자 
);



create table t_photo_list (	 	-- 공통 사진 리스트 테이블
	photo_idx int auto_increment primary key,	-- 번호
    photo_type char(1) not null, 				-- 구분(H: 숙박, F: 음식점, T: 관광지)
    photo_code char(5) not null, 				-- FK입력 필요함  코드, 각 테이블의 코드값
    photo_name varchar(50) not null,			-- 파일(사진)명
    photo_src varchar(100) not null, 			-- 경로
    photo_main_yn char(1) default 'n', 			-- 대표이미지 여부(Y:대표이미지 , n: 일반이미지)
    photo_reg_date datetime default now(),		-- 등록일자
    photo_del_yn char(1) default 'n', 			-- 삭제유무 (Y: 삭제, N:미삭제)
    photo_del_date datetime default now()		-- 삭제일자
);

create table t_food_info (		-- 음식점 정보 테이블
	food_idx int auto_increment primary key,	-- 번호
    food_code char(5) not null,					-- 식당코드
    food_name varchar(30) not null,				-- 상호명
    food_ceo varchar(30) not null,				-- 대표명
    food_addr varchar(150) not null, 			-- 상호주소
    food_zip varchar(5) not null,				-- 우편번호
    food_tel varchar(15) ,						-- 매장 연락처
    food_type varchar(6) not null,				-- 매장타입 (한식 양식 등)
    food_area varchar(5), 						-- 매장 지역 
    food_like int default 0,					-- 찜하기 수
    food_open varchar(5),						-- 오픈시간
    food_close varchar(5), 						-- 닫는시간
    food_review_cnt int default 0,				-- 리뷰 수
    food_park_yn char(1) default 'n', 			-- 주차여부
    food_open_yn char(1) default 'y',			-- 오픈 여부
    food_detail text not null,					-- 매장 설명
    food_isview char(1) default 'y',			-- 표시 여부
    food_score int default 0,					-- 평점
    food_reg_date datetime default now(),		-- 등록일자
    food_isadd char(1) default 'n'				-- 등록여부(고객센터 통해 신청 후 등록된지 여부)
);

create table t_food_reply (		-- 음식점 후기 테이블
	food_idx int,								-- 음식점 번호
    food_re_idx int auto_increment primary key,	-- 리뷰 번호  
    user_id varchar(20),						-- 유저아이디
    food_re_content text,						-- 후기 내용
    food_re_score int not null,					-- 댓글 평점
    food_re_reg_date datetime default now(),	-- 댓글 등록일자
    food_re_del_yn char(1) default 'n',			-- 삭제 여부(Y: 삭제, N:미삭제)
    food_re_del_date datetime default now(),	-- 삭제일자
    ai_id varchar(20),							-- 삭제한 관리자 
	constraint fk_food_reply_food_idx foreign key (food_idx) references t_food_info(food_idx),
	constraint fk_food_reply_food_idx foreign key (user_id) references t_food_info(user_id)
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
    tour_reg_date datetime default now()		-- 관광지 등록된 일자 
);

create table t_hotel_info (		-- 숙박지 정보 테이블
	hotel_idx int auto_increment primary key,	-- 호텔 번호
	hotel_code char(5) not null,				-- 숙박 코드 (H+인덱스)
    hotel_area varchar(5) not null, 			-- 지역
    hotel_type varchar(5) not null,				-- 숙박 유형
    hotel_name varchar(50) not null,			-- 숙박지명
    hotel_addr varchar(150) not null,			-- 주소
    hotel_zip varchar(5) not null,				-- 우편번호
    hotel_tel varchar(15) not null,				-- 숙박 연락처
    hotel_detail text, 							-- 상세내용
    hotel_stime varchar(5),						-- 체크인(HH:MM 형태)
    hotel_etime varchar(5),						-- 체크아웃
    hotel_park_yn char(1) default 'y',			-- 주차여부 (Y: 가능, N:불가능)
    hotel_score int default 0,					-- 평점
    hotel_review_cnt int default 0,				-- 리뷰 수
    hotel_open_yn char(1) default 'n',			-- 운영여부 (Y:운영중, N:미운영)
    hotel_reg_date datetime default now(),		-- 등록일자
    hotel_del_yn char(1) default 'n',			-- 삭제유무 (Y: 삭제, N:미삭제)
    hotel_del_date datetime default now()		-- 삭제일자
);

create table t_room_info (		-- 방 정보 테이블
	room_idx int auto_increment,				-- 방 번호
	room_code varchar(5) not null,				-- 방코드 (R+인덱스)
    hotel_code varchar(5),						-- 숙박코드 FK
	room_type varchar(5) not null,				-- 방종류
    room_number int not null,					-- 방 호수
    room_eq varchar(50) not null,			   	-- 객실구성 (t_master_code:master_code 에 있는 값 ㅇㅇ,ㅇㅇ,ㅇㅇ 형태로)
    room_svc text,								-- 객실 추가제공 서비스
	room_min_cnt int,							-- 최소 인원
    room_max_cnt int,							-- 최대 인원
    room_price int,								-- 원가
    room_sale int,								-- 할인율
    room_sale_price int,						-- 할인금액
    room_score int default 0,					-- 평점
    room_open_yn char(1) default 'n',			-- 운영여부 (Y:운영중 N:미운영)
	room_reg_date datetime default now(),		-- 등록일자
    room_del_yn	char(1) default 'n',			-- 삭제유무(Y: 삭제 N:미삭제)
    room_del_date datetime default now(),		-- 삭제일자
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
    user_id varchar(20),						-- 유저아이디
	room_re_content text,						-- 후기내용
    room_re_score int,							-- 평점
    room_re_date datetime default now(),		-- 등록일
    room_re_del_yn char(1) default 'n',			-- 삭제유무 (Y: 삭졔 , N:미삭제)
    ai_id varchar(20),							-- 삭제한 관리자 
	constraint fk_room_reply_ai_id foreign key (ai_id) references t_admin_info(ai_id),
	constraint fk_room_reply_user_id foreign key (user_id) references t_user_info(user_id),
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
    user_id varchar(20),						-- 유저아이디
    bq_cata varchar(20) not null,				-- 분류(유형)
    bq_title varchar(20) not null,				-- 질문제목
    bq_content text not null,					-- 질문내용
	bq_qdate datetime default now(),			-- 질문 등록일
    bq_answer text,								-- 답변내용
    ai_id varchar(20),							-- 관리자 아이디
	bq_adate datetime,							-- 답변일
    bq_status char(1) default 'n',				-- 답변상태 (Y: 답변완료 N:미답변
	constraint fk_brd_qna_ai_id foreign key (ai_id) references t_admin_info(ai_id) ,
	constraint fk_brd_faq_user_id foreign key (user_id) references t_user_info(user_id) 
);