package com.learning.mkb.material;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.learning.mkb.material.Model.ChatModel;

import java.util.ArrayList;

public class ChatRecyclerViewAdapter extends RecyclerView.Adapter<ChatRecyclerViewAdapter.ViewHolder> {


    ArrayList<ChatModel> chatModelList;
    Context context;

    public ChatRecyclerViewAdapter(ArrayList<ChatModel> chatModelList, Context context) {
        this.chatModelList= chatModelList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(parent.getContext());

        View view = inflater.inflate(R.layout.chat_row_item, parent,false);

        ViewHolder viewHolder = new ViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.chatTextView.setText(chatModelList.get(position).getTitle());

        String uri = "@drawable/" + chatModelList.get(position).getImageName();

        int imageResource  = context.getResources().getIdentifier(uri, null, context.getPackageName());

        Drawable res = context.getResources().getDrawable(imageResource);

        holder.chatImageView.setImageDrawable(res);


    }

    @Override
    public int getItemCount() {

        return chatModelList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView chatTextView;
        ImageView chatImageView;

        public ViewHolder(View itemView) {
            super(itemView);

            chatTextView = (TextView) itemView.findViewById(R.id.chatTextView);
            chatImageView = (ImageView) itemView.findViewById(R.id.imageView);
        }
    }
}
