package com.newapp.bookshow;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class Recyclerviewadapter2 extends RecyclerView.Adapter<Recyclerviewadapter2.ViewHolder> {

    private ArrayList<String> textbox= new ArrayList<>();
    private Context context;

    public Recyclerviewadapter2(Context context, ArrayList<String> textbox){
        this.context = context;
        this.textbox = textbox;
    }

    @NonNull
    @Override
    public Recyclerviewadapter2.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_listitem2,parent,false);
        Recyclerviewadapter2.ViewHolder holder = new Recyclerviewadapter2.ViewHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull Recyclerviewadapter2.ViewHolder holder, int position) {

        holder.textboxview.setText(textbox.get(position));


    }

    @Override
    public int getItemCount() {
        return textbox.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        RelativeLayout relativeLayout1;
        TextView textboxview;

        public ViewHolder(View itemView){
            super(itemView);

            relativeLayout1 = itemView.findViewById(R.id.relativelayout4);
            textboxview = itemView.findViewById(R.id.textboxevent);

        }
    }
}
