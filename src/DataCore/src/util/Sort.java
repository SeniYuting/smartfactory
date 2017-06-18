package util;

import java.util.Comparator;

import org.bson.BsonDocument;
/**
 * 排序类
 * @author Victor_Zhou
 *
 */
public class Sort implements Comparator<BsonDocument> {
	private String key;
	private String order;

	public Sort(String key, String order) {
		this.key = key;
		this.order = order;
	}

	/**
	 * 重写compare函数
	 */
	@Override
	public int compare(BsonDocument arg0, BsonDocument arg1) {
		double first = 0;
		double second = 0;
		if (arg0.get(key).isInt32()) {
			first = arg0.getInt32(key).getValue();
		} else if (arg0.get(key).isDouble()) {
			first = arg0.getDouble(key).getValue();
		}
		if (arg1.get(key).isInt32()) {
			second = arg1.getInt32(key).getValue();
		} else if (arg1.get(key).isDouble()) {
			second = arg1.getDouble(key).getValue();
		}
		switch (order) {
		case "asc":
			return (int) (first - second);
		case "desc":
			return (int) (second - first);
		case "unorder":
			return 0;
		default:
			return 0;
		}
	}
}
