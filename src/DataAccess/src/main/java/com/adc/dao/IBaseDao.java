package com.adc.dao;

import java.util.List;
/**
 * 源数据访问接口
 * @author Victor_Zhou
 *
 */
public interface IBaseDao {
	public String find(String sql);
	@SuppressWarnings("rawtypes")
	public List findList(String sql);
}