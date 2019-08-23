package com.example.gson;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
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
        Log.d("iftm","-----------");
        RetrofitService.getServico().obterUsuarios().enqueue(new Callback<List<User>>() {
            @Override
            public void onResponse(Call<List<User>> call, Response<List<User>> response) {
                TextView campo = findViewById(R.id.tv_campo);
                List<User> lista = response.body();
                for (User user : lista) {
                    campo.append("\nId: " + user.getId() +
                            "\nNome: " + user.getName() +
                            "\nEndereço: " + user.getAddress().getStreet() +
                            "\nEmail: " + user.getEmail() +
                            "\nUser" + user.getUsername() +
                            "\nPhone: " + user.getPhone() +
                            "\nWebSite: " + user.getWebsite()
                            + "\n");
                }
            }

            @Override
            public void onFailure(Call<List<User>> call, Throwable t) {
                Log.d("iftm","-----------"+t.getMessage());
            }
        });
    }
}
