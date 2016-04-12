package com.slugger7.upresearch;

/**
 * Created by Priscilla on 01-Apr-16.
 */
public class Value
{

    private Long id;
    private String userRights;

    public Value() {
    }

    public Long getId() {
        return this.id;
    }

    public String getUserRights() {
        return this.userRights;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setUserRights(String userRights) {
        this.userRights = userRights;
    }

    @Override
    public String toString()
    {
        return "Value{" +
                "id=" + id +
                ", quote='" + quote + '\'' +
                '}';
    }
}
