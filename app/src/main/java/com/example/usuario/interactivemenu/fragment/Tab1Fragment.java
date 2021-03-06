package com.example.usuario.interactivemenu.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.usuario.interactivemenu.R;
import com.example.usuario.interactivemenu.adapters.MyAdapter;
import com.example.usuario.interactivemenu.data.Items;
import com.example.usuario.interactivemenu.process.ReadLocalJSON;

import java.util.ArrayList;


public class Tab1Fragment extends Fragment {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;
    final ReadLocalJSON readLocalJSON = new ReadLocalJSON();

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

       GridLayoutManager recycleLayoutManager = new GridLayoutManager(container.getContext(), 2, GridLayoutManager.VERTICAL, false);

        View v = inflater.inflate(R.layout.activity_tab1_fragment,container, false);
        recyclerView = (RecyclerView) v.findViewById(R.id.recycler);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(container.getContext());
        recyclerView.setLayoutManager(recycleLayoutManager);
        ArrayList<Items> itemses = null;
        itemses = readLocalJSON.getItemses(v.getContext(), 0);
        mAdapter = new MyAdapter(itemses);
        recyclerView.setAdapter(mAdapter);
        return v;
    }


}
