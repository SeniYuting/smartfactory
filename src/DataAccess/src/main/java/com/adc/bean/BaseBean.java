package com.adc.bean;
/**
 * 源数据类
 * @author Victor_Zhou
 *
 */
public class BaseBean {
	private String name;
	private String type;
	private String tupleNum;
	private String frequency;
    private Object content;
    
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
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Object getContent() {
		return content;
	}
	public void setContent(Object content) {
		this.content = content;
	}
}
