package firstWebApp.dao;

public class DriverManagement {
	public static void getDriver(String name) {
		try {
			String drivername = convertDriverName(name);
			Class.forName(drivername);
		} catch (ClassNotFoundException e) {
			System.err.println(DriverManagement.class.getName() + ": Driver Class issue.");
			e.printStackTrace();
		}
	}
	
	private static String convertDriverName(String name)
	{
		switch(name.trim().toLowerCase())
		{
		case "mysql": return "com.mysql.cj.jdbc.Driver"; 
		}
		return "";
	}
}
