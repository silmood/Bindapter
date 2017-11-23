package com.silmood.sbindapter;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.silmood.bindapter.Bindapter;

public class BindapterJavaSample extends Fragment {

    private RecyclerView list;
    private Bindapter<Game> bindapter;

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

    private void setupList() {
        list.setLayoutManager(new LinearLayoutManager(getContext()));

        bindapter = new Bindapter<>(R.layout.item, BR.game);
        bindapter.addItems(GameDataSource.Companion.getGames());
        list.setAdapter(bindapter);
    }
}
