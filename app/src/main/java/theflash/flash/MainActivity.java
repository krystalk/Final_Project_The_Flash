package theflash.flash;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;






public class MainActivity extends Activity implements OnClickListener {

    private Button buttonmake;
    private Button buttonstudy;
    private Button buttonscore;
    public static Deck myDeck;
    public static scoring score1;


    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        buttonmake = (Button)findViewById(R.id.make_button);
        buttonstudy = (Button)findViewById(R.id.study_button);
        buttonscore =(Button)findViewById(R.id.scores_button);

        buttonmake.setOnClickListener(this);
        buttonstudy.setOnClickListener(this);
        buttonscore.setOnClickListener(this);

        myDeck = new Deck();
        score1 = new scoring();


    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);

        return true;

    }
    @Override
    public boolean onOptionsItemSelected(MenuItem menu)
    {
        switch(menu.getItemId())
        {
            case R.id.menu_edit:
            {
                Intent intent = new Intent(this,edit.class);
                startActivity(intent);
                break;
            }
            case R.id.menu_clear:
            {
                myDeck.deckClear();
                break;
            }
            case R.id.menu_save:
            {
                Intent intent = new Intent(this,save.class);
                startActivity(intent);
                break;
            }
        }
        return false;
    }

    @Override
    public void onClick(View v) {
        // Inflate the menu; this adds items to the action bar if it is present.
        switch (v.getId())
        {
            case R.id.make_button:
            {
                Intent intent = new Intent(MainActivity.this,make.class);
                startActivity(intent);
                break;
            }
            case R.id.study_button:
            {
                Intent intent = new Intent(MainActivity.this,study.class);
                startActivity(intent);
                break;
            }
            case R.id.scores_button:
            {
                Intent intent = new Intent(MainActivity.this, scores.class);
                startActivity(intent);
                break;
            }
            default:
            {
                break;
            }
        }


    }



}

