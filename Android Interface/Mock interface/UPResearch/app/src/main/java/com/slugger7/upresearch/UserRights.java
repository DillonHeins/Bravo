package com.slugger7.upresearch;

/**
 * Created by Priscilla on 01-Apr-16.
 * This class will be used to store data retrieved from the JSON object - Used for
 *
 */

//import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

//@JsonIgnoreProperties(ignoreUnknown = true)
public class UserRights
{
    private String type;
    private Value value;

    public UserRights()
    {

    }

    public String getType()
    {
        return type;
    }

    public void setType(String type)
    {
        this.type = type;
    }

    public Value getValue()
    {
        return value;
    }

    @Override
    public String toString()
    {
        return "Quote{" +
                "type='" + type + '\'' +
                ", value=" + value +
                '}';
    }
}
