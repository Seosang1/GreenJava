use world;

-- 350468.2236
select * from city;
select * from country;
select * from countrylanguage;

-- 나라별 나라코드, 도시의 개수, 도시인구 평균(소수점 아래 2자리까지) 출력
select CountryCode, count(ID), truncate(avg(Population), 2) 
from city group by CountryCode;

-- 나라별 가장 인구가 많은 나라코드, 도시의 이름, 인구수 출력
select CountryCode, Name, Population 
from city group by CountryCode having Population = max(Population);

-- 나라별 인구가 100만 ~ 900만인 도시 개수 : 나라코드, 도시개수
select CountryCode, count(ID) from city 
-- where Population between 1000000 and 9000000 
where Population >= 1000000 and Population <= 9000000 
group by CountryCode;

-- 나라별 인구가 500만이상인 도시들을 인구 많은 순으로 정렬하여 모든 컬럼 출력
select * from city where Population >= 5000000 order by Population desc;

select floor(1.5), truncate(1.5, 0), floor(-1.5), truncate(-1.5, 0);
select ceil(1.5), truncate(1.5, 0), ceil(-1.5), truncate(-1.5, 0);

select adddate('2020-02-01', interval 31 day), addtime('23:59:59', '1:1:1');
select datediff('2021-07-15', now()), datediff('2021-01-28', now());
select timediff('23:59:59', curtime()), timediff('00:00:00', curtime());
select dayofweek('2021-12-25'), monthname(now()), dayofyear(now()), last_day('2020-02-15');
select makedate(2021, 100), makedate(2021, -1), maketime(12, 34, 56);
select period_add(202111, 6), period_diff(202205, 202111), quarter(now()), time_to_sec('12:34:56');
select database(), schema(), found_rows(), version();




select * from city;
select * from country;

-- 평균 인구수(35만)가 넘는 도시를 5개 이상 가진 나라의 Code, Name을 출력
select a.CountryCode, b.Name, count(a.ID) cnt 
from city a, country b 
where a.CountryCode = b.Code 
and a.Population >= (select avg(Population) from city) 
group by a.CountryCode, b.Name 
having cnt >= 5 
order by cnt desc;

show index from city;
show index from country;

create table test (
	col1 varchar(5) , 
    col2 varchar(5) not null, 
    col3 varchar(5) 
);
show index from test;
insert into test values ('abcd1', 'fdsa', 'asdf1');
insert into test values ('abcd2', 'fdsa', 'asdf2');
insert into test values ('abcd3', 'fdsa', 'asdf3');
insert into test values ('abcd4', 'fdsa', 'asdf4');
select * from test;

set autocommit = on;
drop procedure if exists sp_test;
delimiter $$
create procedure sp_test(c1 varchar(5), c2 varchar(5))
begin
	start transaction;
		update test set col2 = c2 where col1 = c1;
		update test set col3 = 'fdsafsda' where col1 = c1;
    commit;
end $$
delimiter ;
call sp_test('abcd2', 'aaadd');

-- gnp가 예전 gnp보다 높은 나라들의 이름과 코드, 도시개수와 도시의 평균 인구수를 보여주는 쿼리를 이용하여 view를 생성
-- 뷰의 이름은 develop_country, 현재 gnp가 20만 이상, 예전 gnp가 null이 아니어야 함
create view v_develop_country as 
	select b.Code, b.Name, count(a.ID), avg(a.Population) from city a, country b 
	where a.CountryCode = b.Code and b.GNP >= 200000 and b.GNP > b.GNPOld and b.GNPOld is not null 
	group by b.Code, b.Name;

select * from v_develop_country;








select b.Code, b.Name, count(a.ID), avg(a.Population)
from city a, country b 
where a.CountryCode = b.Code and b.GNP >= 200000 
and b.GNP > b.GNPOld and b.GNPOld is not null 
group by b.Code, b.Name; 






