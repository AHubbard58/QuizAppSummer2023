package org.hubbard.quizappsummer2023;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ScoreActivity extends AppCompatActivity {
    TextView scoreTV;
    Button sendBTN;
    int score;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);
        scoreTV =(TextView) findViewById(R.id.scoreTV);
        sendBTN =(Button) findViewById(R.id.sendBTN);
        Intent incomingIntent =getIntent();
        score = incomingIntent.getIntExtra("score", 0);
        scoreTV.setText("score = " + score);

        sendBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String subject = "New quiz score on Mr. Hubbard App";
                String body = "I just scored" + score;
                composeEmail(subject, body);
            }
        });
    }
    private void composeEmail(  String subject,String body ) {
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setData(Uri.parse("mailto:")); // Only email apps handle this.

        intent.putExtra(Intent.EXTRA_SUBJECT, subject);
        intent.putExtra(Intent.EXTRA_TEXT, body);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }
}