package com.example.gson.services;

import com.example.gson.dominio.User;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiEndpoint {

    @GET("users")
    Call<List<User>> obterUsuarios();

}
