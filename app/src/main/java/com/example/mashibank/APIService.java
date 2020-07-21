package com.example.mashibank;


import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface APIService {
    @GET("loguear")
    Call<ResponseBody> loguear(@Query("user") String user, @Query("clave") String clave);

    @GET("cambiarClave")
    Call<ResponseBody> cambiarClave(@Query("correo") String correo);
}