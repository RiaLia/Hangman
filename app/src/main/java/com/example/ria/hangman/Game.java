package com.example.ria.hangman;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.ContextThemeWrapper;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import static android.content.Intent.FLAG_ACTIVITY_CLEAR_TOP;
import static android.content.Intent.FLAG_ACTIVITY_SINGLE_TOP;


public class Game extends AppCompatActivity {
    private String currWord;
    private char[] asterisk;

    private int count = 0;
    private int tries = 9;

    private ImageView[] bodyParts;
    private int numParts = 9;

    private TextView showWord;
    private TextView textView;
    private TextView textView2;
    private Toolbar myToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        Intent intent = getIntent();

        String name = intent.getStringExtra("Message");
        textView = (TextView)findViewById(R.id.namnText);
        textView.setText(name);

        String text2 = intent.getStringExtra("Key");
        textView2 = (TextView)findViewById(R.id.textView5);
        textView2.setText(text2);

        currWord = intent.getStringExtra("Word");
        myToolbar = (Toolbar)findViewById(R.id.my_toolbar);
        myToolbar.setTitleTextColor(Color.WHITE);
        setSupportActionBar(myToolbar);



        bodyParts = new ImageView[numParts];
        bodyParts[0] = (ImageView) findViewById(R.id.loose);
        bodyParts[1] = (ImageView) findViewById(R.id.stool);
        bodyParts[2] = (ImageView) findViewById(R.id.head);
        bodyParts[3] = (ImageView) findViewById(R.id.body);
        bodyParts[4] = (ImageView) findViewById(R.id.arm1);
        bodyParts[5] = (ImageView) findViewById(R.id.arm2);
        bodyParts[6] = (ImageView) findViewById(R.id.leg1);
        bodyParts[7] = (ImageView) findViewById(R.id.leg2);
        bodyParts[8] = (ImageView) findViewById(R.id.stool_fallen);


        showWord = (TextView) findViewById(R.id.showWord);

        asterisk = new char[currWord.length()];
        for (int s = 0; s < currWord.length(); s++) {
            asterisk[s] = '*';
        }
        showWord.setText(String.valueOf(asterisk));

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toolbar_game, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if( item.getItemId() == R.id.Home){
            Intent intent = new Intent(this, Start.class);
            intent.setFlags(FLAG_ACTIVITY_SINGLE_TOP | FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);
            return true;
        }
        else if (item.getItemId() == R.id.Rules){
            AlertDialog.Builder rulesBuild = new AlertDialog.Builder(new ContextThemeWrapper(this, R.style.AlertDialogCustom));
            rulesBuild.setTitle("RULES:").setMessage("You have 7 tries to guees the hidden word.")
                    .setPositiveButton("OK", new DialogInterface.OnClickListener(){
                        public void onClick(DialogInterface dialog, int id){

                        }
                    }).show();

            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void clickedButton(View view){
        String guess = ((TextView)view).getText().toString();
        view.setEnabled(false);
        view.setBackgroundResource(R.drawable.letter_down);
        hang(guess);
    }

    public void hang(String guess) {
    boolean correct = false;
        for (int i = 0; i < currWord.length(); i++) {
            if(currWord.charAt(i) == guess.charAt(0)) {
               asterisk[i] = guess.charAt(0);
               showWord.setText(String.valueOf(asterisk));
                win();
               correct = true;
            }
        }
        if (!correct){
            count ++;
            hangmanImage();
        }

    }

    public void win(){
        for ( int i = 0; i < String.valueOf(asterisk).length(); i++ ){
            if (! String.valueOf(asterisk).contains("*")){


                final Intent intent = new Intent(this , Category.class);
                final Intent intentStart = new Intent(this, Start.class);
                AlertDialog.Builder winBuild = new AlertDialog.Builder(new ContextThemeWrapper(this, R.style.AlertDialogCustom));
                winBuild.setTitle("YOU WON!!!").setMessage("You correctly guessed the word in: " +count+ " tries!! ")
                .setPositiveButton("Next Word", new DialogInterface.OnClickListener(){
                            public void onClick(DialogInterface dialog, int id){
                                startActivity(intent);
                            }
                        })
                .setNegativeButton("Exit",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                intentStart.setFlags(FLAG_ACTIVITY_SINGLE_TOP | FLAG_ACTIVITY_CLEAR_TOP);
                                startActivity(intentStart);
                                Game.this.finish();
                            }})
                .setCancelable(false)
                .show();
            }
        }
    }

    private void hangmanImage() {
        // BÖR MINIMERAS

        if (count == 1){bodyParts[0].setVisibility(View.VISIBLE);}
        if (count == 2){bodyParts[1].setVisibility(View.VISIBLE);}
        if (count == 3){bodyParts[2].setVisibility(View.VISIBLE);
                      bodyParts[0].setVisibility(View.INVISIBLE);}
        if (count == 4){bodyParts[3].setVisibility(View.VISIBLE);}
        if (count == 5){bodyParts[4].setVisibility(View.VISIBLE);}
        if (count == 6){bodyParts[5].setVisibility(View.VISIBLE);}
        if (count == 7){bodyParts[6].setVisibility(View.VISIBLE);}
        if (count == 8){bodyParts[7].setVisibility(View.VISIBLE);}
        if (count == 9){bodyParts[8].setVisibility(View.VISIBLE);
                      bodyParts[1].setVisibility(View.INVISIBLE);}

        if (count == tries){
            final Intent intent = new Intent(this , Start.class);
            AlertDialog.Builder lostBuild = new AlertDialog.Builder(new ContextThemeWrapper(this, R.style.AlertDialogCustom));
            lostBuild.setTitle("GAME OVER").setMessage("THE CORRECT WORD WAS: "+currWord)
            .setPositiveButton("Main Menu", new DialogInterface.OnClickListener(){
                        public void onClick(DialogInterface dialog, int id){
                            intent.setFlags(FLAG_ACTIVITY_SINGLE_TOP | FLAG_ACTIVITY_CLEAR_TOP);
                            startActivity(intent);
                        }
                    })
            .setCancelable(false)
            .show();
        }
    }
}










