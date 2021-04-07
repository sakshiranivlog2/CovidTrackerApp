package com.example.stateapi2.fragment;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.stateapi2.Adapter.ViewPagerAdapter;
import com.example.stateapi2.R;
import com.google.android.material.tabs.TabLayout;

/**
 * A simple {@link Fragment} subclass.
 */
public class SymptomsFrag extends Fragment {


    TabLayout tablayout;
    ViewPager viewpager;
    View view;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate( R.layout.fragment_symptoms, container, false );


        tablayout = view.findViewById( R.id.tablayout );
        viewpager = view.findViewById( R.id.viewpager );



                ViewPagerAdapter adapter = new ViewPagerAdapter( getChildFragmentManager() );
                adapter.add( new FragmentRecord(), "ENGLISH" );
                adapter.add( new FragmentSavedRecordings(), "हिन्दी" );
                viewpager.setAdapter( adapter );
                tablayout.setupWithViewPager( viewpager );


        return view;
            }






}
