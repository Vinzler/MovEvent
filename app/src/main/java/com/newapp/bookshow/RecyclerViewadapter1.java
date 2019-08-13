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

public class RecyclerViewadapter1 extends RecyclerView.Adapter<RecyclerViewadapter1.ViewHolder> {

    private ArrayList<String> singers = new ArrayList<>();
    private ArrayList<String> singernames = new ArrayList<>();
    private Context context;

    public RecyclerViewadapter1(Context context, ArrayList<String> singernames, ArrayList<String>  singers){
            this.context = context;
            this.singernames = singernames;
            this.singers = singers;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_listitem1,parent,false);
        ViewHolder holder = new ViewHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.singernames.setText(singernames.get(position));
        Picasso.get().load(singers.get(position)).into(holder.singers);

    }

    @Override
    public int getItemCount() {
        return singernames.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        RelativeLayout relativeLayout1;
        ImageView singers;
        TextView singernames;

        public ViewHolder(View itemView){
            super(itemView);

            relativeLayout1 = itemView.findViewById(R.id.relativelayout1);
            singers = itemView.findViewById(R.id.singers);
            singernames = itemView.findViewById(R.id.singernames);

        }
    }
}
