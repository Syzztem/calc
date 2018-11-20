package fr.wcs.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
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
        TextView display = this.findViewById(R.id.Display);

    }

    public void clicked(View view){
        System.out.println("r");
    }
    public static void addToDisplay(String add) {
        //TODO
    }

}
