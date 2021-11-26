package com.company.asset;

public class Brand {
    int brandId;
    String brandName;
    String logo;
    int IMEI;

    Brand(int brandId, String brandName,String logo,int IMEI){
        this.brandId=brandId;
        this.brandName=brandName;
        this.logo=logo;
        this.IMEI=IMEI;

    }
    Brand(int brandId, String brandName,String logo){
        this.brandId=brandId;
        this.brandName=brandName;
        this.logo=logo;

    }
    public void setBrandId(int brandId){
        this.brandId=brandId;
    }
    public void setBrandName(String brandName){
        this.brandName=brandName;
    }
    public void setLogo(String logo){
        this.logo=logo;
    }
    public void setIMEI(int IMEI){
        this.IMEI=IMEI;
    }

    public int getBrandId() {
        return brandId;
    }

    public String getBrandName() {
        return brandName;
    }

    public int getIMEI() {
        return IMEI;
    }

    public String getLogo() {
        return logo;
    }
}
