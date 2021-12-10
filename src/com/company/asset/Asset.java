package com.company.asset;

public class Asset {
    private String assetName;
    private int make;
    private int amount;
    private String invoiceDetails;
    private Brand brand;
    private int assetNumber;
    private AssetType type;
    private long imei;
    private int assignedTo=0;
    private boolean isScrapped=false;


    public Asset() {}

    public Asset(String assetName, int assetNumber, int make, int amount, String invoiceDetails, Brand brand, AssetType type, long imei) {
        this.assetName = assetName;
        this.make = make;
        this.amount = amount;
        this.invoiceDetails = invoiceDetails;
        this.brand = brand;
        this.assetNumber = assetNumber;
        this.imei=imei;
        this.type=type;
    }

    public Asset(String assetName, int assetNumber, int make, int amount, String invoiceDetails, Brand brand, AssetType type) {
        this.assetName = assetName;
        this.make = make;
        this.amount = amount;
        this.invoiceDetails = invoiceDetails;
        this.brand = brand;
        this.assetNumber = assetNumber;
        this.type=type;
    }

    public void setType(AssetType type){
        this.type=type;
    }

    public AssetType getType() {
        return type;
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

    public void setAssignedTo(int assignedTo){
        this.assignedTo=assignedTo;
    }

    public void setScrapped(boolean isScrapped){
        this.isScrapped=isScrapped;
    }

    public boolean getScrapped() {
        return isScrapped;
    }

    public int getAssignedTo() {
        return assignedTo;
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

    public void setIMEI(long imei) {
        this.imei = imei;
    }

    public long getIMEI() {
        return imei;
    }

    public Brand getBrand() {
        return brand;
    }

}
