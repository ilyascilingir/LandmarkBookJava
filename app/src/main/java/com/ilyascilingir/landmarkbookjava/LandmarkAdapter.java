package com.ilyascilingir.landmarkbookjava;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ilyascilingir.landmarkbookjava.databinding.RecyclerRowBinding;

import java.util.ArrayList;
import java.util.List;

public class LandmarkAdapter extends RecyclerView.Adapter<LandmarkAdapter.LandMarkHolder> {

    ArrayList<Landmark> landmarkArrayList;

    public LandmarkAdapter(ArrayList<Landmark> landmarkArrayList) {
        this.landmarkArrayList = landmarkArrayList;
    }

    @NonNull
    @Override
    public LandMarkHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        RecyclerRowBinding recyclerRowBinding = RecyclerRowBinding.inflate(LayoutInflater.from(parent.getContext()),parent,false);
        return new LandMarkHolder(recyclerRowBinding);
    }

    /*@Override
    public void onBindViewHolder(@NonNull LandMarkHolder holder, int position, @NonNull List<Object> payloads) {
        super.onBindViewHolder(holder, position, payloads);
    }*/

    @Override
    public void onBindViewHolder(@NonNull LandMarkHolder holder, int position) {

        holder.landmark = landmarkArrayList.get(position);
        holder.binding.recyclerViewTextView.setText(holder.landmark.name);
        holder.binding.recyclerViewTextView2.setText(holder.landmark.country);

        holder.itemView.setOnClickListener(view -> {
            Intent intent = new Intent(holder.itemView.getContext(),DetailsActivity.class);
            intent.putExtra("Landmark",holder.landmark);
            holder.itemView.getContext().startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return landmarkArrayList.size();
    }

    public class LandMarkHolder extends RecyclerView.ViewHolder{

        private RecyclerRowBinding binding;
        public Landmark landmark;

        public LandMarkHolder(RecyclerRowBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }



}
