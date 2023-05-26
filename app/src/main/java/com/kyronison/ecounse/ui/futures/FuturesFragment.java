package com.kyronison.ecounse.ui.futures;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.kyronison.ecounse.R;
import com.kyronison.ecounse.adapters.FuturesRecyclerAdapter;
import com.kyronison.ecounse.adapters.OptionsRecyclerAdapter;
import com.kyronison.ecounse.databinding.FragmentFuturesBinding;
import com.kyronison.ecounse.databinding.FragmentOptionsBinding;
import com.kyronison.ecounse.model.Instrument;
import com.kyronison.ecounse.ui.HorizontalItemDivider;
import com.kyronison.ecounse.ui.futures.FuturesViewModel;

import java.util.ArrayList;

public class FuturesFragment extends Fragment {
    private FragmentFuturesBinding binding;
    FuturesRecyclerAdapter adapter;
    private FuturesViewModel futuresViewModel;



    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        futuresViewModel =
                new ViewModelProvider(requireActivity()).get(FuturesViewModel.class);
        futuresViewModel.setAdditionalText(getResources().getString(R.string.text_futures));

        binding = FragmentFuturesBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        return root;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ArrayList<Instrument> futures = new ArrayList<Instrument>();
        adapter = new FuturesRecyclerAdapter(getContext(),futures);
        RecyclerView rv = view.findViewById(R.id.futures_recycler);
        rv.setAdapter(adapter);
        rv.addItemDecoration(new HorizontalItemDivider(getResources().getDrawable(R.drawable.divider)));
        rv.setLayoutManager(new LinearLayoutManager(getContext()));

        binding.swipeRefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                binding.swipeRefresh.setRefreshing(false);
                futuresViewModel.updatePrice();
                adapter.notifyDataSetChanged();
            }
        });

        futuresViewModel.getText().observe(getViewLifecycleOwner(), listFutures -> {
            Log.d("CALL","SBER ADDED");
            // listShares.add(0, sber);
            adapter.setFutures(listFutures);
            adapter.notifyDataSetChanged();
        });

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}