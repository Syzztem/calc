package fr.wcs.calculator;

import android.content.Context;
import android.support.v7.widget.AppCompatButton;
import android.view.View;

public class Pad extends AppCompatButton {
    private String display;


    public Pad(Context context, String display) {
        super(context);
        this.display = display;
    }

    public void setup(MainActivity activity) {
        this.setText(display);
        activity.addToGrid(this);
        this.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View V) {

            }

        });
    }
}

