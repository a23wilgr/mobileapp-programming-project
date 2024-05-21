package com.example.project;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    private List<Svamp> svampar;
    private LayoutInflater layoutInflater;
    private OnClickListener onClickListener;

    RecyclerViewAdapter(Context context, List<Svamp> Svampar, OnClickListener onClickListener) {
        this.layoutInflater = LayoutInflater.from(context);
        this.svampar = svampar;
        this.onClickListener = onClickListener;
    }

    @Override
    @NonNull
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = (layoutInflater.inflate(R.layout.activity_recyclerview_item, parent, false));
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Svamp svamp = svampar.get(position);
        holder.tvName.setText(svampar.get(position).getName());
        holder.tvLocation.setText(svampar.get(position).getLocation());
        holder.tvCategory.setText(svampar.get(position).getCategory());
        holder.tvSize.setText(svampar.get(position).getSize());
    }

    @Override
    public int getItemCount() {
        return svampar.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView tvName;
        TextView tvLocation;
        TextView tvCategory;
        TextView tvSize;


        ViewHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            tvName = itemView.findViewById(R.id.tvName);
            tvLocation = itemView.findViewById(R.id.tvLocation);
            tvCategory = itemView.findViewById(R.id.tvCategory);
            tvSize = itemView.findViewById(R.id.tvSize);
        }

        @Override
        public void onClick(View view) {
            onClickListener.onClick(svampar.get(getAdapterPosition()));
        }
    }

    public interface OnClickListener {
        void onClick(Svamp item);
    }
}