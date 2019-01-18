package com.example.cheeku.mycollections;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public  class adapter extends RecyclerView.Adapter<adapter.MyViewHolder> {
    private List<String> moviesList;
    private Context mContext;
    public static int k;


    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        public TextView title;
        public MyViewHolder(View view) {
            super(view);
            view.setOnClickListener(this);
            title = (TextView) view.findViewById(R.id.ttle);
        }


        @Override
        public void onClick(View view) {
            Intent myIntent;
            myIntent = new Intent(mContext, product.class);
             k = getAdapterPosition();
            myIntent.putExtra("key", MainActivity.coolid.get(k)); //Optional parameters
            mContext.startActivity(myIntent);
            //Toast.makeText(view.getContext(),"Hello Javatpoint",Toast.LENGTH_SHORT).show();
        }
    }

    public adapter(Context context, ArrayList<String> moviesList) {
        this.moviesList = moviesList;
        mContext = context;

    }


    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull adapter.MyViewHolder holder, int position) {
        String s = moviesList.get(position);
        holder.title.setText(s);

    }

    @Override
    public int getItemCount() {
        return moviesList.size();
    }
}
