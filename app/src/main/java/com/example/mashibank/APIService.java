package com.example.mashibank;


import com.example.mashibank.models.Credito;

import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface APIService {
    @GET("getCreditos")
    Call<List<Credito>> getCreditos(@Query("cue_id") int cue_id);

    @GET("loguear")
    Call<ResponseBody> loguear(@Query("user") String user, @Query("clave") String clave);

    @GET("cambiarClave")
    Call<ResponseBody> cambiarClave(@Query("correo") String correo);

    @GET("getSaldo")
    Call<ResponseBody> getSaldo(@Query("cuenta") String cuenta);

    @GET("transferir")
    Call<ResponseBody> transferir(@Query("origen") int origen, @Query("destino") int destino,
                                  @Query("monto") double monto);
}