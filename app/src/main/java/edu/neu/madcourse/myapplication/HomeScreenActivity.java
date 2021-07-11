package edu.neu.madcourse.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class HomeScreenActivity extends AppCompatActivity implements RecyclerViewAdapter.UserSummaryListener{

    private RecyclerView recyclerViewForAllUsers;
    private RecyclerView.LayoutManager recyclerViewLayoutManger;
    private RecyclerViewAdapter recyclerViewAdapter;
    private ArrayList<UserCard> userCards = new ArrayList<>();
    private String username;
    private DatabaseReference mDatabase;
    private DatabaseReference mUsers;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);
        username = getIntent().getStringExtra("USERNAME");

        TextView user_info = (TextView) findViewById(R.id.userInfoTextView);
        user_info.append("Hello " + username + ", send a sticker to any of the app users or see history");

      UserCard user = new UserCard(username);
        //reference to firebase
        mDatabase = FirebaseDatabase.getInstance().getReference();
        //get user reference
        mUsers = mDatabase.child("users");
        //add user to db
        mUsers.child(username).setValue(user);

        initializeRecyclerView();

    }

    private void initializeRecyclerView() {

        // pre-existing users for testing purposes
        String[] usernames = getResources().getStringArray(R.array.pre_existing_users);

        // get users from firebase
        //String[] usernames = getExistingUsers();

        for (String username : usernames) {
            UserCard userCard = new UserCard(username);
            userCards.add(userCard);
        }

        recyclerViewForAllUsers = findViewById(R.id.recyclerViewAllChats);

        recyclerViewLayoutManger = new LinearLayoutManager(this);
        recyclerViewForAllUsers.setLayoutManager(recyclerViewLayoutManger);

        recyclerViewAdapter = new RecyclerViewAdapter(userCards, this);
        recyclerViewForAllUsers.setAdapter(recyclerViewAdapter);
    }

    // called upon clicking onClickSeeAllStickers button
    public void onClickSeeAllStickersButton(View view) {
        System.out.println("SeeAllStickers button clicked");
        startActivity(new Intent(HomeScreenActivity.this, DisplayStickers.class));
    }

    @Override
    public void onUserClick(int position) {
        System.out.println("User clicked at position " + position);

        Intent intent = new Intent(this, ChatHistoryActivity.class);
        intent.putExtra("friend_username", userCards.get(position).getUsername());
        intent.putExtra("current_user_username", username);

        startActivity(intent);
    }

    @Override
    public void onUserSendStickerButtonClick(int position) {
        System.out.println("Send sticker clicked at position " + position);

        Intent intent = new Intent(this, DisplayStickers.class);
        intent.putExtra("friend_username", userCards.get(position).getUsername());
        intent.putExtra("current_user_username", username);

        startActivity(intent);
    }
}