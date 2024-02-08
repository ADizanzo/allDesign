package com.example.alldesign;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class FavoritosAdapter extends RecyclerView.Adapter<FavoritosAdapter.ProductViewHolder> {

    private final List<Product> productList;
    private final Context context;

    // Constructor
    public FavoritosAdapter(Context context, List<Product> productList) {
        this.context = context;
        this.productList = productList;
    }

    @NonNull
    @Override
    public ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.activity_favoritos, parent, false);
        return new ProductViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductViewHolder holder, int position) {
        Product product = productList.get(position);
        // Configurar los elementos de la vista ViewHolder con los datos del producto
        holder.productTitle.setText(product.getName());
        holder.productPrice.setText(product.getPrice());
        // Aquí puedes configurar la imagen del producto si es necesario
    }

    @Override
    public int getItemCount() {
        return productList.size();
    }

    public int getSelectedPosition() {
        return 0;
    }


    // Clase ViewHolder para los elementos de la lista
    public static class ProductViewHolder extends RecyclerView.ViewHolder {

        TextView productTitle;
        TextView productPrice;

        public ProductViewHolder(@NonNull View itemView) {
            super(itemView);
            productTitle = itemView.findViewById(R.id.productTitle);
            productPrice = itemView.findViewById(R.id.productPrice);
            // Inicializar otros elementos de la vista ViewHolder aquí si es necesario
        }
    }
}
