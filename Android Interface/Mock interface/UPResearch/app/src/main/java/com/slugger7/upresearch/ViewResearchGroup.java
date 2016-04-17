package com.slugger7.upresearch;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListAdapter;
import android.widget.ListView;

public class ViewResearchGroup extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_research_group);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });

        Intent intent = getIntent();
        people = (People) intent.getSerializableExtra("people");
        peopleInGroup = new People(people);
        peopleNotInGroup = new People(people);
        group = intent.getStringExtra("selected");
        peopleInGroup.removePeople(false, group);
        peopleNotInGroup.removePeople(true, group);

        ListAdapter adapter = new CustomListAdapter(this, peopleInGroup.toArray());
        ListView list = (ListView) findViewById(R.id.list_view_research_group);
        list.setAdapter(adapter);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu_view_research_group, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        int id = item.getItemId();
        Intent intent = null;

        if(id == R.id.add_user_to_group){
            intent = new Intent(this, AddToGroup.class);
            intent.putExtra("people", people);
            intent.putExtra("peopleInGroup", peopleInGroup);
            intent.putExtra("peopleNotInGroup", peopleNotInGroup);
            intent.putExtra("group", group);
        }

        if(id == R.id.remove_user_from_group){
            intent = new Intent(this, RemoveFromGroup.class);
            intent.putExtra("people", people);
            intent.putExtra("peopleInGroup", peopleInGroup);
            intent.putExtra("peopleNotInGroup", peopleNotInGroup);
            intent.putExtra("group", group);
        }

        if(intent != null){
            //finish();
            startActivity(intent);
        }

        return true;
    }

    @Override
    public void onBackPressed(){
        finish();
    }

    People people, peopleInGroup, peopleNotInGroup;
    String group;
}
