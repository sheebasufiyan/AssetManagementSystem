package com.company.asset;
import java.util.ArrayList;
import java.util.List;

import java.util.stream.Collectors;



public class EmployeeService  {
    public static ArrayList<Employee> employees=new ArrayList<Employee>();
    ArrayList<Asset> assets=new ArrayList<Asset>();

    Employee e6=createObject("Rabindranath",12,"18/09/1999","Chikmagaluru",Designation.PROJECT_LEADER,3);

    private static Employee createObject(String name,int num, String dob, String address, Designation desig, int org){
        Employee e=new Employee();
        e.setEmployeeName(name);
        e.setEmployeeNumber(num);
        e.setdob(dob);
        e.setAddress(address);
        e.setDesignation(desig);
        e.setOrganisation(org);
        return e;

    }

    public Employee getList() {
        return e6;
    }

    public void register(Employee a){

        employees.add(a);
    }
    public void register(Employee a, Employee b, Employee c, Employee d, Employee e){
        employees.add(a);
        employees.add(b);
        employees.add(c);
        employees.add(d);
        employees.add(e);

    }
    public void display(){

        employees.forEach(e->System.out.print(e.getEmployeeName()+"--"+e.getEmployeeNumber()+"--"+e.getDob()+"--"+e.getAddress()+"--"+e.getDesignation()+"--"+e.getOrganisation()+"\n"));
}
//    public void displayAfterSorting(){
//        c.displaySort(employees);
//        display();
//    }
//
//    private void updateException (int index) throws MyException{
//        if(index>employees.size()){
//            throw new MyException("Array Index out of bound Exception\n");
//        }
//    }
//
//    public void update ( int index) {
//        try {
//            updateException(index);
//            Employee e = new Employee();
//            e = employees.get(index);
//
//            e.setDesignation(Designation.PROJECT_LEADER);
//            employees.set(index, e);
//
//            System.out.println("________________________________________________________\nDetails after updation");
//            display();
//
//
//        } catch (MyException e) {
//            System.out.println("Exception caught.....Array out of bound during update method");
////        }
////    }
//    public void remove(int index){
//        try {
//            employees.remove(index);
//            System.out.println("________________________________________________________\ncom.company.Employee details after removing an employee of index " + index);
//            display();
//        }
//        catch (Exception e){
//            System.out.println("Array index out of bound exception caught during remove method");
//        }
   }





