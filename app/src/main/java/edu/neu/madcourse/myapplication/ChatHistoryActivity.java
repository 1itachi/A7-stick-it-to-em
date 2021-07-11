package edu.neu.madcourse.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ChatHistoryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat_history);

        Intent intent = getIntent();
        String fiend_username = intent.getStringExtra("friend_username");

        TextView chat_info = (TextView) findViewById(R.id.chatHistoryInfoText);
        chat_info.append("This is chat history with " + fiend_username);
    }
}