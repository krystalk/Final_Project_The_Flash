package theflash.flash;

import android.app.Activity;
import android.view.View;
import android.os.Bundle;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by rickygomes on 4/28/15.
 */
public class edit extends Activity implements View.OnClickListener
{
    Button nextQuestion;
    Button backButton;
    Button editQuestion;
    TextView question;
    TextView answer;
    private card currentQues;

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.edit);

        nextQuestion = (Button)findViewById(R.id.next_ques);
        backButton = (Button)findViewById(R.id.back_button);
        editQuestion =(Button)findViewById(R.id.edit_button);

        answer=(TextView)findViewById(R.id.answer_edit);
        question =(TextView)findViewById(R.id.question_edit);

        nextQuestion.setOnClickListener(this);
        backButton.setOnClickListener(this);
        editQuestion.setOnClickListener(this);

        if(answer.getText().toString().equals("")&&question.getText().toString().equals(""))
        {
            if (MainActivity.myDeck.getSize() != 0)
            {
                currentQues = MainActivity.myDeck.getCard(false);
                question.setText(currentQues.getQuestion());
                answer.setText(currentQues.getAnswer());
            }
            else
            {
                Toast.makeText(edit.this, "Your Deck is empty! There are no cards to edit.", Toast.LENGTH_LONG).show();
                finish();
            }
        }


    }

    @Override
    public void onClick(View v)
    {
        switch(v.getId())
        {
            case R.id.edit_button:
            {
                if(answer.getText().toString().equals("")&&question.getText().toString().equals(""))
                    break;
                String q = question.getText().toString();
                String a = answer.getText().toString();
                currentQues.setAnswer(a);
                currentQues.setQuestion(q);

            }
            case R.id.next_ques:
            {
                if(answer.getText().toString().equals("")&&question.getText().toString().equals(""))
                    break;
                currentQues = MainActivity.myDeck.getCard(false);
                if(currentQues!=null)
                {
                    question.setText(currentQues.getQuestion());
                    answer.setText(currentQues.getAnswer());
                }
                break;
            }
            case R.id.back_button:
            {
                finish();
                break;
            }
        }

        }
    }
