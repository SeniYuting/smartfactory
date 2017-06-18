package com.adc.bean;
/**
 * 配置数据类
 */
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "sourceData")
public class ConfigBean {
//	@Id
//	private double id;
//	private String configId;
//	private String source;
//	private String sql;
//	
//	public double getId() {
//		return id;
//	}
//	public void setId(double id) {
//		this.id = id;
//	}
//	public String getConfigId() {
//		return configId;
//	}
//	public void setConfigId(String configId) {
//		this.configId = configId;
//	}
//	public String getSource() {
//		return source;
//	}
//	public void setSource(String source) {
//		this.source = source;
//	}
//	public String getSql() {
//		return sql;
//	}
//	public void setSql(String sql) {
//		this.sql = sql;
//	}
	
	@Id
	private String id;
	private String name;
	private String type;
	private String tupleNum;
	private String frequency;
	private String source;
	private String SQL;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getTupleNum() {
		return tupleNum;
	}
	public void setTupleNum(String tupleNum) {
		this.tupleNum = tupleNum;
	}
	public String getFrequency() {
		return frequency;
	}
	public void setFrequency(String frequency) {
		this.frequency = frequency;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public String getSQL() {
		return SQL;
	}
	public void setSQL(String sQL) {
		SQL = sQL;
	}
}
