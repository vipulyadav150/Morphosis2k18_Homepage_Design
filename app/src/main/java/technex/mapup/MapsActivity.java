package technex.mapup;


import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.GroundOverlayOptions;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MapStyleOptions;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static technex.mapup.R.id.map;


public class MapsActivity extends FragmentActivity implements GoogleMap.OnInfoWindowClickListener,OnMapReadyCallback,GoogleMap.OnMarkerClickListener {

//GoogleMap.OnInfoWindowClickListener,
    private static final String TAG = MapsActivity.class.getSimpleName();



   /* private static final LatLng SAN_START = new LatLng(37.777030, -122.431464);
    private static final LatLng SAN_POS2 = new LatLng(37.778646, -122.431778);
    private static final LatLng SAN_POS3 = new LatLng(37.780487, -122.432160);
    private static final LatLng SAN_POS4 = new LatLng(37.782352, -122.432545);
    private static final LatLng SAN_POS5 = new LatLng(37.784310, -122.432932);
    private static final LatLng SAN_POS6 = new LatLng(37.786093, -122.433296);
    private static final LatLng SAN_POS7 = new LatLng(37.787958, -122.433669);
    private static final LatLng SAN_POS8 = new LatLng(37.789852, -122.434054);*/



        private static final LatLng SAN_START = new LatLng(49.273039, -123.119800);
        private static final LatLng SAN_POS2 = new LatLng(49.273965, -123.121352);
        private static final LatLng SAN_POS3 = new LatLng(49.275246, -123.123266);
        private static final LatLng SAN_POS4 = new LatLng(49.276524, -123.125211);
        private static final LatLng SAN_POS5 = new LatLng(49.277822, -123.127211);
        private static final LatLng SAN_POS6 = new LatLng(49.279086, -123.129170);
        private static final LatLng SAN_POS7 = new LatLng(49.280376, -123.131211);
        private static final LatLng SAN_POS8 = new LatLng(49.281818, -123.133354);
        private static final LatLng SAN_POS9 = new LatLng(49.283712, -123.136296);

    int p=0,pOld=0;
    int height = 250;
    int width = 250;
    int animDelay = 4000;

    double distance;


    private Marker mSAN_START;
    private Marker mSAN_START_POS2;
    private Marker mSAN_START_POS3;
    private Marker mSAN_START_POS4;
    private Marker mSAN_START_POS5;
    private Marker mSAN_START_POS6;
    private Marker mSAN_START_POS7;
    private Marker mSAN_START_POS8;
    private Marker mSAN_START_POS9;


    private GoogleMap mMap;
    // float mCameraTilt = (float) 67.5;

    int camzoom = 22;     //21;
     int cambear = -48;    //default -10
    double x = 19.537065;
    double y = 75.769825;

    int i;
    int o_v = 10;
    int o_w = 10;
    String start_txt = "Morphosis is the annual technical festival organized by the Technical Society of NIT Mizoram."+
            "It is basically a techno-management festival that is organized ......";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(map);
        mapFragment.getMapAsync(this);
 }


    @Override
    public void onMapReady(final GoogleMap googleMap) {
        mMap = googleMap;
        mMap.setBuildingsEnabled(true);
        mMap.setIndoorEnabled(true);
        mMap.getUiSettings().setZoomControlsEnabled(false);
        mMap.getUiSettings().setCompassEnabled(false);
        mMap.getUiSettings().setAllGesturesEnabled(true);
        mMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);

        mMap.setMinZoomPreference(17);         //or set 16
        mMap.setMaxZoomPreference(22);
        mMap.setOnMarkerClickListener(this);

       // JSON STYLED MAP

        try {
            // Customise the styling of the base map using a JSON object defined
            // in a raw resource file.
            boolean success = googleMap.setMapStyle(
                    MapStyleOptions.loadRawResourceStyle(
                            this, R.raw.asas));

            if (!success) {
                Log.e(TAG, "Style parsing failed.");
            }
        } catch (Resources.NotFoundException e) {
            Log.e(TAG, "Can't find style. Error: ", e);
        }




        BitmapDrawable bitmapDraw = (BitmapDrawable) getResources().getDrawable(R.drawable.newspin);
        final Bitmap b = bitmapDraw.getBitmap();
        final Bitmap smallMarker = Bitmap.createScaledBitmap(b, width, height, false);


        BitmapDrawable bitmapDrawnews = (BitmapDrawable) getResources().getDrawable(R.drawable.newspin);
        Bitmap bnews = bitmapDrawnews.getBitmap();
        Bitmap smallMarkernews = Bitmap.createScaledBitmap(bnews, width, height, false);


        BitmapDrawable bitmapDrawpeople = (BitmapDrawable) getResources().getDrawable(R.drawable.peoplepin);
        Bitmap bpeople = bitmapDrawpeople.getBitmap();
        Bitmap smallMarkerpeople = Bitmap.createScaledBitmap(bpeople, width, height, false);

        BitmapDrawable bitmapDrawprizes = (BitmapDrawable) getResources().getDrawable(R.drawable.prizepin);
        Bitmap bprizes = bitmapDrawprizes.getBitmap();
        Bitmap smallMarkerprizes = Bitmap.createScaledBitmap(bprizes, width, height, false);

        BitmapDrawable bitmapDrawweb = (BitmapDrawable) getResources().getDrawable(R.drawable.webpin);
        Bitmap bweb = bitmapDrawweb.getBitmap();
        Bitmap smallMarkerweb = Bitmap.createScaledBitmap(bweb, width, height, false);

        BitmapDrawable bitmapDrawabout = (BitmapDrawable) getResources().getDrawable(R.drawable.aboutpin);
        Bitmap babout = bitmapDrawabout.getBitmap();
        Bitmap smallMarkerabout = Bitmap.createScaledBitmap(babout, width, height, false);

        BitmapDrawable bitmapDrawwinner = (BitmapDrawable) getResources().getDrawable(R.drawable.winnerpin);
        Bitmap bwinner = bitmapDrawwinner.getBitmap();
        Bitmap smallMarkerwinner = Bitmap.createScaledBitmap(bwinner, width, height, false);

        BitmapDrawable bitmapDrawdev = (BitmapDrawable) getResources().getDrawable(R.drawable.devpin);
        Bitmap bdev = bitmapDrawdev.getBitmap();
        Bitmap smallMarkerdev = Bitmap.createScaledBitmap(bdev, width, height, false);




        final   CameraPosition SAN_START_POS9 = new CameraPosition.Builder()
                .target(SAN_POS9)
                .zoom(20)
                .bearing(cambear)
                .tilt((int) 67.5)
                .build();
        final CameraPosition SAN_START_POS8 = new CameraPosition.Builder()
                .target(SAN_POS8)
                .zoom(20)
                .bearing(cambear)
                .tilt((int) 67.5)
                .build();
        final CameraPosition SAN_START_POS7 = new CameraPosition.Builder()
                .target(SAN_POS7)
                .zoom(20)
                .bearing(cambear)
                .tilt((int) 67.5)
                .build();
        final CameraPosition SAN_START_POS6 = new CameraPosition.Builder()
                .target(SAN_POS6)
                .zoom(20)
                .bearing(cambear)
                .tilt((int) 67.5)
                .build();
        final CameraPosition SAN_START_POS5 = new CameraPosition.Builder()
                .target(SAN_POS5)
                .zoom(20)
                .bearing(cambear)
                .tilt((int) 67.5)
                .build();
       final CameraPosition SAN_START_POS4 = new CameraPosition.Builder()
                .target(SAN_POS4)
                .zoom(20)
                .bearing(cambear)
                .tilt((int) 67.5)
                .build();
        final CameraPosition SAN_START_POS3 = new CameraPosition.Builder()
                .target(SAN_POS3)
                .zoom(20)
                .bearing(cambear)
                .tilt((int) 67.5)
                .build();
        final CameraPosition SAN_START_POS2 = new CameraPosition.Builder()
                .target(SAN_POS2)
                .zoom(20)
                .bearing(cambear)
                .tilt((int) 67.5)
                .build();
        final CameraPosition SAN_START_POS = new CameraPosition.Builder()
                .target(SAN_START)
                .zoom(20)
                .bearing(cambear)
                .tilt((int) 67.5)
                .build();



        mMap.animateCamera(CameraUpdateFactory.newCameraPosition(SAN_START_POS9));
        mMap.animateCamera(CameraUpdateFactory.newCameraPosition(SAN_START_POS8));
        mMap.animateCamera(CameraUpdateFactory.newCameraPosition(SAN_START_POS7));
        mMap.animateCamera(CameraUpdateFactory.newCameraPosition(SAN_START_POS6));
        mMap.animateCamera(CameraUpdateFactory.newCameraPosition(SAN_START_POS5));
        mMap.animateCamera(CameraUpdateFactory.newCameraPosition(SAN_START_POS4));
        mMap.animateCamera(CameraUpdateFactory.newCameraPosition(SAN_START_POS3));
        mMap.animateCamera(CameraUpdateFactory.newCameraPosition(SAN_START_POS2));
        mMap.animateCamera(CameraUpdateFactory.newCameraPosition(SAN_START_POS), animDelay, null);







        mSAN_START_POS9 = mMap.addMarker(new MarkerOptions()
                .position(SAN_POS9)
                .title("NEWS").icon(BitmapDescriptorFactory.fromBitmap(smallMarkernews))
                .snippet("Hey this is news"));
        mSAN_START_POS9.setTag(9);

        mSAN_START_POS8 = mMap.addMarker(new MarkerOptions()
                .position(SAN_POS8)
                .title("NEWS").icon(BitmapDescriptorFactory.fromBitmap(smallMarkernews)));
        mSAN_START_POS8.setTag(8);
        mSAN_START_POS7 = mMap.addMarker(new MarkerOptions()
                .position(SAN_POS7)
                .title("NEWS").icon(BitmapDescriptorFactory.fromBitmap(smallMarkernews)));
        mSAN_START_POS7.setTag(7);
        mSAN_START_POS6 = mMap.addMarker(new MarkerOptions()
                .position(SAN_POS6)
                .title("NEWS").icon(BitmapDescriptorFactory.fromBitmap(smallMarkernews)));
        mSAN_START_POS6.setTag(6);
        mSAN_START_POS5 = mMap.addMarker(new MarkerOptions()
                .position(SAN_POS5)
                .title("NEWS").icon(BitmapDescriptorFactory.fromBitmap(smallMarkernews)));
        mSAN_START_POS5.setTag(5);
        mSAN_START_POS4 = mMap.addMarker(new MarkerOptions()
                .position(SAN_POS4)
                .title("NEWS").icon(BitmapDescriptorFactory.fromBitmap(smallMarkernews)));
        mSAN_START_POS4.setTag(4);

        mSAN_START_POS3 = mMap.addMarker(new MarkerOptions()
                .position(SAN_POS3)
                .title("NEWS").icon(BitmapDescriptorFactory.fromBitmap(smallMarkernews)));
        mSAN_START_POS3.setTag(3);

        mSAN_START_POS2 = mMap.addMarker(new MarkerOptions()
                .position(SAN_POS2)
                .title("NEWS").icon(BitmapDescriptorFactory.fromBitmap(smallMarkernews)));
        mSAN_START_POS2.setTag(2);

        mSAN_START = mMap.addMarker(new MarkerOptions()
                .position(SAN_START)
                .draggable(false)
                .title("MORPHOSIS").icon(BitmapDescriptorFactory.fromBitmap(smallMarkernews))
                .snippet(start_txt));
        mSAN_START.setTag(1);



          FloatingActionButton lost_float = findViewById(R.id.lostbtn);
          lost_float.setOnClickListener(new View.OnClickListener(){


            @Override
            public void onClick(View view) {


                    List<Marker> markers = new ArrayList<>();
                    markers.add(mSAN_START);
                    markers.add(mSAN_START_POS2);
                    markers.add(mSAN_START_POS3);
                    markers.add(mSAN_START_POS4);
                    markers.add(mSAN_START_POS5);
                    markers.add(mSAN_START_POS6);
                    markers.add(mSAN_START_POS7);
                    markers.add(mSAN_START_POS8);
                    markers.add(mSAN_START_POS9);

                    List<CameraPosition> camerapositions = new ArrayList<>();
                    camerapositions.add(SAN_START_POS);
                    camerapositions.add(SAN_START_POS2);
                    camerapositions.add(SAN_START_POS3);
                    camerapositions.add(SAN_START_POS4);
                    camerapositions.add(SAN_START_POS5);
                    camerapositions.add(SAN_START_POS6);
                    camerapositions.add(SAN_START_POS7);
                    camerapositions.add(SAN_START_POS8);
                    camerapositions.add(SAN_START_POS9);




                    List<Double> distances = new ArrayList<>();


                    CameraPosition curr_pos = mMap.getCameraPosition();
                    LatLng curr_latlng = curr_pos.target;
                    System.out.println("current latlng "+" is "+curr_latlng.latitude+","+curr_latlng.longitude);



                    for (i=0 ; i<9; i++) {
                        distances.add(CalculationByDistance(curr_latlng,markers.get(i).getPosition()));
                        //System.out.println("distance "+i+" is "+distances.get(i));
                    }

                    List<Double> temp = new ArrayList<Double>();

                    temp.addAll(distances);



                    Collections.sort(temp);


                    int p = distances.indexOf(temp.get(0));
                    System.out.println("distance latlng "+" is "+distances.get(p));

                    //Toast.makeText(MapsActivity.this, "distance is" + p , Toast.LENGTH_SHORT).show();
                    System.out.println("marker latlng "+" is "+markers.get(p).getPosition().latitude+","+markers.get(p).getPosition().longitude);
                    System.out.println("pip "+" is "+p);
                    System.out.println("pipo "+" is "+pOld);


                    if(p != pOld) {
                        mMap.animateCamera(CameraUpdateFactory.newCameraPosition(camerapositions.get(p)));
                        pOld = p;
                    } else{
                        if(p!=8){
                        mMap.animateCamera(CameraUpdateFactory.newCameraPosition(camerapositions.get(++p)));
                        }else{
                            p=-1;
                            mMap.animateCamera(CameraUpdateFactory.newCameraPosition(camerapositions.get(++p)));
                        }
                        pOld = p;
                    }



             /*   if(curr_latlng == SAN_POS3){
                      //  mMap.animateCamera(CameraUpdateFactory.newCameraPosition(SAN_START_POS9));
                        Toast.makeText(MapsActivity.this, "position is" + curr_latlng.latitude + ","+ curr_latlng.longitude , Toast.LENGTH_SHORT).show();
                    }
                    else
                    {
                      //  mMap.animateCamera(CameraUpdateFactory.newCameraPosition(SAN_START_POS));
                        Toast.makeText(MapsActivity.this, "position is" + curr_latlng.latitude + ","+ curr_latlng.longitude , Toast.LENGTH_SHORT).show();
                    }*/


            }
        });




        //SET GROUND OVERLAYS

        GroundOverlayOptions newarkMap = new GroundOverlayOptions()
                .image(BitmapDescriptorFactory.fromResource(R.drawable.morphhead))
                .position(SAN_START, o_v, o_w);
        mMap.addGroundOverlay(newarkMap);

        GroundOverlayOptions newarkMapa = new GroundOverlayOptions()
                .image(BitmapDescriptorFactory.fromResource(R.drawable.scheduleso))
                .position(SAN_POS2, o_v, o_w);
        mMap.addGroundOverlay(newarkMapa);

        GroundOverlayOptions newarkMapb = new GroundOverlayOptions()
                .image(BitmapDescriptorFactory.fromResource(R.drawable.newso))
                .position(SAN_POS3, o_v, o_w);
        mMap.addGroundOverlay(newarkMapb);

        GroundOverlayOptions newarkMapc = new GroundOverlayOptions()
                .image(BitmapDescriptorFactory.fromResource(R.drawable.peopleo))
                .position(SAN_POS4, o_v, o_w);
        mMap.addGroundOverlay(newarkMapc);

        GroundOverlayOptions newarkMapd = new GroundOverlayOptions()
                .image(BitmapDescriptorFactory.fromResource(R.drawable.winnero))
                .position(SAN_POS5, o_v, o_w);
        mMap.addGroundOverlay(newarkMapd);

        GroundOverlayOptions newarkMape = new GroundOverlayOptions()
                .image(BitmapDescriptorFactory.fromResource(R.drawable.prizeso))
                .position(SAN_POS6, o_v, o_w);
        mMap.addGroundOverlay(newarkMape);

        GroundOverlayOptions newarkMapf = new GroundOverlayOptions()
                .image(BitmapDescriptorFactory.fromResource(R.drawable.abouto))
                .position(SAN_POS7, o_v, o_w);
        mMap.addGroundOverlay(newarkMapf);

        GroundOverlayOptions newarkMapg = new GroundOverlayOptions()
                .image(BitmapDescriptorFactory.fromResource(R.drawable.devo))
                .position(SAN_POS8, o_v, o_w);
        mMap.addGroundOverlay(newarkMapg);

        GroundOverlayOptions newarkMaph = new GroundOverlayOptions()
                .image(BitmapDescriptorFactory.fromResource(R.drawable.webint))
                .position(SAN_POS9, o_v, o_w);
        mMap.addGroundOverlay(newarkMaph);




       /* mMap.addPolyline(new PolylineOptions().add(

                SAN_START,
                new LatLng(37.777030, -122.431464),
                new LatLng(37.778646, -122.431778),

                SAN_POS2


                )
                        .width(30)
                        .color(Color.BLUE)


        );
        mMap.addPolyline(new PolylineOptions().add(

                SAN_POS2,
                new LatLng(37.778646, -122.431778),
                new LatLng(37.780487, -122.432160),

                SAN_POS3


                )
                        .width(30)
                        .color(Color.BLUE)


        );

        mMap.addPolyline(new PolylineOptions().add(

                SAN_POS3,
                new LatLng(37.778646, -122.431778),
                new LatLng(37.782352, -122.432545),

                SAN_POS4


                )
                        .width(30)
                        .color(Color.BLUE)


        );
        mMap.addPolyline(new PolylineOptions().add(

                SAN_POS4,
                new LatLng(37.782352, -122.432545),
                new LatLng(37.784310, -122.432932),

                SAN_POS5


                )
                        .width(30)
                        .color(Color.BLUE)


        );
        mMap.addPolyline(new PolylineOptions().add(

                SAN_POS5,
                new LatLng(37.784310, -122.432932),
                new LatLng(37.786093, -122.433296),

                SAN_POS6


                )
                        .width(30)
                        .color(Color.BLUE)


        );

        mMap.addPolyline(new PolylineOptions().add(

                SAN_POS6,
                new LatLng(37.786093, -122.433296),
                new LatLng(37.787958, -122.433669),

                SAN_POS7


                )
                        .width(30)
                        .color(Color.BLUE)


        );

        mMap.addPolyline(new PolylineOptions().add(

                SAN_POS7,
                new LatLng(37.787958, -122.433669),
                new LatLng(37.789852, -122.434054),

                SAN_POS8


                )
                        .width(30)
                        .color(Color.BLUE)


        );

        mMap.addPolyline(new PolylineOptions().add(

                SAN_POS8,
                new LatLng(37.789852, -122.434054),
                new LatLng(37.791601, -122.434413),

                SAN_POS9


                )
                        .width(30)
                        .color(Color.BLUE)


        );*/



        //  mSAN_START.showInfoWindow();

                mMap.setOnInfoWindowClickListener(this);

                mMap.setInfoWindowAdapter(new GoogleMap.InfoWindowAdapter(){


                    @Override
                    public View getInfoWindow(Marker marker) {
                        return null;
                    }

                    @Override
                    public View getInfoContents(Marker marker) {
                        View view = getLayoutInflater().inflate(R.layout.marker_info,null);
                       // mSAN_START.showInfoWindow();
                        TextView textViewTitle = (TextView) view.findViewById(R.id.marker_title);
                        textViewTitle.setText(marker.getTitle());

                        TextView textViewSnippet = (TextView) view.findViewById(R.id.marker_snippet);
                        textViewSnippet.setText(marker.getSnippet());

                        return view;
                    }


        });


    }


            public double CalculationByDistance(LatLng StartP, LatLng EndP) {
                int Radius = 6371;// radius of earth in Km
                double lat1 = StartP.latitude;
                double lat2 = EndP.latitude;
                double lon1 = StartP.longitude;
                double lon2 = EndP.longitude;
                double dLat = Math.toRadians(lat2 - lat1);
                double dLon = Math.toRadians(lon2 - lon1);
                double a = Math.sin(dLat / 2) * Math.sin(dLat / 2)
                        + Math.cos(Math.toRadians(lat1))
                        * Math.cos(Math.toRadians(lat2)) * Math.sin(dLon / 2)
                        * Math.sin(dLon / 2);
                double c = 2 * Math.asin(Math.sqrt(a));
                double valueResult = Radius * c;
                double km = valueResult / 1;
                DecimalFormat newFormat = new DecimalFormat("####");
                int kmInDec = Integer.valueOf(newFormat.format(km));
                double meter = valueResult % 1000;
                int meterInDec = Integer.valueOf(newFormat.format(meter));
                Log.i("Radius Value", "" + valueResult + "   KM  " + kmInDec
                        + " Meter   " + meterInDec);

                return Radius * c;
            }


    @Override
    public boolean onMarkerClick(Marker marker)
        {

        Intent myintent = new Intent(MapsActivity.this ,opensample.class);
            startActivity(myintent);
           return false;

    }


    @Override
    public void onInfoWindowClick(Marker marker) {
        Intent myintent = new Intent(MapsActivity.this,opensample.class);
        startActivity(myintent);
    }
}


































/*

































































































































































































































































































/*  mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(AHMEDABAD,10));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(HIMACHAL_TOP,10));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(HYDER_SOUTH,10));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(MIZORAM_EAST,10));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(MUMBAI,10));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(NAG_RAJASTHAN,10));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(BIHAR,10));


        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(START_RES,10));*/



