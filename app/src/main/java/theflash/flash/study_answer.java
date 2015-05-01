package theflash.flash;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Button;
import android.widget.TextView;

public class study_answer extends Activity implements View.OnClickListener //the study_answer class
{
    private TextView answer; //answer variable for the answer text field
    Button right_button; //right button variable for the right button
    Button wrong_button; //wrong button variable for the wrong button


    @Override

    protected void onCreate(Bundle savedInstanceState) //when the activity loads
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.study_ans); //loads the study_ans.xml layout

        answer = (TextView) findViewById(R.id.answer_input); //sets the answer variable equal to the answer_input

        initializeTextViews();

        right_button = (Button) findViewById(R.id.right_button); //sets the right button variable equal to the right_button
        right_button.setOnClickListener(this); //allows for the right button to have a function when it is clicked
        wrong_button = (Button) findViewById(R.id.wrong_button); //sets the wrong button variable equal to the wrong_button
        wrong_button.setOnClickListener(this); //allows for the wrong button to have a function when it is clicked

    }

    public void onClick(View v) //when something is clicked
    {
        switch (v.getId())
        {
            case R.id.right_button: //if the right button is clicked, then increments the score1 right and goes back to the question activity
            {
                MainActivity.score1.incRight(); //increments the score1 right (dynamic variable created in the MainActivity)
                study.currentQues = MainActivity.myDeck.getCard(false); //gets the next card from the deck
                study.question.setText(study.currentQues.getQuestion()); //sets the text field for the current question equal to the card's question string

                finish();
                break;
            }
            case R.id.wrong_button: //if the wrong button is clicked, then increments the score1 wrong and goes back to the question activity
            {
                MainActivity.score1.incWrong(); //increments the score1 wrong (dynamic variable created in the MainActivity)
                study.currentQues = MainActivity.myDeck.getCard(false); //gets the next card from the deck
                study.question.setText(study.currentQues.getQuestion()); //sets the text field for the current question equal to the card's question string

                finish();
                break;
            }
        }
    }

    private void initializeTextViews() //initializes the text fields, function is called on the activity load
    {
        String myanswer = getIntent().getExtras().getString(study.answer2);
        answer.setText(myanswer);
    }

}
