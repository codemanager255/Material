package com.learning.mkb.material.Adapters;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.learning.mkb.material.Interfaces.RecyclerViewOnItemClickListener;
import com.learning.mkb.material.Model.ChatModel;
import com.learning.mkb.material.R;

import java.util.ArrayList;

public class ChatRecyclerViewAdapter extends RecyclerView.Adapter<ChatRecyclerViewAdapter.ViewHolder> {


    ArrayList<ChatModel> chatModelList;
    Context context;
    RecyclerViewOnItemClickListener recyclerViewOnItemClickListener;

    public ChatRecyclerViewAdapter(ArrayList<ChatModel> chatModelList, Context context, RecyclerViewOnItemClickListener recyclerViewOnItemClickListener) {
        this.chatModelList= chatModelList;
        this.context = context;
        this.recyclerViewOnItemClickListener = recyclerViewOnItemClickListener;
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


        holder.onBind(chatModelList.get(position));
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

        public void onBind(final ChatModel chatModel) {
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    recyclerViewOnItemClickListener.onItemClick(chatModel);
                }
            });
        }
        }
}
