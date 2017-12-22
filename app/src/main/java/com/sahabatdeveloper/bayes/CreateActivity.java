package com.sahabatdeveloper.bayes;

import android.content.Intent;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class CreateActivity extends AppCompatActivity {

    Spinner spnSky, spnAirTemp, spnHumadity, spnWind, spnWater, spnForecast, spnEnjoySport;
    Button btnTambahData;
    ArrayList<Model> listModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create);

        spnSky = (Spinner)findViewById(R.id.spn_Sky);
        spnAirTemp = (Spinner)findViewById(R.id.spn_air_temp);
        spnHumadity = (Spinner)findViewById(R.id.spn_humidity);
        spnWind = (Spinner)findViewById(R.id.spn_wind);
        spnWater = (Spinner)findViewById(R.id.spn_water);
        spnForecast = (Spinner)findViewById(R.id.spn_forecast);
        spnEnjoySport = (Spinner)findViewById(R.id.spn_enjoy_sport);
        btnTambahData = (Button)findViewById(R.id.btnTambahData);

        String[] strSky= {"Sunny","Runny"};
        spnSky.setAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,strSky));

        String[] strAirTemp= {"Warm","Cold"};
        spnAirTemp.setAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,strAirTemp));

        String[] strHumadity= {"Normal","High"};
        spnHumadity.setAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,strHumadity));

        String[] strWind= {"Strong","Weak"};
        spnWind.setAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,strWind));

        String[] strWater= {"Warm","Cool"};
        spnWater.setAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,strWater));

        String[] strForecast= {"Same","Change"};
        spnForecast.setAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,strForecast));

        String[] strEnjoySport= {"YES","NO"};
        spnEnjoySport.setAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,strEnjoySport));

        btnTambahData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listModel = ((Helper)CreateActivity.this.getApplication()).getListTable();
                listModel.add(new Model((String)spnSky.getSelectedItem(),(String)spnAirTemp.getSelectedItem(),(String)spnHumadity.getSelectedItem()
                        ,(String)spnWind.getSelectedItem(),(String)spnWater.getSelectedItem(),(String)spnForecast.getSelectedItem(),(String)spnEnjoySport.getSelectedItem()));

//                listModel.add(new Model("a","a","a","a","a","a","a"));

                ((Helper)CreateActivity.this.getApplication()).setListTable(listModel);

                Intent i = new Intent(CreateActivity.this,MainActivity.class);
                startActivity(i);
            }
        });
    }
}
