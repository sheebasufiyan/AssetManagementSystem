package com.company.asset;

import java.util.ArrayList;
import java.util.List;

public class Employee {
    private String employeeName;
    private int employeeNumber;
    private String dob;
    private String address;
    private Designation designation;
    private int organisation;
    private Asset asset;
    ArrayList<Asset> assets=new ArrayList<>();
    Employee(){

    }

    Employee(String name, int number, String dob, String address, Designation designation, int Organization,Asset asset) {
        this.employeeName = name;
        this.employeeNumber = number;
        this.dob = dob;
        this.address = address;
        this.designation = designation;
        this.organisation = Organization;
        this.asset=asset;

    }
    public void setEmployeeName(String name){
        employeeName=name;
    }

    public void setEmployeeNumber(int num){
        employeeNumber=num;
    }
    public void setdob(String dob){
        this.dob=dob;
    }
    public void setAddress(String address){
        this.address=address;
    }
    public void setDesignation(Designation desig){
        designation=desig;
    }
    public void  setOrganisation(int org){
        organisation=org;
    }
    public void setAsset(Asset a){asset=a;}
    public  void addAsset(Asset a){
        assets.add(a);
    }


    public String getEmployeeName(){
        return employeeName;
    }
    public int getEmployeeNumber(){
        return employeeNumber;
    }
    public String getDob(){
        return dob;
    }
    public String getAddress(){
        return address;
    }
    public Designation getDesignation(){
        return designation;
    }
    public int getOrganisation(){
        return organisation;
    }
    public Asset getAsset(){ return asset;}
    public String toString() {
        return "\n" + employeeName + "," + employeeNumber + " , " + dob + " , " + address + " , " + designation + " , " + organisation;
    }


}
