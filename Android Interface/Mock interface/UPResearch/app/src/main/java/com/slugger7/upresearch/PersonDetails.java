package com.slugger7.upresearch;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.Switch;

public class PersonDetails extends AppCompatActivity {
    private EditText name, surname, email, cellphone, username, staffnumber;
    private Switch notifications;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_person_details);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        name = (EditText) findViewById(R.id.name_details);
        surname = (EditText) findViewById(R.id.surname_details);
        email = (EditText) findViewById(R.id.email_details);
        cellphone = (EditText) findViewById(R.id.cellphone_details);
        username = (EditText) findViewById(R.id.username_details);
        staffnumber = (EditText) findViewById(R.id.staffnumber_details);
        notifications = (Switch) findViewById(R.id.notifications_details);
        setData();
    }

    private void setData() {
        name.setText(Globals.getName());
        surname.setText(Globals.getSurname());
        email.setText(Globals.getEmail());
        cellphone.setText(Globals.getCellphone());
        username.setText(Globals.getUsername());
        staffnumber.setText(Globals.getStaffnumber());
        notifications.setChecked(Globals.getNotifications());
    }

    public void validateDetails(View view) {
        Boolean ret = true;

        if (name.getText().toString().length() == 0)
            ret = false;
        if (surname.getText().toString().length() == 0)
            ret = false;
        if (email.getText().toString().length() == 0 || email.getText().toString().indexOf('@') == 0)
            ret = false;
        if (username.getText().toString().length() == 0)
            ret = false;
        if (staffnumber.getText().toString().length() == 0)
            ret = false;
        if (cellphone.getText().toString().length() == 0 || cellphone.getText().toString().length() > 10)
            ret = false;

        if (ret)
        {
            Globals.setName(name.getText().toString());
            Globals.setSurname(surname.getText().toString());
            Globals.setEmail(email.getText().toString());
            Globals.setUsername(username.getText().toString());
            Globals.setStaffnumber(staffnumber.getText().toString());
            Globals.setCellphone(cellphone.getText().toString());
            Globals.setNotifications(notifications.isChecked());
            Globals.updateData();
            finish();
        }
        else
        {
            Snackbar.make(view, "Please fill in all data", Snackbar.LENGTH_LONG).show();
        }
    }
}
