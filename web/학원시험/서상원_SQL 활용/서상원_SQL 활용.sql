use ssw;

-- 1번 문제
create table t_member (
	m_idx int unique,
	m_id varchar(20) primary key,
    m_pwd varchar(20) not null,
    m_name varchar(10) not null
);

-- 2번 문제
drop procedure sp_member_insert;
delimiter $$
create procedure sp_member_insert()
begin 
    declare i int;
    set i = 1;
	 loop1:loop
	if i = 11 then
		leave loop1;
	end if;
		insert into t_member (m_idx, m_id, m_pwd, m_name) values
		(101-i, concat('test',i), '1234', '홍길동');
		set i = i + 1;
	 end loop;
     select min(m_idx) from t_member ;
end $$
delimiter ;
call sp_member_insert();  
select * from t_member order by m_idx desc; 

SET SQL_SAFE_UPDATES = 0;

-- 3번 문제
drop procedure sp_member_update;
delimiter $$
create procedure sp_member_update()
begin  
		update t_member set m_name = "김길동" where m_idx % 2 = 0;
		update t_member set m_name = "이길동" where m_idx % 2 = 1;
	select * from t_member order by m_idx desc;
end $$ 
delimiter ;	  
call sp_member_update();  

-- 4번 문제
select m_name 이름, count(m_name) 회원수 from t_member 
group by m_name;