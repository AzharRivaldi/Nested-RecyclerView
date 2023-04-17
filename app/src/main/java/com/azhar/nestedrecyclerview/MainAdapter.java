package com.azhar.nestedrecyclerview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

/**
 * Created by Azhar Rivaldi on 14-02-2023
 * Youtube Channel : https://bit.ly/2PJMowZ
 * Github : https://github.com/AzharRivaldi
 * Twitter : https://twitter.com/azharrvldi_
 * Instagram : https://www.instagram.com/azhardvls_
 * LinkedIn : https://www.linkedin.com/in/azhar-rivaldi
 */

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.ViewHolder> {

    Context context;
    ArrayList<String> arrayList;

    MainAdapter(Context context, ArrayList<String> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public MainAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_main,
                parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MainAdapter.ViewHolder holder, int position) {
        holder.tvListData.setText(arrayList.get(position));

        ArrayList<String> arrayListData = new ArrayList<>();

        for (int i = 1; i <= 3; i++) {
            arrayListData.add("Sub Data Ke : " + i);
        }

        DataAdapter dataAdapter = new DataAdapter(context, arrayListData);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context);

        holder.rvListMain.setLayoutManager(linearLayoutManager);
        holder.rvListMain.setAdapter(dataAdapter);
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        TextView tvListData;
        RecyclerView rvListMain;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            tvListData = itemView.findViewById(R.id.tvListData);
            rvListMain = itemView.findViewById(R.id.rvListMain);
        }
    }
}
