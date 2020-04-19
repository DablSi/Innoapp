package com.example.innoapp.fragments;
// author Makar Shevchenko

import java.io.Serializable;
import java.util.Date;
import java.util.LinkedList;



/*
 *  Класс событий для генерации карточек событий
 */
@SuppressWarnings("serial") //With this annotation we are going to hide compiler warnings
public class Event implements Comparable<Event>, Serializable {
    public String id;
    public String name;
    public Date date;
    public Date dateEnd;
    public LinkedList<String> groups;
    public boolean is_optional;
    public String place;
    public String description;
    public int countVisitors;
    public boolean participation;
    // Название, дата(месяцы: 0-11, остальное - нормально), дата конца, группы, кастомное,
    // место, описание, количество посетителей, идет ли
    public Event(String id, String newName, Date newDate, Date newDateEnd, LinkedList<String> newGroups,
                 boolean newIs_optional, String newPlace, String newDescription,
                 int newCountVisitors, boolean newParticipation) {
        this.id = id;
        name = newName;
        date = newDate;
        dateEnd = newDateEnd;
        groups = newGroups;
        is_optional = newIs_optional;
        place = newPlace;
        description = newDescription;
        countVisitors = newCountVisitors;
        participation = newParticipation;
    }

    @Override
    public int compareTo(Event o) {
        return (int) (this.date.getTime() - o.date.getTime());
    }



}
