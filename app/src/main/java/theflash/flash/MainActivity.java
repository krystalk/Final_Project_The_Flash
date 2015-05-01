package theflash.flash;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;






public class MainActivity extends Activity implements OnClickListener { //the MainActivity class

    private Button buttonmake; //button make variable for the make button
    private Button buttonstudy; //button study variable for the study button
    private Button buttonscore; //button score variable for the score button
    public static Deck myDeck; //myDeck variable from the Deck class
    public static scoring score1; //score1 variable from the scoring class


    @Override
    public void onCreate(Bundle savedInstanceState) //function for when the activity loads
    {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main); //loads the activity_main.xml

        buttonmake = (Button)findViewById(R.id.make_button); //sets the button make variable equal to the make_button
        buttonstudy = (Button)findViewById(R.id.study_button); //sets the button study variable equal to the study_button
        buttonscore =(Button)findViewById(R.id.scores_button); //sets the button score variable equal to the scores_button

        buttonmake.setOnClickListener(this); //allows for the make button to have a function for when it is clicked
        buttonstudy.setOnClickListener(this); //allows for the study button to have a function for when it is clicked
        buttonscore.setOnClickListener(this); //allows for the score button to have a function for when it is clicked

        myDeck = new Deck(); //makes a dynamic myDeck variable from the Deck class
        score1 = new scoring(); //makes a dynamic score1 variable from the scoring class


    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) //for when the menu options loads
    {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);

        return true;

    }
    @Override
    public boolean onOptionsItemSelected(MenuItem menu) //when a menu option is selected
    {
        switch(menu.getItemId())
        {
            case R.id.menu_edit: //if the menu edit is selected
            {
                Intent intent = new Intent(this,edit.class);
                startActivity(intent); //opens the edit activity
                break;
            }
            case R.id.menu_clear: //if the menu clear is selected
            {
                myDeck.deckClear(); //clears the deck by calling the deck's clear function
                break;
            }
            case R.id.menu_save: //if the menu save is selected
            {
                Intent intent = new Intent(this,save.class);
                startActivity(intent); //opens the save activity
                break;
            }
        }
        return false;
    }

    @Override
    public void onClick(View v) { //if something is clicked
        // Inflate the menu; this adds items to the action bar if it is present.
        switch (v.getId())
        {
            case R.id.make_button: //if the make button is clicked
            {
                Intent intent = new Intent(MainActivity.this,make.class);
                startActivity(intent); //opens the make activity
                break;
            }
            case R.id.study_button: //if the study button is clicked
            {
                Intent intent = new Intent(MainActivity.this,study.class);
                startActivity(intent); //opens the study activity
                break;
            }
            case R.id.scores_button: //if the scores button is clicked
            {
                Intent intent = new Intent(MainActivity.this, scores.class);
                startActivity(intent); //opens the scores activity
                break;
            }
            default:
            {
                break;
            }
        }


    }



}

