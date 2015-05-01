package theflash.flash;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class make extends Activity implements OnClickListener //the make class for making flashcards
{
    private Button addCard; //the Add Card button variable
    private Button back; //the Back button variable
    TextView input_ques; //the input question variable
    TextView input_ans; //the input answer variable

    @Override

    protected void onCreate(Bundle savedInstanceState) //function for when the activity loads
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.make); //loads the make xml
        addCard = (Button) findViewById(R.id.button_addCard); //sets the add card variable equal to the button_addCard
        back = (Button) findViewById(R.id.back_button); //sets the back variable equal to the back_button
        input_ques=(TextView)findViewById(R.id.question); //sets the input question variable equal to the question text field
        input_ans =(TextView)findViewById(R.id.answer); //sets the input answer variable equal to the answer text field

        addCard.setOnClickListener(this); //allows for the add card button to have a function when it is clicked
        back.setOnClickListener(this); //allows for the back card button to have a function when it is clicked

    }

    @Override
    public void onClick(View v) //when something is clicked
    {
        switch(v.getId())
        {
            case R.id.button_addCard: //if the add card button is clicked
            {
                if(input_ques.getText().toString().equals("")&&input_ans.getText().toString().equals("")) //if the question and answer text fields are left empty
                {
                    Toast.makeText(make.this, "You did not enter a question or an answer", Toast.LENGTH_LONG).show(); //returns feedback that the a question and answer have not been entered
                }
                else //if a question and answer have ben entered
                {
                    MainActivity.myDeck.addCard(new card(input_ans.getText().toString(), input_ques.getText().toString())); //adds a new card in the Deck with the input strings
                    input_ans.setText(""); //resets the answer text field
                    input_ques.setText(""); //resets the question text field
                }

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