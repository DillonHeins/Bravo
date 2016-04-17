package com.slugger7.upresearch;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class Publications extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_publications);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        assert fab != null;
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Add New Publication", Snackbar.LENGTH_LONG)
                        .setAction("Add", new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Globals.setCurrentPublicationIndex(-1);
                                //Load addPublication activity
                                Intent intent = new Intent(Publications.this, AddPublication.class); // Creating the intent to start a new activity
                              //  finish(); // Closing the current activity
                                startActivity(intent); // Starting the new activity
                            }
                        }).show();
            }
        });

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        assert toolbar != null;
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        //Populate List of Publications
        ListView publications = (ListView) findViewById(R.id.listViewPublications);
        assert publications != null;
        publications.setOnItemClickListener(new ListView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> adapter, View v, int position, long arg3)
            {
                Globals.setCurrentPublicationIndex(position);
                Intent intent = new Intent(Publications.this, ViewPublication.class);
                //finish();
                startActivity(intent);
            }
        });

        List<Publication> publicationsList = Globals.getPublications();

        ArrayAdapter<Publication> arrayAdapter = new ArrayAdapter<Publication>(this, android.R.layout.simple_list_item_1, publicationsList );
        publications.setAdapter(arrayAdapter);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
