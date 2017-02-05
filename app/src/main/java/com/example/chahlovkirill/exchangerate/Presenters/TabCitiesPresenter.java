package com.example.chahlovkirill.exchangerate.Presenters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.util.Log;

import com.example.chahlovkirill.exchangerate.Adapters.CitiesAdapter;
import com.example.chahlovkirill.exchangerate.DataProvider.DataProvider;
import com.example.chahlovkirill.exchangerate.DataProvider.IDataProviderOutput;
import com.example.chahlovkirill.exchangerate.Model.BankModel;
import com.example.chahlovkirill.exchangerate.Model.CityModel;
import com.example.chahlovkirill.exchangerate.Model.EExchangeAction;
import com.example.chahlovkirill.exchangerate.Model.Gis2Model.Gis2Model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/**
 * Created by chahlov.kirill on 23/01/17.
 */

public class TabCitiesPresenter implements IDataProviderOutput {

    private List<CityModel> cities;
    private Context context;
    private CitiesAdapter adapter;

    public TabCitiesPresenter(Context context){
        this.context = context;
        adapter = new CitiesAdapter(context, new ArrayList<CityModel>(), this);
        DataProvider.getInstance().addListener(this);
        DataProvider.getInstance().getCities();
        DataProvider.getInstance().getTheSelectedCity();
    }

    public CitiesAdapter getAdapter(){
        return adapter = new CitiesAdapter(context, cities, this);
    }

//    public void LoadingFromSettings(){//как один
//        cities = Settings.getCities(context);
//        MakeTheCitySelectedInTheModel();
//    }

    private void MakeTheCitySelectedInTheModel(String selectCity){
        //String selectCity = String.valueOf(Settings.getTheSelectedCityID(context));
        for (CityModel city :cities){
            if (String.valueOf(city.getId()).equals(selectCity)){
                city.setSelected(true);
                break;
            }
        }
    }

    public void CityClick(CityModel city){
        for (CityModel cityEdit: cities){
            if (cityEdit.getSelected()){
                cityEdit.setSelected(false);
            }
        }
        city.setSelected(true);
        UpdateAdapter();

        //Settings.setTheSelectCityID(city.getId(),context);
        DataProvider.getInstance().setTheSelectedCity(city);
        DataProvider.getInstance().getBanks(String.valueOf(city.getId()));
    }

    private void UpdateAdapter(){
        if (adapter != null) {
            adapter.clear();
            if (cities.size()==0){Log.i("TabCitiesPresenter.UA","а города то пустые");}
            adapter.addAll(cities);
            adapter.notifyDataSetChanged();
        }
    }
    int i = 0;
    @Override
    public void didReceiveCities(List<CityModel> cities) {
        i++;
        Log.i("TabCitiesPresenter","didReceiveCities ="+i);
        this.cities = cities;
        Log.i("cities = ",String.valueOf(cities.size()));
        //DataProvider.getInstance().setCities(cities);
        //DataProvider.getInstance().getTheSelectedCity();
        //didReceiveTheSelectedCity вызов
        UpdateAdapter();

    }

    @Override
    public void didReceiveTheSelectedCity(CityModel city) {
        Log.i("TabCitiesPresenter","didReceiveTheSelectedCity");
        DataProvider.getInstance().getBanks(String.valueOf(city.getId()));
//        MakeTheCitySelectedInTheModel(city.getName());
        //DataProvider.getInstance().removeListener(this);
//        Log.i("TabCitiesPresenter","я отписываюсь");
//        UpdateAdapter();
//        Log.i("TabCitiesPresenter","didReceiveTheSelectedCity");
    }

    @Override
    public void didReceiveBanks(List<BankModel> banks) {
        //Log.i("TabCitiesPresenter","didReceiveBanks");
    }

    @Override
    public void didReceiveSelectCurrencyForSorting(EExchangeAction mode) {
        //Log.i("TabCitiesPresenter","didReceiveSelectCurrencyForSorting");
    }

    @Override
    public void didReceiveGis2Data(Gis2Model gis2) {
        //Log.i("TabCitiesPresenter","didReceiveGis2Data");
    }
}