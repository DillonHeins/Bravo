package com.slugger7.upresearch;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;

public class RemoveFromGroup extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_remove_from_group);
//        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);



        Intent intent = getIntent();
        people = (People) intent.getSerializableExtra("people");
        peopleInGroup = (People) intent.getSerializableExtra("peopleInGroup");
        peopleNotInGroup = (People) intent.getSerializableExtra("peopleNotInGroup");
        final String group = getIntent().getStringExtra("group");
        ListAdapter adapter = new CustomListAdapter(this, peopleInGroup.toArray());
        ListView list = (ListView) findViewById(R.id.list_remove_from_group);
        list.setAdapter(adapter);

        list.setOnItemClickListener(
                new AdapterView.OnItemClickListener(){
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view1,
                                            int position, long id){
                        Person selected = (Person) parent.getItemAtPosition(position);
                        endResearchGroupAssociation(selected, group);
                    }
                }
        );
    }

    public void endResearchGroupAssociation(Person selected, final String group){
        //some server call. replace body below with correct code

        final View view = findViewById(R.id.coordinator_remove_from_group);
        if(selected.removeFromGroup(group)){
            //make a snackbar
            peopleInGroup.removePerson(selected);
            peopleNotInGroup.addPerson(selected);
            final String name = selected.getName();

            Snackbar.make(view, name + " successfully removed from group " + group, Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
            finish();
        }
        else{
            //make a snackbar
            Snackbar.make(view, "Something went wrong", Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
            finish();
        }
    }

    private People people, peopleInGroup, peopleNotInGroup;
}
