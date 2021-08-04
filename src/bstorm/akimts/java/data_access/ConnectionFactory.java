package bstorm.akimts.java.data_access;

import java.sql.*;
import java.util.stream.IntStream;

public class ConnectionFactory {
    public final static String URL = "jdbc:mysql://localhost:3308/dbslide?serverTimezone=Europe/Brussels";
    public final static String USERNAME = "root";
    public final static String PASSWORD = "";

    public static Connection getConnection(){
        try{
            return DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (SQLException throwables) {
            System.out.println(throwables.getMessage());
            throw new RuntimeException("pas de connexion");
        }
    }

    public static void displayTables(){
        try( Connection co = getConnection() ){
            DatabaseMetaData dbmd = co.getMetaData();
            try( ResultSet rs = dbmd.getTables("dbslide",null,"%", new String[]{"TABLE"}) )
            {
                System.out.println("CAT  \tSCHEM  \tNAME  \tTYPE");
                while(rs.next()){
                    for (int i = 1; i <= 4; i++) {
                        System.out.print(rs.getString(i));
                        if(i != rs.getMetaData().getColumnCount())
                            System.out.print("  \t");
                    }
                    System.out.println();
                }
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }
}
