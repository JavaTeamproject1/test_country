package Database;

import java.io.File;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


 public class Create_CSV {
 public static void main(String[] args) {
 
   try {
    StringBuilder sb=new StringBuilder();
 
 
    Connection connection=null;
    DB_Connection obj_DB_Connection=new DB_Connection();
    connection=obj_DB_Connection.getConnection();
    ResultSet rs=null;
 
    String query="select * from country";
    PreparedStatement ps=connection.prepareStatement(query);
    rs=ps.executeQuery();
 
    while(rs.next()){
     sb.append(rs.getString("Country"));
     sb.append(","); 
     sb.append(rs.getString("Code"));
     sb.append(",");
     sb.append(rs.getString("Capital"));
     sb.append(",");
     sb.append(rs.getString("Climate"));
     sb.append(",");
     sb.append(rs.getString("Location"));
     sb.append(",");
     sb.append(rs.getString("Major City"));
     sb.append(",");
     sb.append(rs.getString("Religion"));
     sb.append(",");
     sb.append(rs.getString("Major Ethnic Group"));
     sb.append(",");
     sb.append(rs.getString("Press"));
     sb.append(",");
     sb.append(rs.getString("Area"));
     sb.append(",");
     sb.append(rs.getString("Language"));
     sb.append(",");
     sb.append(rs.getString("Christian"));
     sb.append(",");
     sb.append(rs.getString("Catholic"));
     sb.append(",");
     sb.append(rs.getString("Islam"));
     sb.append(",");
     sb.append(rs.getString("Buddhism"));
     sb.append(",");
     sb.append(rs.getString("Hinduism"));
     sb.append(",");
     sb.append(rs.getString("ETC"));
     sb.append("\r\n");
    }

    System.out.println("finished");
 
   } catch (Exception e) {
    // TODO: handle exception
   } 
 }
}