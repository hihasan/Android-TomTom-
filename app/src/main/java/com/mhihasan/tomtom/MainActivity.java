package com.mhihasan.tomtom;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.tomtom.online.sdk.common.location.LatLng;
import com.tomtom.online.sdk.map.CameraPosition;
import com.tomtom.online.sdk.map.MapFragment;
import com.tomtom.online.sdk.map.MapView;
import com.tomtom.online.sdk.map.MarkerBuilder;
import com.tomtom.online.sdk.map.SimpleMarkerBalloon;
import com.tomtom.online.sdk.map.TomtomMap;


public class MainActivity extends AppCompatActivity {
    private TomtomMap ttmap;
    private MapView mapView; // Only is you are not using MapFragment and using the MapView from the SDK directly, use this reference variable.
    private MapFragment mapFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final OnMapReadyCallback onMapReadyCallback =
                new OnMapReadyCallback() {
                    @Override
                    public void onMapReady(TomtomMap map) {
                        //Map is ready here
                        ttmap = map;
                        ttmap.setMyLocationEnabled(true);
                    }
                };

        mapFragment = (MapFragment) getSupportFragmentManager().findFragmentById(R.id.mapFragment);
        mapFragment.getAsyncMap(onMapReadyCallback);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        ttmap.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }

    @Override
/** @inheritDoc */
    public void onStart() {
        super.onStart();
        mapFragment.onStart();
    }

    @Override
/** @inheritDoc */
    public void onResume() {
        super.onResume();
        mapFragment.onResume();
    }

    @Override
/** @inheritDoc */
    public void onPause() {
        mapFragment.onPause();
        super.onPause();
    }

    @Override
    public void onStop() {
        mapFragment.onStop();
        super.onStop();
    }

    @Override
    public void onDestroy() {
        mapFragment.onDestroy();
        super.onDestroy();
    }
}