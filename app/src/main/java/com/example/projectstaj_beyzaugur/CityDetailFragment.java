package com.example.projectstaj_beyzaugur;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.util.List;

public class CityDetailFragment extends Fragment {

    Button geribtn2;

    private RecyclerView recyclerView;
    private List<String> itemList;


    private FragmentInteractionListener interactionListener;

    public CityDetailFragment(List<String> itemList) {
        this.itemList = itemList;


    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);

        try {
            interactionListener = (FragmentInteractionListener) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString() + " must implement FragmentInteractionListener");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_city_detail, container, false);
        recyclerView = view.findViewById(R.id.recyclerView2);
        geribtn2 = view.findViewById(R.id.geribtn2);
        setupRecyclerView();


        geribtn2 = view.findViewById(R.id.geribtn2);
        geribtn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                closeFragment();
            }
        });
        return view;
    }

    public void closeFragment() {

        FragmentManager fragmentManager = getParentFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.remove(this); // Bu fragmentı kaldır
        transaction.commit();
        interactionListener.onFragmentReturned();





    }


    private void setupRecyclerView() {
        RecyclerViewAdapter2 adapter = new RecyclerViewAdapter2(itemList, this);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(adapter);
    }

    public interface FragmentInteractionListener {
        void onFragmentReturned();
    }

}

