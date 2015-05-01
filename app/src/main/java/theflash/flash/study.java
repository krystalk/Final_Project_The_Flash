package theflash.flash;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.Toast;


public class study extends Activity implements View.OnClickListener //the study class
{
    public static TextView question; //question variable for the question text field
    Button next_Question; //next question variable for the next question button
    Button back_button; //back button variable for the back button
    Button show_answer; //show answer variable for the show answer button
    String answer; //answer variable for the answer question text field
    public static card currentQues; //current question variable for the current card
    public static final String answer2 = "tag";

    @Override

        public void onCreate(Bundle savedInstanceState) //when the activity loads
        {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.study_quest); //loads the study_quest.xml layout
            back_button = (Button)findViewById(R.id.back_button); //sets the back button variable equal to the back_button
            show_answer = (Button)findViewById(R.id.show_ans_button); //sets the show answer variable equal to the show_ans_button
            question = (TextView)findViewById(R.id.question_input); //sets the question variable equal to the question_input
            back_button.setOnClickListener(this); //allows for the back button to have a function when it is clicked
            show_answer.setOnClickListener(this); //allows for the show answer button to have a function when it is clicked

            if(question.getText().toString().equals(""))
            {
                if (MainActivity.myDeck.getSize() != 0) //if there are cards in the Deck
                {
                    currentQues = MainActivity.myDeck.getCard(false); //gets the next card from the deck
                    question.setText(currentQues.getQuestion()); //sets the text field for the current question equal to the card's question string
                }
                else //if there are no cards in the Deck
                {
                    Toast.makeText(study.this, "Your Deck is empty! There are no cards to study from.", Toast.LENGTH_LONG).show(); //returns feedback that the deck is empty
                    finish();
                }
            }
        }
    @Override
    public void onClick(View v) //when something is clicked
    {
        switch (v.getId())
        {
            case R.id.show_ans_button: //if the show answer button is clicked
            {
                if(currentQues == null)
                {
                    break;
                }
                answer = currentQues.getAnswer().toString(); //gets the answer from the current card's answer string
                Intent answerActivity = new Intent(study.this, study_answer.class);
                answerActivity.putExtra(answer2, answer);
                startActivity(answerActivity); //opens the study_answer activity
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
