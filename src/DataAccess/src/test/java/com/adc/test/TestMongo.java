package com.adc.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.adc.bean.BaseBean;
import com.adc.bean.ConfigBean;
import com.adc.dao.IConfigDao;
import com.adc.dao.impl.ConfigDaoImpl;
import com.adc.service.IBaseService;
import com.adc.utils.DataSourceContextHolder;
import com.alibaba.fastjson.JSON;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.Mongo;

@RunWith(SpringJUnit4ClassRunner.class)
// 表示继承了SpringJUnit4ClassRunner类
@ContextConfiguration(locations = { "classpath:spring-mybatis.xml" })
public class TestMongo {

	// @Resource
	// private IConfigDao configDao;
	// @Resource(name = "baseService")
	// private IBaseService baseService = null;
	//
	// @Test
	// public void testMongodb() {
	// try {
	// //BaseBean baseBean = new BaseBean();
	// ConfigBean configBean = (ConfigBean) configDao.find("source_A");
	// System.out.println(JSON.toJSONString(configBean));
	// //configDao.test();
	// System.out.println("----------");
	// } catch (Exception e) {
	// e.printStackTrace();
	// }
	// }

	String[] strs = new String[]{"source_A", "source_B"};
	
	public void get(String id) {
		URL url;
		BufferedReader bin = null;
		StringBuilder result = new StringBuilder();
		try {
			String urlTemp = "http://139.224.57.175:8080/mavenWebTest/get/" + id;
			url = new URL(urlTemp);
			InputStream in = url.openStream(); // 请求
			bin = new BufferedReader(new InputStreamReader(in, "UTF-8"));
			String s = null;
			while ((s = bin.readLine()) != null) {
				result.append(s);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (null != bin) {
				try {
					bin.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		System.out.println(result.toString());
		return;
	}

	@Test
	public void test2() {
		for (int i = 0; i < 10; i++) {
			String str = strs[(i % 2)];
			new Thread(new ThreadTest(str)).start();
		}
	}

	class ThreadTest implements Runnable {
		private String id;

		public ThreadTest(String id) {
			this.id = id;
		}

		public void run() {
			get(id);
		}
	}

}
