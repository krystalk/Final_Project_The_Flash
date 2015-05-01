package theflash.flash;

import android.app.Activity;
import android.view.View;
import android.os.Bundle;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class edit extends Activity implements View.OnClickListener //edit class to change the previously made flashcards
{
    Button nextQuestion; //Next Question Button
    Button backButton; //Back Button
    Button editQuestion; //Edit Question Button
    TextView question; //Text field that shows the question
    TextView answer; //Text field that shows the answer
    private card currentQues; //card class that shows the current question

    @Override
    public void onCreate(Bundle savedInstanceState) //OnCreate function for when the activity loads
    {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.edit);

        nextQuestion = (Button)findViewById(R.id.next_ques); //sets the Next Question Button variable equal to the next_ques button
        backButton = (Button)findViewById(R.id.back_button); //sets the Back Button variable equal to the back_button
        editQuestion =(Button)findViewById(R.id.edit_button); //sets the Edit Question Button variable equal to the edit_button

        answer=(TextView)findViewById(R.id.answer_edit); //sets the answer text field variable equal to the answer_edit text
        question =(TextView)findViewById(R.id.question_edit); //sets the question text field variable equal to the question_edit text

        nextQuestion.setOnClickListener(this); //allows for the Next Question button to have a function when it is clicked
        backButton.setOnClickListener(this); //allows for the Back Button to have a function when it is clicked
        editQuestion.setOnClickListener(this); //allows for the Edit Question Button to have a function when it is clicked

        if(answer.getText().toString().equals("")&&question.getText().toString().equals(""))
        {
            if (MainActivity.myDeck.getSize() != 0) //if there are still more cards in the Deck, then it set the new card
            {
                currentQues = MainActivity.myDeck.getCard(false);
                question.setText(currentQues.getQuestion());
                answer.setText(currentQues.getAnswer());
            }
            else //if there are no cards in the Deck
            {
                Toast.makeText(edit.this, "Your Deck is empty! There are no cards to edit.", Toast.LENGTH_LONG).show(); //returns feedback that there are no cards in the deck to edit
                finish();
            }
        }


    }

    @Override
    public void onClick(View v) //when something is clicked
    {
        switch(v.getId())
        {
            case R.id.edit_button: //if the edit button is clicked
            {
                if(answer.getText().toString().equals("")&&question.getText().toString().equals(""))
                    break;
                String q = question.getText().toString();
                String a = answer.getText().toString();
                currentQues.setAnswer(a); //sets the current answer to the string answer
                currentQues.setQuestion(q); //sets the current question to the string question

            }
            case R.id.next_ques: //if the next question button is clicked
            {
                if(answer.getText().toString().equals("")&&question.getText().toString().equals(""))
                    break;
                currentQues = MainActivity.myDeck.getCard(false);
                if(currentQues!=null) //if there are more cards, then sets the next card
                {
                    question.setText(currentQues.getQuestion());
                    answer.setText(currentQues.getAnswer());
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
