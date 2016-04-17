package com.slugger7.upresearch;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class ResearchGroup extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_research_group);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);

        String work[] = {"artificial", "compiler", "graphics", "genetics", "quantum computing", "databases"};
        //Person res
        Person kevin = new Person("Kevin", "Heritage", "artificial");
        Person duncan = new Person("Duncan", "Smallwood");
        Person priscilla = new Person("Priscilla", "Madigoe", "compiler");
        priscilla.addToGroup("graphics");
        Person nathan = new Person("Nathan", "Dunkley", "graphics");
        nathan.addToGroup("artificial");
        Person tim = new Person("Timothy", "Kirker", "genetics");
        Person vukile = new Person("Vukile", "Langa");

        ArrayList<Person> peopleList = new ArrayList<Person>();
        peopleList.add(kevin);
        peopleList.add(duncan);
        peopleList.add(priscilla);
        peopleList.add(nathan);
        peopleList.add(tim);
        peopleList.add(vukile);
        final People people = new People(peopleList);


        ListAdapter adapter = new CustomStringListAdapter(this, work);

        ListView list = (ListView) findViewById(R.id.list_item);
        list.setAdapter(adapter);

        list.setOnItemClickListener(
                new android.widget.AdapterView.OnItemClickListener(){
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view,
                                            int position, long id){
                        //some server call to get group items
                        String group = String.valueOf(parent.getItemAtPosition(position));
//                        Toast.makeText(ResearchGroup.this, group, Toast.LENGTH_LONG).show();

                        Intent intent = new Intent(ResearchGroup.this, ViewResearchGroup.class);
                        intent.putExtra("selected", group);
                        intent.putExtra("people", people);
                        startActivity(intent);
                    }
                }
        );
    }


    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        assert drawer != null;
        if (drawer != null && drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }
}
