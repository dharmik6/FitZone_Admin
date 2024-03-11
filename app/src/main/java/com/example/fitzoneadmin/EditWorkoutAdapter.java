package com.example.fitzoneadmin;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;

import java.util.List;

public class EditWorkoutAdapter extends RecyclerView.Adapter<EditWorkoutAdapter.ViewHolder> {
    private List<ExercisesItemList> exercisesItemLists;
    Context context;

    public EditWorkoutAdapter(Context context, List<ExercisesItemList> exercisesItemLists){
        this.exercisesItemLists = exercisesItemLists;
        this.context=context;

    }

    @NonNull
    @Override
    public EditWorkoutAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View tra = LayoutInflater.from(parent.getContext()).inflate(R.layout.exercise_name_delete_list_item, parent, false);
        return new EditWorkoutAdapter.ViewHolder(tra);
    }

    @Override
    public void onBindViewHolder(@NonNull EditWorkoutAdapter.ViewHolder holder, int position) {
        ExercisesItemList member = exercisesItemLists.get(position);
        holder.exename.setText(member.getName());
        holder.exebody.setText(member.getBody());

        // Check if the context is not null before loading the image
        if (context != null) {
            // Load image into CircleImageView using Glide library
            Glide.with(context)
                    .load(member.getImageUrl()) // Assuming getImage() returns the URL of the image
                    .apply(RequestOptions.circleCropTransform()) // Apply circle crop transformation for CircleImageView
                    .diskCacheStrategy(DiskCacheStrategy.ALL) // Cache image to disk
                    .into(holder.exeimage); // Load image into CircleImageView
        }

        // Get the context from the parent view
        final Context context = holder.itemView.getContext();
        // Set OnClickListener for the item
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = holder.getAdapterPosition();
                if (position != RecyclerView.NO_POSITION) {
                    ExercisesItemList item = exercisesItemLists.get(position);

//                    // Create an intent to start the MembersProfile activity
//                    Intent intent = new Intent(context, EditWorkout.class);
//                    // Pass data to the intent
//                    intent.putExtra("imageUrl", item.getImageUrl());
//                    intent.putExtra("name", item.getName());
//                    intent.putExtra("body", item.getBody());
//
//                    // Start the activity
//                    context.startActivity(intent);
                }
            }
        });
    }
    @Override
    public int getItemCount() {
        return exercisesItemLists.size();
    }

    public void filterList(List<ExercisesItemList> filteredList) {
        exercisesItemLists = filteredList;
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView exename;
        public TextView exebody;
        public ImageView exeimage;
        public Button add_exe_delete;
        @SuppressLint("WrongViewCast")
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            exename = itemView.findViewById(R.id.add_exe_name);
            exebody = itemView.findViewById(R.id.add_exe_focus);
            exeimage = itemView.findViewById(R.id.add_exe_image);
            add_exe_delete = itemView.findViewById(R.id.add_exe_delete);
        }
    }
}
