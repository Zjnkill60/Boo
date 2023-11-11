

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.*;

/**
 *
 * @author maz
 */
public class DBContext {

    public static String URL = "jdbc:postgresql://localhost:2345/postgres";
    public static String username = "postgres";
    public static String password = "ai_khoc_noi_dau_nay";
    
    //Test push
    
    public static Connection getConnection() {
         try {
            Connection con = DriverManager.getConnection(URL, username, password);
            return con;
           
        } catch (Exception e) {
             System.out.println(e);
            return null;
        }
        
    }
    
    
    public static void main(String[] args) {
        Connection cn = getConnection();
        if(cn != null) {
            System.out.println("Ket noi thanh cong");
        }else {
            System.out.println("failure");
        }
    }

}
