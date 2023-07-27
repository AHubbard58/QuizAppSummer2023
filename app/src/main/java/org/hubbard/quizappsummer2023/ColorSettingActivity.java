package org.hubbard.quizappsummer2023;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.content.SharedPreferences;
import android.util.Log;
import android.view.View;

public class ColorSettingActivity extends AppCompatActivity {
    private SharedPreferences mPreferences;
    private String sharedPrefFile = "org.codeintheschools.android.unit3_lesson1_a";
    private final String COLOR_KEY = "COLOR";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_color_setting);
        //initialize the shared preferences
        mPreferences = getSharedPreferences(sharedPrefFile, MODE_PRIVATE);
        //Read initial value
        int initialColor = mPreferences.getInt(COLOR_KEY, 0);
        //grab the main activity's id
        View layout = findViewById(R.id.colorView);
        if (R.id.yellowBTN==initialColor)
        {
            layout.setBackgroundColor(Color.parseColor("yellow"));
            Log.d(null, "yellow");
        }
        else if (R.id.blueBTN==initialColor)
        {
            layout.setBackgroundColor(Color.parseColor("blue"));
        }


    }
        /** Called when the user taps the Send button */
        public void selectColor(View view) {
            // Do something in response to button
            Log.d(null, "Button pressed");

            //grab the main activity's id
            View layout = findViewById(R.id.colorView);

            //Created SharedPreferences editor object
            SharedPreferences.Editor preferencesEditor = mPreferences.edit();

//Write the id of the selected button to our SharedPreferences file
//this is an int Key/Value pair where the:
//key = COLOR_KEY = "COLOR"
//value = view.getID() = "red_button", "blue_button", etc.  
            preferencesEditor.putInt(COLOR_KEY, view.getId());

//Commit the value and save the file.
            preferencesEditor.apply();

            if (R.id.yellowBTN==view.getId())
            {
                layout.setBackgroundColor(Color.parseColor("yellow"));
                Log.d(null, "yellow");
            }
            else if (R.id.blueBTN==view.getId())
            {
                layout.setBackgroundColor(Color.parseColor("blue"));
            }


            //Switch based on  which button was pressed

        }
}