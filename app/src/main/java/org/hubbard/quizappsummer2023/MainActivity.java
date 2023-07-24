package org.hubbard.quizappsummer2023;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
TextView questionTV;
Button falseBTN, trueBTN;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        falseBTN = (Button)  findViewById(R.id.falseBTN);
        trueBTN= (Button) findViewById(R.id.trueBTN) ;
        questionTV= (TextView) findViewById(R.id.falseBTN);

         falseBTN.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 String message="You are corect";
                 int duration = Toast.LENGTH_LONG;
                 Toast myToast=Toast.makeText(getApplicationContext(),message,duration);
                 myToast.show();
             }
         });
        trueBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String message="You are incorect";
                int duration = Toast.LENGTH_LONG;
                Toast myToast=Toast.makeText(getApplicationContext(),message,duration);
                myToast.show();
            }
        });
    }
}