package theflash.flash;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by rickygomes on 4/28/15.
 */
public class study_answer extends Activity implements View.OnClickListener
{
    private TextView answer;
    //private Button back_button;
    Button right_button;
    Button wrong_button;


    @Override

    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.study_ans);

        answer = (TextView) findViewById(R.id.answer_input);
        /*back_button = (Button) findViewById(R.id.back_button);
        back_button.setOnClickListener(this); */

        initializeTextViews();

        right_button = (Button) findViewById(R.id.right_button);
        right_button.setOnClickListener(this);
        wrong_button = (Button) findViewById(R.id.wrong_button);
        wrong_button.setOnClickListener(this);

    }

    public void onClick(View v)
    {
        switch (v.getId())
        {
            case R.id.right_button:
            {
                MainActivity.score1.incRight();
                finish();
                break;
            }
            case R.id.wrong_button:
            {
                MainActivity.score1.incWrong();
                finish();
                break;
            }
        }
    }

    private void initializeTextViews()
    {
        String myanswer = getIntent().getExtras().getString(study.answer2);
        answer.setText(myanswer);
    }

}
