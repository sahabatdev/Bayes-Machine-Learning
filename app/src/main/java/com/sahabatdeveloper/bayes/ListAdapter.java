package com.sahabatdeveloper.bayes;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import java.util.List;
import java.util.Random;

/**
 * Created by Sahabat Developer on 07/09/2017.
 */

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ViewHolder> {
    private Context context;
    private List<Model> listModel;

    public ListAdapter(Context context, List<Model> listModel) {
        this.context = context;
        this.listModel = listModel;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.list_table, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Model mm = listModel.get(position);

        holder.tvNomor.setText(""+(position+1));
        holder.tvSky.setText("Sky : "+mm.getSky());
        holder.tvAirTemp.setText("Air Temp : "+mm.getAirTemp());
        holder.tvHumidity.setText("Humidity : "+mm.getHumidity());
        holder.tvWind.setText("Wind : "+mm.getWind());
        holder.tvWater.setText("Water : "+mm.getWater());
        holder.tvForecast.setText("Forecast : "+mm.getForecast());
        holder.tvEnjoySport.setText(""+mm.getEnjoySport());
    }

    @Override
    public int getItemCount() {
        return listModel.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvSky,tvAirTemp,tvNomor,tvHumidity, tvWind, tvWater, tvForecast, tvEnjoySport;

        public ViewHolder(View view) {
            super(view);
            tvNomor = (TextView)itemView.findViewById(R.id.tvNomor);
            tvSky = (TextView)itemView.findViewById(R.id.tvSky);
            tvAirTemp = (TextView)itemView.findViewById(R.id.tvAirTemp);
            tvHumidity = (TextView)itemView.findViewById(R.id.tvHumidity);
            tvWind = (TextView)itemView.findViewById(R.id.tvWind);
            tvWater = (TextView)itemView.findViewById(R.id.tvWater);
            tvForecast = (TextView)itemView.findViewById(R.id.tvForecast);
            tvEnjoySport = (TextView)itemView.findViewById(R.id.tvIsSport);
        }
    }

}
