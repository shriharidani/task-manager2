package com.example.shrihari.navbar.Fragment;

import android.app.Fragment;
import android.app.Service;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.SwipeDismissBehavior;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.shrihari.navbar.Adapter.RecyclerViewAdapter;
import com.example.shrihari.navbar.R;
import com.example.shrihari.navbar.Services.TaskSocketIO;
import com.example.shrihari.navbar.SwipeBehaviour.CardSwipeBehaviour;

/**
 * Created by Shrihari on 11/5/2016.
 */
public class CardSwipe extends android.support.v4.app.Fragment {

    private CardView mCardView;
    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    RecyclerViewAdapter adapter;

    public static CardSwipe getInstance(){
        CardSwipe cardSwipe = new CardSwipe();
        return cardSwipe;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.android_fragment,container,false);
        return view;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        /* Starting service for socketio*/

        Intent serviceIntent = new Intent(getContext(), TaskSocketIO.class);
        serviceIntent.putExtra("KEY","Random string to be used in service socketio");
        //Log.e("Shrihari started","Service..");
        getContext().startService(serviceIntent);
        /* Ending service for socketio*/
        adapter = new RecyclerViewAdapter();
        recyclerView = (RecyclerView)view.findViewById(R.id.rec);
        if(recyclerView != null) {
            mCardView = (CardView) view.findViewById(R.id.swype_card);

            layoutManager = new LinearLayoutManager(getActivity());
            recyclerView.setLayoutManager(layoutManager);
            recyclerView.setAdapter(adapter);
            setUPSwipeBehaviour();
        }

        else{
            //Log.e("Shrihari","recycler null");
        }

    }

    private void setUPSwipeBehaviour() {
        ItemTouchHelper.Callback callback = new CardSwipeBehaviour(adapter);
        ItemTouchHelper helper = new ItemTouchHelper(callback);
        helper.attachToRecyclerView(recyclerView);
    }

    @Override
    public void onResume() {
        super.onResume();

    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

}
