package com.example.innoapp.utils;

public class Vote {
    public String id;
    public String name;
    public String[] variants;
    public Integer[] voted;
    public boolean multiple;
    public String groupName;

    public Vote(String id, String name, String[] variants, Integer[] voted, boolean multiple, String groupName) {
        this.id = id;
        this.name = name;
        this.variants = variants;
        this.multiple = multiple;
        this.groupName = groupName;
        this.voted = voted;
    }
}