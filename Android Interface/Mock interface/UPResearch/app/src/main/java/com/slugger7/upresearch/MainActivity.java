package com.slugger7.upresearch;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    /**
     * Function that is called by the login button on content_main.xml
     * @param view the current view that the function is called from
     */
    public void login(View view) {
        //Getting the text fields
        EditText username = (EditText) findViewById(R.id.txt_username);
        EditText password = (EditText) findViewById(R.id.txt_password);
        boolean[] userRights;
        assert username != null;
        assert password != null;
        //checking username and password
        if ("cos301".equals(username.getText().toString()) && (password.getText().toString().equals("user") || password.getText().toString().equals("hor") || password.getText().toString().equals("admin")) )
        {
            setUserDetails(MockUserDetails.getUserDetails(username.getText().toString()));
            userRights = getAccessRights(username, password);

            Intent intent = new Intent(this, home.class);
            intent.putExtra("User Rights", userRights);

            finish(); // Closing the current activity

            startActivity(intent); // Starting the new activity

            if (!Globals.validate())
            {
                Intent userintent = new Intent(this, PersonDetails.class);
                startActivity(userintent);
            }
        }
        else
        {
            //Display error message that username or password was incorrect
            Snackbar.make(view, "Incorrect username or password", Snackbar.LENGTH_LONG).setAction("Action", null).show();

            // Clear the password field and set the focus to the username field
            password.setText("");
            username.requestFocus();
        }

    }

    public void setUserDetails(String json)
    {
        try {
            JSONObject details = new JSONObject(json);
            Globals.setName(details.getString("name"));
            Globals.setSurname(details.getString("surname"));
            Globals.setCellphone(details.getString("cellphone"));
            Globals.setEmail(details.getString("email"));
            Globals.setNotifications(details.getBoolean("notifications"));
            Globals.setStaffnumber(details.getString("staffnumber"));
            Globals.setUsername(details.getString("username"));
        }
        catch (Exception ex)
        {}
    }
    /**
     * This function sends a request to the server for user access rights and will receive those rights as well as if the user
     * is authorised for any access at all.
     * @return boolean array
     */

    public boolean[] getAccessRights(EditText username, EditText password)
    {
      boolean accessRights[] = new boolean[3];

      //Initialize boolean array
      for(int i = 0; i < accessRights.length; i++)
      {
          accessRights[i] = false;
      }

      //Check user type
      switch(password.getText().toString())
      {
          case "user": accessRights[0] = true; break;
          case "hor" : accessRights[1] = true; break;
          case "admin": accessRights[2] = true; break;
      }

        return accessRights;
    }
}
