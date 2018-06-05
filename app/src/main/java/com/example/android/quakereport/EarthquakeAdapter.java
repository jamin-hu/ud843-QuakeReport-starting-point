package com.example.android.quakereport;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class EarthquakeAdapter extends ArrayAdapter<Earthquake> {

    public EarthquakeAdapter(Context context, ArrayList<Earthquake> earthquakes){
        super(context, 0, earthquakes);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if an existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        Earthquake currentEarthquake = getItem(position);

        DecimalFormat decimalFormatter = new DecimalFormat("0.0");
        String magnitude = decimalFormatter.format(currentEarthquake.getMagnitude());

        TextView magnitudeTextView = listItemView.findViewById(R.id.magnitude);
        // Set the proper background color on the magnitude circle.
        // Fetch the background from the TextView, which is a GradientDrawable.
        GradientDrawable magnitudeCircle = (GradientDrawable) magnitudeTextView.getBackground();

        // Get the appropriate background color based on the current earthquake magnitude
        int magnitudeColor = getMagnitudeColor(currentEarthquake.getMagnitude());

        // Set the color on the magnitude circle
        magnitudeCircle.setColor(magnitudeColor);

        magnitudeTextView.setText(magnitude);

        String offset;
        String city;
        String place = currentEarthquake.getCity();

        if (currentEarthquake.getCity().contains("of ")){
            int cutPointReference = place.indexOf("of ");
            int cutPoint = cutPointReference + 2;
            offset = place.substring(0, cutPoint);

            city = place.substring(cutPoint+1, place.length());
        }

        else {
            offset = "Near the";
            city = place;
        }

        TextView offsetTextView = listItemView.findViewById(R.id.offset);
        offsetTextView.setText(offset);

        TextView cityTextView = listItemView.findViewById(R.id.city);
        cityTextView.setText(city);

        TextView dateTextView = listItemView.findViewById(R.id.date);
        dateTextView.setText(currentEarthquake.getDate());

        TextView timeTextView = listItemView.findViewById(R.id.time);
        timeTextView.setText(currentEarthquake.getTime());

        return listItemView;
    }

    int getMagnitudeColor(double magnitude){
        int magnitudeFloor = (int) Math.floor(magnitude);
        int correspondingColor;
        switch (magnitudeFloor){
            case 1:
                correspondingColor = R.color.magnitude1;
                break;
            case 2:
                correspondingColor = R.color.magnitude2;
                break;
            case 3:
                correspondingColor = R.color.magnitude3;
                break;
            case 4:
                correspondingColor = R.color.magnitude4;
            break;
            case 5:
                correspondingColor = R.color.magnitude5;
            break;
            case 6:
                correspondingColor = R.color.magnitude6;
            break;
            case 7:
                correspondingColor = R.color.magnitude7;
            break;
            case 8:
                correspondingColor = R.color.magnitude8;
            break;
            case 9:
                correspondingColor = R.color.magnitude9;
            break;
            default:
                correspondingColor = R.color.magnitude10plus;
        }
        return ContextCompat.getColor(getContext(), correspondingColor);
    };
}
