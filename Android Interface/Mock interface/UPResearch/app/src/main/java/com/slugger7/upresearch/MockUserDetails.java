package com.slugger7.upresearch;

/**
 * Created by Slugger7 on 4/14/2016.
 */
public class MockUserDetails {
    public static String getUserDetails(String username)
    {
        return "{name : 'Kevin', " +
                "surname : 'Heritage', " +
                "email : 'kheritage222@gmail.com', " +
                "staffnumber : '13044924', " +
                "notifications : 'false', " +
                "username : 'slugger7', " +
                "cellphone : '0767405640'}";
    }

    public static String getUserList()
    {
        return "{userlist : [{username : 'slugger7'}, " +
                "{username : 'slugger8'}]}";
    }
}
