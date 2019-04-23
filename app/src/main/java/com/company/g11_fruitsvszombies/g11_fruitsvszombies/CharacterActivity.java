package com.company.g11_fruitsvszombies.g11_fruitsvszombies;

import android.media.Image;
import android.support.v4.view.GestureDetectorCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class CharacterActivity extends AppCompatActivity {

    private ImageView characterImageView;
    private TextView characterNameTextView;
    private Button chooseCharacterButton;
    private Button previousCharacterButton;
    private Button nextCharacterButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_character);


    }
}
