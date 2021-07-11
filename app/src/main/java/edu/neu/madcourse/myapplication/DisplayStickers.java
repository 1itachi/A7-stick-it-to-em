package edu.neu.madcourse.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

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

    // called upon clicking any image
    public void onClickImageButton(View view) {
        String sticker_tag = (String)view.getTag();
        System.out.println("Image clicked for tag " + sticker_tag);

        Toast myToast = Toast.makeText(this, "Sticker sent!", Toast.LENGTH_LONG);
        myToast.show();

    }
}