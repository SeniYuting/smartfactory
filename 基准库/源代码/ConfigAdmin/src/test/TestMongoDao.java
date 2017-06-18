package test;

import static org.junit.Assert.*;

import java.util.ArrayList;

import model.GoalData;
import model.SourceData;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import dao.MongoDao;

public class TestMongoDao {
	
	public int sourceListSize;
	public int goalListSize;
	

	@Before
	public void setUp() throws Exception {
		sourceListSize = MongoDao.getInstance().getAllSource().size();
		goalListSize = MongoDao.getInstance().getAllGoal().size();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGetAllSource() {
		ArrayList<SourceData> dataList = MongoDao.getInstance().getAllSource();
		assertTrue(dataList.size()>0);
	}
	
	@Test
	public void testGetAllDataList() {
		ArrayList<GoalData> dataList = MongoDao.getInstance().getAllGoal();
		assertTrue(dataList.size()>0);
	}
	
	/**
	@Test
	public void testAddSourceDocument() {
		SourceData data = new SourceData();
		data.setName("test");
		data.setType("single");
		data.setTupleNum("2");
		data.setFrequency("1m");
		data.setSource("dataSourceA");
		data.setSql("SELECT sum(price) FROM `order` WHERE to_days(date) = to_days(now())");
		MongoDao.getInstance().addSourceDocument(data);
		
		ArrayList<SourceData> dataList = MongoDao.getInstance().getAllSource();
		assertTrue(dataList.size() == sourceListSize+1);
	}
	*/
	
	/**
	@Test
	public void testUpdateSourceDocument() {
		SourceData data = new SourceData();
		data.set_id("586e2afeebf1c729fc2e70ac");
		data.setType("single");
		data.setTupleNum("2");
		data.setFrequency("1m");
		data.setSource("dataSourceB");
		data.setSql("SELECT sum(price) FROM `order` WHERE to_days(date) = to_days(now())");
		MongoDao.getInstance().updateSourceDocument(data);
	}
	*/
	
	/**
	@Test
	public void testDeleteSourceDocument() {
		MongoDao.getInstance().deleteSourceDocument("586e2afeebf1c729fc2e70ac");
	}
	*/
	
	/**
	@Test
	public void testAddGoalDocument() {
		GoalData data = new GoalData();
		data.setName("test");
		data.setType("list");
		data.setTupleNum(2);
		data.setFrequency(60);		
		data.setRule("{}");
		data.setDataSourceList("[{\"name\":\"s_resource_middleware\",\"frequency\":60}]");
		MongoDao.getInstance().addGoalDocument(data);
		
		ArrayList<GoalData> dataList = MongoDao.getInstance().getAllGoal();
		assertTrue(dataList.size() == goalListSize+1);
	}
	*/
	
	/**
	@Test
	public void testUpdateGoalDocument() {
		GoalData data = new GoalData();
		data.set_id("586e2e3debf1c726e0d2d6e4");
		data.setName("test");
		data.setType("list");
		data.setTupleNum(2);
		data.setFrequency(30);		
		data.setRule("{}");
		data.setDataSourceList("[{\"name\":\"s_resource_middleware\",\"frequency\":60}]");
		MongoDao.getInstance().updateGoalDocument(data);
	}
	*/
	
	/**
	@Test
	public void testDeleteGoalDocument() {
		MongoDao.getInstance().deleteGoalDocument("586e2e3debf1c726e0d2d6e4");
	}
	*/

}
