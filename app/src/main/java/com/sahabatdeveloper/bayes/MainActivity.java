package com.sahabatdeveloper.bayes;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    RecyclerView rvListData;
    FloatingActionButton fabTambah;
    Button btnCariHipotesa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fabTambah = (FloatingActionButton)findViewById(R.id.fab_tambah);
        rvListData = (RecyclerView)findViewById(R.id.rv_list);
        btnCariHipotesa = (Button)findViewById(R.id.btn_hasil_hipotesa);
        rvListData.setHasFixedSize(true);
        rvListData.setLayoutManager(new LinearLayoutManager(this));
        rvListData.setAdapter(new ListAdapter(this, ((Helper)this.getApplication()).getListTable()));

        fabTambah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent p = new Intent(MainActivity.this,CreateActivity.class);
                startActivity(p);
            }
        });

        btnCariHipotesa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int iya=0, tidak=0, semua=0;
                final List<Model> listTable = ((Helper)MainActivity.this.getApplication()).getListTable();
                for(Model m:listTable){
                    if(m.getEnjoySport().equals("YES")){
                        iya++;
                    }
                    if(m.getEnjoySport().equals("NO")){
                        tidak++;
                    }
                }
                semua = listTable.size();


                final AlertDialog.Builder alertDialog = new AlertDialog.Builder(MainActivity.this);
                final EditText etPertanyaan = new EditText(MainActivity.this);

                alertDialog.setTitle("Yang Di Tanyakan Masukkan dengan dipisah koma");
                alertDialog.setView(etPertanyaan);
                final int finalIya = iya;
                final int finalTidak = tidak;
                alertDialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String[] strPertanyaan = etPertanyaan.getText().toString().split(",");

                        final List<Pertanyaan> listJumlah = new ArrayList<Pertanyaan>();
                        int sky=0, airTemp=0, humadity=0, wind=0, water=0, forecast=0;
                        int skyNo=0, airTempNo=0, humadityNo=0, windNo=0, waterNo=0, forecastNo=0;
                        for(int i = 0;i<strPertanyaan.length ; i++){
                            Toast.makeText(MainActivity.this, ""+strPertanyaan[i], Toast.LENGTH_SHORT).show();
                            if(strPertanyaan[i].split("=")[0].equals("Sky")){
                                for(Model m : listTable){
                                    if(m.getSky().equals(strPertanyaan[i].split("=")[1]) && m.getEnjoySport().equals("YES")){
                                        sky++;
                                    }
                                    else if(m.getSky().equals(strPertanyaan[i].split("=")[1]) && m.getEnjoySport().equals("NO")){
                                        skyNo++;
                                    }
                                }
                                listJumlah.add(new Pertanyaan(strPertanyaan[i],sky, skyNo));
                            }
                            else if(strPertanyaan[i].split("=")[0].equals("Air Temp")){
                                for(Model m : listTable){
                                    if(m.getAirTemp().equals(strPertanyaan[i].split("=")[1]) && m.getEnjoySport().equals("YES")){
                                        airTemp++;
                                    }
                                    if(m.getAirTemp().equals(strPertanyaan[i].split("=")[1]) && m.getEnjoySport().equals("NO")){
                                        airTempNo++;
                                    }

                                }
                                Toast.makeText(MainActivity.this, "MASUK", Toast.LENGTH_SHORT).show();
                                listJumlah.add(new Pertanyaan(strPertanyaan[i],airTemp, airTempNo));
                            }
                            else if(strPertanyaan[i].split("=")[0].equals("Humadity")){
                                for(Model m : listTable){
                                    if(m.getHumidity().equals(strPertanyaan[i].split("=")[1]) && m.getEnjoySport().equals("YES")){
                                        humadity++;
                                    }
                                    else if(m.getHumidity().equals(strPertanyaan[i].split("=")[1]) && m.getEnjoySport().equals("NO")){
                                        humadityNo++;
                                    }

                                }
                                listJumlah.add(new Pertanyaan(strPertanyaan[i],humadity, humadityNo));
                            }
                            else if(strPertanyaan[i].split("=")[0].equals("wind")){
                                for(Model m : listTable){
                                    if(m.getWind().equals(strPertanyaan[i].split("=")[1]) && m.getEnjoySport().equals("YES")){
                                        wind++;
                                    }
                                    else if(m.getWind().equals(strPertanyaan[i].split("=")[1]) && m.getEnjoySport().equals("NO")){
                                        windNo++;
                                    }

                                }
                                listJumlah.add(new Pertanyaan(strPertanyaan[i],wind, windNo));
                            }
                            else if(strPertanyaan[i].split("=")[0].equals("water")){
                                for(Model m : listTable){
                                    if(m.getWater().equals(strPertanyaan[i].split("=")[1]) && m.getEnjoySport().equals("YES")){
                                        water++;
                                    }
                                    else if(m.getWater().equals(strPertanyaan[i].split("=")[1]) && m.getEnjoySport().equals("YES")){
                                        waterNo++;
                                    }

                                }
                                listJumlah.add(new Pertanyaan(strPertanyaan[i],water, waterNo));
                            }
                            else if(strPertanyaan[i].split("=")[0].equals("forecast")){
                                for(Model m : listTable){
                                    if(m.getForecast().equals(strPertanyaan[i].split("=")[1]) && m.getEnjoySport().equals("YES")){
                                        forecast++;
                                    }
                                    else if(m.getForecast().equals(strPertanyaan[i].split("=")[1]) && m.getEnjoySport().equals("YES")){
                                        forecastNo++;
                                    }

                                }
                                listJumlah.add(new Pertanyaan(strPertanyaan[i],forecast, forecastNo));
                            }

                        }

                        int size = listTable.size();
                        final AlertDialog.Builder hipotesaDialog = new AlertDialog.Builder(MainActivity.this);

                        LinearLayout linear = new LinearLayout(MainActivity.this);
                        linear.setOrientation(LinearLayout.VERTICAL);

                        TextView tvYes = new TextView(MainActivity.this);
                        tvYes.setText("YES");
                        tvYes.setTextSize(15);

                        TextView tvHasilYes = new TextView(MainActivity.this);
                        String yes="";
                        double hasilYes = 1.0;
                        for(Pertanyaan p : listJumlah){
                            yes+=p.getJudul()+" : "+p.getJumlah()+"/"+ finalIya +"\n";
                            hasilYes=hasilYes*((double)p.getJumlah()/(double)finalIya);
//                            Log.d("YESS",p.getJumlah()/finalIya +" YES " + hasilYes);
                        }
                        hasilYes*=((double)finalIya/(double)size);
  //                      Log.d("YESS 22"," YES 2 : " + hasilYes);
                        tvHasilYes.setText(yes+"Hasil Yes : "+hasilYes);

                        TextView tvNo = new TextView(MainActivity.this);
                        tvNo.setText("NO");
                        tvNo.setTextSize(15);

                        TextView tvHasilNo = new TextView(MainActivity.this);
                        String no="";
                        double hasilNo = 1.0;
                        for(Pertanyaan p : listJumlah){
                            no+=p.getJudul()+" : "+p.getJumlahNo()+"/"+ finalTidak +"\n";
                            hasilNo*=(double)p.getJumlahNo()/(double)finalTidak;
                        }
                        hasilNo*=((double)finalTidak/(double)size);
                        tvHasilNo.setText(no+"Hasil No : "+hasilNo);

                        linear.addView(tvYes);
                        linear.addView(tvHasilYes);
                        linear.addView(tvNo);
                        linear.addView(tvHasilNo);

                        hipotesaDialog.setView(linear);

                        hipotesaDialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                            }
                        });

                        hipotesaDialog.show();

                     }
                });
                alertDialog.show();
            }
        });
    }
}
