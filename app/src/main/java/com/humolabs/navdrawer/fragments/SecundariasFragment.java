package com.humolabs.navdrawer.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.humolabs.navdrawer.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class SecundariasFragment extends Fragment {


    public SecundariasFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_secundarias, container, false);
    }

}
