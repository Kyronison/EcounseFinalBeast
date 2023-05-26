package com.kyronison.ecounse.ui.shares;

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
import com.kyronison.ecounse.adapters.SharesRecyclerAdapter;
import com.kyronison.ecounse.databinding.FragmentSharesBinding;
import com.kyronison.ecounse.model.Instrument;
import com.kyronison.ecounse.ui.HorizontalItemDivider;

import java.util.ArrayList;

public class SharesFragment extends Fragment {
    private FragmentSharesBinding binding;
    SharesRecyclerAdapter adapter;
    private SharesViewModel sharesViewModel;



    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
         sharesViewModel =
                new ViewModelProvider(requireActivity()).get(com.kyronison.ecounse.ui.shares.SharesViewModel.class);
         sharesViewModel.setAdditionalText(getResources().getString(R.string.text_shares));

        binding = FragmentSharesBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        return root;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ArrayList<Instrument> shares = new ArrayList<Instrument>();
        adapter = new SharesRecyclerAdapter(getContext(),shares);
        RecyclerView rv = view.findViewById(R.id.shares_recycler);
        rv.setAdapter(adapter);
        rv.addItemDecoration(new HorizontalItemDivider(getResources().getDrawable(R.drawable.divider)));
        rv.setLayoutManager(new LinearLayoutManager(getContext()));

        binding.swipeRefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                binding.swipeRefresh.setRefreshing(false);
                sharesViewModel.updatePrice();
                adapter.notifyDataSetChanged();
            }
        });

        sharesViewModel.getText().observe(getViewLifecycleOwner(), listShares -> {
            Log.d("CALL","SBER ADDED");
            // listShares.add(0, sber);
            adapter.setShares(listShares);
            adapter.notifyDataSetChanged();
        });

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}