import java.sql.*;

import java.sql.*;

//commit2
public class PostgreSQLJDBC {
   public static void main( String args[] ) throws SQLException
     {
       Connection c = null;
       Statement stmt = null;
       ResultSet rs = null;
       try {
         Class.forName("org.postgresql.Driver");
         c = DriverManager
            .getConnection("jdbc:postgresql://localhost:5432/assignment2",
            "postgres", "postgres");
         System.out.println("Opened database successfully");

         stmt = c.createStatement();
         /*String sql1 = "CREATE TABLE cup_matches" +
                      "(mid INT PRIMARY KEY     NOT NULL," +
                      " round           varchar(50)    NOT NULL, " +
                      " year            INT     NOT NULL, " +
                      " num_ratings     INT, " +
                      " rating         REAL)";
                      
         String sql2 = "CREATE TABLE player_in" +
                 "(mid INT  references cup_matches(mid)   NOT NULL," +
                 " name VARCHAR(50)        NOT NULL, " +
                 " year            INT     NOT NULL, " +
                 " position        INT, " +
                 " primary key(mid , name))";
         */
         
         for (int i = 0; i < 58960; i++) {
        	 String sql1 = "";
        	 if(i < 118)
        		 sql1 = "insert into player_in values("+i%2680+", 'pele' , 1950 , 10)";
        	 
        	 else if(i < 20000)
        		 sql1 = "insert into player_in values("+i%2680+", 'Ronaldo"+i+"' , 2008 , 7)";
        	 
        	 else if(i < 40000)
        		 sql1 = "insert into player_in values("+i%2680+", 'Abo-Treka"+i+"' , 2005 , 22)";
        	 
        	 else
        		 sql1 = "insert into player_in values("+i%2680+", 'Puyol"+i+"' , 2000 , 5)";

        		 
        	 stmt.executeUpdate(sql1);
		}
         System.out.println("Records inserted successfully");
         String sql2 = "select count (*) from player_in";
         rs =  stmt.executeQuery(sql2);
         if(rs.next())
        	 System.out.println(rs.getInt("count"));
         rs.close();
         stmt.close();
         c.close();
       } catch ( Exception e ) {
         System.err.println( e.getClass().getName()+": "+ e.getMessage() );
         System.exit(0);
       }
     //  System.out.println("Records inserted successfully");
     }
}