package com.company.asset;

import java.util.ArrayList;
import java.util.List;

public class Employee {
    private String name;
    private int number;
    private String dob;
    private String address;
    private Designations designation;
    private int organisation;
    private List<Integer> assetNumbers= new ArrayList<>();
    Employee()
    {
    }
    Employee(String name, int number, String dob, String address, Designations designation, int organisation)
    {
        this.name=name;
        this.dob=dob;
        this.number=number;
        this.address=address;
        this.designation=designation;
        this.organisation=organisation;
    }
    public String getName()
    {
        return name;
    }
    public String getDesignation()
    {
        return designation.name();
    }
    public int getNumber()
    {
        return number;
    }
    public void setNumber(int number)
    {
        this.number=number;
    }
    public int getOrganisation()
    {
        return organisation;
    }
    public void setOrganisation(int organisation)
    {
        this.organisation=organisation;
    }
    public String getAddress()
    {
        return  address;
    }
    public void setAddress(String address)
    {
        this.address=address;
    }
    public void setDesignation(Designations d)
    {
        designation=d;
    }
    public void setName(String name)
    {
        this.name=name;
    }
    public void setDob(String dob)
    {
        this.dob=dob;
    }
    public String getDob()
    {
        return dob;
    }
    public void setAssetNumbers(int assetNumbers)
    {
        this.assetNumbers.add(assetNumbers);
    }
    public List<Integer> getAssetNumbers()
    {
        return assetNumbers;
    }
    public void removeAsset(int assetNumber)
    {
        assetNumbers.remove(assetNumber);
    }
}
