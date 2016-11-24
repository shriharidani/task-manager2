package com.example.shrihari.navbar.Adapter;

import android.support.design.widget.Snackbar;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import com.example.shrihari.navbar.DataObject.dataObject;
import com.example.shrihari.navbar.R;
import com.example.shrihari.navbar.Services.TaskSocketIO;

import java.util.ArrayList;

/**
 * Created by Shrihari on 11/6/2016.
 */
public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {


    private ArrayList<dataObject> titles = TaskSocketIO.getWordList();
    boolean undoOn;

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.content_main,parent,false);
        ViewHolder viewHolder = new ViewHolder(v);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.itemTitle.setText(titles.get(position).getName());
        holder.completed.setChecked(titles.get(position).isCompleted());

    }

    public boolean isUndoOn() {
        return undoOn;
    }

    //Delete
    public void dismiss(int pos){
        titles.remove(pos);
        this.notifyItemRemoved(pos);
    }

    @Override
    public int getItemCount() {
        return titles.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{

        public int currentItem;
        public TextView itemTitle;
        public CheckBox completed;
        public ViewHolder(View itemView) {
            super(itemView);
           itemTitle = (TextView) itemView.findViewById(R.id.item_title);
            completed = (CheckBox) itemView.findViewById(R.id.completed);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition();
                    Snackbar.make(v,"Click detetcted on item "+position,Snackbar.LENGTH_LONG).setAction("Action",null).show();
                }
            });
        }
    }
}
