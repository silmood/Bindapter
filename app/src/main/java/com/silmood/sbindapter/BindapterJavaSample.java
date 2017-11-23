package com.silmood.sbindapter;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.silmood.bindapter.Bindapter;

import java.util.List;
import java.util.Random;

public class BindapterJavaSample extends Fragment {

    private RecyclerView list;
    private Bindapter<Game> bindapter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_list, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        list = view.findViewById(R.id.list);

        setupList();
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.menu_list, menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.item_add:
                addItem();
                break;
            case R.id.item_remove:
                removeItem();
                break;
        }
        return super.onOptionsItemSelected(item);
    }



    private void setupList() {
        list.setLayoutManager(new LinearLayoutManager(getContext()));

        bindapter = new Bindapter<>(R.layout.item, BR.game);
        bindapter.addItems(GameDataSource.Companion.getGames());
        list.setAdapter(bindapter);
    }

    private void addItem() {
        List<Game> games = GameDataSource.Companion.getGames();
        int position = new Random().nextInt(games.size());
        bindapter.addItem(games.get(position));
    }

    private void removeItem() {
        int position = new Random().nextInt(bindapter.getItemCount());
        bindapter.removeItem(position);
    }

}
