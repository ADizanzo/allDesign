package com.example.alldesign;

import android.content.Context;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class FavoritosAdapter {

    private final List<Product> productList;
    private final Context context;
    private int selectedPosition = RecyclerView.NO_POSITION;

    // Constructor
    public FavoritosAdapter(List<Product> productList, Context context) {
        this.productList = productList;
        this.context = context;
    }



}


