package com.example.project;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    private List<Svamp> items;
    private OnClickListener onClickListener;
    private LayoutInflater layoutInflater;

    RecyclerViewAdapter(Context context, List<Svamp> items, OnClickListener onClickListener) {
        this.items = items;
        this.onClickListener = onClickListener;
        this.layoutInflater = LayoutInflater.from(context);
    }

    @Override
    @NonNull
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(layoutInflater.inflate(R.layout.activity_main2, parent, false));
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.tvName.setText(items.get(position).getName());
        holder.tvCategory.setText(items.get(position).getCategory());
        holder.tvLocation.setText(items.get(position).getLocation());
        holder.tvSize.setText(items.get(position).getSize());
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView tvName;
        TextView tvCategory;
        TextView tvLocation;
        TextView tvSize;

        ViewHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            tvName = itemView.findViewById(R.id.tvName);
            tvCategory = itemView.findViewById(R.id.tvCategory);
            tvSize = itemView.findViewById(R.id.tvSize);
        }

        @Override
        public void onClick(View view) {
            onClickListener.onClick(items.get(getAdapterPosition()));
        }
    }

    public interface OnClickListener {
        void onClick(Svamp item);
    }
}