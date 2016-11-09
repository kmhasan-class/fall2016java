/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author kmhasan
 */
public class DatabaseConnection {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        final String DBNAME = "studentinfodb";
        final String HOSTNAME = "172.17.0.134";
        final String USERNAME = "cse2015fall2016";
        final String PASSWORD = "java";
        final String DBURL = "jdbc:mysql://" + HOSTNAME + "/" + DBNAME;

        try {
            Connection connection = DriverManager.getConnection(DBURL, USERNAME, PASSWORD);
            Statement statement = connection.createStatement();
            /*
            String id = "2012420";
            String name = "Md. Rakibul Hasan";
            double cgpa = 2.99;
            
            String query = "insert into studentInfo values('" + id + " ', '" +name + "', " + cgpa + ");";
            statement.executeUpdate(query);
            System.out.println("Query executed");
            */
            String query = "select * from studentInfo;";
            ResultSet resultSet = statement.executeQuery(query);
            
            while (resultSet.next()) {
                String id = resultSet.getString("studentId");
                String name = resultSet.getString("studentName");
                double cgpa = resultSet.getDouble("cgpa");
                
                System.out.println(id + " " + name + " " + cgpa);
            }
            
            connection.close();
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
