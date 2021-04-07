package com.example.stateapi2.Adapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.stateapi2.fragment.FragmentRecord;
import com.example.stateapi2.fragment.FragmentSavedRecordings;


import java.util.ArrayList;

public class ViewPagerAdapter extends FragmentPagerAdapter  {
    private ArrayList<Fragment> fragments = new ArrayList<>( );
     private ArrayList<String> strings = new ArrayList<>( );

    public ViewPagerAdapter(FragmentManager fm) {
        super(fm);

    }

   @NonNull
   @Override
    public  Fragment getItem(int position){
        switch(position)
        {
            case 0:
                return new FragmentRecord();
            case 1:
                return new FragmentSavedRecordings();
            default:
                return null;
        }
    }



    @Override
    public int getCount() {
        return fragments.size();
    }


    public void add(Fragment fr, String str) {
        fragments.add(fr);
        strings.add(str);
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return strings.get(position);
    }

    public void add(FragmentSavedRecordings fragmentSavedRecordings) {

    }

    public void add(FragmentRecord fragmentRecord) {
    }
}
