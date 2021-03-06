package com.example.chahlovkirill.exchangerate.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.chahlovkirill.exchangerate.Model.Gis2Model.Result;
import com.example.chahlovkirill.exchangerate.Presenters.PresentersBankDetails.TabBankDetailsSearchPresenters;
import com.example.chahlovkirill.exchangerate.R;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by chahlov.kirill on 13/02/17.
 */

public class BankDetailsSearchAdapter extends ArrayAdapter<Result> {
    public BankDetailsSearchAdapter(Context context, List<Result> gis2Results, TabBankDetailsSearchPresenters tabBankDetailsSearchPresenters) {
        super(context, 0, gis2Results);
        this.tabBankDetailsSearchPresenters = tabBankDetailsSearchPresenters;
        this.gis2Results = gis2Results;
    }

    public List<Result> getGis2Results() {
        return gis2Results;
    }

    private List<Result> gis2Results;
    TabBankDetailsSearchPresenters tabBankDetailsSearchPresenters;
    Result gis2Result;

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        gis2Result = getItem(position);
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.gis2results_list_item, parent, false);
        }
        TextView nameText = (TextView) convertView.findViewById(R.id.gis2results_name);
        nameText.setText(gis2Result.getName());
        TextView addressText = (TextView) convertView.findViewById(R.id.gis2results_address_text);
        addressText.setText(gis2Result.getCity_name() + ", " + gis2Result.getAddress());
        TextView distance = (TextView) convertView.findViewById(R.id.gis2results_distance_text);
        distance.setText(String.format("%.2f", gis2Result.getDistances()) + " км");

        convertView.setTag(gis2Result);

        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Result gis2result = (Result) v.getTag();
                List<Result> gis2results = new ArrayList<Result>();
                gis2results.add(gis2result);
                tabBankDetailsSearchPresenters.ClickItem(gis2results);
            }
        });

        return convertView;
    }
}