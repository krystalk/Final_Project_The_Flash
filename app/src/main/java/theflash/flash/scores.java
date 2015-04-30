package theflash.flash;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by rickygomes on 4/27/15.
 */
public class scores extends Activity implements View.OnClickListener
{
    Button back_button;

    TextView percent_right_text;
    TextView percent_wrong_text;
    //public static scoring score;

    @Override

    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.scores);
        back_button = (Button) findViewById(R.id.back_button);
        back_button.setOnClickListener(this);

        percent_right_text=(TextView)findViewById(R.id.percent_right_text);
        percent_wrong_text=(TextView)findViewById(R.id.percent_wrong_text);


        percent_right_text.setText(MainActivity.score1.getRight());
        percent_wrong_text.setText(MainActivity.score1.getWrong());

    }

    public void onClick(View v)
    {
        switch (v.getId())
        {
            case R.id.back_button:
            {
                finish();
                break;
            }
        }
    }


}

