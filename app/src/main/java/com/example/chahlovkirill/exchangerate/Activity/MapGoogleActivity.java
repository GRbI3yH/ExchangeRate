package com.example.chahlovkirill.exchangerate.Activity;

/**
 * Created by chahlov.kirill on 26/01/17.
 */
import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.chahlovkirill.exchangerate.R;

import com.google.android.gms.maps.*;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapGoogleActivity extends Activity {
    GoogleMap googleMap;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.map_google);
//        createMapView();
//        addMarker();
    }
//    private void createMapView(){
//        /**
//         * Catch the null pointer exception that
//         * may be thrown when initialising the map
//         */
//        try {
//            if(null == googleMap){
//                googleMap = ((MapFragment) getFragmentManager().findFragmentById(
//                        R.id.mapView)).getMap();
//
//                /**
//                 * If the map is still null after attempted initialisation,
//                 * show an error to the user
//                 */
//                if(null == googleMap) {
//                    Toast.makeText(getApplicationContext(),
//                            "Error creating map",Toast.LENGTH_SHORT).show();
//                }
//            }
//        } catch (NullPointerException exception){
//            Log.e("mapApp", exception.toString());
//        }
//    }
//    private void addMarker(){
//
//        /** Make sure that the map has been initialised **/
//        if(null != googleMap){
//            googleMap.addMarker(new MarkerOptions()
//                    .position(new LatLng(0, 0))
//                    .title("Marker")
//                    .draggable(true)
//            );
//        }
//    }
}