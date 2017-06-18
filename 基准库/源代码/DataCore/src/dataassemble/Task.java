package dataassemble;

import net.spy.memcached.MemcachedClient;

import org.bson.BsonDocument;

import java.util.ArrayList;
import java.util.List;

/**
 * 配置解析类
 * @author Victor_Zhou
 *
 */
public class Task {
	public List<DataAccess> dataAccess;
	public DataAssemble dataAssemble;

	public Task() {
		dataAccess = new ArrayList<DataAccess>();
	}

	/**
	 * 解析配置数据信息
	 * @param document
	 * @param memcachedClient
	 * @return
	 */
	public static Task fromDocument(BsonDocument document, MemcachedClient memcachedClient) {
		// System.out.println(document.toJson());
		Task task = new Task();

		// System.out.println("aaaa");
		int frequency = document.getInt32("frequency").getValue();
		String resultDataName = document.getString("name").getValue();
		String type = document.getString("type").getValue();
		// System.out.println(frequency);
		// System.out.println(resultDataName);

		List<String> sourceDataIds = new ArrayList<>();
		// System.out.println(document.getArray("dataSourceList").toString());
		for (Object source : document.getArray("dataSourceList")) {
			// System.out.println(source.toString());
			BsonDocument sourceDocument = BsonDocument.parse(source.toString());
			// System.out.println(sourceDocument.toJson());
			String sourceDataName = sourceDocument.getString("name").getValue();
			// System.out.println(sourceDataName);
			sourceDataIds.add(sourceDataName);
			DataAccess DataAccess = new DataAccess(sourceDataName, frequency, memcachedClient);
			task.dataAccess.add(DataAccess);
			// System.out.println("next source");
		}

		BsonDocument ruleDocument = null;
		if (document.containsKey("rule")) {
			ruleDocument = document.getDocument("rule");
		}
		task.dataAssemble = new DataAssemble(resultDataName, type, frequency, memcachedClient, sourceDataIds,
				ruleDocument);

		// System.out.println("return");
		return task;
	}
}
