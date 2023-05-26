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

public class OptionsRecyclerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private LayoutInflater inflater;
    private List<Instrument> options;
    private Context context;
    private int counter = 0;

    public OptionsRecyclerAdapter(Context context, ArrayList<Instrument> options) {
        this.inflater = LayoutInflater.from(context);
        this.options = options;
        this.context = context;

    }

    public void setOptions(List<Instrument> options) {
        this.options = options;
    }

    private class MyHolder extends RecyclerView.ViewHolder {
        private TextView optionsName;
        private TextView optionsTicker;
        private TextView optionsTime;
        private TextView optionsPrice;

        public MyHolder(@NonNull View itemView) {
            super(itemView);
            optionsName = itemView.findViewById(R.id.optionsName);
            optionsTicker = itemView.findViewById(R.id.optionsTicker);
            optionsTime = itemView.findViewById(R.id.optionsTime);
            optionsPrice = itemView.findViewById(R.id.optionsPrice);

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
            View view = inflater.inflate(R.layout.layout_options_item, parent, false);
            return new MyHolder(view);
        }
        View view = inflater.inflate(R.layout.options_adapter_item, parent, false);
        return new MyHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        Instrument o = this.options.get(position);
        ((MyHolder) holder).optionsName.setText(o.getName());

        if (position != 0) {
            ((MyHolder) holder).optionsTicker.setText(o.getTicker());
            ((MyHolder) holder).optionsTime.setText(o.getTime());
            ((MyHolder) holder).optionsPrice.setText(o.getPrice()+"₽");
        }

    }


    @Override
    public int getItemCount() {
        return options.size();
    }
}
