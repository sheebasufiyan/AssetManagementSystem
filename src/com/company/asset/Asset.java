package com.company.asset;

public class Asset {
    private String assetName;
    private int make;
    private int amount;
    private String invoiceDetails;
    private Brand brand;
    private int assetNumber;
    private int IMEI;
    private int store=1;
    private int scrap=0;


    public Asset() {}

    public Asset(String assetName, int assetNumber, int make, int amount, String invoiceDetails, Brand brand,int imei) {
        this.assetName = assetName;
        this.make = make;
        this.amount = amount;
        this.invoiceDetails = invoiceDetails;
        this.brand = brand;
        this.assetNumber = assetNumber;
        this.IMEI=imei;
    }

    public Asset(String assetName, int assetNumber, int make, int amount, String invoiceDetails, Brand brand) {
        this.assetName = assetName;
        this.make = make;
        this.amount = amount;
        this.invoiceDetails = invoiceDetails;
        this.brand = brand;
        this.assetNumber = assetNumber;

    }

    public void setAssetName(String name) {
        assetName = name;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public void setInvoiceDetails(String invoiceDetails) {
        this.invoiceDetails = invoiceDetails;
    }

    public void setMake(int make) {
        this.make = make;
    }

    public void setAssetNumber(int number) {
        assetNumber = number;
    }



    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    public void setStore(int store){
        this.store=store;
    }

    public void setScrap(int scrap){
        this.scrap=scrap;
    }

    public int getScrap() {
        return scrap;
    }

    public int getStore() {
        return store;
    }

    public String getAssetName() {
        return assetName;
    }

    public int getMake() {
        return make;
    }

    public String getInvoiceDetails() {
        return invoiceDetails;
    }

    public int getAmount() {
        return amount;
    }

    public int getAssetNumber() {
        return assetNumber;
    }

    public void setIMEI(int imei) {
        IMEI = imei;
    }

    public int getIMEI() {
        return IMEI;
    }

    public Brand getBrand() {
        return brand;
    }

    public boolean isScrapped()
    {
        if(scrap==1)
            return true;
        else
            return false;
    }
    public boolean isAssignedToEmployee()
    {
        if(store == 1)
            return true;
        else
            return false;
    }

}
