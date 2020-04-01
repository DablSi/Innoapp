package com.example.innoapp.utils;
// author Makar Shevchenko

import java.security.acl.Group;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;

/*
 *  Events class for event card generation
 */
@SuppressWarnings("WeakerAccess")
public class Event {
    private String name;
    private Date date;
    private HashMap<String, String> data;
    private LinkedList<Group> groups;
    private boolean is_optional;
    private String place;

    Event() {
        name = "Event";
        date = new Date();
        place = "Innopolis";
        is_optional = true;
    }

    Event(String newName, Date newDate, HashMap<String, String> newData, LinkedList<Group> newGroups, String newPlace, boolean newIs_optional) {
        setName(newName);
        setDate(newDate);
        setData(newData);
        setGroups(newGroups);
        setIs_optional(newIs_optional);
        setPlace(newPlace);
    }

    // setters
    public void setName(String newName) {
        name = newName;
    }

    public void setDate(Date newDate) {
        date = newDate;
    }

    public void setData(HashMap<String, String> newData) {
        data = newData;
    }

    public void setGroups(LinkedList<Group> newGroups) {
        groups = newGroups;
    }

    public void setIs_optional(boolean newIs_optional) {
        is_optional = newIs_optional;
    }

    public void setPlace(String newPlace) {
        place = newPlace;
    }

    // getters
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
