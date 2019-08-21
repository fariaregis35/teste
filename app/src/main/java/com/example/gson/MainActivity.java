package com.example.gson;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.gson.services.RetrofitService;
import com.example.gson.dominio.User;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        busca();
    }

    private void busca() {
        RetrofitService.getServico().obterUsuarios().enqueue(new Callback<List<User>>() {
            @Override
            public void onResponse(Call<List<User>> call, Response<List<User>> response) {
                TextView campo = findViewById(R.id.tv_campo);
                List<User> lista = response.body();
                for (User user : lista) {
                    campo.append("\nId: " + user.getId() +
                            "\nNome: " + user.getName() +
                            "\nEmail: " + user.getEmail() +
                            "\n\nNome: " + user.getPhone());


                }
            }

            @Override
            public void onFailure(Call<List<User>> call, Throwable t) {

            }
        });
    }
}
