import java.sql.*;
import java.util.Vector;

public class DB_Conn {
 Connection con;
 Statement stmt;
 
 DB_Conn() {
	 try{ 
		 Class.forName("oracle.jdbc.driver.OracleDriver").newInstance(); 
		 con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","hr","12345");
		 stmt = con.createStatement();
		 System.out.print("Success"); 
	 }
	 catch(Exception ex) {
		 System.out.println("Exception:" + ex);
	 }  
 }//Db_test()
 
 void setin(String j,String t,String p,String cp){
	 try	{ 
		 String sql="insert into books(idx,genre,title,price,company,ti,rent) values (booknum.nextval,'"+j+"','"+t+"','"+p+"','"+cp+"',sysdate,'T')";   
		 stmt.executeUpdate(sql);
		 System.out.println("setinok");
		 stmt.close();
		 con.close();
	 }
	 catch(Exception e){
		 e.printStackTrace();
		 System.out.println("setin_error");
	 }
  }//close setin
 
 void mjoin(String a, String n) {
	 try {
		 String sql="insert into member(idx,account,passwd,name,ti) values (membernum.nextval, '"+a+"','','"+n+"',sysdate)";
		 stmt.executeUpdate(sql);
		 System.out.println("joinok");
		 stmt.close();
		 con.close();
	 }
	 catch(Exception e){
		 e.printStackTrace();
		 System.out.println("join_error");
	 }
 }//close join

 Vector sel(String f) {
   Vector<String> v=new Vector<String>();
   try {
	   String sql="select * from books where genre='"+f+"'";
	   ResultSet rs=stmt.executeQuery(sql); 
	   while(rs.next()) {
		   String s1=rs.getString("title");
		   v.add(s1);
	   }//close while 
	   System.out.println("selok");
	   stmt.close(); 
	   con.close();
   }
   catch(Exception e){
	   System.out.println("setlerror"+e);
   }  
  return v;
}//close search
 
 String call(String f) {
	 String v="";
	 try{
		 String sql="select * from books where title='"+f+"'";
		 ResultSet rs=stmt.executeQuery(sql); 
		 while(rs.next()){
			 v=rs.getString("price");
		 }//close while 
		 
		 System.out.println("callok");
		 stmt.close(); con.close();
	 }
	 catch(Exception e){
		 System.out.println("callerror"+e);
	 }  
   return v;
 }//close search
 
 public static void main(String ar[]){ 
      new DB_Conn();
  }
}
