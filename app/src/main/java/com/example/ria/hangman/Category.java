package com.example.ria.hangman;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

public class Category extends AppCompatActivity {

    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);
        editText = (EditText)findViewById(R.id.editText);
    }


    public void randomClicked(View view) {
        Intent intent = new Intent(this, Game.class);
        intent.putExtra("Message", editText.getText().toString());
        intent.putExtra("Key", "Random");
        String[] random = getResources().getStringArray(R.array.Random);
        String mysteryWord = random[(int) (Math.random() * random.length)];
        intent.putExtra("Word", mysteryWord);
        startActivity(intent);
    }

    public void animalClicked(View view) {
        Intent intent = new Intent(this, Game.class);
        intent.putExtra("Message", editText.getText().toString());
        intent.putExtra("Key", "Animal");
        String[] animals = getResources().getStringArray(R.array.Animal);
        String mysteryWord = animals[(int) (Math.random() * animals.length)];
        intent.putExtra("Word", mysteryWord);
        startActivity(intent);
    }

    public void countriesClicked(View view) {
        Intent intent = new Intent(this, Game.class);
        intent.putExtra("Message", editText.getText().toString());
        intent.putExtra("Key", "Countries");
        String[] countries = getResources().getStringArray(R.array.Countries);
        String mysteryWord = countries[(int) (Math.random() * countries.length)];
        intent.putExtra("Word", mysteryWord);
        startActivity(intent);
    }

    public void vehiclesClicked(View view) {
        Intent intent = new Intent(this, Game.class);
        intent.putExtra("Message", editText.getText().toString());
        intent.putExtra("Key", "Vehicles");
        String[] vehicles = getResources().getStringArray(R.array.Vehicles);
        String mysteryWord = vehicles[(int) (Math.random() * vehicles.length)];
        intent.putExtra("Word", mysteryWord);
        startActivity(intent);
    }

    public void enzoClicked(View view) {
        Intent intent = new Intent(this, Game.class);
        intent.putExtra("Message", editText.getText().toString());
        intent.putExtra("Key", "Encyklopedia");
        String[] enzo = getResources().getStringArray(R.array.Encyklopedia);
        String mysteryWord = enzo[(int) (Math.random() * enzo.length)];
        intent.putExtra("Word", mysteryWord);
        startActivity(intent);
    }

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
