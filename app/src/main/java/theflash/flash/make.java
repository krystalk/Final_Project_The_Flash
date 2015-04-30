package theflash.flash;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by rickygomes on 4/25/15.
 */
public class make extends Activity implements OnClickListener
{
    private Button addCard;
    private Button back;
    TextView input_ques;
    TextView input_ans;

    @Override

    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.make);
        addCard = (Button) findViewById(R.id.button_addCard);
        back = (Button) findViewById(R.id.back_button);
        input_ques=(TextView)findViewById(R.id.question);
        input_ans =(TextView)findViewById(R.id.answer);

        addCard.setOnClickListener(this);
        back.setOnClickListener(this);

    }

    @Override
    public void onClick(View v)
    {
        switch(v.getId())
        {
            case R.id.button_addCard:
            {
                if(input_ques.getText().toString().equals("")&&input_ans.getText().toString().equals(""))
                {
                    Toast.makeText(make.this, "You did not enter a question or an answer", Toast.LENGTH_LONG).show();
                }
                else
                {
                    MainActivity.myDeck.addCard(new card(input_ans.getText().toString(), input_ques.getText().toString()));
                    input_ans.setText("");
                    input_ques.setText("");
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