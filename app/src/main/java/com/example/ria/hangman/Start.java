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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toolbar, menu);
        return true;
    }

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

    public void playClicked(View view){
        Intent intent = new Intent(this, Category.class);
        startActivity(intent);

    }

    public void aboutClicked(View view){
        Intent intent = new Intent(this, About.class);
        startActivity(intent );
    }

  /*  public void scoreClicked(View view){
        Intent intent = new Intent(this, Category.class);
        startActivity(intent);
    }   Det Finns i nuläget ingen scoreActivity. Skapa Den!  */
}
