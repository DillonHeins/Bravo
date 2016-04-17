package com.slugger7.upresearch;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;

public class AddPublication extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_publication);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        //Display Progress on SeekBar
        final TextView publicationProgressHeadingText = (TextView) findViewById(R.id.textProgress);
        final TextView publicationProgressText = (TextView) findViewById(R.id.textProgressAmount);
        publicationProgressText.setText("0%");
        CheckBox isComplete = (CheckBox) findViewById(R.id.checkBoxComplete);
        CheckBox active = (CheckBox) findViewById(R.id.checkBoxActive);
        EditText name = (EditText) findViewById(R.id.editName);
        EditText url = (EditText) findViewById(R.id.editURL);
        EditText dueDate = (EditText) findViewById(R.id.editDueDate);
        final SeekBar publicationProgress = (SeekBar) findViewById(R.id.seekBarProgress);

        if (Globals.getCurrentPublicationIndex() > -1) {
            Publication publication = Globals.getPublications().get(Globals.getCurrentPublicationIndex());

            name.setText(publication.getName());
            url.setText(publication.getUrl());
            dueDate.setText(publication.getDueDate());
            isComplete.setChecked(publication.getComplete());
            active.setChecked(publication.getActive());
            publicationProgress.setProgress(publication.getProgress());
            publicationProgressText.setText(publication.getProgress() + "%");
        }
        else {
            active.setChecked(true);
        }

        if (isComplete != null) {
            isComplete.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView,boolean isChecked) {
                    if (isChecked) {
                        publicationProgress.setProgress(100);
                        publicationProgressText.setText("100%");
                        publicationProgress.setEnabled(false);
                    }
                    else {
                        publicationProgress.setProgress(0);
                        publicationProgressText.setText("0%");
                        publicationProgress.setEnabled(true);
                    }
                }
            });
        }

        //On change event listener for SeekBar
        publicationProgress.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                publicationProgressText.setText(String.valueOf(progress) + "%");
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

    public void submitPublication(View view) {
        if (validateForm()) {
            EditText name = (EditText) findViewById(R.id.editName);
            EditText url = (EditText) findViewById(R.id.editURL);
            EditText dueDate = (EditText) findViewById(R.id.editDueDate);
            CheckBox isComplete = (CheckBox) findViewById(R.id.checkBoxComplete);
            CheckBox isActive = (CheckBox) findViewById(R.id.checkBoxActive);
            SeekBar progress = (SeekBar) findViewById(R.id.seekBarProgress);
            if (Globals.getCurrentPublicationIndex() == -1) {
                Publication publication = new Publication(name.getText().toString(), url.getText().toString(), dueDate.getText().toString(), isComplete.isChecked(), progress.getProgress(), true, 1);
                Globals.getPublications().add(publication);
            }
            else {
                Publication publication = Globals.getPublications().get(Globals.getCurrentPublicationIndex());
                publication.setName(name.getText().toString());
                publication.setUrl(url.getText().toString());
                publication.setDueDate(dueDate.getText().toString());
                publication.setComplete(isComplete.isChecked());
                publication.setProgress(progress.getProgress());
                publication.setActive(isActive.isChecked());
            }
            Intent intent = new Intent(AddPublication.this, Publications.class);
            //finish(); // Closing the current activity
            startActivity(intent); // Starting the new activity
        }
        else {
            Snackbar.make(view, "Please fill in all the fields", Snackbar.LENGTH_LONG).setAction("Action", null).show();
        }
    }

    private boolean validateForm() {
        EditText name = (EditText) findViewById(R.id.editName);
        EditText url = (EditText) findViewById(R.id.editURL);
        EditText dueDate = (EditText) findViewById(R.id.editDueDate);
        if (name.getText().toString().equals("")) {
            return false;
        }
        if (url.getText().toString().equals("")) {
            return false;
        }
        if (dueDate.getText().toString().equals("")) {
            return false;
        }
        return true;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
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
