package Database;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CountryDB {
	
	private Connection connection;
	private DB_Connection obj_DB_Connection;
	
	public CountryDB() {
		DB_Connection obj_DB_Connection=new DB_Connection();
	    connection=obj_DB_Connection.getConnection();
	}
	
	public ResultSet getCountryDataWith_St(String country) {
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
	
	public String[] getCountryDataWith_Name() {
		String[] country = new String[236];
		ResultSet rs=null;
		String query;
		PreparedStatement ps;
		try {
			query = "SELECT Country FROM country" ;
			ps = connection.prepareStatement(query);
			rs = ps.executeQuery();
			int i = 0;
			while(rs.next()) {
				country[i] = rs.getString("Country");
				i++;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return country;
	}
	
	public ResultSet getCountryDataWith_Pg(String date, String place) {
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
	
	public void SaveDb(String a[]) {
		try {
	         PreparedStatement ps = null;
	      
	         String query = "INSERT INTO country VALUE(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	         ps = connection.prepareStatement(query);
	         
	         
	         ps.setString(1, a[0]);
	         ps.setString(2, a[1]);
	         ps.setString(3, a[2]);
	         ps.setString(4, a[3]);
	         ps.setString(5, a[4]);
	         ps.setString(6, a[5]);
	         ps.setString(7,"");
	         ps.setString(8, a[6]);
	         ps.setString(9 ,a[7]);
	         ps.setInt(10, Integer.parseInt(a[8]));
	         ps.setString(11, a[9]);
	         ps.setInt(12, Integer.parseInt(a[10]));
	         ps.setInt(13, Integer.parseInt(a[11]));
	         ps.setInt(14, Integer.parseInt(a[12]));
	         ps.setInt(15, Integer.parseInt(a[13]));
	         ps.setInt(16, Integer.parseInt(a[14]));
	         ps.setInt(17, Integer.parseInt(a[15]));
	         ps.executeUpdate();
	         
	      } catch (Exception e) {e.printStackTrace();}
	}

}
