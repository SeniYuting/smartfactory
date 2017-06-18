package model;

/**
 * 源数据
 */
public class SourceData {
	private String _id;
	private String name;
	private String type;
	private String tupleNum;
	private String frequency;
	private String source;
	private String sql;

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

	public String getSql() {
		return sql;
	}

	public void setSql(String sql) {
		this.sql = sql;
	}
}
