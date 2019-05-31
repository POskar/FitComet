package com.example.fitcometv3;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.List;

public class WyborPosilku_Fragment extends Fragment implements AdapterView.OnItemClickListener {
    View myView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        myView = inflater.inflate(R.layout.wyborposilku, container, false);
        ListView listPosilki = (ListView) myView.findViewById(R.id.list_options);
        ArrayAdapter<Posilek_Class> listAdapter = new ArrayAdapter<Posilek_Class>(
               myView.getContext(),
                android.R.layout.simple_dropdown_item_1line,
                Posilek_Class.posilki);
        listPosilki.setAdapter(listAdapter);
        return myView;
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
       FragmentManager fragmentManager = getFragmentManager();
       // fragmentManager.beginTransaction().replace(R.id.content_frame, new com.example.fitcometv3.DanyPosilek_Fragment()).commit();
       // Bundle bundle = new Bundle();
       // bundle.putString("Waga", waga1S);

       fragmentManager = getActivity().getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        Pomiar_Fragment pomiar_fragment = new Pomiar_Fragment();
        fragmentTransaction.replace(R.id.content_frame, pomiar_fragment);
       fragmentTransaction.commit();
    }


/*
            @Override
            public void onClick(View v) {

            }
            public void onItemClick(AdapterView<?> listView, View itemView, int position, long id) {
                FragmentManager fragmentManager = getFragmentManager();
                fragmentManager.beginTransaction().replace(R.id.content_frame, new com.example.fitcometv3.Dodaj_Pomiar_Fragment()).commit();
            }*/
        };





