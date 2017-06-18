package com.adc.dao;

import com.adc.bean.ConfigBean;
/**
 * 配置数据访问接口
 * @author Victor_Zhou
 *
 */
public interface IConfigDao {
	public ConfigBean find(String name);
	public void test();
}
