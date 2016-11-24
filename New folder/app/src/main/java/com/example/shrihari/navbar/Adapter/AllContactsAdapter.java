package com.example.shrihari.navbar.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.shrihari.navbar.Activities.addContact;
import com.example.shrihari.navbar.DataObject.AllContacts;
import com.example.shrihari.navbar.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Shrihari on 11/10/2016.
 */
public class AllContactsAdapter extends RecyclerView.Adapter<AllContactsAdapter.ViewHolder> {

    private List<AllContacts> mContactList;

    public AllContactsAdapter(List<AllContacts> mContactList){
        this.mContactList = mContactList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.contacts,null);
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

       // holder.contactNumber.setText(mContactList.get(position).getContactNumber());
        holder.contactName.setText(mContactList.get(position).getContactName());
        //holder.contactImage.setImageIcon();

    }

    @Override
    public int getItemCount() {
        return mContactList.size();
    }



    class ViewHolder extends RecyclerView.ViewHolder {
       ImageView contactImage;
        TextView contactNumber;
        TextView contactName;
        public ViewHolder(final View itemView) {
            super(itemView);
            contactImage = (ImageView)itemView.findViewById(R.id.ivcontactImage);
            contactName = (TextView)itemView.findViewById(R.id.txtcontacName);
            //contactNumber = (TextView)itemView.findViewById(R.id.txtcontactNumber);
            itemView.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v){
                    int pos = getAdapterPosition();
                    Toast.makeText(itemView.getContext(), mContactList.get(pos).getContactName()+" Added", Toast.LENGTH_SHORT).show();
                    addContact.toAddContacts = "UserName "+mContactList.get(pos).getContactName()+
                                                ";Number "+mContactList.get(pos).getContactNumber();


                    }
            });


        }

    }
}
