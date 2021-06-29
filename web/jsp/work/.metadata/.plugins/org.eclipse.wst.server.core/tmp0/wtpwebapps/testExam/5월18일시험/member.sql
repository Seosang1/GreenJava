use testmall;

create table t_member (
	m_idx int auto_increment unique,
    m_id varchar(20) primary key,
    m_pwd varchar(20) not null,
	mi_isactive char(1) default 'y'
);

insert into  t_member (m_id, m_pwd) values ('test', '1234');

select * from t_member;

select * from t_member where m_id = 'test';