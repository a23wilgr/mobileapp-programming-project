package com.example.project;

import com.google.gson.annotations.SerializedName;

public class Svamp {
    @SerializedName("name")
    private String name;
    @SerializedName("category")
    private String category;
    @SerializedName("location")
    private String location;
    @SerializedName("size")
    private String size;


    public Svamp(String name, String category, String location, String size){
        this.name = name;
        this.category = category;
        this.location = location;
        this.size = size;
    }

    public String getName() {
        return name;
    }
    public String getCategory() {
        return category;
    }
    public String getLocation() {
        return location;
    }

    public String getSize() {
        return size;
    }

}
