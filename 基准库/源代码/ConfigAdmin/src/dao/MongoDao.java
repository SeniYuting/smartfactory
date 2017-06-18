package dao;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Properties;

import org.bson.Document;
import org.bson.types.ObjectId;

import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;

import model.GoalData;
import model.SourceData;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * 与MongoDB数据库交互的Dao
 */
public class MongoDao {

	private MongoDao() {
	}

	private static MongoDao mongo = new MongoDao();

	public static MongoDao getInstance() {
		return mongo;
	}

	private MongoClient mongoClient = null;
	private MongoDatabase mongoDatabase = null;

	/**
     * 数据库连接
     * 
     * @param
     * @return
     */
	private void connect() {
		try {
			// 从文件中读取数据库url和端口号
			ClassLoader loader = MongoDao.class.getClassLoader();
			InputStream is = (InputStream) loader.getResourceAsStream("db.properties");
			Properties properties = new Properties();
			properties.load(is);
			String url = properties.getProperty("url");
			Integer port = Integer.parseInt(properties.getProperty("port"));

			// 连接到 mongodb 服务
			mongoClient = new MongoClient(url, port);
			// 连接到数据库
			mongoDatabase = mongoClient.getDatabase("DataConfig");
		} catch (Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
		}
	}

	/**
     * 获取所有源数据
     * 
     * @param
     * @return sourceDataList 源数据列表
     */
	public ArrayList<SourceData> getAllSource() {
		connect();
		MongoCollection<Document> collection = mongoDatabase.getCollection("sourceData");

		FindIterable<Document> findIterable = collection.find();
		MongoCursor<Document> mongoCursor = findIterable.iterator();

		ArrayList<SourceData> sourceDataList = new ArrayList<SourceData>();
		while (mongoCursor.hasNext()) {
			Document document = mongoCursor.next();
			SourceData data = new SourceData();
			data.set_id(document.getObjectId("_id").toString());
			data.setName(document.getString("name"));
			data.setFrequency(document.getString("frequency"));
			data.setSource(document.getString("source"));
			data.setSql(document.getString("SQL"));
			data.setTupleNum(document.getString("tupleNum"));
			data.setType(document.getString("type"));
			sourceDataList.add(data);
		}
		mongoClient.close();
		return sourceDataList;
	}

	/**
     * 获取所有目标数据
     * 
     * @param
     * @return goalDataList 目标数据列表
     */
	@SuppressWarnings("unchecked")
	public ArrayList<GoalData> getAllGoal() {
		connect();
		MongoCollection<Document> collection = mongoDatabase.getCollection("goalData");

		FindIterable<Document> findIterable = collection.find();
		MongoCursor<Document> mongoCursor = findIterable.iterator();

		ArrayList<GoalData> goalDataList = new ArrayList<GoalData>();
		while (mongoCursor.hasNext()) {
			Document document = mongoCursor.next();
			GoalData data = new GoalData();
			data.set_id(document.getObjectId("_id").toString());
			data.setName(document.getString("name"));
			data.setType(document.getString("type"));
			data.setTupleNum(document.getInteger("tupleNum"));
			data.setFrequency(document.getInteger("frequency"));

			Document rule = (Document) document.get("rule");
			if (rule.isEmpty()) {
				data.setRule("{}");
			} else {
				JSONObject jsonObject = new JSONObject();
				jsonObject.put("ruleName", rule.getString("ruleName"));
				jsonObject.put("key", rule.getString("key"));
				if (rule.getString("ruleName").equals("exp")) {
					jsonObject.put("expression", rule.getString("expression"));
				} else {
					jsonObject.put("order", rule.getString("order"));
				}
				data.setRule(jsonObject.toString());
			}

			ArrayList<Document> dataSource = (ArrayList<Document>) document.get("dataSourceList");
			JSONArray dataSourceList = new JSONArray();
			for (int i = 0; i < dataSource.size(); i++) {
				JSONObject jsonObject = new JSONObject();
				jsonObject.put("name", dataSource.get(i).getString("name"));
				jsonObject.put("frequency", dataSource.get(i).getInteger("frequency"));
				dataSourceList.add(jsonObject);
			}
			data.setDataSourceList(dataSourceList.toString());
			goalDataList.add(data);
		}
		mongoClient.close();
		return goalDataList;
	}

	/**
     * 增加源数据
     * 
     * @param data 源数据
     * @return
     */
	public void addSourceDocument(SourceData data) {
		connect();
		MongoCollection<Document> collection = mongoDatabase.getCollection("sourceData");
		Document document = new Document("name", data.getName()).append("type", data.getType())
				.append("tupleNum", data.getTupleNum()).append("frequency", data.getFrequency())
				.append("source", data.getSource()).append("SQL", data.getSql());
		collection.insertOne(document);
		mongoClient.close();
	}

	/**
     * 增加目标数据
     * 
     * @param data 目标数据
     * @return
     */
	public void addGoalDocument(GoalData data) {
		connect();
		MongoCollection<Document> collection = mongoDatabase.getCollection("goalData");
		Document document = new Document("name", data.getName()).append("type", data.getType())
				.append("tupleNum", data.getTupleNum()).append("frequency", data.getFrequency())
				.append("rule", JSONObject.fromObject(data.getRule()))
				.append("dataSourceList", JSONArray.fromObject(data.getDataSourceList()));
		collection.insertOne(document);
		mongoClient.close();
	}

	/**
     * 删除源数据
     * 
     * @param id 源数据id
     * @return
     */
	public void deleteSourceDocument(String id) {
		connect();
		MongoCollection<Document> collection = mongoDatabase.getCollection("sourceData");
		Document document = new Document();
		document.put("_id", new ObjectId(id));
		collection.deleteOne(document);
		mongoClient.close();
	}

	/**
     * 删除目标数据
     * 
     * @param id 目标数据id
     * @return
     */
	public void deleteGoalDocument(String id) {
		connect();
		MongoCollection<Document> collection = mongoDatabase.getCollection("goalData");
		Document document = new Document();
		document.put("_id", new ObjectId(id));
		collection.deleteOne(document);
		mongoClient.close();
	}
	
	/**
     * 更新源数据
     * 
     * @param data 源数据
     * @return
     */
	public void updateSourceDocument(SourceData data) {
		connect();
		MongoCollection<Document> collection = mongoDatabase.getCollection("sourceData");
		Document newDocument = new Document("name", data.getName()).append("type", data.getType())
				.append("tupleNum", data.getTupleNum()).append("frequency", data.getFrequency())
				.append("source", data.getSource()).append("SQL", data.getSql());
		collection.updateOne(Filters.eq("_id", new ObjectId(data.get_id())), new Document("$set", newDocument));
		mongoClient.close();
	}

	/**
     * 更新目标数据
     * 
     * @param data 目标数据
     * @return
     */
	public void updateGoalDocument(GoalData data) {
		connect();
		MongoCollection<Document> collection = mongoDatabase.getCollection("goalData");
		Document newDocument = new Document("name", data.getName()).append("type", data.getType())
				.append("tupleNum", data.getTupleNum()).append("frequency", data.getFrequency())
				.append("rule", JSONObject.fromObject(data.getRule()))
				.append("dataSourceList", JSONArray.fromObject(data.getDataSourceList()));
		collection.updateOne(Filters.eq("_id", new ObjectId(data.get_id())), new Document("$set", newDocument));
		mongoClient.close();
	}

}
