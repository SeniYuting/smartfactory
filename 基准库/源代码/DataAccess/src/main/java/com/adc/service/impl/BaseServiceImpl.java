package com.adc.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.adc.dao.IBaseDao;
import com.adc.service.IBaseService;
/**
 * 源数据获取类
 * @author Victor_Zhou
 *
 */
@Service("baseService")
public class BaseServiceImpl implements IBaseService{

	@Resource
	private IBaseDao baseDao;
	
	public String find(String sql) {
		return baseDao.find(sql);
	}

	@SuppressWarnings("rawtypes")
	public List findList(String sql) {
		return baseDao.findList(sql);
	}
	
}
