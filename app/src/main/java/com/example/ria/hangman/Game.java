package com.example.ria.hangman;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.ContextThemeWrapper;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;


public class Game extends AppCompatActivity {
    private String currWord;
    private char[] asterisk;

    private int count = 0;
    private int tries = 7;

    private ImageView[] bodyParts;
    private int numParts = 6;

    private TextView showLetter;
    private TextView showWord;

    private TextView textView;
    private TextView textView2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        Intent intent = getIntent();

        String text = intent.getStringExtra("Message");
        textView = (TextView)findViewById(R.id.namnText);
        textView.setText(text);

        String text2 = intent.getStringExtra("Key");
        textView2 = (TextView)findViewById(R.id.textView5);
        textView2.setText(text2);

        String mysteryWord = intent.getStringExtra("Word");
        currWord = mysteryWord;




        bodyParts = new ImageView[numParts];
        bodyParts[0] = (ImageView) findViewById(R.id.head);
        bodyParts[1] = (ImageView) findViewById(R.id.body);
        bodyParts[2] = (ImageView) findViewById(R.id.arm1);
        bodyParts[3] = (ImageView) findViewById(R.id.arm2);
        bodyParts[4] = (ImageView) findViewById(R.id.leg1);
        bodyParts[5] = (ImageView) findViewById(R.id.leg2);

        showLetter = (TextView) findViewById(R.id.showLetter);
        showWord = (TextView) findViewById(R.id.showWord);

        asterisk = new char[currWord.length()];
        for (int s = 0; s < currWord.length(); s++) {
            asterisk[s] = '*';
        }
        showWord.setText(String.valueOf(asterisk));

    }

    public void clickedButton(View view){
        String guess = ((TextView)view).getText().toString();
        view.setEnabled(false);
        view.setBackgroundResource(R.drawable.letter_down);
        showLetter.setText(guess);
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
                AlertDialog.Builder winBuild = new AlertDialog.Builder(new ContextThemeWrapper(this, R.style.AlertDialogCustom));
                winBuild.setTitle("YOU WON!!!").setMessage("You correctly guessed the word in: " +count+ " tries!! ")
                .setPositiveButton("Next Word", new DialogInterface.OnClickListener(){
                            public void onClick(DialogInterface dialog, int id){
                                startActivity(intent);
                            }
                        });
                winBuild.setNegativeButton("Exit",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                Game.this.finish();
                                // Behöver backa bakåt ett steg till.
                            }});
                winBuild.show();
            }
        }
    }

    private void hangmanImage() {
        // BÖR MINIMERAS

        if (count == 1){bodyParts[0].setVisibility(View.VISIBLE);}
        if (count == 2){bodyParts[1].setVisibility(View.VISIBLE);}
        if (count == 3){bodyParts[2].setVisibility(View.VISIBLE);}
        if (count == 4){bodyParts[3].setVisibility(View.VISIBLE);}
        if (count == 5){bodyParts[4].setVisibility(View.VISIBLE);}
        if (count == 6){bodyParts[5].setVisibility(View.VISIBLE);}

        if (count == tries){
            final Intent intent = new Intent(this , Start.class);
            AlertDialog.Builder lostBuild = new AlertDialog.Builder(new ContextThemeWrapper(this, R.style.AlertDialogCustom));
            lostBuild.setTitle("GAME OVER").setMessage("THE CORRECT WORD WAS: "+currWord)
            .setPositiveButton("Main Menu", new DialogInterface.OnClickListener(){
                        public void onClick(DialogInterface dialog, int id){
                            startActivity(intent);
                        }
                    });

            lostBuild.show();
        }
    }
}










