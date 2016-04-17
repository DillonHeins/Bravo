package com.slugger7.upresearch;

import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class AddResearchCategory extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_research_category);
    }

    public void addResearchCategory(View view){
        EditText researchCategory = (EditText) findViewById(R.id.field_add_research_category);
        String rc = researchCategory.getText().toString();

        Snackbar.make(view, rc + " successfully added to research categories", Snackbar.LENGTH_LONG).show();
        try {
            wait((long) Snackbar.LENGTH_LONG);
        }
        catch (Exception e){
        }
        finish();
    }
}

