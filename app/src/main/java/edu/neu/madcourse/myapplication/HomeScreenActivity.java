package edu.neu.madcourse.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class HomeScreenActivity extends AppCompatActivity implements RecyclerViewAdapter.UserSummaryListener{

    private RecyclerView recyclerViewForAllUsers;
    private RecyclerView.LayoutManager recyclerViewLayoutManger;
    private RecyclerViewAdapter recyclerViewAdapter;
    private ArrayList<UserCard> userCards = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);

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

        startActivity(intent);
    }
}