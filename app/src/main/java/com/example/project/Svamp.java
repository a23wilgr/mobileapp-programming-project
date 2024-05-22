package com.example.project;

import androidx.annotation.NonNull;

import com.google.gson.annotations.SerializedName;

public class Svamp {
    @SerializedName("ID")
    public String id;
    @SerializedName("name")
    public String name;
    @SerializedName("category")
    public String category;
    @SerializedName("location")
    public String location;
    @SerializedName("size")
    public String size;


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
