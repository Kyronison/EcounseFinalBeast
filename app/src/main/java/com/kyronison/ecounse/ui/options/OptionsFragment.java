package com.kyronison.ecounse.ui.options;

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
import com.kyronison.ecounse.adapters.OptionsRecyclerAdapter;
import com.kyronison.ecounse.databinding.FragmentOptionsBinding;
import com.kyronison.ecounse.model.Instrument;
import com.kyronison.ecounse.ui.HorizontalItemDivider;

import java.util.ArrayList;

public class OptionsFragment extends Fragment {
    private FragmentOptionsBinding binding;
    OptionsRecyclerAdapter adapter;
    private OptionsViewModel optionsViewModel;



    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        optionsViewModel =
                new ViewModelProvider(requireActivity()).get(OptionsViewModel.class);
        optionsViewModel.setAdditionalText(getResources().getString(R.string.text_options));

        binding = FragmentOptionsBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        return root;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ArrayList<Instrument> options = new ArrayList<Instrument>();
        adapter = new OptionsRecyclerAdapter(getContext(),options);
        RecyclerView rv = view.findViewById(R.id.options_recycler);
        rv.setAdapter(adapter);
        rv.addItemDecoration(new HorizontalItemDivider(getResources().getDrawable(R.drawable.divider)));
        rv.setLayoutManager(new LinearLayoutManager(getContext()));

        binding.swipeRefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                binding.swipeRefresh.setRefreshing(false);
                optionsViewModel.updatePrice();
                adapter.notifyDataSetChanged();
            }
        });

        optionsViewModel.getText().observe(getViewLifecycleOwner(), listOptions -> {
            Log.d("CALL","SBER ADDED");
            // listShares.add(0, sber);
            adapter.setOptions(listOptions);
            adapter.notifyDataSetChanged();
        });

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}