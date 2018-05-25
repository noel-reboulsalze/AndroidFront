package com.noelreboulsalze.labellenote;

import com.noelreboulsalze.labellenote.Objects.Bill;
import com.noelreboulsalze.labellenote.Objects.User;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * Created by ysiguman on 24/05/18.
 */

public interface ConnectionInterface {
    @POST("/index.php")
    Call<User> connect(@Body User user);


    @POST("/page_accueil/ressource/add_demande.php")
    Call<ResponseBody> createBIll(@Body Bill user);
}
