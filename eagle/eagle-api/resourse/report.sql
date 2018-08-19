select *
from (
select count(1) as total
,sum(case when code = '00' then 1 else 0 end ) as total_success
,sum(case when code != '00' then 1 else 0 end ) as total_failure
, resp_date
, 'FT' as request_type
from re_transfer_request
group by resp_date

union all

select count(1) as total
,sum(case when code = '00' then 1 else 0 end ) as total_success
,sum(case when code != '00' then 1 else 0 end ) as total_failure
, resp_date
, 'BI' as request_type
from re_balance_request
group by resp_date

union all

select count(1) as total
,sum(case when code = '00' then 1 else 0 end ) as total_success
,sum(case when code != '00' then 1 else 0 end ) as total_failure
, resp_date
, 'TS' as request_type
from re_status_request
group by resp_date

union all

select count(1) as total
,sum(case when code = '00' then 1 else 0 end ) as total_success
,sum(case when code != '00' then 1 else 0 end ) as total_failure
, resp_date
, 'AS' as request_type
from re_stmt_request
group by resp_date
) as b
where b.resp_date = '2016-10-21'


----------------------------------------------------------------------





select sum(d.num_items) as total
, d.code, d.description, d.resp_date
from (
select count(p.*) as num_items
, p.code, s.description, p.resp_date
from re_transfer_request p
inner join re_ws_response s on p.code = s.code
where p.resp_date = '2016-10-21'
group by p.code, s.description, p.resp_date

union all

select count(p.*) as num_items
, p.code, s.description, p.resp_date
from re_balance_request p
inner join re_ws_response s on p.code = s.code
where p.resp_date = '2016-10-21'
group by p.code, s.description, p.resp_date

union all

select count(p.*) as num_items
, p.code, s.description, p.resp_date
from re_status_request p
inner join re_ws_response s on p.code = s.code
where p.resp_date = '2016-10-21'
group by p.code, s.description, p.resp_date

union all

select count(p.*) as num_items
, p.code, s.description, p.resp_date
from re_stmt_request p
inner join re_ws_response s on p.code = s.code
where p.resp_date = '2016-10-21'
group by p.code, s.description, p.resp_date

) d
group by d.code, d.description, d.resp_date
order by d.code




