package com.example.ria.hangman;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

import static android.content.Intent.FLAG_ACTIVITY_CLEAR_TOP;
import static android.content.Intent.FLAG_ACTIVITY_SINGLE_TOP;

public class Category extends AppCompatActivity {

    EditText editText;
    Toolbar myToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);
        editText = (EditText)findViewById(R.id.editText);
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

    /**
     * @param view OnClick Listener for the category Random. Collects the right array with words.
     *             and uses a random to pick one, and sends this mysterWord into the game-class using a key-value on the intent.
     *             Also collects the name the player entered, and sends in into the game.
     */

    public void randomClicked(View view) {
        Intent intent = new Intent(this, Game.class);
        intent.putExtra("Message", editText.getText().toString());
        intent.putExtra("Key", "Random");
        String[] random = getResources().getStringArray(R.array.Random);
        String mysteryWord = random[(int) (Math.random() * random.length)];
        intent.putExtra("Word", mysteryWord);
        startActivity(intent);
    }
    /**
     * @param view OnClick Listener for the category Animal. Collects the right array with words.
     *             and uses a random to pick one, and sends this mysterWord into the game-class using a key-value on the intent.
     *             Also collects the name the player entered, and sends in into the game.
     */

    public void animalClicked(View view) {
        Intent intent = new Intent(this, Game.class);
        intent.putExtra("Message", editText.getText().toString());
        intent.putExtra("Key", "Animal");
        String[] animals = getResources().getStringArray(R.array.Animal);
        String mysteryWord = animals[(int) (Math.random() * animals.length)];
        intent.putExtra("Word", mysteryWord);
        startActivity(intent);
    }
    /**
     * @param view OnClick Listener for the category Countries. Collects the right array with words.
     *             and uses a random to pick one, and sends this mysterWord into the game-class using a key-value on the intent.
     *             Also collects the name the player entered, and sends in into the game.
     */

    public void countriesClicked(View view) {
        Intent intent = new Intent(this, Game.class);
        intent.putExtra("Message", editText.getText().toString());
        intent.putExtra("Key", "Countries");
        String[] countries = getResources().getStringArray(R.array.Countries);
        String mysteryWord = countries[(int) (Math.random() * countries.length)];
        intent.putExtra("Word", mysteryWord);
        startActivity(intent);
    }

    /**
     * @param view OnClick Listener for the category Vehicles. Collects the right array with words.
     *             and uses a random to pick one, and sends this mysterWord into the game-class using a key-value on the intent.
     *             Also collects the name the player entered, and sends in into the game.
     */

    public void vehiclesClicked(View view) {
        Intent intent = new Intent(this, Game.class);
        intent.putExtra("Message", editText.getText().toString());
        intent.putExtra("Key", "Vehicles");
        String[] vehicles = getResources().getStringArray(R.array.Vehicles);
        String mysteryWord = vehicles[(int) (Math.random() * vehicles.length)];
        intent.putExtra("Word", mysteryWord);
        startActivity(intent);
    }
    /**
     * @param view OnClick Listener for the category Encyklodpedia. Collects the right array with words.
     *             and uses a random to pick one, and sends this mysterWord into the game-class using a key-value on the intent.
     *             Also collects the name the player entered, and sends in into the game.
     */

    public void enzoClicked(View view) {
        Intent intent = new Intent(this, Game.class);
        intent.putExtra("Message", editText.getText().toString());
        intent.putExtra("Key", "Encyklopedia");
        String[] enzo = getResources().getStringArray(R.array.Encyklopedia);
        String mysteryWord = enzo[(int) (Math.random() * enzo.length)];
        intent.putExtra("Word", mysteryWord);
        startActivity(intent);
    }

    /**
     * @param view OnClick Listener for the category Food & Drinks. Collects the right array with words.
     *             and uses a random to pick one, and sends this mysterWord into the game-class using a key-value on the intent.
     *             Also collects the name the player entered, and sends in into the game.
     */

    public void foodClicked(View view) {
        Intent intent = new Intent(this, Game.class);
        intent.putExtra("Message", editText.getText().toString());
        intent.putExtra("Key", "Food & Dinks");
        String[] foods = getResources().getStringArray(R.array.Food);
        String mysteryWord = foods[(int) (Math.random() * foods.length)];
        intent.putExtra("Word", mysteryWord);
        startActivity(intent);
    }
}
