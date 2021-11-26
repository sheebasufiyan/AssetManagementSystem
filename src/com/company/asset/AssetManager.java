package com.company.asset;

import java.util.*;

public class AssetManager {
    List<Asset> assets=new ArrayList<Asset>();
    List<Asset>scrap=new ArrayList<Asset>();
    List<Brand>brands=new ArrayList<Brand>();
    List<Employee>employees=new ArrayList<Employee>();
    Scanner sc=new Scanner(System.in);
    EmployeeService employee=new EmployeeService();
    List<Asset> stores=new ArrayList<>();
    List<Asset>emp=new ArrayList<>();

    public void createAsset(Asset asset){
        assets.add(asset);
    }

    public void createBrand(Brand brand){
        brands.add(brand);
    }

    public void deleteAsset(int index){
        try {
            assets.remove(index);
        }
        catch (Exception e){
            System.out.println("Array index out of bound exception caught during remove method");
        }
    }

    public void addAsset(Asset a){
        stores.add(a);
    }

    public void addAssetToemployee(Asset a){
        emp.add(a);
    }

    public void scrapAsset(int in){
        assets.remove(in);

    }

    public void updateName ( int index) {
        try {
            Asset updateAsset= new Asset();
            updateAsset = assets.get(index);
            System.out.println("Enter the new asset name");
            String newAsset=sc.next();
            updateAsset.setAssetName(newAsset);
            assets.set(index, updateAsset);
        } catch (Exception e) {
            System.out.println("Exception caught.....Array out of bound during update method");
        }
    }

    public void updateNumber ( int index) {
        try {
            Asset updateAsset= new Asset();
            updateAsset = assets.get(index);
            System.out.println("Enter new Asset number");
            int newNumber=sc.nextInt();
            updateAsset.setAssetNumber(newNumber);
            assets.set(index, updateAsset);
        } catch (Exception e) {
            System.out.println("Exception caught.....Array out of bound during update method");
        }
    }

    public void updateMake ( int index) {
        try {
            Asset updateAsset= new Asset();
            updateAsset = assets.get(index);
            System.out.println("Enter new Asset make");
            int newNumber=sc.nextInt();
            updateAsset.setMake(newNumber);
            assets.set(index, updateAsset);
        } catch (Exception e) {
            System.out.println("Exception caught.....Array out of bound during update method");
        }
    }

    public void updateAmount ( int index) {
        try {
            Asset updateAsset= new Asset();
            updateAsset = assets.get(index);
            System.out.println("Enter new Asset amount");
            int newNumber=sc.nextInt();
            updateAsset.setAmount(newNumber);
            assets.set(index, updateAsset);
        } catch (Exception e) {
            System.out.println("Exception caught.....Array out of bound during update method");
        }
    }

    public void updateInvoice( int index) {
        try {
            Asset updateAsset= new Asset();
            updateAsset = assets.get(index);
            System.out.println("Enter new Asset invoice");
            String newinvoice=sc.next();
            updateAsset.setInvoiceDetails(newinvoice);
            assets.set(index, updateAsset);
        } catch (Exception e) {
            System.out.println("Exception caught.....Array out of bound during update method");
        }
    }

    public void displayBrandDetails(){
        brands.forEach(a->System.out.println(a.getBrandId()+" "+a.getBrandName()+" "+a.getLogo()));
    }

    public void display(){
        assets.forEach(a->System.out.println(a.getAssetNumber()+"  "+a.getAssetName()+"  "+a.getMake()+"  "+a.getAmount()+"  "+a.getInvoiceDetails()));
    }

    public void displayEmployee(){
        employees.forEach(a->a.assets.forEach(b->System.out.println(b)));
    }

    public void displayAlongWithBrand(){
       assets.forEach(a->System.out.println(a.getAssetNumber()+"  "+a.getAssetName()+"  "+a.getMake()+"  "+a.getAmount()+"  "+a.getInvoiceDetails()+"  "+ a.getBrand().brandId+" "+a.getBrand().brandName+" "+a.getBrand().logo+" "+a.getBrand().IMEI));
    }

    public Asset getDetails(int id)
    {
        Asset es = (Asset) assets.get(id);
        return es;
    }

    public Employee getList(int id)
    {
        Employee es = (Employee) employees.get(id);
        return es;
    }
}
