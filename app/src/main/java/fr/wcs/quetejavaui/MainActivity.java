package fr.wcs.quetejavaui;

import android.graphics.Color;
import android.graphics.Point;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.Gravity;
import android.view.OrientationEventListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Parent Layout
        LinearLayout lMainLayout = this.findViewById(R.id.mainLinearLayout);
        LinearLayout lFnLayout   = new LinearLayout(this);
        LinearLayout lLnLayout   = new LinearLayout(this);
        LinearLayout lCbLayout   = new LinearLayout(this);

        // Views
        TextView welcome   = new TextView(this);
        CheckBox wantTo    = new CheckBox(this);
        EditText firstname = new EditText(this);
        EditText lastname  = new EditText(this);
        Button   accept    = new Button(this);
        Display  display   = getWindowManager().getDefaultDisplay();
        Point    size      = new Point();
        int width;

        // Modify View
        display.getSize(size);
        width = size.x;
        welcome.setText(R.string.text);
        wantTo.setText(R.string.wantTo);
        welcome.setTextColor(Color.parseColor("#000000"));
        welcome.setBackgroundColor(ResourcesCompat.getColor(getResources(), R.color.colorAccent, null));
        accept.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, convertDpToPixel(50)));
        wantTo.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT));

        firstname.setHint(R.string.fn);
        lastname.setHint(R.string.ln);

        accept.setText(R.string.accept);

        // Layout
        LinearLayout.LayoutParams lCb = (new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT));
        lCb.gravity = Gravity.CENTER_HORIZONTAL;
        lCbLayout.setLayoutParams(lCb);

        LinearLayout.LayoutParams lTextLayout =
                new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.MATCH_PARENT,
                        convertDpToPixel(40));
        lTextLayout.setMargins(0, convertDpToPixel(20), 0, convertDpToPixel(10));
        welcome.setLayoutParams(lTextLayout);
        welcome.setGravity(Gravity.CENTER_VERTICAL);

        LinearLayout.LayoutParams lPromptLayout =
                new LinearLayout.LayoutParams(
                        width / 2,
                        convertDpToPixel(60),
                        1);
        firstname.setLayoutParams(lPromptLayout);
        lastname.setLayoutParams(lPromptLayout);

        // Add View to Parent
        lMainLayout.addView(welcome);
        lMainLayout.addView(lCbLayout);
        lCbLayout.addView(wantTo);
        lMainLayout.addView(firstname);
        lMainLayout.addView(lastname);
        lMainLayout.addView(accept);
    }

    private int convertDpToPixel(int dp){
        return Math.round(dp*(getResources().getDisplayMetrics().xdpi/DisplayMetrics.DENSITY_DEFAULT));
    }

}
