package com.slugger7.upresearch;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class People implements Serializable{
    private ArrayList<Person> mPeople;
    private List<Person> lp;

    People(ArrayList<Person> people){
        mPeople = people;
    }

    People(People other){
        mPeople = new ArrayList<Person>();
        for (int i = 0; i < other.size(); i++) {
            mPeople.add(other.mPeople.get(i));
        }
    }

    public List<Person> getPeople(){
        lp = mPeople;
        return lp;
    }

    public Person[] toArray(){
        return mPeople.toArray(new Person[0]);
    }

    public String[] getNames(){
        ArrayList<String> names = new ArrayList<String>();
        for (int i = 0; i < mPeople.size(); i++) {
            names.add(mPeople.get(i).getName());
        }

        return names.toArray(new String[0]);
    }

    public void removePeople(boolean thisGroup, String group){
        ArrayList<Person> newPeople = new ArrayList<Person>();
        Person trav; //used to traverse mPeople
        if(thisGroup){
            for (int i = 0; i < mPeople.size(); i++) {
                trav = mPeople.get(i);
                if(!trav.groups.contains(group)) newPeople.add(trav);
            }
        }
        else{
            for (int i = 0; i < mPeople.size(); i++) {
                trav = mPeople.get(i);
                if(trav.groups.contains(group)) newPeople.add(trav);
            }
        }

        mPeople = newPeople;
    }

    public int size(){
        return mPeople.size();
    }

    public void addPerson(Person p){
        mPeople.add(p);
    }

    public void removePerson(Person p){
        if(!mPeople.contains(p)) return;
        mPeople.remove(p);
    }


}
