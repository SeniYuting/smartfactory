package model;

/**
 * 目标数据
 */
public class GoalData {
	private String _id;
	private String name;
	private String type;
	private Integer tupleNum;
	private Integer frequency;
	private String rule;
	private String dataSourceList;

	public String get_id() {
		return _id;
	}

	public void set_id(String _id) {
		this._id = _id;
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

	public Integer getTupleNum() {
		return tupleNum;
	}

	public void setTupleNum(Integer tupleNum) {
		this.tupleNum = tupleNum;
	}

	public Integer getFrequency() {
		return frequency;
	}

	public void setFrequency(Integer frequency) {
		this.frequency = frequency;
	}

	public String getRule() {
		return rule;
	}

	public void setRule(String rule) {
		this.rule = rule;
	}

	public String getDataSourceList() {
		return dataSourceList;
	}

	public void setDataSourceList(String dataSourceList) {
		this.dataSourceList = dataSourceList;
	}
}
