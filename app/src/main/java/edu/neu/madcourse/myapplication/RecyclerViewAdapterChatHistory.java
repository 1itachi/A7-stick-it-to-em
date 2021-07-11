package edu.neu.madcourse.myapplication;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.TimeZone;

public class RecyclerViewAdapterChatHistory extends RecyclerView.Adapter<RecyclerViewAdapterChatHistory.RecyclerViewHolder>{

    private ArrayList<ChatCard> chat_card_list;
    private String current_user_username, friend_username;

    public RecyclerViewAdapterChatHistory(ArrayList<ChatCard> chat_card_list,
                                          String current_user_username, String friend_username) {
        this.chat_card_list = chat_card_list;
        this.current_user_username = current_user_username;
        this.friend_username = friend_username;
    }

    @NonNull
    @Override
    public RecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.chat_row, parent, false);
        return new RecyclerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewAdapterChatHistory.RecyclerViewHolder holder, int position) {
        ChatCard chatCard = chat_card_list.get(position);

        int sticker_id = chatCard.getSticker_id();
        String time = chatCard.getTime();
        Long value = Long.parseLong(time);
        Date date = new Date(value);
        DateFormat format = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        format.setTimeZone(TimeZone.getTimeZone("Etc/UTC"));
        String formatted = format.format(date);


        String sender = chatCard.getSender();
        String receiver = chatCard.getReceiver();

        if (sender.equals(current_user_username) && receiver.equals(friend_username)) {
            holder.senderSticker.setImageResource(sticker_id);
            holder.senderStickerTime.setText(formatted);
        } else if(sender.equals(friend_username) && receiver.equals(current_user_username)) {
            holder.receiverSticker.setImageResource(sticker_id);
            holder.receiverStickerTime.setText(formatted);
        }
    }

    @Override
    public int getItemCount() {
        return chat_card_list.size();
    }

    public static class RecyclerViewHolder extends RecyclerView.ViewHolder {

        private ImageView senderSticker;
        private ImageView receiverSticker;
        private TextView senderStickerTime;
        private TextView receiverStickerTime;

        public RecyclerViewHolder(@NonNull View itemView) {
            super(itemView);
            senderSticker = itemView.findViewById(R.id.imageViewSender);
            receiverSticker = itemView.findViewById(R.id.imageViewReceiver);
            senderStickerTime = itemView.findViewById(R.id.textViewSenderTime);
            receiverStickerTime = itemView.findViewById(R.id.textViewReceiverTime);
        }

    }
}
