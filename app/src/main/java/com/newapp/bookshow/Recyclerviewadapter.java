package com.newapp.bookshow;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;



public class Recyclerviewadapter extends RecyclerView.Adapter<Recyclerviewadapter.ViewHolder>{

    private ArrayList<String> names = new ArrayList<>();
    private Context context;
    private ArrayList<String> imagenames = new ArrayList<>();



    public Recyclerviewadapter(Context context,ArrayList<String> names,ArrayList<String> imagenames){
        this.names = names;
        this.imagenames=imagenames;
        this.context = context;
    }

    private static final String TAG = "RecyclerViewadapter";

    @NonNull
    @Override
    public Recyclerviewadapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_listitem,parent,false);
        ViewHolder holder = new ViewHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull Recyclerviewadapter.ViewHolder holder, final int position) {


        Log.d(TAG,"onBindViewHolder : called");
        holder.recyclertext.setText(names.get(position));

        Picasso.get().load(imagenames.get(position)).into(holder.recyclerImage);
        holder.parentlayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG,"onClick: clicked on" + names.get(position));

            }
        });

    }

    @Override
    public int getItemCount() {
        return names.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView recyclerImage;
        TextView recyclertext;
        RelativeLayout parentlayout;

        public ViewHolder(View itemView) {
            super(itemView);
            recyclerImage=(ImageView)itemView.findViewById(R.id.recyclerimage);
            recyclertext = (TextView)itemView.findViewById(R.id.recyclertext);
            parentlayout = itemView.findViewById(R.id.parent_layout);
        }
    }
}
