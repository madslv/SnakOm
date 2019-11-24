package com.example.myapp9.TagSnakken;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapp9.R;

import java.util.ArrayList;

public class SpgAdapter extends RecyclerView.Adapter<SpgAdapter.ViewHolder> {

    private ArrayList<Spg> mSpgs;
    final private OnListItemClickListener mOnListItemClickListener;

    SpgAdapter(ArrayList<Spg> spgs, OnListItemClickListener listener){
        mSpgs = spgs;
        mOnListItemClickListener = listener;
    }

    @NonNull
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.spg_list_item, parent, false);
        return new ViewHolder(view);
    }

    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {
        viewHolder.name.setText(mSpgs.get(position).getName());
        viewHolder.icon.setImageResource(mSpgs.get(position).getIconId());
    }

    public int getItemCount() {
        return mSpgs.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView name;
        ImageView icon;

        ViewHolder(View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.tv_name);
            icon = itemView.findViewById(R.id.iv_icon);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            mOnListItemClickListener.onListItemClick(getAdapterPosition());
        }
    }

    public interface OnListItemClickListener {
        void onListItemClick(int clickedItemIndex);
    }
}

