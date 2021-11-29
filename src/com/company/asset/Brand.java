package com.company.asset;

public class Brand {
    int brandId;
    String brandName;
    String logo;

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


    public int getBrandId() {
        return brandId;
    }

    public String getBrandName() {
        return brandName;
    }

    public String getLogo() {
        return logo;
    }
}
