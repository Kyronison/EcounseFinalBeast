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

public class FuturesRecyclerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private LayoutInflater inflater;
    private List<Instrument> futures;
    private Context context;
    private int counter = 0;

    public FuturesRecyclerAdapter(Context context, ArrayList<Instrument> futures) {
        this.inflater = LayoutInflater.from(context);
        this.futures = futures;
        this.context = context;

    }

    public void setFutures(List<Instrument> futures) {
        this.futures = futures;
    }

    private class MyHolder extends RecyclerView.ViewHolder {
        private TextView futuresName;
        private TextView futuresTicker;
        private TextView futuresTime;
        private TextView futuresPrice;

        public MyHolder(@NonNull View itemView) {
            super(itemView);
            futuresName = itemView.findViewById(R.id.futuresName);
            futuresTicker = itemView.findViewById(R.id.futuresTicker);
            futuresTime = itemView.findViewById(R.id.futuresTime);
            futuresPrice = itemView.findViewById(R.id.futuresPrice);

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
            View view = inflater.inflate(R.layout.layout_futures_item, parent, false);
            return new MyHolder(view);
        }
        View view = inflater.inflate(R.layout.futures_adapter_item, parent, false);
        return new MyHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        Instrument f= this.futures.get(position);
        ((MyHolder) holder).futuresName.setText(f.getName());

        if (position != 0) {
            ((MyHolder) holder).futuresTicker.setText(f.getTicker());
            ((MyHolder) holder).futuresTime.setText(f.getTime());
            ((MyHolder) holder).futuresPrice.setText(f.getPrice()+"₽");
        }

    }


    @Override
    public int getItemCount() {
        return futures.size();
    }
}

