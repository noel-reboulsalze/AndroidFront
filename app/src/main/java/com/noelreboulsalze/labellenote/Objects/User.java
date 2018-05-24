package com.noelreboulsalze.labellenote.Objects;

import com.google.gson.annotations.SerializedName;

/**
 * Created by ysiguman on 24/05/18.
 */

public class User {
    @SerializedName("utilisateur_id")
    private String id;
    @SerializedName("login")
    private String login;
    @SerializedName("pass")
    private String pass;
    @SerializedName("type")
    private String type;

    public User() {
    }

    public User(String id, String login, String pass, String type) {
        this.id = id;
        this.login = login;
        this.pass = pass;
        this.type = type;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
