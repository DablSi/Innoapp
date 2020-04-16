package com.example.innoapp.fragments;

import java.util.HashMap;

public class Group {
    public String name;
    public HashMap<String, String> questions;

    public Group(String name, HashMap<String, String> questions) {
        this.name = name;
        this.questions = questions;
    }
}
