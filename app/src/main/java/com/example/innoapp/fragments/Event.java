package com.example.innoapp.fragments;
// author Makar Shevchenko
import java.security.acl.Group;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;

/*
 *  Класс событий для генерации карточек событий
 */
public class Event {
    private String name;
    private Date date;
    private Date dateEnd;
    private LinkedList<Group> groups;
    private boolean is_optional;
    private String place;
    private String description;
    private int countVisitors;

    public Event()
    {
        name = "Event";
        date = new Date();
        dateEnd = new Date();
        is_optional = true;
        place = "Innopolis";
        description = "";
        countVisitors = 0;
    }

    // Название, дата, дата конца, группы, кастомное, место, описание, количество посетителей
    public Event(String newName, Date newDate, Date newDateEnd, LinkedList<Group> newGroups, boolean newIs_optional, String newPlace, String newDescription, int newCountVisitors) {
        setName(newName);
        setDate(newDate);
        setDateEnd(newDateEnd);
        setGroups(newGroups);
        setIs_optional(newIs_optional);
        setPlace(newPlace);
        setDescription(newDescription);
        setCountVisitors(newCountVisitors);
    }

    // setters
    public void setName(String newName) {
        name = newName;
    }

    public void setDate(Date newDate) {
        date = newDate;
    }

    public void setDateEnd(Date newDateEnd) {
        dateEnd = newDateEnd;
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

    public void setDescription(String newDescription) {
        description = newDescription;
    }

    public void setCountVisitors(int newCountVisitors) {
        countVisitors = newCountVisitors;
    }

    // getters
    public String getName() {
        return name;
    }

    public Date getDate() {
        return date;
    }

    public Date getDateEnd() {
        return dateEnd;
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

    public String getDescription() {
        return description;
    }

    public int getCountVisitors() {
        return countVisitors;
    }
}
