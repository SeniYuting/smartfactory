package dataassemble;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;

import net.spy.memcached.MemcachedClient;

import org.bson.BsonDocument;

import java.net.InetSocketAddress;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * 程序入口类
 * @author Victor_Zhou
 *
 */
public class Main {
    // in minutes
    private static final int CONFIG_FETCH_INTERVAL_IN_MINUTES = 5;

    private static final int DATA_ACCESS_THREAD_NUMBER = 32;
    private static final int DATA_ASSEMBLE_THREAD_NUMBER = 32;

    private static final String MONGODB_IP = "139.224.57.175";
    private static final int MONGODB_PORT = 12666;
    private static final String MONGODB_CONFIG_DB = "DataConfig";
    private static final String MONGODB_GOAL_DATA_COLLECTION = "goalData";

    private static DataAccessService dataAccessService =
            new DataAccessService(DATA_ACCESS_THREAD_NUMBER);
    private static DataAssembleService dataAssembleService =
            new DataAssembleService(DATA_ASSEMBLE_THREAD_NUMBER);

    private static MongoClient mongoClient = new MongoClient(MONGODB_IP, MONGODB_PORT);
    private static MongoDatabase mongoDatabase = mongoClient.getDatabase(MONGODB_CONFIG_DB);
    private static MongoCollection<BsonDocument> mongoCollection = 
    		mongoDatabase.getCollection(
    				MONGODB_GOAL_DATA_COLLECTION,
    				BsonDocument.class
    				);
    
    private static final String MEMCACHED_IP = "127.0.0.1";
    private static int MEMCACHED_PORT = 12333;//zhc
    private static MemcachedClient memcachedClient;
    		

    /**
     * 配置获取
     */
    private static void configFetch() {
    	MongoCursor<BsonDocument> mongoCursor =
    			mongoCollection.find().iterator();
    	
    	try {
    		while (mongoCursor.hasNext()) {
    			Task task = Task.fromDocument(
    					mongoCursor.next(), 
    					memcachedClient
    					);
    			dataAccessService.appendTask(task.dataAccess);
    			dataAssembleService.appendTask(task.dataAssemble);
    		}
    	} finally {
    		mongoCursor.close();
    	}
    }

    /**
     * 程序入口
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
    	memcachedClient = new MemcachedClient(new InetSocketAddress(MEMCACHED_IP, MEMCACHED_PORT));
        ScheduledExecutorService scheduledExecutorService =
                Executors.newSingleThreadScheduledExecutor();
        scheduledExecutorService.scheduleAtFixedRate(Main::configFetch, 0,
                CONFIG_FETCH_INTERVAL_IN_MINUTES, TimeUnit.MINUTES);
    }
}
