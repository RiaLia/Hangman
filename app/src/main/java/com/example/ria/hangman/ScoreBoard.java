package com.example.ria.hangman;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import static android.content.Intent.FLAG_ACTIVITY_CLEAR_TOP;
import static android.content.Intent.FLAG_ACTIVITY_SINGLE_TOP;

public class ScoreBoard extends AppCompatActivity {

    private Toolbar myToolbar;
    ListView myList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score_board);
        myToolbar = (Toolbar)findViewById(R.id.my_toolbar);
        myToolbar.setTitleTextColor(Color.WHITE);
        setSupportActionBar(myToolbar);
        myList = findViewById(R.id.highScoreList);
        setAdapter();
    }

    /**
     *
     * @param menu Creates a new toolbar, with custom layout.
     * @return a boolean for visible/invisible.
     */

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toolbar_game, menu);
        return true;
    }

    /**
     * @param item Onclick Listener for the buttons in the toolbar, and funcions for when clicked.
     * @return a boolean for active/inactive.
     */

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if( item.getItemId() == R.id.Rules){
            Intent intent = new Intent(this, About.class);
            startActivity(intent);
            return true;
        }
        else if( item.getItemId() == R.id.Home){
            Intent intent = new Intent(this, Start.class);
            intent.setFlags(FLAG_ACTIVITY_SINGLE_TOP | FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);
            return true;

        }
        return super.onOptionsItemSelected(item);
    }

    public void setAdapter(){
        HighScoreAdapter highscoreAdapter = new HighScoreAdapter(this);
        myList.setAdapter(highscoreAdapter);

    }
}
