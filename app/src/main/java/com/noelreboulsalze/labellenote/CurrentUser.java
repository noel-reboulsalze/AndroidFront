package com.noelreboulsalze.labellenote;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

/**
 * Created by ysiguman on 24/05/18.
 */

public class CurrentUser {
    private final String PREFERENCES = "prefs";
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;

    public CurrentUser(Context context) {
        sharedPreferences = context.getSharedPreferences(PREFERENCES, Context.MODE_PRIVATE);
    }

    public boolean isExist() { return !sharedPreferences.getAll().isEmpty(); }

    public void clear() {
        editor = sharedPreferences.edit();
        editor.clear();
        editor.apply();
    }

    public void setType(String type) {
        editor = sharedPreferences.edit();
        editor.putString("TYPE", type);
        editor.apply();
    }

    public String getType () { return sharedPreferences.getString("TYPE", null); }

    public void setLogin(String login) {
        editor = sharedPreferences.edit();
        editor.putString("LOGIN", login);
        editor.apply();
    }

    public String getLogin() { return sharedPreferences.getString("LOGIN", null); }


    public void setId(String id) {
        editor = sharedPreferences.edit();
        editor.putString("ID", id);
        editor.apply();
    }

    public String getId() { return sharedPreferences.getString("ID", null); }

    public void logs() {
        Log.i("### CURENT_USER", getLogin());
        Log.i("### CURENT_USER", getType());
        Log.i("### CURENT_USER", getId());
    }
}
