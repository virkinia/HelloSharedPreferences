package com.example.hellosharedpreferences;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;

public class ApplicationPreferences {
    static final String KEYNAME = "MYPREFS";


    private  static SharedPreferences mSharedPref;

    private ApplicationPreferences() {}

    public static void init(Context context) {
        if(mSharedPref == null) {
            mSharedPref = context.getSharedPreferences(KEYNAME, Activity.MODE_PRIVATE);
        }
    }

    public static void saveString(String value) {
        SharedPreferences.Editor prefsEditor = mSharedPref.edit();

        prefsEditor.putString(KEYNAME, value);
        prefsEditor.apply();
    }

    public static String readString(String defValue) {
        return mSharedPref.getString(KEYNAME, defValue);
    }
}
