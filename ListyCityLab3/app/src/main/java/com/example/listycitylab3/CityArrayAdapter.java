package com.example.listycitylab3;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class CityArrayAdapter extends ArrayAdapter<City> {

    // context is the activity its being used in.
    // cities is list of City objects i want to display
    public CityArrayAdapter(Context context, ArrayList<City> cities) {

        super(context, 0, cities); // call parent constructor, dont need layout ID so put 0
    }

    @NonNull
    @Override
    // pos: which row in list im rendering.
    // convertView: recycled old view, if null create new one
    // parent: the parent ListView
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View view;
        if (convertView == null) { // no reuasble view so inflate new one
            view = LayoutInflater.from(getContext()).inflate(R.layout.content, parent, false);
        } else {
            view = convertView; // otherwise reuse the old view
        }

        City city = getItem(position); // get City object at current row
        TextView cityName = view.findViewById(R.id.city_text); // find name of city in content.xml
        TextView provinceName = view.findViewById(R.id.province_text); // find province name in content.xml

        cityName.setText(city.getName()); // set text for the two views using data from City object
        provinceName.setText(city.getProvince());

        return view; // return row to ListyView to display

    }
}



