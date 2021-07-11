package edu.neu.madcourse.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ChatHistoryActivity extends AppCompatActivity {

    private RecyclerView recyclerViewChatHistory;
    private RecyclerView.LayoutManager recyclerViewLayoutManger;
    private RecyclerViewAdapterChatHistory recyclerViewAdapterChatHistory;
    private ArrayList<ChatCard> chatCards = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat_history);

        Intent intent = getIntent();
        String friend_username = intent.getStringExtra("friend_username");
        String current_user_username = intent.getStringExtra("current_user_username");

        TextView chat_info = (TextView) findViewById(R.id.chatHistoryInfoText);
        chat_info.append("This is chat history with " + friend_username);

        chatCards = getChatFromFirebase();

        recyclerViewChatHistory = findViewById(R.id.recyclerChatHistory);
        recyclerViewLayoutManger = new LinearLayoutManager(this);
        recyclerViewChatHistory.setLayoutManager(recyclerViewLayoutManger);

        recyclerViewAdapterChatHistory = new RecyclerViewAdapterChatHistory(chatCards,
                current_user_username, friend_username);
        recyclerViewChatHistory.setAdapter(recyclerViewAdapterChatHistory);
    }

    private ArrayList<ChatCard> getChatFromFirebase() {
        ArrayList<ChatCard> chatCards = new ArrayList<>();

        //dummy
        ChatCard chatCard1 = new ChatCard("prajakta", "bob", "sticker1", "1232");
        ChatCard chatCard2 = new ChatCard("bob", "prajakta", "sticker1", "34353");
        chatCards.add(chatCard1);
        chatCards.add(chatCard2);

        return chatCards;
    }
}