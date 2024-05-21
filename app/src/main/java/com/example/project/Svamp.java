package com.example.project;

import com.google.gson.annotations.SerializedName;

public class Svamp {
    private String name;
    private String location;
    private String category;
    private String size;


    public String getName(){
        return name;
    }
    public String getLocation(){
        return location;
    }
    public String getCategory(){
        return category;
    }
    public String getSize(){
        return size;
    }


    public void setName(){
        this.name = name;
    }
    public void setLocation(){
        this.location = location;
    }
    public void setCategory(){
        this.category = category;
    }
    public void setSize(){
        this.size = size;
    }
}
