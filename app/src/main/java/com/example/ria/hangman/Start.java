package com.example.ria.hangman;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class Start extends AppCompatActivity{


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
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
