package dataassemble;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.bson.BsonArray;
import org.bson.BsonDocument;
import org.bson.BsonDouble;
import org.bson.BsonInt32;
import org.bson.BsonString;

import net.spy.memcached.MemcachedClient;
import util.Calculator;
import util.Sort;
/**
 * 数据组装类
 * @author Victor_Zhou
 *
 */
class DataAssemble {
	private String resultDataId;
	private String type;
	private int dataAssembleIntervalInSeconds;
	private MemcachedClient memcachedClient;
	private List<String> sourceDataIds;
	private BsonDocument ruleDocument;

	public String getResultDataId() {
		return resultDataId;
	}

	public int getDataAssembleIntervalInSeconds() {
		return dataAssembleIntervalInSeconds;
	}

	/**
	 * 构造函数
	 * @param resultDataId
	 * @param type
	 * @param dataAssembleIntervalInSeconds
	 * @param memcachedClient
	 * @param sourceDataIds
	 * @param ruleDocument
	 */
	public DataAssemble(String resultDataId, String type, int dataAssembleIntervalInSeconds,
			MemcachedClient memcachedClient, List<String> sourceDataIds, BsonDocument ruleDocument) {
		this.resultDataId = resultDataId;
		this.type = type;
		this.dataAssembleIntervalInSeconds = dataAssembleIntervalInSeconds;
		this.memcachedClient = memcachedClient;
		this.sourceDataIds = sourceDataIds;
		this.ruleDocument = ruleDocument;
	}

	/**
	 * 后台线程
	 */
	public void run() {
		// if(ruleDocument == null){
		// System.out.println("no rule");
		// memcachedClient.set(resultDataId, 0, result.toString());
		// return;
		// }
		if (ruleDocument.isEmpty()) {
			StringBuilder result = new StringBuilder();
			for (String sourceDataId : sourceDataIds) {
				Object object = memcachedClient.get(sourceDataId);
				String data = (String) object;
				result.append(data);
			}
			BsonDocument goalData = BsonDocument.parse(result.toString());
			goalData.replace("name", new BsonString(resultDataId));
			System.out.println(goalData.toJson());
			memcachedClient.set(resultDataId, 0, goalData.toJson());
			return;
		}
		//System.out.println(resultDataId + ruleDocument.toJson());
		switch (ruleDocument.getString("ruleName").getValue()) {
		case "sort": {
			List<BsonDocument> sortSourceDataList = new ArrayList<>();
			for (String sourceDataId : sourceDataIds) {
				Object object = memcachedClient.get(sourceDataId);
				BsonDocument sourceDataObject = BsonDocument.parse((String) object);
				if ("single".equals(sourceDataObject.getString("type").getValue()) && sourceDataObject.containsKey("content")) {
					BsonDocument sourceData = sourceDataObject.getDocument("content");
					if(sourceData.containsKey(ruleDocument.getString("key").getValue())){
						sortSourceDataList.add(sourceData);
					}
				}
			}
			//System.out.println(sortSourceDataList.toString());
			Collections.sort(sortSourceDataList,
					new Sort(ruleDocument.getString("key").getValue(), ruleDocument.getString("order").getValue()));

			BsonArray sourceDataArray = new BsonArray();
			sourceDataArray.addAll(sortSourceDataList);
			
			BsonDocument sortResultData = new BsonDocument();

			sortResultData.append("name", new BsonString(resultDataId));
			sortResultData.append("type", new BsonString(type));
			sortResultData.append("frequency", new BsonInt32(dataAssembleIntervalInSeconds));
			sortResultData.append("content", sourceDataArray);

			System.out.println(sortResultData.toJson());
			memcachedClient.set(resultDataId, 0, sortResultData.toJson());
			return;
		}
		case "exp": {
			String expression = ruleDocument.getString("expression").getValue();
			String[] expressionArray = expression.split(" ");
			String key = ruleDocument.getString("key").getValue();
			for (String sourceDataId : sourceDataIds) {
				Object object = memcachedClient.get(sourceDataId);
				
				String value = "";
				BsonDocument sourceDataObject = BsonDocument.parse((String) object);
				
				if (sourceDataObject.containsKey("content")) {
					BsonDocument sourceDataContent = sourceDataObject.getDocument("content");
					
					if(sourceDataContent.containsKey(key)){
						if (sourceDataContent.get(key).isInt32()) {
							value = String.valueOf(sourceDataContent.getInt32(key).getValue());
						} else if (sourceDataContent.get(key).isDouble()) {
							value = String.valueOf(sourceDataContent.getInt32(key).getValue());
						}
					}
				}
				for(int i = 0; i < expressionArray.length; i++){
					if(expressionArray[i].equals(sourceDataId)){
						expressionArray[i] = value;
					}
				}		
			}
			expression = "";
			for(int i = 0; i < expressionArray.length; i++){
				expression += expressionArray[i];
			}
			BsonDocument expResultData = new BsonDocument();
			Calculator calculator = new Calculator();
			try {
				//System.out.println(expression);
				double result = calculator.calculate(expression);
				//System.out.println(result);
				expResultData.append("name", new BsonString(resultDataId));
				expResultData.append("type", new BsonString(type));
				expResultData.append("frequency", new BsonInt32(dataAssembleIntervalInSeconds));
				expResultData.append("content", new BsonDocument().append("result", new BsonDouble(result)));
				System.out.println(expResultData.toJson());
				memcachedClient.set(resultDataId, 0, expResultData.toJson());
				return;
			} catch (Exception e) {
				// TODO: handle exception
				if (e instanceof java.lang.ArithmeticException) {
					System.out.println("/ by zero");

					expResultData.append("name", new BsonString(resultDataId));
					expResultData.append("type", new BsonString(type));
					expResultData.append("frequency", new BsonInt32(dataAssembleIntervalInSeconds));
					expResultData.append("content", new BsonDocument().append("result",new BsonString("/ by zero")));
					System.out.println(expResultData.toJson());
					memcachedClient.set(resultDataId, 0, expResultData.toJson());
					return;
				} else if (e instanceof java.util.EmptyStackException) {
					System.out.println("表达式不完整");

					expResultData.append("name", new BsonString(resultDataId));
					expResultData.append("type", new BsonString(type));
					expResultData.append("frequency", new BsonInt32(dataAssembleIntervalInSeconds));
					expResultData.append("content", new BsonDocument().append("result",new BsonString("表达式不完整")));
					System.out.println(expResultData.toJson());
					memcachedClient.set(resultDataId, 0, expResultData.toJson());
					return;
				} else if (e instanceof java.lang.NumberFormatException) {
					System.out.println("表达式中包含非数字部分");

					expResultData.append("name", new BsonString(resultDataId));
					expResultData.append("type", new BsonString(type));
					expResultData.append("frequency", new BsonInt32(dataAssembleIntervalInSeconds));
					expResultData.append("content", new BsonDocument().append("result",new BsonString("表达式中包含非数字部分")));
					System.out.println(expResultData.toJson());
					memcachedClient.set(resultDataId, 0, expResultData.toJson());
					return;
				}
			}
		}
		}

		// System.out.println(result.toString());
		// memcachedClient.set(resultDataId, 0);
	}
}