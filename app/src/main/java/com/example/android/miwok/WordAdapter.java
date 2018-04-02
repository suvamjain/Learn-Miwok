package com.example.android.miwok;

import android.app.Activity;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by SUVAM JAIN on 28-03-2017.
 */

public class WordAdapter extends ArrayAdapter<Word> {

    /** ResourceId for he backgroud color of the list of words*/
    private int mColorResourceId;


    public WordAdapter(Activity context, ArrayList<Word> words, int color) {
        super(context,0,words);
        mColorResourceId = color;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        // Get the {@link Word} object located at this position in the list
        Word currentWord = getItem(position);

        // Find the ImageView in the list_item.xml layout with the img name
        ImageView image = (ImageView) listItemView.findViewById(R.id.img);
        // Get the resId of image from the current Word object and
        // set this image on the image Imageview.

        if(currentWord.hasImage()) {

            //set the ImageView to the image resource specified in the current word
            image.setImageResource(currentWord.getImageResourceId());
            //Make sure the image visibility is visible because when the list pick the view frm scrap file during recycling then
            // if the list is last used for a phrase then it's visibility must have be hidden for image.
            image.setVisibility(View.VISIBLE);
        }
        else
        // otherwise hide the image (set Visibility GONE) - it is for phrases activity
            image.setVisibility(View.GONE);

        //Set the theme color for the list item
        View textContainer = listItemView.findViewById(R.id.text_container);
        //Find the color that the resource id maps to
        int color = ContextCompat.getColor(getContext(),mColorResourceId);
        //Set the background color of the text_container View
        textContainer.setBackgroundColor(color);

        // Find the TextView in the list_item.xml layout with the defaultTranslation_name
        TextView defaultTranslation = (TextView) listItemView.findViewById(R.id.default_text_view);
        // Get the defaultTranslation_name from the current Word object and
        // set this text on the defaultTranslation TextView
        defaultTranslation.setText(currentWord.getDefaultTranslation());

        // Find the TextView in the list_item.xml layout with the miwokTranslation_name
        TextView miwokTranslation = (TextView) listItemView.findViewById(R.id.miwok_text_view);
        // Get the miwokTranslation from the current Word object and
        // set this text on the miwokTranslation TextView
        miwokTranslation.setText(currentWord.getMiwokTranslation());

        // Return the whole list item layout (containing 2 TextViews)
        // so that it can be shown in the ListView
        return listItemView;
    }

}
