package com.example.drg.ubuntuaudiobot;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final EditText texta = findViewById(R.id.texta);
        final EditText textb = findViewById(R.id.textb);
        final TextView result = findViewById(R.id.result);

        View.OnFocusChangeListener fcl = new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(!hasFocus){
                    result.setText("Result : " + addPositives(texta.getText().toString(),textb.getText().toString()));
                }
            }
        };

        texta.setOnFocusChangeListener(fcl);
        textb.setOnFocusChangeListener(fcl);
    }
    public static int addPositives(String a, String b){
        try {
            int num1 = Integer.parseInt(a);
            int num2 = Integer.parseInt(b);
            return addPositives(num1, num2);
        }catch (NumberFormatException nfe){
            return 0;
        }
    }

    public static int addPositives(int a, int b){
        if(a < 0){
            if(b  < 0){
                return  0;
            }
            return  b;
        }
        if(b  < 0 )
        {
            if (a < 0)
                return  0;
            return a;
        }
        return a + b;

    }
}
