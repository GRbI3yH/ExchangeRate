package com.example.chahlovkirill.exchangerate.Fragments.FragmentsBankDetails;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import com.example.chahlovkirill.exchangerate.DataProvider.DataProvider;
import com.example.chahlovkirill.exchangerate.Model.BankViewModel;
import com.example.chahlovkirill.exchangerate.Presenters.PresentersBankDetails.TabCashMachinesPresenter;
import com.example.chahlovkirill.exchangerate.R;

/**
 * Created by chahlov.kirill on 08/02/17.
 */

public class TabСashMachinesFragment extends Fragment {
    /**
     * The fragment argument representing the section number for this
     * fragment.
     */
    private static final String ARG_SECTION_NUMBER = "section_number";

    public TabСashMachinesFragment() {
    }

    /**
     * Returns a new instance of this fragment for the given section
     * number.
     */
    public static TabСashMachinesFragment newInstance(int sectionNumber) {
        TabСashMachinesFragment fragment = new TabСashMachinesFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_SECTION_NUMBER, sectionNumber);
        fragment.setArguments(args);
        return fragment;
    }

    private View view;
    private TabCashMachinesPresenter tabCashMachinesPresenter;
    private BankViewModel bankView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.tab_cash_machines, container, false);
        tabCashMachinesPresenter = new TabCashMachinesPresenter(getContext(),this,bankView);
        ListView cashMachineslistView = (ListView)view.findViewById(R.id.cashmachines_listview);
        cashMachineslistView.setAdapter(tabCashMachinesPresenter.getAdapter());
        TextView TextViewShowAll = (TextView) view.findViewById(R.id.cashmachines_ShowAll);

        TextViewShowAll.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                tabCashMachinesPresenter.ClickResultsAll();
            }
        });
        return view;
    }

    @Override
    public void onDestroy() {
        DataProvider.getInstance().removeListener(tabCashMachinesPresenter);
        Log.e("onDestroy","TabСashMachinesFragment");
        super.onDestroy();
    }

    public void setBank(BankViewModel bankView){
        this.bankView = bankView;
    }
}
