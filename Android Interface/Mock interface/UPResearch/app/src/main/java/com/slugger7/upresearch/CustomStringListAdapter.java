package com.slugger7.upresearch;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

class CustomStringListAdapter extends ArrayAdapter<String>{
    CustomStringListAdapter(Context context, String[] resources) {
        //super(context, R.layout.content_research_group, (resources.getPeople().toArray());
        super(context, R.layout.content_research_group, resources);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
//        LayoutInflater inflater = LayoutInflater.from(getContext());
        LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View customView = inflater.inflate(R.layout.custom_row, parent, false);
        if(customView == null) System.out.println("yes");

        String item = getItem(position).toString();
        TextView text = (TextView) customView.findViewById(R.id.textView2);

        text.setText((CharSequence)item);

        return customView;
    }
}