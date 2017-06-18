package dataassemble;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import net.spy.memcached.MemcachedClient;
/**
 * 数据获取类
 * @author Victor_Zhou
 *
 */
class DataAccess {
	private String dataId;
	private int dataAccessIntervalInSeconds;
	private MemcachedClient memcachedClient;

	private static final String dataAccessURL = "http://127.0.0.1:8080/DataAccess/get/";

	public int getDataAccessIntervalInSeconds() {
		return dataAccessIntervalInSeconds;
	}

	public String getDataId() {
		return dataId;
	}

	/**
	 * 构造函数
	 * @param dataId
	 * @param dataAccessIntervalInSeconds
	 * @param memcachedClient
	 */
	public DataAccess(String dataId, int dataAccessIntervalInSeconds, MemcachedClient memcachedClient) {
		this.dataId = dataId;
		this.dataAccessIntervalInSeconds = dataAccessIntervalInSeconds;
		this.memcachedClient = memcachedClient;
	}

	/**
	 * 后台线程
	 */
	public void run() {
		StringBuilder result = new StringBuilder();
		try {
			URL url = new URL(dataAccessURL + dataId);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			String line;
			while ((line = reader.readLine()) != null) {
				result.append(line);
			}
			reader.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		memcachedClient.set(dataId, 0, result.toString());
	}
}