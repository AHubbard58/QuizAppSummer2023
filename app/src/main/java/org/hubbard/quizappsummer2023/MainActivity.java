package org.hubbard.quizappsummer2023;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
TextView questionTV;
Button falseBTN, trueBTN, scoreBTN;
int score;
Question q1, q2, q3, q4, q5,currentQ;
Question[] questions;
int currentIndex;
String message;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        falseBTN = (Button)  findViewById(R.id.falseBTN);
        trueBTN= (Button) findViewById(R.id.trueBTN) ;
        questionTV= (TextView) findViewById(R.id.questionTV);
        scoreBTN= (Button) findViewById(R.id.nextbutton);
        score = 0;
        currentIndex = 0;
         q1 = new Question(getString(R.string.q1text),false );
        q2 = new Question("Quarter is equal to 3.5", false);
        q3 = new Question("Quarter is equal to 4", true);
        q4 = new Question("Quarter is equal to 1", false);
        q5 = new Question("Quarter is equal to 2", false);
        currentQ = q1;
        questions= new Question[]{q1,q2,q3,q4,q5};
        message = "";

         falseBTN.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {

                     if (currentQ.isCorrectAnswer() == false){

                 score++;
                  message=getString(R.string.CorrectMSG);}
                 else{
                     message=("You are wrong");
                 }
                 int duration = Toast.LENGTH_LONG;
                 Toast myToast=Toast.makeText(getApplicationContext(),message,duration);
                 myToast.show();
             }
         });
        trueBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (currentQ.isCorrectAnswer() == true){

                    score++;
                    message="You are corect";}
                else{
                    message=("You are wrong");
                }
                int duration = Toast.LENGTH_LONG;
                Toast myToast=Toast.makeText(getApplicationContext(),message,duration);
                myToast.show();
            }
        });
        scoreBTN.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                currentIndex++;
                if (currentIndex< 5)
                {
                    currentQ = questions[currentIndex];
                    questionTV.setText(currentQ.getQprompt());
                }
                else {
                    Intent scoreIntent = new Intent(MainActivity.this, ScoreActivity.class);
                    scoreIntent.putExtra("score", score);
                    startActivity(scoreIntent);
                }
            }
        });
    }
}