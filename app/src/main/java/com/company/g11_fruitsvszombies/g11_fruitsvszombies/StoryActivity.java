package com.company.g11_fruitsvszombies.g11_fruitsvszombies;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class StoryActivity extends AppCompatActivity {

    public Button btn_pageTwo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_g11_story);
        Toast.makeText(this,"Scroll down for more",Toast.LENGTH_SHORT).show();

        btn_pageTwo = (Button)findViewById(R.id.btn_pageTwo);
        btn_pageTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity_instruction();
            }
        });
    }

    public void openActivity_instruction(){
        Intent intent = new Intent(this, PageTwo.class);
        startActivity(intent);
    }
}
