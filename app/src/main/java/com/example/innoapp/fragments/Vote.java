package com.example.innoapp.fragments;

public class Vote {
    public String id;
    public String name;
    public String[] variants;
    public boolean multiple;
    public String groupName;

    public Vote(String id, String name, String[] variants, boolean multiple, String groupName) {
        this.id = id;
        this.name = name;
        this.variants = variants;
        this.multiple = multiple;
        this.groupName = groupName;
    }
}
