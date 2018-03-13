package com.example.ria.hangman;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class Start extends AppCompatActivity{

    private Toolbar myToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        myToolbar = (Toolbar)findViewById(R.id.my_toolbar);
        myToolbar.setTitleTextColor(Color.WHITE);
        setSupportActionBar(myToolbar);
    }

    /**
     *
     * @param menu Creates a new toolbar, with custom layout.
     * @return a boolean for visible/invisible.
     */

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toolbar, menu);
        return true;
    }

    /**
     * @param item Onclick Listener for the buttons in the toolbar, and funcions for when clicked.
     * @return a boolean for active/inactive.
     */

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if( item.getItemId() == R.id.Info){
            Intent intent = new Intent(this, About.class);
            startActivity(intent);
            return true;
        }
        else if (item.getItemId() == R.id.Play){
            Intent intentPlay = new Intent(this, Category.class);
            startActivity(intentPlay);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    /**
     *
     * @param view Onclicked Listener for when play-button is clicked, start the Category-class.
     */

    public void playClicked(View view){
        Intent intent = new Intent(this, Category.class);
        startActivity(intent);

    }
    /**
     *
     * @param view Onclicked Listener for when about-button is clicked, start the About-class.
     */

    public void aboutClicked(View view){
        Intent intent = new Intent(this, About.class);
        startActivity(intent );
    }

    /**
     *
     * @param view Onclicked Listener for when score-button is clicked, start the ScoreBoard-class.
     */

    public void scoreClicked(View view){
        Intent intent = new Intent(this, ScoreBoard.class);
        startActivity(intent);
    }
}
