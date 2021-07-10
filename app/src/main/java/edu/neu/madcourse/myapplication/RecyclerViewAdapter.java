package edu.neu.madcourse.myapplication;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.RecyclerViewHolder>{

    private ArrayList<UserCard> user_card_list;

    public RecyclerViewAdapter(ArrayList<UserCard> user_card_list) {
        this.user_card_list = user_card_list;
    }

    @NonNull
    @Override
    public RecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.user_chat_summary, parent, false);
        return new RecyclerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewHolder holder, int position) {
        String username = user_card_list.get(position).getUsername();
        holder.username.setText(username);
        holder.sendSticker.setTag(username);
    }

    @Override
    public int getItemCount() {
        return user_card_list.size();
    }

    public static class RecyclerViewHolder extends RecyclerView.ViewHolder{

        private TextView username;
        private Button sendSticker;

        public RecyclerViewHolder(@NonNull View itemView) {
            super(itemView);
            username = itemView.findViewById(R.id.usernameTextView);
            sendSticker = itemView.findViewById(R.id.sendStickerButton);
        }
    }
}
