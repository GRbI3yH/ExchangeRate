package com.example.chahlovkirill.exchangerate.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.chahlovkirill.exchangerate.AppSetting.Setting;
import com.example.chahlovkirill.exchangerate.Model.BankModel;
import com.example.chahlovkirill.exchangerate.Model.CityModel;
import com.example.chahlovkirill.exchangerate.Presenters.TabBanksPresenter;
import com.example.chahlovkirill.exchangerate.R;
import com.example.chahlovkirill.exchangerate.Services.DataService;


import java.util.ArrayList;
import java.util.List;

//import retrofit2.Callback;

/**
 * Created by chahlov.kirill on 19/01/17.
 */

public class  CitiesAdapter extends ArrayAdapter<CityModel> {
    public CitiesAdapter(Context context, List<CityModel> Cities){
        super(context,0,Cities);
        this.Cities = Cities;
    }
    private List<CityModel> Cities = new ArrayList<>();

    //ListenersRegistrator registrator = new ListenersRegistrator();

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        final CityModel City = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.cities_list_item, parent, false);
        }

        TextView cityName = (TextView) convertView.findViewById(R.id.city_name);
        ImageView imageView = (ImageView) convertView.findViewById(R.id.imageView);

        convertView.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                for (CityModel city: CitiesAdapter.this.Cities){
                    if (city.getSelected()){
                        city.setSelected(false);
                    }
                }
                City.setSelected(true);
                Setting.setselectCity(String.valueOf(City.getId()),getContext());
                CitiesAdapter.this.notifyDataSetChanged();

                DataService.getInstance().BanksDownload(String.valueOf(City.getId()));
                //registrator.addListener(new TabBanksPresenter(getContext()));
            }

        });
        // Lookup view for data population
        if (City.getSelected()){
            imageView.setVisibility(View.VISIBLE);
        }
        else{
            imageView.setVisibility(View.GONE);
        }
        // Populate the data into the template view using the data object
        cityName.setText(City.getName());
        // Return the completed view to render on screen
        return convertView;
    }

}