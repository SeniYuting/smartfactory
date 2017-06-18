package com.adc.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.test.context.ContextConfiguration;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.adc.bean.BaseBean;
import com.adc.bean.ConfigBean;
import com.adc.dao.IConfigDao;
import com.adc.service.IBaseService;
import com.adc.utils.DataSourceContextHolder;
import com.alibaba.fastjson.JSON;

//@ContextConfiguration(locations = {"classpath:spring-mybatis.xml"})
/**
 * 控制器类
 * @author Victor_Zhou
 *
 */
@RestController
public class BaseController {
	@Resource(name="baseService")
	private IBaseService baseService = null;
	@Resource
	private IConfigDao configDao;
	
	/**
	 * http请求获取函数
	 * @param name
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	@RequestMapping("get/{name}")
	public BaseBean get(@PathVariable String name) {
		BaseBean baseBean = new BaseBean();
		
		ConfigBean configBean = configDao.find(name);
		String source = configBean.getSource();
		String sql = configBean.getSQL();
		String type = configBean.getType();
		String tupleNum = configBean.getTupleNum();
		String frequency = configBean.getFrequency();
		int tNum = Integer.parseInt(tupleNum);
		
		DataSourceContextHolder.setDataSource(source);
		
		Object result = null;
		if("single".equals(type)){
			try{
				result = (List)baseService.findList(sql);
				result = ((List)result).get(0);
			}catch(Exception e){
				result = "config error";
			}
		} else {
			try{
				result = (List)baseService.findList(sql);
			}catch(Exception e){
				result = "config error";
			}
		}
		
		baseBean.setName(name);
		baseBean.setContent(result);
		baseBean.setType(type);
		baseBean.setTupleNum(tupleNum);
		baseBean.setFrequency(frequency);
		System.out.println(JSON.toJSONString(baseBean));
		return baseBean;
	}
	
//	@SuppressWarnings("rawtypes")
//	@RequestMapping("getList/{name}")
//	public BaseBean getList(@PathVariable String name) {
//		BaseBean baseBean = new BaseBean();
//		
//		ConfigBean configBean = configDao.find(name);
//		String source = configBean.getSource();
//		String sql = configBean.getSQL();
//		String type = configBean.getType();
//		String tupleNum = configBean.getTupleNum();
//		String frequency = configBean.getFrequency();
//		
//		DataSourceContextHolder.setDataSource(source);
//		
//		List result = baseService.findList(sql);
//		
//		baseBean.setName(name);
//		baseBean.setContent(result);
//		baseBean.setType(type);
//		baseBean.setTupleNum(tupleNum);
//		baseBean.setFrequency(frequency);
//		System.out.println(JSON.toJSONString(baseBean));
//		return baseBean;
//	}
}