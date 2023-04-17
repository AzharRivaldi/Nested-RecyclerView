package com.azhar.nestedrecyclerview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;

import androidx.annotation.NonNull;
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

public class SubDataAdapter extends RecyclerView.Adapter<SubDataAdapter.ViewHolder> {

    ArrayList<String> arrayListData;
    int lastSelectedPosition = -1;

    public SubDataAdapter(ArrayList<String> arrayListData) {
        this.arrayListData = arrayListData;
    }

    @NonNull
    @Override
    public SubDataAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_sub_data,
                parent, false);
        return new SubDataAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SubDataAdapter.ViewHolder holder, int position) {

        holder.rbData.setText(arrayListData.get(position));
        holder.rbData.setChecked(lastSelectedPosition == position);
    }

    public int getItemCount() {
        return arrayListData.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        RadioButton rbData;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            rbData = itemView.findViewById(R.id.rbData);

            rbData.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    lastSelectedPosition = getAdapterPosition();
                    notifyDataSetChanged();
                }
            });
        }
    }
}
