package edu.neu.madcourse.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class DisplayStickers extends AppCompatActivity {
    private String current_user_username;
    private String friend_username;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_stickers);

        current_user_username = getIntent().getStringExtra("current_user_username");
        friend_username = getIntent().getStringExtra("friend_username");
        TextView send_sticker_info = (TextView) findViewById(R.id.sendStickerInfo);
        send_sticker_info.append("Send any of these stickers to " + friend_username);

    }
}