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
import android.widget.CheckBox;
import android.widget.SeekBar;
import android.widget.TextView;

import org.w3c.dom.Text;

public class ViewPublication extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_publication);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        TextView name = (TextView) findViewById(R.id.textName);
        TextView url = (TextView) findViewById(R.id.textURL);
        TextView dueDate = (TextView) findViewById(R.id.textDueDate);
        CheckBox isComplete = (CheckBox) findViewById(R.id.checkBoxComplete);
        CheckBox isActive = (CheckBox) findViewById(R.id.checkBoxActive);
        SeekBar progress = (SeekBar) findViewById(R.id.seekBarProgress);
        TextView progressText = (TextView) findViewById(R.id.textProgressAmount);

        Publication publication = Globals.getPublications().get(Globals.getCurrentPublicationIndex());

        name.setText(publication.getName());
        url.setText(publication.getUrl());
        dueDate.setText(publication.getDueDate());
        isComplete.setChecked(publication.getComplete());
        isComplete.setEnabled(false);
        isActive.setChecked(publication.getActive());
        isActive.setEnabled(false);
        progress.setProgress(publication.getProgress());
        progress.setEnabled(false);
        progressText.setText(publication.getProgress() + "%");

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_publication, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.action_modify_publication:
                Intent intent = new Intent(ViewPublication.this, AddPublication.class);
                startActivity(intent);
                return true;
            case R.id.action_logout:
                System.exit(0);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
