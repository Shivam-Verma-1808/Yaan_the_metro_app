package com.example.root.myapplication;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.rilixtech.CountryCodePicker;                                             //from GitHub

public class sign_up_fragment extends Fragment {

    CountryCodePicker ccp ;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView =inflater.inflate(R.layout.sign_up_fragment,container,false);
        ccp= (CountryCodePicker) rootView.findViewById(R.id.country_code_picker);
        return rootView ;
    }
}
