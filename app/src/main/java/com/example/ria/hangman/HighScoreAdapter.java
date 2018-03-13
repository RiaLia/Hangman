package com.example.ria.hangman;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

/**
 * Created by Ria on 13/12/17.
 */

public class HighScoreAdapter extends BaseAdapter {

    private LayoutInflater mInflater;
    private Context context;

    public HighScoreAdapter(Context context){
        this.context = context;
        mInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }
    @Override
    public int getCount() {
        return 5;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View rowView = mInflater.inflate(R.layout.highscore_item, parent, false);
        TextView nameTextView = rowView.findViewById(R.id.highScore_name);
        TextView scoreTextView = rowView.findViewById(R.id.highScore_score);
        TextView positionTextView = rowView.findViewById(R.id.highScore_position);


        nameTextView.setText("Kalle");
        scoreTextView.setText("666");
        positionTextView.setText("1");

        return rowView;
    }
}
