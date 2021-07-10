package edu.neu.madcourse.myapplication;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ChatRowActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat_row);
    }

    // called upon clicking Send Sticker button
    public void onClickSendSticker(View view) {
        System.out.println("Send sticker button clicked");
        startActivity(new Intent(ChatRowActivity.this, DisplayStickers.class));
    }

}