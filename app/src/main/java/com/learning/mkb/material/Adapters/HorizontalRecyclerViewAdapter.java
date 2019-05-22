package com.learning.mkb.material.Adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.learning.mkb.material.Interfaces.RecyclerViewOnItemClickListener;
import com.learning.mkb.material.Model.ChatModel;
import com.learning.mkb.material.R;

import java.util.ArrayList;
import java.util.HashMap;

public class HorizontalRecyclerViewAdapter extends RecyclerView.Adapter<HorizontalRecyclerViewAdapter.ViewHolder> {

    RecyclerViewOnItemClickListener recyclerViewOnItemClickListener;

    public HorizontalRecyclerViewAdapter(RecyclerViewOnItemClickListener recyclerViewOnItemClickListener) {
        this.recyclerViewOnItemClickListener = recyclerViewOnItemClickListener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.chat_horizontal_row,parent,false);

        ViewHolder viewHolder = new ViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 10;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {


        RecyclerView recyclerView;
        public ViewHolder(View itemView) {
            super(itemView);

            recyclerView = itemView.findViewById(R.id.horizontalRecyclerView);

            LinearLayoutManager layoutManager = new LinearLayoutManager(itemView.getContext());
            layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
            recyclerView.setLayoutManager(layoutManager);


//
//            StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
//
//
//            staggeredGridLayoutManager.setOrientation(staggeredGridLayoutManager.HORIZONTAL);
//             recyclerView.setLayoutManager(staggeredGridLayoutManager);

            HashMap<String,Object> emplyoyee = new HashMap<>();

            emplyoyee.put("Name", "Anil");
            emplyoyee.put("Age", 25);
            emplyoyee.put("Gender", "M");
            emplyoyee.put("company", "xyz");
            emplyoyee.put("Name", "Vikash");

            emplyoyee.get("Name");

            emplyoyee.keySet();

            ArrayList<ChatModel> list = new ArrayList<>();

            ChatModel chatModel1 = new ChatModel();
            chatModel1.setTitle("Hyderbad");
            chatModel1.setImageName("apple_pie");
            chatModel1.setPrice(22.0);

            list.add(chatModel1);

            ChatModel chatModel2 = new ChatModel();
            chatModel2.setTitle("Bangalore");
            chatModel2.setImageName("berry_tart");
            chatModel2.setPrice(22.0);
            list.add(chatModel2);

            ChatModel chatModel3 = new ChatModel();
            chatModel3.setTitle("Chennai");
            chatModel3.setImageName("brownie");
            chatModel3.setPrice(22.0);


            list.add(chatModel3);

            ChatModel chatModel4 = new ChatModel();
            chatModel4.setTitle("Kochi");
            chatModel4.setImageName("cafe_latte");
            chatModel4.setPrice(22.0);

            list.add(chatModel4);

            ChatModel chatModel5 = new ChatModel();
            chatModel5.setTitle("Pune");
            chatModel5.setImageName("cafe_latte");
            chatModel5.setPrice(22.0);

            list.add(chatModel5);

            ChatModel chatModel6 = new ChatModel();
            chatModel6.setTitle("Delhi");
            chatModel6.setImageName("classic_burger");
            chatModel6.setPrice(22.0);

            list.add(chatModel6);

            ChatRecyclerViewAdapter chatRecyclerViewAdapter = new ChatRecyclerViewAdapter(list, itemView.getContext(), recyclerViewOnItemClickListener);

            recyclerView.setAdapter(chatRecyclerViewAdapter);

        }


        }
    }



