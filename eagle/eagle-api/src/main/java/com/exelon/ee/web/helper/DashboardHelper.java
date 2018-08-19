/**
 * 
 */
package com.exelon.ee.web.helper;

import javax.inject.Named;


/**
 * @author ukaegbu
 *
 */
//@Named("dashboardHelper")
public class DashboardHelper {
	private static StringBuilder SUMMARY_BY_REQUEST = null;
	private static StringBuilder SUMMARY_BY_CODE = null;
	

	/**
	 * 
	 */
	public DashboardHelper() {
	}

	public static StringBuilder getSummaryByRequest(){
		if(null == SUMMARY_BY_REQUEST){
			StringBuilder b = new StringBuilder();
			
			b.append(" select *  ");
			b.append(" from (  ");
			b.append(" select count(1) as total  ");
			b.append(" ,sum(case when code = '00' then 1 else 0 end ) as total_success  ");
			b.append(" ,sum(case when code != '00' then 1 else 0 end ) as total_failure  ");
			b.append(" , resp_date  ");
			b.append(" , 'FT' as request_type  ");
			b.append(" from re_transfer_request  ");
			b.append(" group by resp_date  ");
			b.append(" union all  ");
			b.append(" select count(1) as total  ");
			b.append(" ,sum(case when code = '00' then 1 else 0 end ) as total_success  ");
			b.append(" ,sum(case when code != '00' then 1 else 0 end ) as total_failure  ");
			b.append(" , resp_date  ");
			b.append(" , 'BI' as request_type  ");
			b.append(" from re_balance_request  ");
			b.append(" group by resp_date  ");
			b.append(" union all  ");
			b.append(" select count(1) as total  ");
			b.append(" ,sum(case when code = '00' then 1 else 0 end ) as total_success  ");
			b.append(" ,sum(case when code != '00' then 1 else 0 end ) as total_failure  ");
			b.append(" , resp_date  ");
			b.append(" , 'TS' as request_type  ");
			b.append(" from re_status_request  ");
			b.append(" group by resp_date  ");
			b.append(" union all  ");
			b.append(" select count(1) as total  ");
			b.append(" ,sum(case when code = '00' then 1 else 0 end ) as total_success  ");
			b.append(" ,sum(case when code != '00' then 1 else 0 end ) as total_failure  ");
			b.append(" , resp_date  ");
			b.append(" , 'AS' as request_type  ");
			b.append(" from re_stmt_request  ");
			b.append(" group by resp_date  ");
			b.append(" ) as b  ");
			b.append(" where b.resp_date = :date   ");
			
			SUMMARY_BY_REQUEST = b;
			
		}
		
		return SUMMARY_BY_REQUEST;
	}
	
	
	public static StringBuilder getSummaryByCode(){
		if(null == SUMMARY_BY_CODE){
			StringBuilder b = new StringBuilder();
			
			b.append(" select sum(d.num_items) as total  ");
			b.append(" , d.code, d.description, d.resp_date  ");
			b.append(" from (  ");
			b.append(" select count(p.*) as num_items  ");
			b.append(" , p.code, s.description, p.resp_date  ");
			b.append(" from re_transfer_request p  ");
			b.append(" inner join re_ws_response s on p.code = s.code  ");
			b.append(" where p.resp_date = :date  ");
			b.append(" group by p.code, s.description, p.resp_date  ");
			b.append(" union all  ");
			b.append(" select count(p.*) as num_items  ");
			b.append(" , p.code, s.description, p.resp_date  ");
			b.append(" from re_balance_request p  ");
			b.append(" inner join re_ws_response s on p.code = s.code  ");
			b.append(" where p.resp_date = :date  ");
			b.append(" group by p.code, s.description, p.resp_date  ");
			b.append(" union all  ");
			b.append(" select count(p.*) as num_items  ");
			b.append(" , p.code, s.description, p.resp_date  ");
			b.append(" from re_status_request p  ");
			b.append(" inner join re_ws_response s on p.code = s.code  ");
			b.append(" where p.resp_date = :date  ");
			b.append(" group by p.code, s.description, p.resp_date  ");
			b.append(" union all  ");
			b.append(" select count(p.*) as num_items  ");
			b.append(" , p.code, s.description, p.resp_date  ");
			b.append(" from re_stmt_request p  ");
			b.append(" inner join re_ws_response s on p.code = s.code  ");
			b.append(" where p.resp_date = :date  ");
			b.append(" group by p.code, s.description, p.resp_date  ");
			b.append(" ) d  ");
			b.append(" group by d.code, d.description, d.resp_date  ");
			b.append(" order by d.code  ");

			
			SUMMARY_BY_CODE = b;
			
		}
		
		return SUMMARY_BY_CODE;
	}
}
