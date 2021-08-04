package bstorm.akimts.java;

import bstorm.akimts.java.data_access.ConnectionFactory;

import java.sql.Connection;
import java.sql.SQLException;

public class TestConnection {

    public static void main(String[] args) {
        try(Connection co = ConnectionFactory.getConnection()){
            System.out.println("Connection opened");
            ConnectionFactory.displayTables();
        }
        catch (SQLException e){
            System.out.println("Connection failed");
        }
        System.out.println("Connection stopped");
    }
}
