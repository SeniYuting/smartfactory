import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class InsertDB {
	private static InsertDB database;
	private static Connection conn;

	public static InsertDB getInstance() throws IOException {
		if (database == null)
			database = new InsertDB();
		return database;
	}

	private void openDB1() throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		String url = "jdbc:mysql://114.55.92.31:3306/test";
		String user = "hbj_2012_writer";
		String pwd = "writer_2012_hbj";

		Class.forName("com.mysql.jdbc.Driver");
		conn = DriverManager.getConnection(url, user, pwd);
	}

	private void openDB2() throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		String url = "jdbc:mysql://114.215.197.124:3306/tjdb";
		String user = "hbj_2012_writer";
		String pwd = "writer_2012_hbj";

		Class.forName("com.mysql.jdbc.Driver");
		conn = DriverManager.getConnection(url, user, pwd);
	}

	private void insertOne(String sql) throws IOException {
		try {
			conn.setAutoCommit(false);
			java.sql.PreparedStatement pst = conn.prepareStatement("");
			pst.addBatch(sql);
			pst.executeBatch();
			conn.commit();
			pst.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args)
			throws SQLException, InstantiationException, ClassNotFoundException, IllegalAccessException, IOException {
		InsertDB db = InsertDB.getInstance();
		db.openDB1();
		for (int i = 0; i < 1000; i++) {
			db.insertOne(SqlProducer.getOrderSql());
			db.insertOne(SqlProducer.getDeviceSql());
			db.insertOne(SqlProducer.getProduceControlSql());
			db.insertOne(SqlProducer.getQualityTestSql());
		}
		db.openDB2();
		for (int i = 0; i < 1000; i++) {
			db.insertOne(SqlProducer.getCongestionSql());
			db.insertOne(SqlProducer.getStaffSql());
			db.insertOne(SqlProducer.getWorksheetSql());
			db.insertOne(SqlProducer.getPlanCompleteSql());
			db.insertOne(SqlProducer.getScheduleInfoSql());
			db.insertOne(SqlProducer.getSupplyChainSql());
		}
	}

}