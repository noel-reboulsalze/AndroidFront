package com.noelreboulsalze.labellenote;

import com.noelreboulsalze.labellenote.Objects.Bill;
import com.noelreboulsalze.labellenote.Objects.History;
import com.noelreboulsalze.labellenote.Objects.User;

import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by ysiguman on 24/05/18.
 */

public interface ConnectionInterface {
    @POST("/index.php")
    Call<User> connect(@Body User user);


    @POST("/page_accueil/ressource/add_demande.php")
    Call<ResponseBody> createBIll(@Body Bill user);

    @GET("/page_accueil/ressource/get_history.php")
    Call<List<History>> getHistory(@Query("userID") String id);
}
