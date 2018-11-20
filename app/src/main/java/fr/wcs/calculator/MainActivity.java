package fr.wcs.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private GridLayout buttons = this.findViewById(R.id.buttons);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // layout init
        TextView   display = this.findViewById(R.id.Display);

        for (int i = 0; i < 10; i++) {
            Pad p  = new Pad(this, String.valueOf(i));
            p.setup(this);
        }
    }

    public void addToGrid(Button b){
        this.buttons.addView(b);
    }

    public static void addToDisplay(String add) {
        //TODO
    }

}
