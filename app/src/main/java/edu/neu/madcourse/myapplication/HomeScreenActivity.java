package edu.neu.madcourse.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class HomeScreenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);
    }

    // called upon clicking onClickSeeAllStickers button
    public void onClickSeeAllStickersButton(View view) {
        System.out.println("SeeAllStickers button clicked");
        startActivity(new Intent(HomeScreenActivity.this, DisplayStickers.class));
    }
}