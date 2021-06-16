create table std_info(
	std_num varchar(10) primary key, 
    std_name varchar(30) not null,
    gender char(1) default 'f',
    std_bd varchar(10) not null,
    phone varchar(15) not null,
	zip char(5) not null,
	addr1 varchar(50) not null, 	
	addr2 varchar(50) not null,
	email varchar(50) not null
);

create table sj_info (
	sj_id varchar(30) primary key,
    sj_name varchar(20),
    pf_name varchar(30) not null
);

create table test (
	std_num varchar(10) not null,
	sj_id varchar(30) not null,
	test_num varchar(30) not null,
    result int default '0',
    test_day datetime default now(),
	constraint fk_std_num foreign key (std_num) references std_info(std_num),
	constraint fk_sj_id foreign key (sj_id) references sj_info(sj_id)
);
