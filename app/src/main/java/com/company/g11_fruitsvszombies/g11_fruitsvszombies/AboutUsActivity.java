package com.company.g11_fruitsvszombies.g11_fruitsvszombies;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

public class AboutUsActivity extends AppCompatActivity {
    MediaPlayer backgroundMusic = null;

    @Override
    protected void onResume(){
        super.onResume();
        if (backgroundMusic != null){
            backgroundMusic.start();
        }
    }

    @Override
    protected void onPause(){
        super.onPause();
        if (backgroundMusic != null){
            backgroundMusic.pause();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_g11_about_us);

        ImageButton homeButton = findViewById(R.id.homeButton);
        homeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent goHome = new Intent(AboutUsActivity.this, MainActivity.class);
                startActivity(goHome);
            }
        });

        TextView aboutUs = findViewById(R.id.aboutUsText);
        aboutUs.setText("\nTeam members:\n" +
                "1. Raiyan Reza (HDIT Year 2)\n" +
                "2. Anri Kitami (HDIT Year 2)\n" +
                "3. Howard Tang (HDIT Year 2)\n" +
                "4. Max Chui (HDIT Year 2)\n" +
                "5. Jason Chan (AEng Year 2)\n" +
                "6. Vincent Wong (HDIT Year 2)");

        backgroundMusic = MediaPlayer.create(this,R.raw.about_us_music);
        backgroundMusic.setLooping(true);
    }
}

