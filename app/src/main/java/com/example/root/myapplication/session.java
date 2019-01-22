package com.example.root.myapplication;

import android.content.Context;
import android.content.SharedPreferences;

import static android.content.Context.MODE_PRIVATE;

public class session {

    //private SharedPreferences sharedPreferences;
    private static final String Email = "Email";                                                    //Email_Key
    //private static final String Password = "Password";                                            //password_key
    private static final String SharedPrefs = "SharedPrefs";
    private static final String signed_in = "signed_in";                                            //signed_in_key

    private static  SharedPreferences getPrefs(Context context)
    {
        return context.getSharedPreferences(SharedPrefs,MODE_PRIVATE);
    }

    /*
    public void saveData(Context context,String user_name,String password)
    {
        saveUser(context,user_name);
        savePassword(context,password);
    }
    */


    public static void saveUser(Context context,String user_name)                                          //first call this and only after verification of the credentials call saveData();
    {
        SharedPreferences.Editor editor = getPrefs(context).edit();
        editor.putString(Email,user_name);
        editor.putBoolean(signed_in,false);
        editor.apply();
    }

    public static void saveData(Context context)                                                           //if the user is valid only then saveData() will be called and the user will be marked as signed_in
    {
        SharedPreferences.Editor editor = getPrefs(context).edit();
        editor.putBoolean(signed_in,true);
        editor.apply();
    }

    public static void deleteData(Context context)                                                         //deleting User/logging out the user
    {
        SharedPreferences.Editor editor = getPrefs(context).edit();
        editor.putString(Email,"Guest");
        editor.putBoolean(signed_in,false);
        editor.apply();
    }
    /*
    public void savePassword(Context context,String user_password)
    {
        SharedPreferences.Editor editor = getPrefs(context).edit();
        editor.putString(Password,user_password);
        editor.apply();
    }
    */

    public static String getUser(Context context)
    {
        return getPrefs(context).getString(Email,"Guest");
    }

    public static boolean get_signed_in_status(Context context)
    {
        return getPrefs(context).getBoolean(signed_in,false);
    }

}
