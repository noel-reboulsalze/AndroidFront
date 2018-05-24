package com.noelreboulsalze.labellenote;

import com.noelreboulsalze.labellenote.Objects.User;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * Created by ysiguman on 24/05/18.
 */

public interface ConnectionInterface {
    @POST("/index.php")
    Call<User> connect(@Body User user);
}
