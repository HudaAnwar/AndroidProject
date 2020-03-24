package com.example.homeactivity.View;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import com.example.homeactivity.R;
import com.example.homeactivity.Pojos.TripPojo;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    private LayoutInflater inflater;
    private ArrayList<TripPojo> tripList;
    Context context;
    public MyAdapter(Context ctx, ArrayList<TripPojo> tripList){

        inflater = LayoutInflater.from(ctx);
        this.tripList = tripList;
        context = ctx;
    }

    @Override
    public MyAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = inflater.inflate(R.layout.recycler_item, parent, false);
        MyViewHolder holder = new MyViewHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(MyAdapter.MyViewHolder holder, int position) {

        holder.time.setText(tripList.get(position).getTripName());
    }

    @Override
    public int getItemCount() {
        return tripList.size();
    }



    public void removeItem(int position) {
        tripList.remove(position);
        notifyItemRemoved(position);
    }

    public void restoreItem(TripPojo item, int position) {
        tripList.add(position, item);
        notifyItemInserted(position);
    }

    public ArrayList<TripPojo> getData() {
        return tripList;
    }

    class MyViewHolder extends RecyclerView.ViewHolder{

        TextView time;
        Button start;
        Button edit;


        public MyViewHolder(View itemView) {
            super(itemView);
            time = (TextView) itemView.findViewById(R.id.tripNameTxt);
            start = (Button)  itemView.findViewById(R.id.startBtn);
            edit = (Button) itemView.findViewById(R.id.editBtn);
            start.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(context,"onClick:from start",Toast.LENGTH_LONG).show();

                    Log.i("TAG", "onClick:from start ");
                }
            });
            edit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(context,"onClick:from edit ",Toast.LENGTH_LONG).show();

                    Log.i("TAG", "onClick: from edit ");
                }
            });
        }

    }
}