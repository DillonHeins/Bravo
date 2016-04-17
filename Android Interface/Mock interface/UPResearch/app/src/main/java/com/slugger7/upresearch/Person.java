package com.slugger7.upresearch;

import java.io.Serializable;
import java.util.ArrayList;

public class Person implements Serializable {
    String firstName;
    String lastName;
    ArrayList<String> groups;

    Person(String f, String l) {
        firstName = f;
        lastName = l;
        groups = new ArrayList<String>();
    }

    Person(String f, String l, String g){
        this(f, l);
        addToGroup(g);
    }

    public boolean addToGroup(String g){
        if(groups.contains(g)) return false;
        groups.add(g);
        return true;
    }

    public boolean removeFromGroup(String g){
        if(groups.isEmpty() || !groups.contains(g)) return false;

        groups.remove(groups.indexOf(g));
        return true;
    }

    public String getName(){
        return firstName + " " + lastName;
    }

    @Override
    public String toString(){
        return getName();
    }
}
