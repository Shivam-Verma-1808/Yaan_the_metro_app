package com.example.root.myapplication;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.app.Fragment;
import android.support.design.widget.TextInputEditText;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class log_in_fragment extends Fragment {

    View rootView;
    EditText user_name ;
    TextInputEditText password ;
    Context mContext;                                                                               //mContext:my Context
    Button log_in_btn;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.log_in_fragment,container,false);
        mContext = rootView.getContext();                                                           //mContext = getApplicationContext();

        user_name = rootView.findViewById(R.id.user_name);
        password = rootView.findViewById(R.id.user_password);
        log_in_btn = rootView.findViewById(R.id.final_log_in_btn);

        log_in_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                session.saveUser(mContext,user_name.getText().toString());
                //validate user credentials
                //if(valid)
                session.saveData(mContext);
                Toast.makeText(rootView.getContext(),R.string.logged_in_message,Toast.LENGTH_LONG).show();
                startActivity(new Intent(getActivity(),play_area.class));                           //to change to play_area activity
                getActivity().finish();
                //else
                //session.deleteData(mContext);
                //Toast.makeText(rootView.getContext(),"User Not Found",Toast.LENGTH_LONG);
            }
        });



        return rootView;
    }
}
