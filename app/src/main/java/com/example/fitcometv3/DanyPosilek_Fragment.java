package com.example.fitcometv3;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class DanyPosilek_Fragment extends Fragment {
    View myView;
    public static final String EXTRA_PosilekNO = " posilekNO";
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        myView = inflater.inflate(R.layout.danyposilek, container, false);

       int drinkNo=(int)getActivity().getIntent().getExtras().get(EXTRA_PosilekNO);
        Posilek_Class posilek = Posilek_Class.posilki[drinkNo];//drinkNO


        ImageView photo=(ImageView)myView.findViewById(R.id.photo);
        photo.setImageResource(posilek.getImageResourceId());
        photo.setContentDescription(posilek.getName());

        TextView name= (TextView)myView.findViewById(R.id.name);
        name.setText(posilek.getName());

        TextView description = (TextView)myView.findViewById(R.id.description);
        description.setText(posilek.getDescription());

        TextView poziom = (TextView)myView.findViewById(R.id.poziom);
        poziom.setText(posilek.getPoziomTrudnosciPrzygotownia());
        return myView;
    }
}
