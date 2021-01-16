package com.example.testhelper;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;


public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.ViewHolder>{

    LayoutInflater inflater;
    ArrayList<String> category;


    CategoryAdapter(Context context, ArrayList<String> category ) {
        this.category = category;
        this.inflater = LayoutInflater.from(context);
    }
    @Override
    public CategoryAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = inflater.inflate(R.layout.category_list_adapter, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(CategoryAdapter.ViewHolder holder, int position) {
       String buffer = category.get(position);
       holder.categoryView.setText(buffer);
    }

    @Override
    public int getItemCount() {
        return category.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
      public final  TextView categoryView;
        ViewHolder(View view){
            super(view);
            categoryView = (TextView) view.findViewById(R.id.category);
        }
    }
}