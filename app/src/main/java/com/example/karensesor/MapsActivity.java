package com.example.karensesor;

import androidx.core.app.ActivityCompat;
import androidx.fragment.app.FragmentActivity;

import android.Manifest;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CircleOptions;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolylineOptions;

import java.util.ArrayList;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    ArrayList<LatLng> arrayList= new ArrayList<>();
    LatLng Philippines = new LatLng(12.3300, 122.4880);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)
                != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_BACKGROUND_LOCATION)
                != PackageManager.PERMISSION_GRANTED) {
        } else if (mMap != null) {
            // Access to the location has been granted to the app.
            mMap.setMyLocationEnabled(true);
        }

        // Add a marker in Sydney and move the camera
        LatLng sydney = new LatLng(15.970806821408441, 120.5606979138104);
        mMap.addMarker(new MarkerOptions().position(sydney).title("Karen's Location"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
        //marker of urdaneta
        Marker m1 = googleMap.addMarker(new MarkerOptions()
                .position(new LatLng(15.980608693731682, 120.56065956620292))
                .anchor(0.5f, 0.5f)
                .title("LOCATION")
                .snippet("Urdanetas's Location"));


        mMap.addCircle(new CircleOptions()
                .center(new LatLng(15.970806821408441, 120.5606979138104))
                .radius(500)
                .strokeWidth(5)
                .strokeColor(Color.GREEN)
                .fillColor(Color.argb(128, 255, 0, 0)));

        //location of urdaneta
        mMap.addCircle(new CircleOptions()
                .center(new LatLng(15.980620369721564, 120.56062868579194))
                .radius(500)
                .strokeWidth(5)
                .strokeColor(Color.GREEN)
                .fillColor(Color.argb(128, 255, 0, 0)));

        mMap.addPolyline(new PolylineOptions()
                .add(new LatLng(15.970806821408441, 120.5606979138104),
                        new LatLng(15.970744933052561, 120.55968940328667),
                        new LatLng(15.97392689624217, 120.55950158156813),
                        new LatLng(15.974297382495266, 120.56024822961477),
                        new LatLng(15.97508466350611, 120.5602964004565),
                        new LatLng(15.97559407898057, 120.56376470106026),
                        new LatLng(15.980064569035731, 120.56344392643548),
                        new LatLng(15.981778009652112, 120.56014422377774),

                        new LatLng(15.980608693731682, 120.56065956620292))


                .width(10)
                .color(Color.BLUE));





        enableMyLocation();
        mMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
        mMap.getUiSettings().setZoomControlsEnabled(true);
        mMap.getUiSettings().setZoomGesturesEnabled(true);
        mMap.getUiSettings().setCompassEnabled(true);
    }


    public void enableMyLocation() {

    }
}