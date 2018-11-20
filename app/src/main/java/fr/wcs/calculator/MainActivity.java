package fr.wcs.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.TextView;

import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    public static Character[] OPERATORS = {'+','-','/','X'};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // layout init
        TextView display = this.findViewById(R.id.Display);

    }

    public void clicked(View view){
        TextView textView = this.findViewById(R.id.Display);
        String currentDisplay = textView.getText().toString();
        Button b= (Button)view;
        String buttonTxt = b.getText().toString();

        switch (buttonTxt) {

            case "suppr" :
                if(!"".equals(currentDisplay));
                textView.setText(currentDisplay.substring( 0,currentDisplay.length() - 1));
                break;
            case "C" :
                textView.setText("");
                break;

            case "+":
            case "-":
            case "/":
            case "X":
                if(!"".equals( currentDisplay )) {
                    char lastChar = currentDisplay.charAt( currentDisplay.length() - 1 );
                    if(Arrays.asList( OPERATORS ).contains( lastChar )) {
                        textView.setText(currentDisplay.substring( 0,currentDisplay.length() - 1) + buttonTxt);
                    } else {
                        textView.append(b.getText());
                    }
                }

                break;

            case "()":
                char lastChar = currentDisplay.charAt( currentDisplay.length() - 1 );

                if("".equals( currentDisplay )) {
                    textView.setText("(");
                } else if (currentDisplay.endsWith(")")) {
                    textView.append("X(");
                } else if (currentDisplay.endsWith("(") || Arrays.asList( OPERATORS ).contains( lastChar )) {
                    textView.append("(");
                } else textView.append(")");


                //si le dernier charactere est un symbole ou une ouvrante , alors "("
                //si le dernier charactere est un nombre ET que le dernier click "()" à fait "(", then ")"



            default:
                textView.append(b.getText());
                break;
        }



    }


}