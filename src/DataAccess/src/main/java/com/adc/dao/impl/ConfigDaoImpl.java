package com.adc.dao.impl;

import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.adc.bean.ConfigBean;
import com.adc.dao.IConfigDao;
/**
 * 配置数据访问类
 * @author Victor_Zhou
 *
 */
@Repository
public class ConfigDaoImpl implements IConfigDao {
	@Resource
	private MongoTemplate mongoTemplate;

	/**
	 * 配置数据访问
	 */
	public ConfigBean find(String name) {
		Query query = new Query();
		query.addCriteria(new Criteria("name").is(name));
		return this.mongoTemplate.findOne(query, ConfigBean.class);
		//ConfigBean configBean = mongoOperation.findOne(query, ConfigBean.class);
		//System.out.println("find : " + configBean.getSource());
		//return configBean;
	}

	public void test() {
		System.out.println("11111111");
		Set<String> colls = this.mongoTemplate.getCollectionNames();
		for (String coll : colls) {
			System.out.println("CollectionName=" + coll);
		}
	}
}
