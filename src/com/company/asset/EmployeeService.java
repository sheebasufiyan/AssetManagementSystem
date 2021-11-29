package com.company.asset;

import java.text.DecimalFormat;
import java.util.*;

public class EmployeeService {
    static int i;
    private List<Employee> list1=new ArrayList<Employee>();

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
        Employee e=new Employee(name,employeeNumber(),dob,address,designation,organisation);
        list1.add(e);
    }

    public void registerSet(String name, String dob, String address, Designations designation, int organisation)
    {
        Employee e=new Employee();
        e.setName(name);
        e.setDob(dob);
        e.setAddress(address);
        e.setDesignation(designation);
        e.setOrganisation(organisation);
        e.setNumber(employeeNumber());
        list1.add(e);
    }

    public void display()
    {
        System.out.println("Name\tEmployeeNumber");
        list1.forEach(e->print(e));
    }

    public void print(Employee e)
    {
        System.out.println(e.getName()+"\t"+e.getNumber());
    }

    public List<Employee> getList()
    {
        return list1;
    }
    public void setList1(Employee e, int index)
    {
        list1.remove(index);
        list1.add(index, e);
    }
}
