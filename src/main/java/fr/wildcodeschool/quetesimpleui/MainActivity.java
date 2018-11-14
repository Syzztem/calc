package fr.wildcodeschool.quetesimpleui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView firstname = findViewById(R.id.firstname);
        final TextView lastname = findViewById(R.id.lastname);
        final TextView okay = findViewById((R.id.okay));
        final Button accept = findViewById(R.id.accept);
        final CheckBox wantTo = findViewById(R.id.wantto);
        wantTo.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                firstname.setEnabled(!firstname.isEnabled());
                lastname.setEnabled(!lastname.isEnabled());
            }
        });
            accept.setOnClickListener(new View.OnClickListener()
            {
                public void onClick(View v) {
                    String fullname = getResources().getString(R.string.gg) + " " + firstname.getText().toString() + " " + lastname.getText().toString();
                    if (TextUtils.isEmpty(firstname.getText().toString()) || TextUtils.isEmpty(lastname.getText().toString())) //if nothing turned in
                        Toast.makeText(getApplicationContext(), R.string.errtoast1, Toast.LENGTH_SHORT).show();
                    else
                        okay.setText(fullname);
                }
            });
    }
}
