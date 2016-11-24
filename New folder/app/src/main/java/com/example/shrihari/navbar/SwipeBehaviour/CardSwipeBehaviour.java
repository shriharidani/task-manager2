package com.example.shrihari.navbar.SwipeBehaviour;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;

import com.example.shrihari.navbar.Adapter.RecyclerViewAdapter;

/**
 * Created by Shrihari on 11/6/2016.
 */
public class CardSwipeBehaviour extends ItemTouchHelper.SimpleCallback {

    RecyclerViewAdapter adapter;

    public CardSwipeBehaviour(int dragDirs, int swipeDirs) {
        super(dragDirs, swipeDirs);
    }

    public CardSwipeBehaviour(RecyclerViewAdapter adapter) {
        super(ItemTouchHelper.DOWN|ItemTouchHelper.UP,ItemTouchHelper.LEFT);
        this.adapter = adapter;

    }

    @Override
    public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {
        return false;
    }

    @Override
    public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) {
        adapter.dismiss(viewHolder.getAdapterPosition());
    }
}
