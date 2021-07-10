package edu.neu.madcourse.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {

    private static final String SERVER_KEY = "AAAAMuvSWzI:APA91bGmSW15pFeh-c2VyDuke4Oz6YDBSGxiFZFObdDuXsbUe6ecSPZnIp8WY1slnlMNXYPaxREh03bgxqkjH3ecTrDk2q48I7mkpq8TbuZC-1JzgCL_TRFChePN6MFKcTTa3TOh9siO";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    // called upon clicking Login button
    public void onClickLoginButton(View view) {
        System.out.println("Login button clicked");

        TextView usernameTextView = (TextView) findViewById(R.id.editUsername);
        String username = usernameTextView.getText().toString();

        if (!userExists(username)) {
            createNewUser(username);
        }

        startActivity(new Intent(LoginActivity.this, HomeScreenActivity.class));
    }

    // saves the new user to database
    private void createNewUser(String username) {
    }

    // returns True if user exists, else False
    private boolean userExists(String username) {
        // write an api call to fetch if user exists
        return true;
    }
}