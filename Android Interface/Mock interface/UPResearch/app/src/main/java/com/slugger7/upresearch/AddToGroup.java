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
import android.widget.TextView;

import java.util.ArrayList;

public class AddToGroup extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_to_group);
//        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);



        //TODO: get list of people not in the group from server
        //some server call. replace below paragraph with correct code
        Intent intent = getIntent();
        people = (People) intent.getSerializableExtra("people");
        peopleInGroup = (People) intent.getSerializableExtra("peopleInGroup");
        peopleNotInGroup = (People) intent.getSerializableExtra("peopleNotInGroup");
        final String group = getIntent().getStringExtra("group");
        ListAdapter adapter = new CustomListAdapter(this, peopleNotInGroup.toArray());
        ListView list = (ListView) findViewById(R.id.list_add_to_group);
        list.setAdapter(adapter);

        list.setOnItemClickListener(
                new AdapterView.OnItemClickListener(){
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view1,
                                            int position, long id){
                        Person selected = (Person) parent.getItemAtPosition(position);
                        addResearchGroupAssociation(selected, group);
                    }
                }
        );
    }

    /**
     * This function allows someone with Research Group Leader access
     * rights to add users to the list of their current research group.
     * @param selected  - Person object that will be added to a group
     * @param group     - name of the additonal research group
     */
    public void addResearchGroupAssociation(Person selected, final String group){
        //first search for the user
//        Person old = selected;
        final View view = findViewById(R.id.coordinator_add_to_group);
        if(selected.addToGroup(group)){
            //make a snackbar
            peopleInGroup.addPerson(selected);
            peopleNotInGroup.removePerson(selected);
            final String name = selected.getName();

            Snackbar.make(view, name + " successfully added to group " + group, Snackbar.LENGTH_LONG)
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
