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
        String str=name;
        str+=" belongs to the family ";
        str+=category;
        str+= ". Can be found near ";
        str+=location;
        str+=" and is ";
        str+=size;
        str+="cm tall.";
        return str;
    }
    public String getTitle(){
        String str=name;
        str+=" belongs to the family ";
        str+=category;
        str+= ". It can be found near ";
        str+=location;
        str+=", and is ";
        str+=size;
        str+="cm tall.";
        return str;
    }

}
