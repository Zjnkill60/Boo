/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import db.DBContext;
import java.util.ArrayList;
import java.util.List;
import model.Employee;
import java.sql.*;

/**
 *
 * @author maz
 */
public class EmployeeService {
    public Integer getAllEmployee() {
        Integer number = 0;
        try {          
            Connection conn =  DBContext.getConnection();
            String query = "select count(*) from nhanvien";
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(query);
            while(rs.next()) {
               
                number = rs.getInt("count");
            }
           
            
        }
        catch(Exception e) {
            System.out.println(e);
        }
        
        return number;
    }

    public List<Employee> getEmployeePaginate(int pageNumber,int pageSize) {
        List<Employee> list = new ArrayList<>();
        try {
            
            Connection conn =  DBContext.getConnection();
            int skipNumber = (pageNumber -1) * pageSize;
            String query = "select manhanvien,hoten,gioitinh,diachi,dienthoai,email,matkhau,nhanvien.machucvu,tenchucvu   from nhanvien  join chucvu\n" +
            "on nhanvien.machucvu = chucvu.machucvu limit " + pageSize + " "+ "offset " + skipNumber;
            System.out.println("limit =" + pageSize);
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(query);
            while(rs.next()) {
                String codeEmp = rs.getString("manhanvien");
                String name = rs.getString("hoten");
                String gender = rs.getString("gioitinh");
                String address = rs.getString("diachi");
                int phone = rs.getInt("dienthoai");
                String email = rs.getString("email");
                String password = rs.getString("matkhau");
                String codePos = rs.getString("machucvu");
                int namePos = rs.getInt("tenchucvu");
                list.add(new Employee(codeEmp,name,gender,address,phone,email,password,codePos,namePos));
            }
        }catch(Exception e) {
            System.out.println(e);
        }
        return list;
    }
    
    public List<Employee> findEmployee(String id) {
        List<Employee> list = new ArrayList<>();
        try {
            
            Connection conn =  DBContext.getConnection();
            
            String query = "select * from nhanvien join chucvu\n" +
            "on nhanvien.machucvu = chucvu.machucvu where manhanvien = ?";
            PreparedStatement pstm = conn.prepareStatement(query);   
            pstm.setString(1, id);
            ResultSet rs = pstm.executeQuery();
            while(rs.next()) {
                String codeEmp = rs.getString("manhanvien");
                String name = rs.getString("hoten");
                String gender = rs.getString("gioitinh");
                String address = rs.getString("diachi");
                int phone = rs.getInt("dienthoai");
                String email = rs.getString("email");
                String password = rs.getString("matkhau");
                String codePos = rs.getString("machucvu");
                int namePos = rs.getInt("tenchucvu");
                list.add(new Employee(codeEmp,name,gender,address,phone,email,password,codePos,namePos));
            }
            
           
        }catch(Exception e) {
            System.out.println(e);
        }
        return list;
    }
    
    public Integer addNewEmployee(Employee e) {
        Integer row = 0;
        System.out.println(e.getCodeEmployee() + e.getName() + e.getGender() + e.getAddress() + e.getPhoneNumber()
         + e.getEmail() + e.getPassword() + e.getCodePosition());
        try {
            Connection conn =  DBContext.getConnection();
            String query = "insert into NHANVIEN(manhanvien,hoten,gioitinh,diachi,dienthoai,email,matkhau,machucvu) values(?,?,?,?,?,?,?,?)";
            PreparedStatement pstm = conn.prepareStatement(query);
            pstm.setString(1, e.getCodeEmployee());
            pstm.setString(2, e.getName());
            pstm.setString(3, e.getGender());
            pstm.setString(4, e.getAddress());
            pstm.setInt(5, e.getPhoneNumber());
            pstm.setString(6, e.getEmail());
            pstm.setString(7, e.getPassword());
            pstm.setString(8, e.getCodePosition());
            
            row = pstm.executeUpdate();
        }catch(Exception c) {
            System.out.println(c);
        }
        return row;
    }
    
    public Integer updateAEmployee(Employee e) {
        Integer row = 0;
        try {
            Connection conn =  DBContext.getConnection();
            String query = "update NHANVIEN set hoten=?,gioitinh=?,diachi=?,dienthoai=?,email=?,matkhau=?,machucvu=? where manhanvien=? ";
            PreparedStatement pstm = conn.prepareStatement(query);
            pstm.setString(1, e.getName());
            pstm.setString(2, e.getGender());
            pstm.setString(3, e.getAddress());
            pstm.setInt(4, e.getPhoneNumber());
            pstm.setString(5, e.getEmail());
            pstm.setString(6, e.getPassword());
            pstm.setString(7, e.getCodePosition());
            pstm.setString(8, e.getCodeEmployee());
            
            row = pstm.executeUpdate();
        }catch(Exception c) {
            System.out.println(c);
        }
        return row;
    }
    
    public Integer removeAEmployee(Employee e) {
        Integer row = 0;
        try {
            Connection conn =  DBContext.getConnection();
            String query = "delete from NHANVIEN where manhanvien=?";
            PreparedStatement pstm = conn.prepareStatement(query);
            pstm.setString(0, e.getCodeEmployee());
                
            row = pstm.executeUpdate();
        }catch(Exception c) {
            System.out.println(c);
        }
        return row;
    }
}
