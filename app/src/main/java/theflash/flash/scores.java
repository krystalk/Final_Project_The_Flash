package theflash.flash;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class scores extends Activity implements View.OnClickListener //the scores class
{
    Button back_button; //back button variable for the back button

    TextView percent_right_text; //percent right text for the number of cards gotten right
    TextView percent_wrong_text; //percent wrong text for the number of cards gotten wrong
    //public static scoring score;

    @Override

    protected void onCreate(Bundle savedInstanceState) //when the activity loads
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.scores); //loads the scores.xml layout
        back_button = (Button) findViewById(R.id.back_button); //sets the back button variable equal to the back_button
        back_button.setOnClickListener(this); //allows for the back button to have a function when it is clicked

        percent_right_text=(TextView)findViewById(R.id.percent_right_text); //sets the percent right text variable equal to the corresponding text field
        percent_wrong_text=(TextView)findViewById(R.id.percent_wrong_text); //sets the percent wrong text variable equal to the corresponding text field


        percent_right_text.setText(MainActivity.score1.getRight()); //sets the text of percent right equal to the number of cards gotten right (by accessing the dynamic score1 variable created in the MainActivity)
        percent_wrong_text.setText(MainActivity.score1.getWrong()); //sets the text of percent wrong equal to the number of cards gotten wrong (by accessing the dynamic score1 variable created in the MainActivity)

    }

    public void onClick(View v) //when something is clicked
    {
        switch (v.getId())
        {
            case R.id.back_button: //if the back button is clicked
            {
                finish();
                break;
            }
        }
    }


}

