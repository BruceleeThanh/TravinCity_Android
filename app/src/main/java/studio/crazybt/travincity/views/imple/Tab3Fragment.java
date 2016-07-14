package studio.crazybt.travincity.views.imple;

/**
 * Created by Brucelee Thanh on 11/04/2016.
 */

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.List;

import studio.crazybt.travincity.R;

public class Tab3Fragment extends Fragment {

    private View rootView;
    private static final int REQUEST_ID_ACCESS_COURSE_FINE_LOCATION = 100;
    private SupportMapFragment fragment;
    private GoogleMap googleMap;
    LocationManager locationManager;
    LocationListener locationListener;
    String provider;

    private boolean fabStatus;

    FloatingActionButton floatingActionButton;
    FloatingActionButton sub_fab_1;
    FloatingActionButton sub_fab_2;
    FloatingActionButton sub_fab_3;
    Animation show_sub_fab_1;
    Animation hide_sub_fab_1;
    Animation show_sub_fab_2;
    Animation hide_sub_fab_2;
    Animation show_sub_fab_3;
    Animation hide_sub_fab_3;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if (rootView == null) {
            rootView = inflater.inflate(R.layout.tab_fragment_3, container, false);
            this.prepareMap();

            this.fab_Load(rootView, this.getContext());
            this.subFAB_Load(rootView, this.getContext());

        } else {
            ((ViewGroup) rootView.getParent()).removeView(rootView);
        }

        return rootView;
    }

    private void fab_Load(View view, final Context context){
        floatingActionButton = (FloatingActionButton) view.findViewById(R.id.fabTab3);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (fabStatus == false) {
                    //Display FAB menu
                    expandFAB();
                    fabStatus = true;
                } else {
                    //Close FAB menu
                    hideFAB();
                    fabStatus = false;
                }
            }
        });
    }

    private void subFAB_Load(View view, Context context){
        sub_fab_1 = (FloatingActionButton) view.findViewById(R.id.sub_fab_1_tab_3);
        sub_fab_2 = (FloatingActionButton) view.findViewById(R.id.sub_fab_2_tab_3);
        sub_fab_3 = (FloatingActionButton) view.findViewById(R.id.sub_fab_3_tab_3);
        show_sub_fab_1 = AnimationUtils.loadAnimation(this.getActivity().getApplication(), R.anim.sub_fab_1_tab_1_show);
        hide_sub_fab_1 = AnimationUtils.loadAnimation(this.getActivity().getApplication(), R.anim.sub_fab_1_tab_1_hide);
        show_sub_fab_2 = AnimationUtils.loadAnimation(this.getActivity().getApplication(), R.anim.sub_fab_2_tab_1_show);
        hide_sub_fab_2 = AnimationUtils.loadAnimation(this.getActivity().getApplication(), R.anim.sub_fab_2_tab_1_hide);
        show_sub_fab_3 = AnimationUtils.loadAnimation(this.getActivity().getApplication(), R.anim.sub_fab_3_tab_1_show);
        hide_sub_fab_3 = AnimationUtils.loadAnimation(this.getActivity().getApplication(), R.anim.sub_fab_3_tab_1_hide);
        sub_fab_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                prepareMap();
            }
        });
    }

    private void expandFAB() {

        //Floating Action Button 1
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) sub_fab_1.getLayoutParams();
        layoutParams.rightMargin += (int) (sub_fab_1.getWidth() * 1.7);
        layoutParams.bottomMargin += (int) (sub_fab_1.getHeight() * 0.25);
        sub_fab_1.setLayoutParams(layoutParams);
        sub_fab_1.startAnimation(show_sub_fab_1);
        sub_fab_1.setClickable(true);

        //Floating Action Button 2
        FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) sub_fab_2.getLayoutParams();
        layoutParams2.rightMargin += (int) (sub_fab_2.getWidth() * 1.5);
        layoutParams2.bottomMargin += (int) (sub_fab_2.getHeight() * 1.5);
        sub_fab_2.setLayoutParams(layoutParams2);
        sub_fab_2.startAnimation(show_sub_fab_2);
        sub_fab_2.setClickable(true);

        //Floating Action Button 3
        FrameLayout.LayoutParams layoutParams3 = (FrameLayout.LayoutParams) sub_fab_3.getLayoutParams();
        layoutParams3.rightMargin += (int) (sub_fab_3.getWidth() * 0.25);
        layoutParams3.bottomMargin += (int) (sub_fab_3.getHeight() * 1.7);
        sub_fab_3.setLayoutParams(layoutParams3);
        sub_fab_3.startAnimation(show_sub_fab_3);
        sub_fab_3.setClickable(true);
    }


    private void hideFAB() {

        //Floating Action Button 1
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) sub_fab_1.getLayoutParams();
        layoutParams.rightMargin -= (int) (sub_fab_1.getWidth() * 1.7);
        layoutParams.bottomMargin -= (int) (sub_fab_1.getHeight() * 0.25);
        sub_fab_1.setLayoutParams(layoutParams);
        sub_fab_1.startAnimation(hide_sub_fab_1);
        sub_fab_1.setClickable(false);

        //Floating Action Button 2
        FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) sub_fab_2.getLayoutParams();
        layoutParams2.rightMargin -= (int) (sub_fab_2.getWidth() * 1.5);
        layoutParams2.bottomMargin -= (int) (sub_fab_2.getHeight() * 1.5);
        sub_fab_2.setLayoutParams(layoutParams2);
        sub_fab_2.startAnimation(hide_sub_fab_2);
        sub_fab_2.setClickable(false);

        //Floating Action Button 3
        FrameLayout.LayoutParams layoutParams3 = (FrameLayout.LayoutParams) sub_fab_3.getLayoutParams();
        layoutParams3.rightMargin -= (int) (sub_fab_3.getWidth() * 0.25);
        layoutParams3.bottomMargin -= (int) (sub_fab_3.getHeight() * 1.7);
        sub_fab_3.setLayoutParams(layoutParams3);
        sub_fab_3.startAnimation(hide_sub_fab_3);
        sub_fab_3.setClickable(false);
    }

    private void prepareMap() {
        FragmentManager fm = getChildFragmentManager();
        fragment = (SupportMapFragment) fm.findFragmentById(R.id.fmMap);
        if (fragment == null) {
            fragment = SupportMapFragment.newInstance();
            fm.beginTransaction().replace(R.id.fmMap, fragment).commit();
        }
        if (googleMap == null) {
            googleMap = fragment.getMap();
            if (ActivityCompat.checkSelfPermission(this.getContext(), Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this.getContext(), Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                return;
            }
            googleMap.setMyLocationEnabled(true);

            if (Build.VERSION.SDK_INT >= 10) {
                int accessCoarsePermission
                        = ContextCompat.checkSelfPermission(this.getActivity(), Manifest.permission.ACCESS_COARSE_LOCATION);
                int accessFinePermission
                        = ContextCompat.checkSelfPermission(this.getActivity(), Manifest.permission.ACCESS_FINE_LOCATION);


                if (accessCoarsePermission != PackageManager.PERMISSION_GRANTED
                        || accessFinePermission != PackageManager.PERMISSION_GRANTED) {

                    // Các quyền cần người dùng cho phép.
                    String[] permissions = new String[]{Manifest.permission.ACCESS_COARSE_LOCATION,
                            Manifest.permission.ACCESS_FINE_LOCATION};

                    // Hiển thị một Dialog hỏi người dùng cho phép các quyền trên.
                    ActivityCompat.requestPermissions(this.getActivity(), permissions, REQUEST_ID_ACCESS_COURSE_FINE_LOCATION);

                }
            }
            this.currentLocation();
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults) {

        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        //
        switch (requestCode) {
            case REQUEST_ID_ACCESS_COURSE_FINE_LOCATION: {


                // Chú ý: Nếu yêu cầu bị bỏ qua, mảng kết quả là rỗng.
                if (grantResults.length > 1
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED
                        && grantResults[1] == PackageManager.PERMISSION_GRANTED) {

                    Toast.makeText(this.getContext(), "Permission granted!", Toast.LENGTH_LONG).show();

                    // Hiển thị vị trí hiện thời trên bản đồ.
                    this.currentLocation();
                }
                // Hủy bỏ hoặc từ chối.
                else {
                    Toast.makeText(this.getContext(), "Permission denied!", Toast.LENGTH_LONG).show();
                }
                break;
            }
        }
    }

    public void currentLocation() {
        Location lastLocation = this.getLastKnownLocation();
        if (lastLocation != null) {
            LatLng latLng = new LatLng(lastLocation.getLatitude(), lastLocation.getLongitude());
            googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(latLng, 13));

            CameraPosition cameraPosition = new CameraPosition.Builder()
                    .target(latLng)      // Sets the center of the map to location user
                    .zoom(15)                   // Sets the zoom
                    .bearing(90)                // Sets the orientation of the camera to east
                    .build();                   // Creates a CameraPosition from the builder
            googleMap.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));
            //Thêm MarketOption cho Map:
            MarkerOptions option = new MarkerOptions();
            option.title("Bạn đang ở đây!");
            //option.snippet("Near some where.");
            option.position(latLng);
            Marker currentMarker = googleMap.addMarker(option);
            currentMarker.showInfoWindow();
        } else {
            Toast.makeText(this.getContext(), "Không thể tìm thấy vị trí của bạn.", Toast.LENGTH_SHORT).show();
        }
    }

    private Location getLastKnownLocation() {
        locationManager = (LocationManager) this.getContext().getApplicationContext().getSystemService(Context.LOCATION_SERVICE);
        List<String> providers = locationManager.getProviders(true);
        Location bestLocation = null;
        for (String provider : providers) {
            if (ActivityCompat.checkSelfPermission(this.getContext(), Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this.getContext(), Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {

            }
            Location l = locationManager.getLastKnownLocation(provider);
            if (l == null) {
                continue;
            }
            if (bestLocation == null || l.getAccuracy() < bestLocation.getAccuracy()) {
                // Found best last known location: %s", l);
                bestLocation = l;
            }
        }
        return bestLocation;
    }




    private void activeLocationFinder() {
        locationManager = (LocationManager) this.getActivity().getSystemService(Context.LOCATION_SERVICE);
        provider = locationManager.getBestProvider(new Criteria(), false);
        locationListener = new LocationListener() {
            @Override
            public void onLocationChanged(Location location) {
                Double lat = location.getLatitude();
                Double lng = location.getLongitude();
                googleMap.addMarker(new MarkerOptions().position(new LatLng(lat, lng)).title("You're Here!"));
                googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(lat, lng), 12));
            }

            @Override
            public void onStatusChanged(String provider, int status, Bundle extras) {

            }

            @Override
            public void onProviderEnabled(String provider) {
                if (ActivityCompat.checkSelfPermission(getContext(), Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(getContext(), Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                    return;
                }
                locationManager.requestLocationUpdates(provider, 10000, 0, locationListener);
            }

            @Override
            public void onProviderDisabled(String provider) {
                Intent intent = new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
                startActivity(intent);
            }
        };
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (ActivityCompat.checkSelfPermission(this.getContext(), Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this.getContext(), Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                requestPermissions(new String[]{
                        Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION, Manifest.permission.INTERNET
                }, 10);
                return;
            }
        }
        locationManager.requestLocationUpdates(provider, 10000, 0, locationListener);
    }
}
