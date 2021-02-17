package com.example.retrofit_multiple;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.retrofit_multiple.Model.Model;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    ArrayList<Model> model = new ArrayList<>();
    RecyclerView recyclerView;
    MyAdapter myAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recycler_view);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Api.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        Api api = retrofit.create(Api.class);

        Call<List<Model>> call = api.getmodel();

        call.enqueue(new Callback<List<Model>>() {
            @Override
            public void onResponse(Call<List<Model>> call, Response<List<Model>> response) {
                model = new ArrayList<>(response.body());

//                for (int i = 0; i < response.body().size(); i++) {
//                    model.add(new Model(response.body().get(i).getId(),
//                            response.body().get(i).getName(),
//                            response.body().get(i).getUsername(),
//                            response.body().get(i).getEmail(),
//                            response.body().get(i).getAddress(),
//                            response.body().get(i).getPhone(),
//                            response.body().get(i).getWebsite(),
//                            response.body().get(i).getCompany()));
//                }
//                Log.e("main", "onResponse: --" + response.body().get);

                myAdapter = new MyAdapter(MainActivity.this,model);
                recyclerView.setAdapter(myAdapter);

            }

            @Override
            public void onFailure(Call<List<Model>> call, Throwable t) {
                Toast.makeText(MainActivity.this, "error", Toast.LENGTH_SHORT).show();

            }
        });


    }
}