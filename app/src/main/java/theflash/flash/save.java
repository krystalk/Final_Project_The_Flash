package theflash.flash;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.os.Bundle;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import android.os.Environment;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by rickygomes on 4/28/15.
 */
public class save extends Activity implements View.OnClickListener
{
    Button save;
    Button back_button;
    TextView name;
    private String newDeck;
    private String title;
    File file;
    FileOutputStream outputStream;

    @Override

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.save);

        save = (Button) findViewById(R.id.button_save);
        back_button = (Button) findViewById(R.id.back_button);

        name = (TextView) findViewById(R.id.deck_name);

        save.setOnClickListener(this);
        back_button.setOnClickListener(this);
    }


    public void onClick(View v)
    {
        switch (v.getId()) {
            case R.id.button_save:
            {
                newDeck = MainActivity.myDeck.deckSave();
                title = name.getText().toString();


                try {
                    file = new File(Environment.getExternalStorageDirectory(), title);
                    outputStream = new FileOutputStream(file);
                    outputStream.write(newDeck.getBytes());
                    outputStream.close();
                }
                catch (IOException e)
                {
                    e.printStackTrace();
                }
                Toast.makeText(save.this, "Your deck has been saved!", Toast.LENGTH_LONG).show();
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
