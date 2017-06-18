package com.adc.dao.impl;

import java.util.List;

import org.springframework.jdbc.core.support.JdbcDaoSupport;

import com.adc.dao.IBaseDao;
/**
 * 源数据访问类
 * @author Victor_Zhou
 *
 */
public class BaseDaoImpl extends JdbcDaoSupport implements IBaseDao{

	/**
	 * 查找一条记录
	 */
	public String find(String sql) {
		String result = this.getJdbcTemplate().queryForObject(sql, java.lang.String.class);
		return result;
	}

	/**
	 * 查找多条记录
	 */
	@SuppressWarnings({"rawtypes" })
	public List findList(String sql) {
		List result = this.getJdbcTemplate().queryForList(sql);
		return result;
	}
 
}
