package com.company.g11_fruitsvszombies.g11_fruitsvszombies;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class PageTwo extends AppCompatActivity {

    public Button btn_pageThree;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page_two);

        btn_pageThree = (Button)findViewById(R.id.btn_pageThree);


        btn_pageThree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity_pageThree();
            }


        });
    }

    public void openActivity_pageThree(){

        Intent intent = new Intent(this, PageThree.class);
        startActivity(intent);
    }

}

