package com.adc.test;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.adc.service.IBaseService;
import com.adc.service.impl.BaseServiceImpl;
import com.adc.utils.DataSourceContextHolder;
import com.alibaba.fastjson.JSON;

@RunWith(SpringJUnit4ClassRunner.class) // 表示继承了SpringJUnit4ClassRunner类
@ContextConfiguration(locations = { "classpath:spring-mybatis.xml" })

public class TestMaven {
	@Resource(name = "baseService")
	private IBaseService baseService = null;

	@Test
	public void test1() {
//		DataSourceContextHolder.setDataSource("dataSourceA");
//		String sql = "SELECT material as name,count(*) as value FROM `order` GROUP BY `material` ORDER BY value DESC LIMIT 3";
//		// String str = baseService.find(sql);
//		List str = baseService.findList(sql);
//		System.out.println(JSON.toJSONString(str));
	}

	@Test
	public void test2() {
//		DataSourceContextHolder.setDataSource("dataSourceA");
//		String sql = "SELECT count(*) FROM `order` WHERE to_days(date) = to_days(now()) AND is_schedule = 1";
//		String str = baseService.find(sql);
//		// List str = baseService.findList(sql);
//		System.out.println(JSON.toJSONString(str));
	}

	@Test
	public void test3() {
//		DataSourceContextHolder.setDataSource("dataSourceA");
//		String sql = "SELECT count(*) FROM `order` WHERE `state` = 'urgent'";
//		String str = baseService.find(sql);
//		// List str = baseService.findList(sql);
//		System.out.println(JSON.toJSONString(str));
	}

	@Test
	public void test4() {
//		DataSourceContextHolder.setDataSource("dataSourceA");
//		String sql = "SELECT count(*) FROM `order` WHERE `state` = 'urgent'";
//		// String str = baseService.find(sql);
//		List str = baseService.findList(sql);
//		System.out.println(JSON.toJSONString(str));
	}

	@Test
	public void test5() {
//		DataSourceContextHolder.setDataSource("dataSourceA");
//		String[] sqls = new String[4];
//		sqls[0] = "SELECT material as name,count(*) as value FROM `order` GROUP BY `material` ORDER BY value DESC LIMIT 3";
//		sqls[1] = "SELECT count(*) FROM `order` WHERE to_days(date) = to_days(now()) AND is_schedule = 1";
//		sqls[2] = "SELECT count(*) FROM `order` WHERE `state` = 'urgent'";
//		sqls[3] = "SELECT count(*) FROM `order` WHERE `state` = 'urgent'";
//		
//		for(int i = 0; i < 1000; i++){
//			List str = baseService.findList(sqls[i%4]);
//			System.out.println(JSON.toJSONString(str));
//		}
	}
}
