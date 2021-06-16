use ssw1;

-- 1번 문제
create table t_member (
	m_idx int auto_increment unique,
	mi_id varchar(20) primary key,
    m_pwd varchar(20) not null,
    m_name varchar(10) not null,
    m_phone varchar(13) not null,
    m_date datetime default now()
);

-- 2번 문제
drop procedure if exists sp_member_insert;
delimiter $$
create procedure sp_member_insert(mid varchar(20), mpwd varchar(20), 
	mname varchar(10), mphone varchar(13))
begin 	
declare i int;
set i = 1;
	loop1:while (i <= 15) do
		insert into t_member (mi_id, m_pwd, m_name, m_phone, m_date) values
		(concat(i,' id'), '1234', concat('홍길동',i), '010-1234-5678', now()); 
		set i = i + 1;
	end while;
end $$
delimiter ;
call sp_member_insert('1 id', 1234, '홍길동1', '010-1234-5678'); 
select * from t_member order by m_idx asc;

-- 3번문제
drop procedure if exists sp_member_update;
delimiter $$
create procedure sp_member_update(midx int, mid varchar(10), mname varchar(10), mdate datetime)
begin
   update t_member set mi_id = mid, m_name = mname, m_date = mdate where m_idx = midx;
end $$
delimiter ;
call sp_member_update(10,'10id', '홍길동10', '2021-03-28');
select * from t_member;


-- 4번문제
select m_date 월별, count(m_idx) 회원수 from t_member  group by month(m_date);

-- 5번문제
select * from t_member group by m_idx order by m_date desc limit 10;