package com.angogasapps.recyclerviewlesson;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MessageHolder> {
    private List<Message> messageList = new ArrayList<>();

    public MyAdapter(List<Message> messageList) {
        this.messageList = messageList;
    }

    @NonNull
    @Override
    public MessageHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MessageHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.message_view_holder, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull MessageHolder holder, int position) {
        holder.bind(messageList.get(position));
    }

    @Override
    public int getItemCount() {
        return messageList.size();
    }

    class MessageHolder extends RecyclerView.ViewHolder {
        private TextView textView;

        public MessageHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.text);
            textView.setOnLongClickListener(v -> {
                messageList.remove(this.getLayoutPosition());
                MyAdapter.this.notifyItemRemoved(getLayoutPosition());
                return false;
            });
        }

        public TextView getTextView() {
            return textView;
        }

        public void bind(Message message) {
            textView.setText(message.getText());
        }
    }
}



