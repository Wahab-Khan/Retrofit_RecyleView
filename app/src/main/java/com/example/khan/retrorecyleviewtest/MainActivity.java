package com.example.khan.retrorecyleviewtest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private ApiInterface apiInterface;
    private RV_Adapter adapter;
    private List<Student> students = new ArrayList<>();
    private List<Student> names = new ArrayList<>();
    private List<Student> studentList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.RV);
        recyclerView.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);



        Log.i("main" , "in main method ");

        Retrofit retrofit = new Retrofit.Builder().baseUrl(ApiClient.URL).addConverterFactory(GsonConverterFactory.create()).build();

        apiInterface = retrofit.create(ApiInterface.class);
        apiInterface = ApiClient.getApiClient().create(ApiInterface.class);

        Call<List<Student>> studentData= apiInterface.getStudentData();

        studentData.enqueue(new Callback<List<Student>>() {
            @Override
            public void onFailure(Call<List<Student>> call, Throwable t) {

            }

            @Override
            public void onResponse(Call<List<Student>> call, Response<List<Student>> response) {
                Log.i("Responce ", "in responce method ");
                try{
                if(response.isSuccessful() && response != null){
                    students.addAll(response.body());
                    for (Student s : students) {
                        if (s != null) {
                            studentList.add(s);
                            Log.i("student item", s + "");
                                    }
                        }
                    }
                    adapter = new RV_Adapter(studentList);
                    recyclerView.setAdapter(adapter);
                }
                catch (Exception e){
                  Log.i("panga" , "panga from indexing");
            }


    }
});

    }
}
