package com.example.gettingcountrynamebycodeusingretrofit.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.gettingcountrynamebycodeusingretrofit.R;
import com.example.gettingcountrynamebycodeusingretrofit.model.Info;
import com.example.gettingcountrynamebycodeusingretrofit.model.Result;
import com.example.gettingcountrynamebycodeusingretrofit.service.GetCountryNameService;
import com.example.gettingcountrynamebycodeusingretrofit.service.RetrofitInstance;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {


    Button displayCountry;
    TextView displayThename;
    EditText getCode;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        displayCountry = findViewById(R.id.showCountryName);
        displayThename = findViewById(R.id.setTheText);
        getCode = findViewById(R.id.getTheText);
        displayCountry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GetCountryNameService getCountryNameService = RetrofitInstance.getService();
                Call<Info> call = getCountryNameService.getCountryName(getCode.getText().toString().trim());
                call.enqueue(new Callback<Info>() {
                    @Override
                    public void onResponse(Call<Info> call, Response<Info> response) {
                        Info info = response.body();

                        if (info!=null && info.getRestResponse()!=null){
                            displayThename.setText(info.getRestResponse().getResult().getName());
                        }
                    }

                    @Override
                    public void onFailure(Call<Info> call, Throwable t) {

                    }
                });
            }
        });
    }
}
