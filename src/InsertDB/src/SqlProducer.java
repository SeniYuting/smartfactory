import java.util.Random;

public class SqlProducer {

	private static int getRandomNum(int min, int max) {
		Random random = new Random();
		int randomNum = random.nextInt(max - min + 1) + min;
		return randomNum;
	}

	/**
	 * 
	 * @param min最小值
	 * @param max最大值
	 * @param scl小数最大位数
	 * @return
	 */
	private static double getRandomDouble(int min, int max, int scl) {
		int pow = (int) Math.pow(10, scl); // 用于提取指定小数位
		double num = Math.floor((Math.random() * (max - min) + min) * pow) / pow;
		return num;
	}

	private static String getRandomDate() {
		String date = "2016-01-01";
		int year = 2016;
		int month = getRandomNum(1, 12);
		int day = getRandomNum(1, DayOfMonthHelper.getDayOfMonth(year, month));
		if (month < 10) {
			date = year + "-0" + month;
		} else {
			date = year + "-" + month;
		}
		if (day < 10) {
			date = date + "-0" + day;
		} else {
			date = date + "-" + day;
		}
		return date;
	}

	private static String getRandomName() {
		String[] firstNames = { "张", "王", "李", "周", "朱", "曹" };
		String[] lastNames = { "红", "刚", "林", "汉", "鸣", "婷", "晴", "娟", "兰", "琴", "琳", "" };
		String name = firstNames[getRandomNum(0, 5)] + lastNames[getRandomNum(0, 11)] + lastNames[getRandomNum(0, 11)];
		return name;
	}

	public static String getOrderSql() {
		String date = getRandomDate();

		int price = getRandomNum(99, 999);

		String[] areas = { "北京", "上海", "天津", "美国", "西安", "杭州" };
		String area = areas[getRandomNum(0, 5)];

		int is_schedule = getRandomNum(0, 1);
		int is_in_time = getRandomNum(0, 1);

		String[] states = { "exception", "change", "normal", "urgent" };
		String state = states[getRandomNum(0, 3)];

		String[] brands = { "only", "纽伯伦", "真维斯", "nike" };
		String brand = brands[getRandomNum(0, 3)];

		String[] materials = { "棉", "麻", "牛仔", "涤纶" };
		String material = materials[getRandomNum(0, 3)];

		String sql = "INSERT INTO `order`(date,price,area,is_schedule,is_in_time,state,brand,material) VALUES ('" + date
				+ "', " + price + ", '" + area + "', " + is_schedule + ", " + is_in_time + ", '" + state + "', '"
				+ brand + "', '" + material + "');";

		return sql;
	}

	public static String getDeviceSql() {
		String[] types = { "缝纫机", "熨烫" };
		String type = types[getRandomNum(0, 1)];

		int is_on = getRandomNum(0, 1);
		int is_normal = getRandomNum(0, 1);

		String sql = "INSERT INTO `device`(type,is_on,is_normal) VALUES ('" + type + "', " + is_on + ", " + is_normal
				+ ");";

		System.out.println(sql);

		return sql;
	}

	public static String getProduceControlSql() {
		String[] workshops = { "车间A", "车间B", "车间C", "车间D" };
		String workshop = workshops[getRandomNum(0, 3)];

		String date = getRandomDate();

		int total_num = getRandomNum(40, 60);
		int onduty = getRandomNum(0, total_num);
		int daily_output = getRandomNum(2000, 5000);

		double rework_rate = getRandomDouble(0, 1, 3);

		double average_hours = getRandomDouble(0, 24, 3);

		String sql = "INSERT INTO `produce_control`(workshop,date,total_num,onduty,daily_output,rework_rate,average_hours) VALUES "
				+ "('" + workshop + "', '" + date + "', " + total_num + ", " + onduty + ", " + daily_output + ", "
				+ rework_rate + "," + average_hours + ");";

		System.out.println(sql);

		return sql;
	}

	public static String getQualityTestSql() {
		String[] is_one_time_qualifieds = { "合格", "不合格" };
		String is_one_time_qualified = is_one_time_qualifieds[getRandomNum(0, 1)];

		String[] not_qualify_reasons = { "充绒量不合格", "纤维含量不合格", "甲醛含量超标", "色牢度不合格", "芳香胺染料超标" };

		String is_repair_qualified, not_qualify_reason;
		String sql;

		if (is_one_time_qualified.equals("合格")) {
			sql = "INSERT INTO `quality_test`(is_one_time_qualified,is_repair_qualified,not_qualify_reason) VALUES "
					+ "('" + is_one_time_qualified + "', null,null);";
		} else {
			is_repair_qualified = is_one_time_qualifieds[getRandomNum(0, 1)];
			not_qualify_reason = not_qualify_reasons[getRandomNum(0, 4)];
			sql = "INSERT INTO `quality_test`(is_one_time_qualified,is_repair_qualified,not_qualify_reason) VALUES "
					+ "('" + is_one_time_qualified + "', '" + is_repair_qualified + "','" + not_qualify_reason + "');";
		}

		System.out.println(sql);

		return sql;
	}

	public static String getCongestionSql() {
		String[] nodes = { "AVG小车", "智能吊挂", "自动裁床" };
		String node = nodes[getRandomNum(0, 2)];

		String reason = "待检查";
		String measure = "待定";
		
		String responsible_person = getRandomName();
		String recovery_time = getRandomDate() + " 16:08:56";
		int flow = getRandomNum(0, 300);

		String sql = "INSERT INTO `congestion`(node,reason,measure,responsible_person,recovery_time,flow) VALUES " + "('" + node
				+ "', '" + reason + "', '" + measure + "', '" + responsible_person + "','" + recovery_time + "'," + flow + ");";

		System.out.println(sql);

		return sql;
	}

	public static String getStaffSql() {
		String name = getRandomName();

		String[] states = { "online", "offline" };
		String state = states[getRandomNum(0, 1)];

		String sql = "INSERT INTO `custom_service_staff`(name,state) VALUES " + "('" + name + "', '" + state + "');";

		System.out.println(sql);

		return sql;
	}

	public static String getWorksheetSql() {

		String[] states = { "处理中", "未处理", "紧急", "完成" };
		String state = states[getRandomNum(0, 3)];

		String[] contents = { "商品介绍", "物流查询", "询价", "投诉", "退货" };
		String content = contents[getRandomNum(0, 4)];

		String sql = "INSERT INTO `custom_service_worksheet`(state,content) VALUES " + "('" + state + "', '" + content
				+ "');";

		System.out.println(sql);

		return sql;
	}

	public static String getPlanCompleteSql() {

		String[] types = { "批发出库", "外协发货", "采购计划" };
		String type = types[getRandomNum(0, 2)];

		int is_complete = getRandomNum(0, 1);

		String sql = "INSERT INTO `plan_complete`(type,is_complete) VALUES " + "('" + type + "', " + is_complete + ");";

		System.out.println(sql);

		return sql;
	}

	// 不需要，3*7=21条就够了
	// public static String getResourceSql() {
	// String[] types = { "中间件", "数据库", "主机" };
	// String type = types[getRandomNum(0, 2)];
	//
	// String[] production_lines = { "产线G", "产线F", "产线E", "产线D", "产线C", "产线B",
	// "产线A" };
	// String production_line = production_lines[getRandomNum(0, 6)];
	//
	// int num = getRandomNum(0, 500);
	//
	// String sql = "INSERT INTO `resource`(type,production_line,num) VALUES " +
	// "('" + type + "','" + production_line
	// + "'," + num + ");";
	//
	// System.out.println(sql);
	//
	// return sql;
	// }

	public static String getScheduleInfoSql() {
		int is_success = getRandomNum(0, 1);

		String sql;
		if (is_success == 1) {
			sql = "INSERT INTO `schedule_info`(is_success) VALUES " + "(" + is_success + ");";
		} else {
			int is_conflict = getRandomNum(0, 1);
			sql = "INSERT INTO `schedule_info`(is_success,is_conflict) VALUES " + "(" + is_success + ", " + is_conflict
					+ ");";
		}

		System.out.println(sql);

		return sql;
	}

	public static String getSupplyChainSql() {
		String date = getRandomDate();

		String[] types = { "配件", "辅料", "面料" };
		String type = types[getRandomNum(0, 2)];

		int is_complete = getRandomNum(0, 1);
		int is_intime = getRandomNum(0, 1);

		String sql = "INSERT INTO `supply_chain`(date,type,is_complete,is_intime) VALUES " + "('" + date + "','" + type
				+ "'," + is_complete + "," + is_intime + ");";

		System.out.println(sql);

		return sql;
	}

}
