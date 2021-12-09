package com.company.asset;

public class Asset {
    private String assetName;
    private int make;
    private int amount;
    private String invoiceDetails;
    private Brand brand;
    private int assetNumber;
    private TypeOf type;
    private long IMEI;
    private boolean assignedTo=false;
    private boolean isScrapped=false;


    public Asset() {}

    public Asset(String assetName, int assetNumber, int make, int amount, String invoiceDetails, Brand brand,TypeOf type,long imei,boolean assignedTo,boolean isScrapped) {
        this.assetName = assetName;
        this.make = make;
        this.amount = amount;
        this.invoiceDetails = invoiceDetails;
        this.brand = brand;
        this.assetNumber = assetNumber;
        this.IMEI=imei;
        this.isScrapped=isScrapped;
        this.assignedTo=assignedTo;
        this.type=type;
    }

    public Asset(String assetName, int assetNumber, int make, int amount, String invoiceDetails, Brand brand,TypeOf type,boolean isScrapped,boolean assignedTo) {
        this.assetName = assetName;
        this.make = make;
        this.amount = amount;
        this.invoiceDetails = invoiceDetails;
        this.brand = brand;
        this.assetNumber = assetNumber;
        this.type=type;
        this.assignedTo=assignedTo;
        this.isScrapped=isScrapped;

    }

    public void setType(TypeOf type){
        this.type=type;
    }

    public TypeOf getType() {
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

    public void setAssignedTo(boolean assignedTo){
        this.assignedTo=assignedTo;
    }

    public void setScrapped(boolean isScrapped){
        this.isScrapped=isScrapped;
    }

    public boolean getScrapped() {
        return isScrapped;
    }

    public boolean getAssignedTo() {
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
        IMEI = imei;
    }

    public long getIMEI() {
        return IMEI;
    }

    public Brand getBrand() {
        return brand;
    }

}
