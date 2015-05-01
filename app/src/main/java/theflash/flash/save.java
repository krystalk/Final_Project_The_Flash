package theflash.flash;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.os.Bundle;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import android.os.Environment;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;


public class save extends Activity implements View.OnClickListener //the save class
{
    Button save; //save variable for the save button
    Button back_button; //back button variable for the back button
    TextView name; //name variable for the name text field
    private String newDeck; //string variable for the new deck
    private String title; //string variable for the title of the deck
    File file; //file variable
    FileOutputStream outputStream; //so that the file can be written to

    @Override

    public void onCreate(Bundle savedInstanceState) { //when the activity loads
        super.onCreate(savedInstanceState);

        setContentView(R.layout.save); //opens the save.xml layout

        save = (Button) findViewById(R.id.button_save); //sets the save button variable equal to the button_save
        back_button = (Button) findViewById(R.id.back_button); //sets the back button variable equal to the back_button

        name = (TextView) findViewById(R.id.deck_name); //sets the name variable equal to the deck_name text field

        save.setOnClickListener(this); //allows for the save button to have a function when it is clicked
        back_button.setOnClickListener(this); //allows for the back button to have a function when it is clicked
    }


    public void onClick(View v) //when something is clicked
    {
        switch (v.getId()) {
            case R.id.button_save: //if the save button is clicked
            {
                newDeck = MainActivity.myDeck.deckSave(); //gets the dynamic myDeck that was created in the MainActivity
                title = name.getText().toString(); //sets the title string equal to the text of the name


                try {
                    file = new File(Environment.getExternalStorageDirectory(), title); //location of where the deck is to be saved
                    outputStream = new FileOutputStream(file);
                    outputStream.write(newDeck.getBytes()); //writes the deck to the file
                    outputStream.close(); //closes the file being written to
                }
                catch (IOException e) //catches the exception
                {
                    e.printStackTrace();
                }
                Toast.makeText(save.this, "Your deck has been saved!", Toast.LENGTH_LONG).show(); //returns feedback that the deck has been saved
                break;

            }
            case R.id.back_button: //if the back button is clicked
            {
                finish();
                break;
            }
        }
    }
}
