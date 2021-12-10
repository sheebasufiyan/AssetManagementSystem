package com.company.asset;

import java.util.*;
import java.util.concurrent.atomic.AtomicBoolean;
public class AssetManager {
    List<Asset> assets=new ArrayList<>();
    List<Brand>brands=new ArrayList<>();
    EmployeeService employee=new EmployeeService();
    Scanner s=new Scanner(System.in);

    public void registerEmployee(String name, String dob, String address, Designations designation, int organisation)
    {
        employee.register(name,dob,address,designation,organisation);
    }


    public void createAsset(Asset asset){
        assets.add(asset);
        System.out.println("Asset created successfully");
    }

    public void createBrand(Brand brand){
        brands.add(brand);
    }

    public void assignAssetToEmployee()
    {
        employee.display();
        System.out.println("Enter employee number to whom asset to be assigned");
        int employeeNumber=s.nextInt();
        Employee employees=employee.getList().stream().filter(e1->employeeNumber==e1.getNumber()).findAny().orElse(null);
        if(employees != null) {
            assignAsset(employees);
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
        Asset filteredAsset=assets.stream().filter(assetIndex->assetNumber == assetIndex.getAssetNumber()).findAny().orElse(null);
        if(filteredAsset != null)
        {
            if( filteredAsset.getScrapped()==false) {
//                employee.getList().stream().filter(e1->e.getNumber()==e1.getNumber()).findAny().get().setAssetNumbers(filteredAsset.getAssetNumber());
                assets.stream().filter(a1->filteredAsset.getAssetNumber()==a1.getAssetNumber()).findAny().get().setAssignedTo(e.getNumber());
                System.out.println("Asset is assigned to employee");
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
                if (a.getAssignedTo()!=0) {
                    System.out.println(a.getAssetNumber() + ":" + a.getAssetName());
                    System.out.println("Enter the asset number to be returned");
                    long assetNumber = s.nextLong();
                    Asset filteredAsset = assets.stream().filter(assetIndex -> assetIndex.getAssetNumber() == assetNumber).findAny().orElse(null);
                    if (filteredAsset!= null) {
//                        employee.getList().stream().filter(e1 -> e1.getAssetNumbers().contains(b.getAssetNumber())).findAny().get().removeAsset(b.getAssetNumber());
                        assets.stream().filter(indexOfAsset-> filteredAsset.getAssetNumber() == indexOfAsset.getAssetNumber()).findAny().get().setAssignedTo(0);
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
        if(assets.stream().filter(assetIndex->assetIndex.getAssetNumber()==assetNumber).findAny().orElse(null) != null) {
            assets.stream().filter(index ->index.getAssetNumber() == assetNumber).findAny().get().setScrapped(true);
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
        Asset filterAsset=assets.stream().filter(index->assetNumber == index.getAssetNumber()).findAny().orElse(null);
        if(filterAsset != null)
        {
            System.out.println("What has to be updated\n1.AssetName\n2.Asset Number\n3.Asset make\n4.Asset Amount\n5.Asset Invoice Details");
            int ch=s.nextInt();
            switch(ch)
            {
                case 1:assets.stream().filter(previousAsset->filterAsset.getAssetName()==previousAsset.getAssetName()).findAny().get().setAssetName(s.next());
                    break;
                case 2:assets.stream().filter(previousAsset->filterAsset.getAssetNumber()==previousAsset.getAssetNumber()).findAny().get().setAssetNumber(s.nextInt());
                    break;
                case 3:assets.stream().filter(previousAsset->filterAsset.getMake()==previousAsset.getMake()).findAny().get().setMake(s.nextInt());
                    break;
                case 4:assets.stream().filter(previousAsset->filterAsset.getAmount()==previousAsset.getAmount()).findAny().get().setAmount(s.nextInt());
                    break;
                case 5:assets.stream().filter(previousAsset->filterAsset.getInvoiceDetails()==previousAsset.getInvoiceDetails()).findAny().get().setInvoiceDetails(s.next());
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
        assets.forEach(allassets->printAssets(allassets));

    }

    public void printAssets(Asset assets)
    {
        System.out.println("Asset Name:"+assets.getAssetName());
        System.out.println("Asset Number:"+assets.getAssetNumber());
        System.out.println("Asset Make:"+assets.getMake());
        System.out.println("Asset Amount:"+assets.getAmount());
        System.out.println("Asset Invoice Details:"+assets.getInvoiceDetails());
        System.out.println("--------------------------------------------------------------------------------------------");

    }

    public void displayAssetWithBrand(){
        assets.forEach(allAssets->printAssetswithBrand(allAssets));

    }
    public void printAssetswithBrand(Asset assets){

        System.out.println("Asset Name:"+assets.getAssetName());
        System.out.println("Asset Number:"+assets.getAssetNumber());
        System.out.println("Asset Make:"+assets.getMake());
        System.out.println("Asset Amount:"+assets.getAmount());
        System.out.println("Asset Invoice Details:"+assets.getInvoiceDetails());
        System.out.println("Asset Brand id:"+assets.getBrand().id);
        System.out.println("Asset Brand Name:"+assets.getBrand().name);
        System.out.println("Asset Brand logo:"+assets.getBrand().logo);
        System.out.println("--------------------------------------------------------------------------------------------");
    }

    public void displayEmployeeWithAssets()
    {
        employee.getList().forEach(employess->employess.getAssetNumbers().forEach((employes)->{
            for(Asset assetList:assets)
            {
                if (employes== assetList.getAssetNumber())
                {
                    System.out.println("Employee Name:"+employess.getName());
                    printAssetswithBrand(assetList);
                }
            }
        }));
    }

    public void displayStore()
    {
        assets.forEach((assets)->{
            if(assets.getAssignedTo()==0)
            {
                printAssetswithBrand(assets);
            }
        });
    }

    public void displayBranddetails(){
        assets.forEach(assets->displayBrands(assets));
    }

    public void displayBrands(Asset assets){
        System.out.println("Asset Brand id:"+assets.getBrand().id);
        System.out.println("Asset Brand Name:"+assets.getBrand().name);
        System.out.println("Asset Brand logo:"+assets.getBrand().logo);
    }

    public void assetDetailsFromAssetNumber()
    {
        System.out.println("Asset Numbers");
        assets.forEach(assets->System.out.println(assets.getAssetNumber()));
        System.out.println("Enter the asset number to fetch details");
        long assetNumber = s.nextLong();
        AtomicBoolean flag= new AtomicBoolean(false);
        assets.forEach((assets)->{
            if(assets.getAssetNumber()==assetNumber)
            {
                printAssets(assets);
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
        assets.forEach(assets->System.out.println(assets.getAssetNumber()+":"+assets.getAssetName()));
        System.out.println("Enter the asset number to be fetched");
        int assetNumber = s.nextInt();
        if(assets.stream().filter(assets->assets.getAssetNumber()==assetNumber).findAny().orElse(null) != null)
        {
            if (assets.stream().filter(assets -> assets.getAssetNumber() == assetNumber).findAny().get().getAssignedTo()!=0)
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


    // Returns check digit for 14 digit IMEI prefix
    public int getCheckDigit(String imeiPrefix) {
        int sum = 0;
        for(int index = 13;index>=0;index=index-1) {
            String sDigit = imeiPrefix.substring(index,index+1);
            int digit = Integer.valueOf(sDigit);
            if(index%2==0) {
                sum = sum + digit;
            }else {
                sum = sum + sumOfDigits(digit*2);
            }
        }
        sum = sum * 9;
        return sum%10; // Return check digit
    }

    // Calculate sum of digits for a number
    private int sumOfDigits(int number) {
        int sum=0;
        while(number > 0) {
            sum += number%10;
            number = number/10;
        }
        return sum;
    }
}

