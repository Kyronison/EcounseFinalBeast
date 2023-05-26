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

public class SharesRecyclerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private LayoutInflater inflater;
    private List<Instrument> shares;
    private Context context;
    private int counter = 0;

    public SharesRecyclerAdapter(Context context, ArrayList<Instrument> shares) {
        this.inflater = LayoutInflater.from(context);
        this.shares = shares;
        this.context = context;

    }

    public void setShares(List<Instrument> shares) {
        this.shares = shares;
    }

    private class MyHolder extends RecyclerView.ViewHolder {
        private TextView shareName;
        private TextView shareTicker;
        private TextView shareTime;
        private TextView sharePrice;

        public MyHolder(@NonNull View itemView) {
            super(itemView);
            shareName = itemView.findViewById(R.id.shareName);
            shareTicker = itemView.findViewById(R.id.shareTicker);
            shareTime = itemView.findViewById(R.id.shareTime);
            sharePrice = itemView.findViewById(R.id.sharePrice);

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
            View view = inflater.inflate(R.layout.layout_share_item, parent, false);
            return new MyHolder(view);
        }
        View view = inflater.inflate(R.layout.shares_adapter_item, parent, false);
        return new MyHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        Instrument s = this.shares.get(position);
        ((MyHolder) holder).shareName.setText(s.getName());

        if (position != 0) {
            ((MyHolder) holder).shareTicker.setText(s.getTicker());
            ((MyHolder) holder).shareTime.setText(s.getTime());
            ((MyHolder) holder).sharePrice.setText(s.getPrice()+"₽");
        }

    }


    @Override
    public int getItemCount() {
        return shares.size();
    }
}
