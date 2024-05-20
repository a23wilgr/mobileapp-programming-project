package com.example.project;

import com.google.gson.annotations.SerializedName;
public class Svamp{
    @SerializedName("name")
    private String name;
    public Svamp(String name){
        this.name=name;
    }
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name=name;
    }
    @Override
    public String toString(){
        return name;
    }
    public String getTitle(){
        return name;
    }
}