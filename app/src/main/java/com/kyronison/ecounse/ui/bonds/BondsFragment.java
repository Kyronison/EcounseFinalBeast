package com.kyronison.ecounse.ui.bonds;

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
import com.kyronison.ecounse.adapters.BondsRecyclerAdapter;
import com.kyronison.ecounse.databinding.FragmentBondsBinding;
import com.kyronison.ecounse.model.Instrument;
import com.kyronison.ecounse.ui.HorizontalItemDivider;

import java.util.ArrayList;

public class BondsFragment extends Fragment {
    private FragmentBondsBinding binding;
    BondsRecyclerAdapter adapter;
    private BondsViewModel bondsViewModel;



    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        bondsViewModel =
                new ViewModelProvider(requireActivity()).get(BondsViewModel.class);
        bondsViewModel.setAdditionalText(getResources().getString(R.string.text_bonds));

        binding = FragmentBondsBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        return root;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ArrayList<Instrument> bonds = new ArrayList<Instrument>();
        adapter = new BondsRecyclerAdapter(getContext(),bonds);
        RecyclerView rv = view.findViewById(R.id.bonds_recycler);
        rv.setAdapter(adapter);
        rv.addItemDecoration(new HorizontalItemDivider(getResources().getDrawable(R.drawable.divider)));
        rv.setLayoutManager(new LinearLayoutManager(getContext()));

        binding.swipeRefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                binding.swipeRefresh.setRefreshing(false);
                bondsViewModel.updatePrice();
                adapter.notifyDataSetChanged();
            }
        });

        bondsViewModel.getText().observe(getViewLifecycleOwner(), listBonds -> {
            Log.d("CALL","SBER ADDED");
            // listShares.add(0, sber);
            adapter.setBonds(listBonds);
            adapter.notifyDataSetChanged();
        });

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}