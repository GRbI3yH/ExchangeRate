package com.example.chahlovkirill.exchangerate.Fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.chahlovkirill.exchangerate.Adapters.CitiesAdapter;
import com.example.chahlovkirill.exchangerate.AppSetting.Setting;
import com.example.chahlovkirill.exchangerate.Model.CityModel;
import com.example.chahlovkirill.exchangerate.Presenters.TabBanksPresenter;
import com.example.chahlovkirill.exchangerate.Presenters.TabCitiesPresenter;
import com.example.chahlovkirill.exchangerate.R;
import com.example.chahlovkirill.exchangerate.Services.ListenersRegistrator;
import com.example.chahlovkirill.exchangerate.Services.cash2cashAPI;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by chahlov.kirill on 23/01/17.
 */

public class TabCitiesFragment extends Fragment {
    /**
     * The fragment argument representing the section number for this
     * fragment.
     */
    private static final String ARG_SECTION_NUMBER = "section_number";

    public TabCitiesFragment() {
    }

    /**
     * Returns a new instance of this fragment for the given section
     * number.
     */
    public static TabCitiesFragment newInstance(int sectionNumber) {
        TabCitiesFragment fragment = new TabCitiesFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_SECTION_NUMBER, sectionNumber);
        fragment.setArguments(args);
        return fragment;
    }

    private View rootView;
    private ListView listViewCities;
    private TabCitiesPresenter citiesPresenter;
    //ListenersRegistrator registrator = new ListenersRegistrator();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.cities_tab_exc_rate, container, false);

        listViewCities = (ListView)rootView.findViewById(R.id.lvCityM);
        citiesPresenter = new TabCitiesPresenter(getContext());
        citiesPresenter.LoadModelOfSetting();
        citiesPresenter.DownloadModelOfServices();

        listViewCities.setAdapter(citiesPresenter.getAdapter());
        listViewCities.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //registrator.addListener(new TabBanksPresenter(getContext()));
            }
        });

        return rootView;
    }
}