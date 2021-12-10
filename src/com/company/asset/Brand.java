package com.company.asset;

public class Brand {
    int id;
    String name;
    String logo;

    Brand(int id, String name,String logo){
        this.id=id;
        this.name=name;
        this.logo=logo;
    }

    public void setBrandId(int id){
        this.id=id;
    }
    public void setBrandName(String name){
        this.name=name;
    }
    public void setLogo(String logo){
        this.logo=logo;
    }


    public int getBrandId() {
        return id;
    }

    public String getBrandName() {
        return name;
    }

    public String getLogo() {
        return logo;
    }
}
