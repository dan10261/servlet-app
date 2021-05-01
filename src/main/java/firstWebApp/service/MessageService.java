package firstWebApp.service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import firstWebApp.dao.DBConnection;

public class MessageService {
	public Statement getStatement() {
		Connection connection = DBConnection.getConnection();
		try {
			Statement stmt = connection.createStatement();
			System.out.println(MessageService.class.getName() + ": statement is created.");
			return stmt;
		} catch (SQLException e) {
			System.err.println(MessageService.class.getName() + ": Statement creation error.");
			e.printStackTrace();
		}
		return null;
	}

	public List<HashMap<String, String>> getAllMsgs() {
		String sql = "SELECT * FROM cav.incomming_dsrc_message";
		List<HashMap<String, String>> mapList = new ArrayList<HashMap<String, String>>();
		try {
			ResultSet result = getStatement().executeQuery(sql);
			while (result.next()) {
				HashMap<String, String> map = new HashMap<String, String>();
				map.put("payload", result.getString(4));
				map.put("original_message", result.getString(5));
				mapList.add(map);
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return mapList;
	}
}
