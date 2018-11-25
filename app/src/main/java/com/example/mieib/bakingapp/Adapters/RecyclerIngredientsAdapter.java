package com.example.mieib.bakingapp.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.mieib.bakingapp.Model.Ingredient;
import com.example.mieib.bakingapp.R;

import java.util.ArrayList;
import java.util.List;


public class RecyclerIngredientsAdapter  extends RecyclerView.Adapter<RecyclerIngredientsAdapter.IngredientsViewHolder>{
    private Context mContext;
    private List<Ingredient> ingredients = new ArrayList<>();
    public RecyclerIngredientsAdapter(Context context){
        mContext = context;
    }

    public class IngredientsViewHolder extends RecyclerView.ViewHolder{
        public TextView quantity;
        public TextView measure;
        public TextView ingredientName;
        public IngredientsViewHolder(View itemView) {
            super(itemView);
            quantity = itemView.findViewById(R.id.ingredient_quantity);
            measure = itemView.findViewById(R.id.ingredient_measure);
            ingredientName = itemView.findViewById(R.id.ingredient_name);

        }
    }

    @Override
    public IngredientsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.list_item_ingredient,parent,false);
        return new IngredientsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(IngredientsViewHolder holder, int position) {
        Ingredient actualIngredient = ingredients.get(position);
        holder.quantity.setText(actualIngredient.getQuantity());
        holder.measure.setText(actualIngredient.getMeasure());
        holder.ingredientName.setText(actualIngredient.getIngredient());
    }

    @Override
    public int getItemCount() {
        if (ingredients==null) return 0;
        return ingredients.size();
    }
    public void setData(List<Ingredient> ingredients){
        this.ingredients = ingredients;
        notifyDataSetChanged();
    }


}
