package Database;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Database.DB_Connection;

public class PollutionDB {
	
	private Connection connection;
	private DB_Connection obj_DB_Connection;
	
	public PollutionDB() {
		DB_Connection obj_DB_Connection=new DB_Connection();
	    connection=obj_DB_Connection.getConnection();
	}
	
	public ResultSet getPollutionDataWith_St(String country) {
		ResultSet rs=null;
		String query;
		PreparedStatement ps;
		try {
			query = "select * from country where Country=?" ;
			ps = connection.prepareStatement(query);
			ps.setString(1, country);
			
			rs = ps.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
	}
	
	public ResultSet getPollutionDataWith_Pg(String date, String place) {
		String range = Integer.toString((Integer.parseInt(date) + 6));

		ResultSet rs=null;
		String query;
		PreparedStatement ps;
		try {
			query = "SELECT * FROM pollution WHERE (DATE BETWEEN ? AND ?) AND PLACE=?";
			ps = connection.prepareStatement(query);
			ps.setString(1, date);
			ps.setString(2, range);
			ps.setString(3, place);
			rs = ps.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs; 
	}
}
