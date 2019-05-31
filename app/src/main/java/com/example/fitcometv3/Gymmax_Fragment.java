package com.example.fitcometv3;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class Gymmax_Fragment extends Fragment {
    View myView;
    private ViewPager MviewPager;
    private static final String TAG = "GymMax";
    private SectionsPageAdapter mSectionsPageAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        myView = inflater.inflate(R.layout.gymmax_layout, container, false);
        Log.d(TAG, "onCreate:");
        mSectionsPageAdapter = new SectionsPageAdapter(getFragmentManager());

        MviewPager = (ViewPager) myView.findViewById(R.id.conteiner);
        setupViewPager(MviewPager);


        TabLayout tabLayout = (TabLayout) myView.findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(MviewPager);


        return myView;
    }

    private void setupViewPager(ViewPager viewPager) {
        SectionsPageAdapter adapter = new SectionsPageAdapter(getFragmentManager());
        adapter.addFragment(new MaxBP_Fragment(), "BenchPr");
        adapter.addFragment(new MaxDL_Fragment(), "DeadLift");
        adapter.addFragment(new MaxOHP_Fragment(), "OHP");
        adapter.addFragment(new MaxSQ_Fragment(), "Squad");
        viewPager.setAdapter(adapter);
    }
}
