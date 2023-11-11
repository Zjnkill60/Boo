/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author maz
 */
public class Employee {
    private String codeEmployee;
    private String name;
    private String gender;
    private String address;
    private int phoneNumber;
    private String email;
    private String password;
    private String codePosition;
    private int namePosition;

    public Employee() {
    }

    public Employee(String codeEmployee, String name, String gender, String address, int phoneNumber, String email, String password, String codePosition, int namePosition) {
        this.codeEmployee = codeEmployee;
        this.name = name;
        this.gender = gender;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.password = password;
        this.codePosition = codePosition;
        this.namePosition = namePosition;
    }
    
    

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    

    public String getCodeEmployee() {
        return codeEmployee;
    }

    public void setCodeEmployee(String codeEmployee) {
        this.codeEmployee = codeEmployee;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getCodePosition() {
        return codePosition;
    }

    public void setCodePosition(String codePosition) {
        this.codePosition = codePosition;
    }

    public String getNamePosition() {
        if(this.namePosition == 0) {
            return "Quản lý";
        }else {
            return "Nhân viên";
        }
    }

    public void setNamePosition(int namePosition) {
        this.namePosition = namePosition;
    }
    
    public Object[] toDataRow() {
        return new Object[]{
           this.getCodeEmployee(),this.getName(),this.getGender(),this.getAddress(),
            this.getPhoneNumber(),this.getEmail(),this.getPassword(),
            this.getCodePosition(),this.getNamePosition()
        };
    }
    
    
}

