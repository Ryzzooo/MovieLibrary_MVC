/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mvc.Koneksi;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Database connection class
 * @author ACER
 */
public class Koneksi {
    static Connection con;
    
    public static Connection connection() {
        if (con == null) {
            try {
                // Updated connection string for newer MySQL connector
                String url = "jdbc:mysql://localhost:3306/db_movie_library";
                String username = "root";
                String password = "root"; // Change this to your MySQL password
                
                con = DriverManager.getConnection(url, username, password);
                System.out.println("Database connected successfully!");
            } catch (SQLException ex) {
                System.out.println("Connection failed: " + ex.getMessage());
            }
        }
        return con;
    }
}