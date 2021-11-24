package Database;

import java.io.*;
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
 public void SaveCSV() {
	 Connection connection = null;
	 DB_Connection db = new DB_Connection();
	 connection = db.getConnection();
     String createfile= "c:\\db\\csvfile.csv";
     String sql = "select * from country";
     FileOutputStream fos = null;
     OutputStreamWriter osw = null;
     BufferedWriter bfw = null;

     
     
     try {
        fos = new FileOutputStream(createfile);
        osw = new OutputStreamWriter(fos, "MS949");
        bfw = new BufferedWriter(osw);
        PreparedStatement stmt = connection.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();
        bfw.write("Country");
        bfw.write(",");
        bfw.write("Code");
        bfw.write(",");
        bfw.write("Capital");
        bfw.write(",");
        bfw.write("Climate");
        bfw.write(",");
        bfw.write("Location");
        bfw.write(",");
        bfw.write("Major City");
        bfw.write(",");
        bfw.write("Religion");
        bfw.write(",");
        bfw.write("Major Ethnic Group");
        bfw.write(",");
        bfw.write("Press");
        bfw.write(",");
        bfw.write("Area");
        bfw.write(",");
        bfw.write("Language");
        bfw.write(",");
        bfw.write("Christian");
        bfw.write(",");
        bfw.write("Catholic");
        bfw.write(",");
        bfw.write("Islam");
        bfw.write(",");
        bfw.write("Buddhism");
        bfw.write(",");
        bfw.write("Hinduism");
        bfw.write(",");
        bfw.write("ETC");
        bfw.write("\r\n");
        
        while(rs.next()) {
           bfw.write("\""+rs.getString("Country")+"\"");
           bfw.write(",");
           bfw.write("\""+rs.getString("Code")+"\"");
           bfw.write(",");
           bfw.write("\""+rs.getString("Capital")+"\"");
           bfw.write(",");
           bfw.write("\""+rs.getString("Climate")+"\"");
           bfw.write(",");
           bfw.write("\""+rs.getString("Location")+"\"");
           bfw.write(",");
           bfw.write("\""+rs.getString("Major City")+"\"");
           bfw.write(",");
           bfw.write("\""+rs.getString("Religion")+"\"");
           bfw.write(",");
           bfw.write("\""+rs.getString("Major Ethnic Group")+"\"");
           bfw.write(",");
           bfw.write("\""+rs.getString("Press")+"\"");
           bfw.write(",");
           bfw.write("\""+Integer.toString(rs.getInt("Area"))+"\"");
           bfw.write(",");
           bfw.write("\""+rs.getString("Language")+"\"");
           bfw.write(",");
           bfw.write("\""+Integer.toString(rs.getInt("Christian"))+"\"");
           bfw.write(",");
           bfw.write("\""+Integer.toString(rs.getInt("Catholic"))+"\"");
           bfw.write(",");
           bfw.write("\""+Integer.toString(rs.getInt("Islam"))+"\"");
           bfw.write(",");
           bfw.write("\""+Integer.toString(rs.getInt("Buddhism"))+"\"");  
           bfw.write(",");
           bfw.write("\""+Integer.toString(rs.getInt("Hinduism"))+"\""); 
           bfw.write(",");
           bfw.write("\""+Integer.toString(rs.getInt("ETC"))+"\""); 
           bfw.write("\r\n");
        }
        bfw.flush();
        bfw.close();
     }catch(Exception e){
        
     }
 }
}