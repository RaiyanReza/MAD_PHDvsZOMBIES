package com.company.g11_fruitsvszombies.g11_fruitsvszombies;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class PageThree extends AppCompatActivity {

    public Button startGame;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page_three);

        startGame = (Button)findViewById(R.id.btn_pageGame);

        startGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity_startGame();
            }


        });
    }

    public void openActivity_startGame(){
        Intent intent = new Intent(this, GameActivity.class);
        startActivity(intent);
    }
}
