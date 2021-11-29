package com.company.asset;

import java.util.Scanner;

public class AssetController {
    public static void main(String args[]) {
//        Scanner s=new Scanner(System.in);
        Scanner sc = new Scanner(System.in);
        AssetManager assetManager = new AssetManager();
        Asset assets = new Asset();
        boolean repeat = true;
        assetManager.registerEmployee("Shamitha","09/02/2000","Davanagere", Designations.TRAINEE,1);
        assetManager.registerEmployee("Prakruthi","23/07/1999","577004", Designations.PROJECT_LEADER,2);
        assetManager.registerEmployee("Shakti","20/11/1999","Harihara", Designations.TRAINEE,4);
        assetManager.registerEmployee("Netra","09/03/2000","Bellary", Designations.SYSTEM_ENGINEER,3);
        assetManager.registerEmployee("Gagana","26/08/1999","Davanagere", Designations.SYSTEM_ENGINEER,5);
        assetManager.registerEmployee("Sharvari","09/02/2000","Davanagere", Designations.TRAINEE,1);
        assetManager.registerEmployee("Prerna","23/07/1999","577004", Designations.SYSTEM_ENGINEER,2);
        assetManager.registerEmployee("Samiya","20/11/1999","Harihara", Designations.TRAINEE,4);
        assetManager.registerEmployee("Nida","09/03/2000","Bellary", Designations.PROJECT_LEADER,3);
        assetManager.registerEmployee("Shifana","26/08/1999","Davanagere", Designations.TRAINEE,5);

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
                    Boolean condition = true;
                    if (assetNumbers > 10000000 && assetNumbers < 99999999) {

                        for (int ind = 0; ind < assetManager.assets.size(); ind++) {
                            Asset assetDetails = assetManager.get(ind);
                            if (assetNumbers == assetDetails.getAssetNumber()) {
                                System.out.println("Asset Number already exist, Enter a new asset number");
                                condition = false;

                            }
                        }
                        while (condition) {
                            if (assetName.equals("mobile")) {
                                System.out.println("brand id, brand name, logo,IMEI");
                                brandId = sc.nextInt();
                                brandName = sc.next();
                                logo = sc.next();
                                int IMEI = sc.nextInt();
                                brand = new Brand(brandId, brandName, logo);
                                assetManager.createBrand(brand);

                                Asset asset = new Asset(assetName, assetNumbers, make, amount, invoiceDetails, brand, IMEI);
                                assetManager.createAsset(asset);
                                System.out.println("Asset created successfully");
                                condition = false;
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
                    } else {
                        System.out.println("Enter 8 digits valid asset number");
                    }
                    break;
                case 2:System.out.println("Enter asset number to be deleted");
                    int assetNumber=sc.nextInt();
                    if(assetManager.assets.stream().filter(a->a.getAssetNumber()==assetNumber).findAny().orElse(null) != null)
                    {
                        assetManager.assets.remove(assetManager.assets.stream().filter(a -> a.getAssetNumber() == assetNumber).findAny().orElse(null));
                    }
                    else
                        System.out.println("Asset number is wrong");
                    break;
                case 3:assetManager.assignAssetToEmployee();
                    break;
                case 4:assetManager.returnBackToStore();
                    break;
                case 5:assetManager.addToScrapList();
                    break;
                case 6:assetManager.updateAsset();
                    break;
                case 7:assetManager.displayAsset();
                    break;
                case 8:assetManager.displayAssetWithBrand();
                    break;
                case 9:assetManager.displayEmployee();
                    break;
                case 10:assetManager.displayStore();
                    break;
                case 11:assetManager.displayBranddetails();
                    break;
                case 12:assetManager.assetDetailsFromAssetNumber();
                    break;
                case 13:assetManager.assignedAssetToEmployee();
                    break;
                case 14:repeat=false;
                    break;
                default:System.out.println("Invalid Choice");
            }

        }
    }
}
