package com.slugger7.upresearch;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView username;
    private TextView password;
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
        username = (TextView) findViewById(R.id.txt_username);
        password = (TextView) findViewById(R.id.txt_password);

        assert username != null;
        assert password != null;
        //checking username and password
        if ("cos301".equals(username.getText().toString()) && password.getText().toString().equals("password"))
        {
            Intent intent = new Intent(this, home.class); // Creating the intent to start a new activity
            finish(); // Closing the current activity
            getAccessRights();
            startActivity(intent); // Starting the new activity
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

    /**
     * This function sends a request to the server for user access rights and will receive those rights as well as if the user
     * is authorised for any acess at all.
     * @return boolean array
     */
    public void getAccessRights()
    {

    }
}
