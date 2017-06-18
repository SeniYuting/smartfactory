package com.adc.service;

import java.util.List;
/**
 * 源数据获取接口
 * @author Victor_Zhou
 *
 */
public interface IBaseService {
	public String find(String sql);
	@SuppressWarnings("rawtypes")
	public List findList(String sql);
}
