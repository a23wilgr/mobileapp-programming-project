package com.example.project;

import androidx.annotation.NonNull;

import com.google.gson.annotations.SerializedName;

public class Svamp {
    @SerializedName("ID")
    private String id;
    @SerializedName("name")
    private String name;
    @SerializedName("category")
    private String category;
    @SerializedName("location")
    private String location;
    @SerializedName("size")
    private String size;


    public Svamp(String name){
        this.id = id;
        this.name = name;
        this.category = category;
        this.location = location;
        this.size = size;
    }

    @NonNull
    @Override
    public String toString(){
        return name + "Belongs to the family " + category + "Can be found in/near " + location + " and is " + size + "cm tall";
    }
    public String getTitle(){
        return name + "Belongs to the family " + category + "Can be found in/near " + location + " and is " + size + "cm tall";
    }

}
