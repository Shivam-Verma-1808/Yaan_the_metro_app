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
import android.widget.TextView;
import android.widget.Toast;

import com.rilixtech.CountryCodePicker;                                             //from GitHub

public class sign_up_fragment extends Fragment {

    View rootView;
    CountryCodePicker ccp ;
    Button signup_btn;
    EditText first_name,last_name,new_user_email,phone_no,re_enter_password;
    TextInputEditText set_password;
    TextView error_box;
    Context mContext;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView =inflater.inflate(R.layout.sign_up_fragment,container,false);
        mContext =rootView.getContext();

        ccp= (CountryCodePicker) rootView.findViewById(R.id.country_code_picker);
        new_user_email = rootView.findViewById(R.id.new_user_email);
        signup_btn = rootView.findViewById(R.id.final_sign_up_btn);
        set_password = rootView.findViewById(R.id.set_password);
        re_enter_password = rootView.findViewById(R.id.re_enter_password);
        error_box = rootView.findViewById(R.id.error_message_box);
        first_name = rootView.findViewById(R.id.new_user_first_name);
        last_name = rootView.findViewById(R.id.new_user_last_name);
        phone_no = rootView.findViewById(R.id.new_user_phone);

        signup_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(first_name.getText().toString().equals("")||last_name.getText().toString().equals("")||new_user_email.getText().toString().equals("")||phone_no.getText().toString().trim().equals("")||(set_password.getText().toString().equals(""))||(re_enter_password.getText().toString().equals("")))
                {
                    set_password.setText(null);
                    re_enter_password.setText(null);
                    error_box.setText(R.string.blank_field_error);
                }

                else if(((set_password.getText().toString()).equals(re_enter_password.getText().toString())))
                {
                    //validate user credentials(email verification and contact number varification)
                    //if(valid)
                    session.saveUser(mContext,new_user_email.getText().toString());
                    session.saveData(mContext);
                    Toast.makeText(rootView.getContext(),R.string.welcome_new_user_message,Toast.LENGTH_LONG).show();
                    startActivity(new Intent(getActivity(),play_area.class));                           //to change to play_area activity
                    getActivity().finish();
                }
                else
                {
                    set_password.setText(null);
                    re_enter_password.setText(null);
                    error_box.setText(R.string.password_error);
                    //Toast.makeText(rootView.getContext(),"this was called",Toast.LENGTH_SHORT).show();
                }
            }
        });


        return rootView ;
    }
}
