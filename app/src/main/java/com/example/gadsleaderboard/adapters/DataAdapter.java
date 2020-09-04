package com.example.gadsleaderboard.adapters;

import android.content.Context;
import android.provider.ContactsContract;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.gadsleaderboard.R;
import com.example.gadsleaderboard.model.TopLearnersData;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class DataAdapter extends RecyclerView.Adapter<DataAdapter.MyViewHolder> {

    private Context mContext;
    List<TopLearnersData> learnernamesList = new ArrayList<>();

    public void setLearnerNamesList(List<TopLearnersData> learnernameslist) {
        this.learnernamesList = learnernameslist;
        notifyDataSetChanged();
    }
    public DataAdapter(Context mContext, List<TopLearnersData> learnernamesList) {
        this.learnernamesList = learnernamesList;
        this.mContext = mContext;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.row_learner_layout, parent, false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        TopLearnersData topLearnersData = learnernamesList.get(position);
        holder.name.setText(topLearnersData.getName());
//        String thumbnail = topLearnersData.getCountry();
    }

    @Override
    public int getItemCount(){
        return learnernamesList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        public TextView name, hours;
//        ImageView image;

        public MyViewHolder(View view){

            super(view);
            name=view.findViewById(R.id.text_learner_name);
            hours=view.findViewById(R.id.text_learner_hours);
//            name = (TextView) view.findViewById(R.id.text_learner_name);
//            image = (ImageView) view.findViewById(R.id.thumbnail);



        }
    }
}