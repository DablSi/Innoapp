package com.example.innoapp.fragments;
// author Makar Shevchenko

import java.io.Serializable;
import java.util.Date;
import java.util.LinkedList;



/*
 *  Класс событий для генерации карточек событий
 */
@SuppressWarnings("serial") //With this annotation we are going to hide compiler warnings
public class Event implements Serializable {
    public String id;
    private String name;
    private Date date;
    private Date dateEnd;
    private LinkedList<String> groups;
    private boolean is_optional;
    private String place;
    private String description;
    private int countVisitors;
    private boolean participation;
    private String tabName;

    public Event() {
        name = "Event";
        date = new Date();
        dateEnd = new Date();
        is_optional = true;
        place = "Innopolis";
        description = "";
        countVisitors = 0;
        participation = false;
        tabName = "01.01";
    }

    // Название, дата(месяцы: 0-11, остальное - нормально), дата конца, группы, кастомное,
    // место, описание, количество посетителей, идет ли
    public Event(String id, String newName, Date newDate, Date newDateEnd, LinkedList<String> newGroups,
                 boolean newIs_optional, String newPlace, String newDescription,
                 int newCountVisitors, boolean newParticipation) {
        this.id = id;
        setName(newName);
        setDate(newDate);
        setDateEnd(newDateEnd);
        setGroups(newGroups);
        setIs_optional(newIs_optional);
        setPlace(newPlace);
        setDescription(newDescription);
        setCountVisitors(newCountVisitors);
        setParticipation(newParticipation);
    }

    public boolean compare(Event obj) {
        if (name.equals(obj.getName()) && date.equals(obj.getDate()) &&
                dateEnd.equals(obj.getDateEnd()) && is_optional == obj.is_optional &&
                groups.equals(obj.getGroups()))
            return true;
        return false;
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

    public void setGroups(LinkedList<String> newGroups) {
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

    public void setParticipation(boolean newParticipation) {
        participation = newParticipation;
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

    public LinkedList<String> getGroups() {
        return groups;
    }

    public boolean getIs_optional() {
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

    public boolean getParticipation() {
        return participation;
    }
}
