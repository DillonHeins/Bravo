package com.slugger7.upresearch;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by Duncan on 2016/04/14.
 */
public class ChangePublication extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_publication);

        //displaying the information of the publication
        EditText edtPubName = (EditText) findViewById(R.id.edtPubName);
        EditText edtPubWeb = (EditText) findViewById(R.id.edtPubWebSite);
        EditText edtDue = (EditText) findViewById(R.id.edtDueDate);
        TextView txtProg = (TextView) findViewById(R.id.txtProgress);
        SeekBar skbProg = (SeekBar) findViewById(R.id.skbProgress);
        CheckBox cbxComplete = (CheckBox) findViewById(R.id.cbxIsCompleted);
        CheckBox cbxAct = (CheckBox) findViewById(R.id.cbxActive);

        //insert the new values into the components
        Publication curr = Globals.getPublications().get(Globals.getCurrentPublicationIndex());
        edtPubName.setText(curr.getName());
        edtPubWeb.setText(curr.getUrl());
        edtDue.setText(curr.getDueDate());
        txtProg.setText(curr.getProgress() + "%");
        skbProg.setProgress(curr.getProgress());
        cbxComplete.setChecked(curr.getActive());
        cbxAct.setChecked(curr.getActive());

        Button submit = (Button) findViewById(R.id.btnSubmit);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
