package com.example.innoapp.fragments;
//author Makar Shevchenko
import java.security.acl.Group;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;

/*
Class of events which contains information to generate event-cards
 */
public class Event {
    //parameters
    private String name;
    private Date date;
    private HashMap<String, String> data;
    private LinkedList<Group> groups;
    private boolean is_optional;
    private String place;

    //clear constructor
    Event()
    {
        this.name = "Event";
        this.date = new Date();
        this.place = "Innopolis";
        this.is_optional = true;
    }

    //constructor with inputs
    Event(String newName, Date newDate, HashMap<String, String> newData, LinkedList<Group> newGroups, boolean newIs_optional) {
        this.setName(newName);
        this.setDate(newDate);
        this.setData(newData);
        this.setGroups(newGroups);
        this.setIs_optional(newIs_optional);
    }

    //setters
    public void setName(String newName) {
        this.name = newName;
    }

    public void setDate(Date newDate) {
        this.date = newDate;
    }

    public void setData(HashMap<String,String> newData) {
        this.data = newData;
    }

    public void setGroups(LinkedList<Group> newGroups) {
        this.groups = newGroups;
    }

    public void setIs_optional(boolean newIs_optional) {
        this.is_optional = newIs_optional;
    }

    public void setPlace(String newPlace) {
        this.place = newPlace;
    }

    //getters
    public String getName() {
        return name;
    }

    public Date getDate() {
        return date;
    }

    public HashMap<String, String> getData() {
        return data;
    }

    public LinkedList<Group> getGroups() {
        return groups;
    }

    public boolean isIs_optional() {
        return is_optional;
    }

    public String getPlace() {
        return place;
    }
}