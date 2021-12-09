package com.company.asset;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicBoolean;
public class AssetManager {
    List<Asset> assets=new ArrayList<Asset>();
    List<Brand>brands=new ArrayList<>();
    EmployeeService employee=new EmployeeService();
    Scanner s=new Scanner(System.in);
    HashMap<Integer,Asset> assetHashMap=new HashMap<Integer, Asset>();

    public void registerEmployee(String name, String dob, String address, Designations designation, int organisation)
    {
        employee.register(name,dob,address,designation,organisation);
    }


    public void createAsset(Asset asset){
        assets.add(asset);
        assetHashMap.put(asset.getAssetNumber(),asset);
        System.out.println("Asset created successfully");
    }

    public void createBrand(Brand brand){
        brands.add(brand);
    }

    public void assignAssetToEmployee()
    {
        employee.display();
        System.out.println("Enter employee number to whom asset to be assigned");
        int i=0;
        int employeeNumber=s.nextInt();
        Employee e=employee.getList().stream().filter(e1->employeeNumber==e1.getNumber()).findAny().orElse(null);
        if(e != null) {
            assignAsset(e);
            System.out.println("Asset is assigned to employee");
        }
        else
        {
            System.out.println("Employee number is wrong");
            assignAssetToEmployee();
        }
    }

    public void assignAsset(Employee e)
    {
        System.out.println("Asset Numbers and Name");
        assets.forEach(a->System.out.println(a.getAssetNumber()+":"+a.getAssetName()));
        System.out.println("Enter the asset number to be assigned");
        int assetNumber = s.nextInt();
        Asset a=assets.stream().filter(a1->assetNumber == a1.getAssetNumber()).findAny().orElse(null);
        if(a != null)
        {
            if(a.getAssignedTo()==false && a.getScrapped()==false) {
                employee.getList().stream().filter(e1->e.getNumber()==e1.getNumber()).findAny().get().setAssetNumbers(a.getAssetNumber());
                assets.stream().filter(a1->a.getAssetNumber()==a1.getAssetNumber()).findAny().get().setAssignedTo(true);
                assetHashMap.remove(a.getAssetNumber());
            }
            else
            {
                System.out.println("Asset is either assigned or scrapped");
            }
        }
        else
        {
            System.out.println("Asset number is wrong");
        }
    }

    public void returnBackToStore()
    {
            System.out.println("AssetNumber\tAssetName");
            assets.forEach((a) -> {
                if (a.getAssignedTo()==true) {
                    System.out.println(a.getAssetNumber() + ":" + a.getAssetName());
                    System.out.println("Enter the asset number to be returned");
                    long assetNumber = s.nextLong();
                    Asset b = assets.stream().filter(a1 -> a1.getAssetNumber() == assetNumber).findAny().orElse(null);
                    if (b != null) {
                        employee.getList().stream().filter(e1 -> e1.getAssetNumbers().contains(b.getAssetNumber())).findAny().get().removeAsset(b.getAssetNumber());
                        assets.stream().filter(a1 -> b.getAssetNumber() == a1.getAssetNumber()).findAny().get().setAssignedTo(false);
                    } else {
                        System.out.println("Asset number is wrong");
                    }
                }
            });
    }

    public void addToScrapList(){

        System.out.println("Asset Numbers and Name");
        assets.forEach(a->System.out.println(a.getAssetNumber()+":"+a.getAssetName()));
        System.out.println("Enter the asset number added to the scrap");
        long assetNumber = s.nextLong();
        if(assets.stream().filter(a->a.getAssetNumber()==assetNumber).findAny().orElse(null) != null) {
            assets.stream().filter(a -> a.getAssetNumber() == assetNumber).findAny().get().setScrapped(true);
            System.out.println("Asset is added to scrap list");
        }
        else
            System.out.println("Asset number is wrong");
    }

    public void updateAsset()
    {
        System.out.println("Asset Numbers and Name");
        assets.forEach(a->System.out.println(a.getAssetNumber()+":"+a.getAssetName()));
        System.out.println("Enter the asset number to be updated");
        long assetNumber = s.nextLong();
        Asset a=assets.stream().filter(a1->assetNumber == a1.getAssetNumber()).findAny().orElse(null);
        if(a != null)
        {
            System.out.println("What has to be updated\n1.AssetName\n2.Asset Number\n3.Asset make\n4.Asset Amount\n5.Asset Invoice Details");
            int ch=s.nextInt();
            switch(ch)
            {
                case 1:assets.stream().filter(a1->a.getAssetName()==a1.getAssetName()).findAny().get().setAssetName(s.next());
                    break;
                case 2:assets.stream().filter(a1->a.getAssetNumber()==a1.getAssetNumber()).findAny().get().setAssetNumber(s.nextInt());
                    break;
                case 3:assets.stream().filter(a1->a.getMake()==a1.getMake()).findAny().get().setMake(s.nextInt());
                    break;
                case 4:assets.stream().filter(a1->a.getAmount()==a1.getAmount()).findAny().get().setAmount(s.nextInt());
                    break;
                case 5:assets.stream().filter(a1->a.getInvoiceDetails()==a1.getInvoiceDetails()).findAny().get().setInvoiceDetails(s.next());
                    break;
                default:System.out.println("Invalid Input");
            }
        }
        else
        {
            System.out.println("Asset number is wrong");
        }
    }

    public void displayAsset()
    {
        assets.forEach(a->printAssets(a));

    }

    public void printAssets(Asset a)
    {
        System.out.println("Asset Name:"+a.getAssetName());
        System.out.println("Asset Number:"+a.getAssetNumber());
        System.out.println("Asset Make:"+a.getMake());
        System.out.println("Asset Amount:"+a.getAmount());
        System.out.println("Asset Invoice Details:"+a.getInvoiceDetails());
        System.out.println("--------------------------------------------------------------------------------------------");

    }

    public void displayAssetWithBrand(){
        assets.forEach(a->printAssetswithBrand(a));

    }
    public void printAssetswithBrand(Asset a){

        System.out.println("Asset Name:"+a.getAssetName());
        System.out.println("Asset Number:"+a.getAssetNumber());
        System.out.println("Asset Make:"+a.getMake());
        System.out.println("Asset Amount:"+a.getAmount());
        System.out.println("Asset Invoice Details:"+a.getInvoiceDetails());
        System.out.println("Asset Brand id:"+a.getBrand().brandId);
        System.out.println("Asset Brand Name:"+a.getBrand().brandName);
        System.out.println("Asset Brand logo:"+a.getBrand().logo);
        System.out.println("--------------------------------------------------------------------------------------------");
    }

    public void displayEmployee()
    {
        employee.getList().forEach(e->e.getAssetNumbers().forEach((l)->{
            for(Asset a:assets)
            {
                if (l == a.getAssetNumber())
                {
                    System.out.println("Employee Name:"+e.getName());
                    printAssetswithBrand(a);
                }
            }
        }));
    }

    public void displayStore()
    {
        assets.forEach((a)->{
            if(a.getAssignedTo()==false)
            {
                printAssetswithBrand(a);
            }
        });
    }

    public void displayBranddetails(){
        assets.forEach(a->displayBrands(a));
    }

    public void displayBrands(Asset a){
        System.out.println("Asset Brand id:"+a.getBrand().brandId);
        System.out.println("Asset Brand Name:"+a.getBrand().brandName);
        System.out.println("Asset Brand logo:"+a.getBrand().logo);
    }

    public void assetDetailsFromAssetNumber()
    {
        System.out.println("Asset Numbers");
        assets.forEach(a->System.out.println(a.getAssetNumber()));
        System.out.println("Enter the asset number to fetch details");
        long assetNumber = s.nextLong();
        AtomicBoolean flag= new AtomicBoolean(false);
        assets.forEach((a)->{
            if(a.getAssetNumber()==assetNumber)
            {
                printAssets(a);
                flag.set(true);
            }
        });
        if (flag.get()==false){
            System.out.println("Asset number is wrong");
            assetDetailsFromAssetNumber();
        }
    }

    public void assignedAssetToEmployee()
    {
        System.out.println("Asset Numbers and Name");
        assets.forEach(a->System.out.println(a.getAssetNumber()+":"+a.getAssetName()));
        System.out.println("Enter the asset number to be fetched");
        int assetNumber = s.nextInt();
        if(assets.stream().filter(a->a.getAssetNumber()==assetNumber).findAny().orElse(null) != null)
        {
            if (assets.stream().filter(a -> a.getAssetNumber() == assetNumber).findAny().get().getAssignedTo())
            {
                System.out.println("Asset is assigned to an Employee");
            }
            else
            {
                System.out.println("Asset is not assigned to an Employee");
            }
        }
        else
            System.out.println("Asset number is wrong");
    }
}

