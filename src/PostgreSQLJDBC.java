import java.sql.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;


public class PostgreSQLJDBC {
   public static void main( String args[] )
     {
       Connection c = null;
       Statement stmt = null;
       try {
         Class.forName("org.postgresql.Driver");
         c = DriverManager
            .getConnection("jdbc:postgresql://localhost:5432/assignment2",
            "postgres", "postgres");
         System.out.println("Opened database successfully");

         stmt = c.createStatement();
         String sql1 = "CREATE TABLE cup_matches" +
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
         

         stmt.executeUpdate(sql1);
         stmt.executeUpdate(sql2);
         stmt.close();
         c.close();
       } catch ( Exception e ) {
         System.err.println( e.getClass().getName()+": "+ e.getMessage() );
         System.exit(0);
       }
       System.out.println("Table created successfully");
     }
}