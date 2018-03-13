package com.example.ria.hangman;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import static android.content.Intent.FLAG_ACTIVITY_CLEAR_TOP;
import static android.content.Intent.FLAG_ACTIVITY_SINGLE_TOP;

public class About extends AppCompatActivity {

    private Toolbar myToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
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
        getMenuInflater().inflate(R.menu.toolbar_about, menu);
        return true;
    }

    /**
     * @param item Onclick Listener for the buttons in the toolbar, and funcions for when clicked.
     * @return a boolean for active/inactive.
     */

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if( item.getItemId() == R.id.home){
            Intent intent = new Intent(this, Start.class);
            intent.setFlags(FLAG_ACTIVITY_SINGLE_TOP | FLAG_ACTIVITY_CLEAR_TOP);
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
}
