package com.company.asset;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class AssetController {
    public static void main(String args[]) {

        Scanner sc = new Scanner(System.in);
        AssetManager assetManager = new AssetManager();
        Asset assets = new Asset();
        boolean repeat = true;
        while (repeat) {
            System.out.println("Enter your choice\n" +
                    "\n" +
                    "1. create assets\n" +
                    "2. delete assets\n" +
                    "3. assign asset to any employee\n" +
                    "4. return asset back to store\n" +
                    "5. scrap an asset\n" +
                    "6. Update asset details \n" +
                    "7. Print asset details\n" +
                    "8. Show list of all assets along with its brand details.\n" +
                    "9. Show list of all assets assigned to an employee along with its brand details.\n" +
                    "10. Show only those assets which are present in the store along with its brand details.\n" +
                    "11. Create/update/show all/show individual brand details. \n" +
                    "12. Fetch asset details by providing the asset number \n" +
                    "13. Check if asset assigned to any employee by providing the asset number\n" +
                    "14. Quit ");
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Enter all the asset details:\n" +
                            "asset name,asset number, make, amount, invoice details");
                    String assetName = sc.next();
                    int assetNumbers = sc.nextInt();
                    int make = sc.nextInt();
                    int amount = sc.nextInt();
                    String invoiceDetails = sc.next();
                    int brandId;
                    String brandName;
                    String logo;
                    Brand brand;
                    Boolean condition=true;
                    if (assetNumbers > 10000000 && assetNumbers < 99999999) {

                            for (int ind = 0; ind < assetManager.assets.size(); ind++) {
                                Asset assetDetails = assetManager.getDetails(ind);
                                if (assetNumbers == assetDetails.getAssetNumber()) {
                                    System.out.println("Asset Number already exist, Enter a new asset number");
                                    condition = false;

                                }
                            }
                            while (condition){
                            if (assetName.equals("mobile")) {
                                System.out.println("brand id, brand name, logo,IMEI");
                                brandId = sc.nextInt();
                                brandName = sc.next();
                                logo = sc.next();
                                int IMEI = sc.nextInt();
                                brand = new Brand(brandId, brandName, logo, IMEI);
                                assetManager.createBrand(brand);

                                Asset asset = new Asset(assetName, assetNumbers, make, amount, invoiceDetails, brand);
                                assetManager.createAsset(asset);
                                System.out.println("Asset created successfully");
                                condition=false;
                            } else {
                                System.out.println("brand id, brand name, logo");
                                brandId = sc.nextInt();
                                brandName = sc.next();
                                logo = sc.next();
                                brand = new Brand(brandId, brandName, logo);
                                assetManager.createBrand(brand);

                                Asset asset = new Asset(assetName, assetNumbers, make, amount, invoiceDetails, brand);
                                assetManager.createAsset(asset);
                                System.out.println("Asset created successfully");
                                condition = false;
                            }
                            }
                        }
                     else {
                        System.out.println("Enter 8 digits valid asset number");
                    }
                 break;

            case 2:
                System.out.println("Enter the index of asset that need to be deleted");
                int index = sc.nextInt();
                assetManager.deleteAsset(index);
                break;

            case 3:System.out.println("Enter employee number to which asset need to be assigned");
                    int en=sc.nextInt();
                System.out.println("Enter the asset number that need to assign for employee ");
                int asset_Num = sc.nextInt();
                boolean flag = false;
                int a;
                for( a=0; a<assetManager.assets.size();a++){
                    Asset assetDetails= assetManager.getDetails(a);
                    if(asset_Num==assetDetails.getAssetNumber())
                    {
                        assetManager.addAssetToemployee(assetDetails);
                        flag=true;
                    }
                }
                break;

            case 4:
                System.out.println("Enter the asset number that need to return to the store");
                int n= sc.nextInt();
                boolean k=false;
                for(int m=0; m<assetManager.assets.size();m++){
                    Asset assetDetails= assetManager.getDetails(m);
                    if(n==assetDetails.getAssetNumber())
                    {
                        assetManager.addAsset(assetDetails);
                        assetManager.deleteAsset(m);
                        k=true;
                    }
                }
                if(!k)
                {
                    System.out.println("Sorry, no data exists with the id " +n);
                }
                break;

            case 5:
                System.out.println("Enter the  damaged asset name need to be scraped ");
                String asset_Names = sc.next();
                boolean fla = false;
                int x;
                for( x=0; x<assetManager.assets.size();x++){
                    Asset assetDetails= assetManager.getDetails(x);
                    if(asset_Names.equals(assetDetails.getAssetName()))
                    {
                        assetManager.scrapAsset(x);
                        assetManager.scrap.add(assetDetails);
                        fla=true;
                    }
                }
                if(!fla)
                {
                    System.out.println("Sorry, no data exists with the id " +asset_Names);
                }
                break;

            case 6:
                System.out.println("Enter the index whose asset need to be updated");
                int ind=0;
                for(Asset s : assetManager.assets)
                    System.out.println((ind++)+": "+s.getAssetName());
                int i=sc.nextInt();
                System.out.println("Press 1:update name\n" +
                        "2:update number\n" +
                        "3:update make\n" +
                        "4:update amout\n" +
                        "5:update invoice");
                int c=sc.nextInt();
                switch (c){
                    case 1: assetManager.updateName(i);
                            break;
                    case  2:assetManager.updateAmount(i);
                        break;
                    case 3:assetManager.updateMake(i);
                    break;
                    case 4:assetManager.updateAmount(i);
                    break;
                    case 5:assetManager.updateInvoice(i);
                    break;
                    default:System.out.println("Invalid input");
                }
                break;

            case 7:
                System.out.println("Asset details\n" +
                        "---------------------------------------------------------------------------");
                assetManager.display();
                break;

            case 8:
                System.out.println("Asset details along with brand details\n" +
                        "-----------------------------------------------------------------------------");
                assetManager.displayAlongWithBrand();
                break;

            case 9:
                System.out.println("Employees contain asset\n" +
                        "--------------------------------------------------------------------------");
                assetManager.emp.forEach(z->System.out.println(z.getAssetName()+" "+z.getAssetNumber()+" "+z.getMake()+" "+z.getAmount()+" "+z.getInvoiceDetails()+" "+z.getBrand().brandId+" "+z.getBrand().brandName+" "+z.getBrand().logo));
                break;

            case 10:
                System.out.println("Assets present in store with their brand details");
                assetManager.stores.forEach(y->System.out.println(y.getAssetName()+" "+y.getAssetNumber()+" "+y.getMake()+" "+y.getAmount()+" "+y.getInvoiceDetails()+" "+y.getBrand().brandId+" "+y.getBrand().brandName+" "+y.getBrand().logo));
                break;

                case 11:System.out.println("Brand Details\n" +
                        "------------------------------------------------------------------------------");
                        assetManager.displayBrandDetails();
                        break;
                case 12:System.out.println("Enter asset number");
                    int num=sc.nextInt();
                    boolean flags = false;
                    int as;
                    for( as=0; as<assetManager.assets.size();as++){
                        Asset assetDetails= assetManager.getDetails(as);
                        if(num == assetDetails.getAssetNumber())
                        {
                            System.out.println("The details of the asset with asset number  " +assetDetails.getAssetNumber() +" is: ");
                            System.out.print(assetDetails.getAssetName() +" " +assetDetails.getMake()+" " +assetDetails.getAmount()+" "+assetDetails.getInvoiceDetails());
                            flag = true;
                            break;
                        }
                    }
                    if(!flags)
                    {
                        System.out.println("Sorry, no data exists with the id " +num);
                    }
                    break;

                case 13:System.out.println("Enter asset number to check whether it is assigned to employee");
                    int ass=sc.nextInt();
                    boolean p = false;
                    int t;
                    for( t=0; t<assetManager.employees.size();t++){
                        Employee employeeDetails= assetManager.getList(t);
                        if(ass==employeeDetails.getAsset().getAssetNumber())
                        {
                            System.out.println("Asset "+ass+" is assigned to the employee");
                            p=true;
                            break;
                        }
                    }
                    if(!p){
                        System.out.println("Asset is not assigned to employee");
                    }
                    break;

            case 14:repeat=false;
                    break;
            default:
                System.out.println("Invalid expression");


        }}
}



}
