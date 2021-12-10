package com.company.asset;

import java.text.DecimalFormat;
import java.util.*;

public class EmployeeService {
    static int i;
    private List<Employee> employeesList=new ArrayList<Employee>();

    String getHashmap(int company)
    {
        Map<Integer,String> org =new HashMap<Integer,String>();
        org.put(1,"Robosoft");
        org.put(2,"Mphasis");
        org.put(3,"Apisero");
        org.put(4,"Infosys");
        org.put(5,"Accenture");
        return org.get(company);
    }

    public int employeeNumber()
    {
        DecimalFormat decimalFormat=new DecimalFormat("0000");
        Calendar calendar=Calendar.getInstance();
        String str=calendar.get(Calendar.YEAR)+decimalFormat.format(i++);
        return Integer.parseInt(str);
    }

    public void register(String name, String dob, String address, Designations designation, int organisation)
    {
        Employee employees=new Employee(name,employeeNumber(),dob,address,designation,organisation);
        employeesList.add(employees);
    }

    public void registerSet(String name, String dob, String address, Designations designation, int organisation)
    {
        Employee employees=new Employee(name,employeeNumber(),dob,address,designation,organisation);
        employeesList.add(employees);
    }

    public void display()
    {
        System.out.println("Name\tEmployeeNumber");
        employeesList.forEach(employees->print(employees));
    }

    public void print(Employee employees)
    {
        System.out.println(employees.getName()+"\t"+employees.getNumber());
    }

    public List<Employee> getList()
    {
        return employeesList;
    }
    public void setList1(Employee employees, int index)
    {
        employeesList.remove(index);
        employeesList.add(index, employees);
    }
}
