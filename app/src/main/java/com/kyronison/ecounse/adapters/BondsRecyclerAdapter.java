package com.kyronison.ecounse.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.kyronison.ecounse.R;
import com.kyronison.ecounse.model.Instrument;

import java.util.ArrayList;
import java.util.List;

public class BondsRecyclerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private LayoutInflater inflater;
    private List<Instrument> bonds;
    private Context context;
    private int counter = 0;

    public BondsRecyclerAdapter(Context context, ArrayList<Instrument> bonds) {
        this.inflater = LayoutInflater.from(context);
        this.bonds = bonds;
        this.context = context;

    }

    public void setBonds(List<Instrument> bonds) {
        this.bonds = bonds;
    }

    private class MyHolder extends RecyclerView.ViewHolder {
        private TextView bondsName;
        private TextView bondsTicker;
        private TextView bondsTime;
        private TextView bondsPrice;

        public MyHolder(@NonNull View itemView) {
            super(itemView);
            bondsName = itemView.findViewById(R.id.bondsName);
            bondsTicker = itemView.findViewById(R.id.bondsTicker);
            bondsTime = itemView.findViewById(R.id.bondsTime);
            bondsPrice = itemView.findViewById(R.id.bondsPrice);

        }
    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0) {
            return 0;
        }
        return 1;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType == 0) {
            View view = inflater.inflate(R.layout.layout_bonds_item, parent, false);
            return new MyHolder(view);
        }
        View view = inflater.inflate(R.layout.bonds_adapter_item, parent, false);
        return new MyHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        Instrument b = this.bonds.get(position);
        ((MyHolder) holder).bondsName.setText(b.getName());

        if (position != 0) {
            ((MyHolder) holder).bondsTicker.setText(b.getTicker());
            ((MyHolder) holder).bondsTime.setText(b.getTime());
            ((MyHolder) holder).bondsPrice.setText(b.getPrice()+"%");
        }

    }


    @Override
    public int getItemCount() {
        return bonds.size();
    }
}

