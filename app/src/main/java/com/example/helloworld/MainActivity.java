package com.example.helloworld;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //connect layout to main activity (what buttons do and where buttons are)
        setContentView(R.layout.activity_main);
        //search for a button (in the layout) and cast and store it in a button variable
        Button button = (Button) findViewById(R.id.button);
        Button secondActivity = (Button) findViewById(R.id.secondActivityBtn);
        //actions below are caused by button press
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView textView = (TextView) findViewById(R.id.textView);
                textView.setText("huehuehuehue");
            }
        }
        );
        //launching second activity within app
        secondActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //create a new intent and link it to the second activity. provide link from main activity to second one
                Intent startIntent = new Intent(getApplicationContext(),SecondActivity.class);
                //extra info to be associated with the new intent (starting the second activity)
                startIntent.putExtra("com.example.helloworld.SOMETHING","COMMUNISM IS THE ONLY WAY!!!");
                //causes the second activity to be started
                startActivity(startIntent);
                //all happens within a button press
            }
        });
        //launching another app within the app
        Button youtubeBtn = (Button) findViewById(R.id.otherAppBtn);
        //what happens when youtubebtn is pressed
        youtubeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //store website address in a string and parse it into a legible  format
                String youtube = "http://www.youtube.com";
                Uri webaddress = Uri.parse(youtube);

                Intent gotoYoutube = new Intent(Intent.ACTION_VIEW,webaddress);

                if(gotoYoutube.resolveActivity(getPackageManager()) != null){
                    startActivity(gotoYoutube);
                }
            }
        });
    }
}
