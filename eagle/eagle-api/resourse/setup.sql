insert into core_role(id, name, description) values 
('admin','admin role',' the admin role'),
('audit','audit role',' the audit role');


insert into core_user(id, first_name, last_name, password, email,mobile_number, role,deleted) values
(1,'admin', 'user', 'admin','admin@exelon.ng','08023202211','admin',false),
(2,'audit', 'user', 'audit','audit@exelon.ng','08023202212','audit',false);

update core_user set password = 'eHYVOtqCdKJMSGR+h2dHAXVfnQk=' where role = 'audit';
update core_user set password = '0DPiKuNIrrVmD8IUCuw1hQxNqZc=' where role = 'admin';

 insert into core_parameter(id, timeout) values  ('system', 30);
 
 
 insert into finacle.cmg(cust_id,cif_id,cust_name) values('001','R001','Demo Customer 1');
 insert into finacle.cmg(cust_id,cif_id,cust_name) values('002','R002','Demo Customer 2');
 
 
 insert into finacle.gam(foracid,cust_id,acct_name,sol_id,acct_crncy_code,acid,clr_bal_amt) values
 ('2001451201','001','Demo Customer 1 NGN Account','001','NGN','A121212',25400),
 ('7001451201','001','Demo Customer 1 USD Account','001','USD','45522',1232.12),
 ('2001451451','002','Demo Customer 2 USD Account','001','USD','568845',78922.12),
 ('2071451451','002','Demo Customer 2 USD Account','001','NGN','774454',8788912.12);
 
 
 insert into core_region(id,name,description, deleted) values(nextval('region_id_seq'),'VICTORIA ISLAND', 'Victoria Island Region',false);
 
 -------------------------------------------------------------------------------------------------
 create or replace view v_callover_summary as
 select 
 	t.tran_date
 	, trim(t.tran_id) as tran_id
 	, sum(case when t.part_tran_type = 'D' then t.tran_amt else 0 end ) as total_debit
 	, sum(case when t.part_tran_type = 'C' then t.tran_amt else 0 end ) as total_credit
 	, count(t.tran_id) as num_entries
 	, t.entry_user_id
 	, t.sol_id
 	, (sum(case when t.part_tran_type = 'D' then t.tran_amt else 0 end )  - 
 		sum(case when t.part_tran_type = 'C' then t.tran_amt else 0 end ) ) as difference
 from finacle.dtd t
 group by t.tran_date, t.tran_id, t.sol_id, t.entry_user_id
 order by t.tran_date, t.tran_id desc;
 
---------------------------------------------------------------------------------------
select 
	g.foracid
	, g.acct_name
	, t.*
from finacle.dtd t 
join finacle.gam g on g.acid = t.acid
where trim(t.tran_id) = ?
and t.tran_date =  ?
order by t.tran_id desc

-------------------------------------------------------------------------------
insert into core_channel(id,name,description) values
(nextval('hibernate_sequence'),'POS','POS'),
(nextval('hibernate_sequence'),'ATM','ATM Channel'),
(nextval('hibernate_sequence'),'BRANCH','Branch'),
(nextval('hibernate_sequence'),'ALAT','ALAT'),
(nextval('hibernate_sequence'),'USSD','USSD'),
(nextval('hibernate_sequence'),'ONLINE','WEB');

------------------------------------------------------------------


insert into core_audit_exception(id,name,description,deleted) values
(nextval('hibernate_sequence'),'Repeated Debits','Repeated Debits',false),
(nextval('hibernate_sequence'),'Repeated Credits','Repeated Credits',false),
(nextval('hibernate_sequence'),'Odd Hour Transaction','Odd Hour Transaction',false),
(nextval('hibernate_sequence'),'Large Value Transaction','Large Value Transaction',false);

--------------------------------------------------------
select d.*
	,g.foracid
from finacle.dtd d
join finacle.gam g on g.acid = d.acid
where d.cust_id is not null
and d.tran_particular like '%Wema USSD%';


---------------------------------------------------
select 
	d.cust_id
	, g.foracid
	, d.tran_date
	, g.acct_crncy_code
	, sum(case when d.part_tran_type = 'D' then d.tran_amt else 0 end ) as total_debit
 	, sum(case when d.part_tran_type = 'C' then d.tran_amt else 0 end ) as total_credit
 	, count(d.cust_id) as txn_count
 	, 6 as channel_id
from finacle.dtd d
join finacle.gam g on g.acid = d.acid
where d.cust_id is not null
and d.tran_particular like 'POS%'
group by d.cust_id, g.foracid, d.tran_date, g.acct_crncy_code
order by d.cust_id

----------------------------------------------------------------------------------------------- 	

insert into core_txn_by_channel(id,cr_amount,currency,dr_amount,tran_date,txn_count,account_number,channel,customer)
select 
	 nextval('ctxn_id_seq')
	, sum(case when d.part_tran_type = 'C' then d.tran_amt else 0 end ) as total_credit
	, g.acct_crncy_code
	, sum(case when d.part_tran_type = 'D' then d.tran_amt else 0 end ) as total_debit
	, d.tran_date
	, count(d.cust_id) as txn_count
	, g.foracid
	, 6 as channel_id
	, c.cif_id
from finacle.dtd d
inner join finacle.gam g on g.acid = d.acid
inner join finacle.cmg c on c.cust_id = d.cust_id
where d.cust_id is not null
and ( d.tran_particular like 'POS%')
group by c.cif_id, g.foracid, d.tran_date, g.acct_crncy_code
order by c.cif_id;
   
-----------------------------------------------------------------------------------------------
with txn_by_channel as (
select
	c.id
	, c.name
	, t.currency
	, sum(dr_amount) as dr_amount
	, sum(cr_amount) as cr_amount
	, sum(txn_count) as txn_count
from core_txn_by_channel t
inner join core_channel c on c.id = t.channel
group by c.id, c.name, t.currency
order by c.name
)
select * 
from txn_by_channel


-----------------------------------------------------------------------------

with txn_by_channel as (
select
	c.id
	, c.name
	, t.currency
	, sum(dr_amount) as dr_amount
	, sum(cr_amount) as cr_amount
	, sum(txn_count) as txn_count
from core_txn_by_channel t
inner join core_channel c on c.id = t.channel
where t.customer = 'C001105636'
group by c.id, c.name, t.currency
order by c.name
)
select * 
from txn_by_channel


-----------------------------------------------------------------------------------
select 
	'SYSTEM' as txn_type
	, count(1) as txn_count
from finacle.dtd
where left(trim(tran_id),1) = 'S' and entry_user_id in ('CDCI')

union all
select 
	'MANUAL' as txn_type
	, count(1) as txn_count
from finacle.dtd
where left(trim(tran_id),1) = 'M' 
 	
 	
 	