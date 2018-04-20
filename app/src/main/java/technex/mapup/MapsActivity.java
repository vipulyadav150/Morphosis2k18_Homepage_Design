package technex.mapup;


import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.animation.BounceInterpolator;
import android.view.animation.Interpolator;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.GroundOverlayOptions;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import static technex.mapup.R.id.map;
import static technex.mapup.R.id.start;


public class MapsActivity extends FragmentActivity implements GoogleMap.OnInfoWindowClickListener,OnMapReadyCallback,GoogleMap.OnMarkerClickListener {

//GoogleMap.OnInfoWindowClickListener,
    private static final String TAG = MapsActivity.class.getSimpleName();




    private static final LatLng WEST_BENG = new LatLng(19.831878, 75.903721);
    private static final LatLng AHMEDABAD = new LatLng(20.133228, 75.822871);
    private static final LatLng HIMACHAL_TOP = new LatLng(20.543667, 75.747941);//
    private static final LatLng HYDER_SOUTH = new LatLng(20.656386, 75.695408);
    private static final LatLng MIZORAM_EAST = new LatLng(20.977515, 75.645371);
    private static final LatLng MUMBAI = new LatLng(21.219211, 75.652879);
    private static final LatLng NAG_RAJASTHAN = new LatLng(21.601164, 75.884302);
    private static final LatLng BIHAR = new LatLng(21.874551, 75.941858);

    private static final LatLng START_RES = new LatLng(19.537065, 75.769825);

    private static final LatLng SAN_START = new LatLng(37.777030, -122.431464);
    private static final LatLng SAN_POS2 = new LatLng(37.778646, -122.431778);
    private static final LatLng SAN_POS3 = new LatLng(37.780487, -122.432160);
    private static final LatLng SAN_POS4 = new LatLng(37.782352, -122.432545);
    private static final LatLng SAN_POS5 = new LatLng(37.784310, -122.432932);
    private static final LatLng SAN_POS6 = new LatLng(37.786093, -122.433296);
    private static final LatLng SAN_POS7 = new LatLng(37.787958, -122.433669);
    private static final LatLng SAN_POS8 = new LatLng(37.789852, -122.434054);
    private static final LatLng SAN_POS9 = new LatLng(37.791601, -122.434413);


    int height = 250;
    int width = 250;
    int animDelay = 4000;


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
    // int cambear = 10;
    double x = 19.537065;
    double y = 75.769825;

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

        //JSON STYLED MAP

        /*try {
            // Customise the styling of the base map using a JSON object defined
            // in a raw resource file.
            boolean success = googleMap.setMapStyle(
                    MapStyleOptions.loadRawResourceStyle(
                            this, R.raw.try2));

            if (!success) {
                Log.e(TAG, "Style parsing failed.");
            }
        } catch (Resources.NotFoundException e) {
            Log.e(TAG, "Can't find style. Error: ", e);
        }*/


        BitmapDrawable bitmapDraw = (BitmapDrawable) getResources().getDrawable(R.drawable.newspin);
        Bitmap b = bitmapDraw.getBitmap();
        Bitmap smallMarker = Bitmap.createScaledBitmap(b, width, height, false);


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


        CameraPosition SAN_START_POS9 = new CameraPosition.Builder()
                .target(SAN_POS9)
                .zoom(20)
                .bearing(-10)
                .tilt((int) 67.5)
                .build();
        CameraPosition SAN_START_POS8 = new CameraPosition.Builder()
                .target(SAN_POS8)
                .zoom(20)
                .bearing(-10)
                .tilt((int) 67.5)
                .build();
        CameraPosition SAN_START_POS7 = new CameraPosition.Builder()
                .target(SAN_POS7)
                .zoom(20)
                .bearing(-10)
                .tilt((int) 67.5)
                .build();
        CameraPosition SAN_START_POS6 = new CameraPosition.Builder()
                .target(SAN_POS6)
                .zoom(20)
                .bearing(-10)
                .tilt((int) 67.5)
                .build();
        CameraPosition SAN_START_POS5 = new CameraPosition.Builder()
                .target(SAN_POS5)
                .zoom(20)
                .bearing(-10)
                .tilt((int) 67.5)
                .build();
        CameraPosition SAN_START_POS4 = new CameraPosition.Builder()
                .target(SAN_POS4)
                .zoom(20)
                .bearing(-10)
                .tilt((int) 67.5)
                .build();
        CameraPosition SAN_START_POS3 = new CameraPosition.Builder()
                .target(SAN_POS3)
                .zoom(20)
                .bearing(-10)
                .tilt((int) 67.5)
                .build();
        CameraPosition SAN_START_POS2 = new CameraPosition.Builder()
                .target(SAN_POS2)
                .zoom(20)
                .bearing(-10)
                .tilt((int) 67.5)
                .build();
        final CameraPosition SAN_START_POS = new CameraPosition.Builder()
                .target(SAN_START)
                .zoom(20)
                .bearing(-10)
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


        FloatingActionButton lost_float = findViewById(R.id.lostbtn);
        lost_float.setOnClickListener(new View.OnClickListener(){


            @Override
            public void onClick(View view) {
            mMap.animateCamera(CameraUpdateFactory.newCameraPosition(SAN_START_POS));
            }
        });



        FloatingActionButton help_fab = findViewById(R.id.helpbtn);
        help_fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent move_to_help_activity = new Intent(MapsActivity.this, help_tutorial.class);
                startActivity(move_to_help_activity);

            }
        });


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
                .draggable(true)
                .title("MORPHOSIS").icon(BitmapDescriptorFactory.fromBitmap(smallMarkernews))
                .snippet(start_txt));
        mSAN_START.setTag(1);


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





    @Override
    public boolean onMarkerClick(Marker marker)
        {
        /*Integer clickCount = (Integer) marker.getTag();
        if (clickCount != null) {
            clickCount = clickCount + 1;
            marker.setTag(clickCount);
            Toast.makeText(this,
                    marker.getTitle() +
                            " has been clicked " + clickCount + " times.",
                    Toast.LENGTH_SHORT).show();
        }

        return false;*/

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

//Adding polylines btw given coordinates








        Circle circle = mMap.addCircle(new CircleOptions()
                .center(START_RES)
                .radius(1000)
                .strokeColor(R.color.colorLoc)
                .fillColor(R.color.colorLocedge)
        );

        Circle circlewest = mMap.addCircle(new CircleOptions()
                .center(WEST_BENG)
                .radius(1000)
                .strokeColor(R.color.colorLoc)
                .fillColor(R.color.colorLocedge)
        );
        Circle circleahm = mMap.addCircle(new CircleOptions()
                .center(AHMEDABAD)
                .radius(1000)
                .strokeColor(R.color.colorLoc)
                .fillColor(R.color.colorLocedge)
        );
        Circle circlehim = mMap.addCircle(new CircleOptions()
                .center(HIMACHAL_TOP)
                .radius(1000)
                .strokeColor(R.color.colorLoc)
                .fillColor(R.color.colorLocedge)
        );
        Circle circlehyd = mMap.addCircle(new CircleOptions()
                .center(HYDER_SOUTH)
                .radius(1000)
                .strokeColor(R.color.colorLoc)
                .fillColor(R.color.colorLocedge)
        );
        Circle circlemz = mMap.addCircle(new CircleOptions()
                .center(MIZORAM_EAST)
                .radius(1000)
                .strokeColor(R.color.colorLoc)
                .fillColor(R.color.colorLocedge)
        );
        Circle circlemum = mMap.addCircle(new CircleOptions()
                .center(MUMBAI)
                .radius(1000)
                .strokeColor(R.color.colorLoc)
                .fillColor(R.color.colorLocedge)
        );

        Circle circleraj = mMap.addCircle(new CircleOptions()
                .center(NAG_RAJASTHAN)
                .radius(1000)
                .strokeColor(R.color.colorLoc)
                .fillColor(R.color.colorLocedge)
        );

        Circle circlebihar = mMap.addCircle(new CircleOptions()
                .center(BIHAR)
                .radius(1000)
                .strokeColor(R.color.colorLoc)
                .fillColor(R.color.colorLocedge)
        );




        mMap.addPolyline(new PolylineOptions().add(

                    START_RES,
                    new LatLng(19.679041, 75.820701),
                    new LatLng(19.789562, 75.857780),

                    WEST_BENG


                )
                .width(30)
                .color(Color.BLACK)


        );


        mMap.addPolyline(new PolylineOptions().add(

                WEST_BENG,
                new LatLng(19.984436, 75.874192),
                new LatLng(20.085070, 75.836427),

                AHMEDABAD


                )
                        .width(30)
                        .color(Color.BLACK)


        );



        mMap.addPolyline(new PolylineOptions().add(

                AHMEDABAD,
                new LatLng(20.366147, 75.728715),
                new LatLng(20.497410, 75.738328),

                HIMACHAL_TOP


                )
                        .width(30)
                        .color(Color.BLACK)


        );






        mMap.addPolyline(new PolylineOptions().add(

                HIMACHAL_TOP,
                new LatLng(20.596020, 75.722239),
                new LatLng(20.635223, 75.711596),
                HYDER_SOUTH




                )
                        .width(30)
                        .color(Color.BLACK)


        );







        mMap.addPolyline(new PolylineOptions().add(

                HYDER_SOUTH,
                new LatLng(20.795756, 75.659197),
                new LatLng(20.911256, 75.645464),
                MIZORAM_EAST




                )
                        .width(30)
                        .color(Color.BLACK)


        );



        mMap.addPolyline(new PolylineOptions().add(

                MIZORAM_EAST,
                new LatLng(21.117427, 75.665925),
                new LatLng(21.200032, 75.661119),
                MUMBAI




                )
                        .width(30)
                        .color(Color.BLACK)


        );



        mMap.addPolyline(new PolylineOptions().add(

                MUMBAI,
                new LatLng(21.430594, 75.764574),
                new LatLng(21.569867, 75.868944),
                NAG_RAJASTHAN




                )
                        .width(30)
                        .color(Color.BLACK)


        );





        mMap.addPolyline(new PolylineOptions().add(

                NAG_RAJASTHAN,
                new LatLng(21.736154, 75.910028),
                new LatLng(21.856014, 75.929941),
                BIHAR




                )
                        .width(30)
                        .color(Color.BLACK)


        );


































































































































































































































































/*package technex.mapup;


        import android.animation.Animator;
        import android.animation.ObjectAnimator;
        import android.animation.TypeEvaluator;
        import android.content.res.Resources;
        import android.graphics.Bitmap;
        import android.graphics.Color;
        import android.graphics.drawable.BitmapDrawable;
        import android.os.Bundle;
        import android.support.v4.app.FragmentActivity;
        import android.util.Log;
        import android.util.Property;
        import android.widget.Toast;

        import com.google.android.gms.maps.CameraUpdateFactory;
        import com.google.android.gms.maps.GoogleMap;
        import com.google.android.gms.maps.OnMapReadyCallback;
        import com.google.android.gms.maps.SupportMapFragment;
        import com.google.android.gms.maps.model.BitmapDescriptor;
        import com.google.android.gms.maps.model.BitmapDescriptorFactory;
        import com.google.android.gms.maps.model.CameraPosition;
        import com.google.android.gms.maps.model.Circle;
        import com.google.android.gms.maps.model.CircleOptions;
        import com.google.android.gms.maps.model.GroundOverlay;
        import com.google.android.gms.maps.model.GroundOverlayOptions;
        import com.google.android.gms.maps.model.LatLng;
        import com.google.android.gms.maps.model.LatLngBounds;
        import com.google.android.gms.maps.model.MapStyleOptions;
        import com.google.android.gms.maps.model.Marker;
        import com.google.android.gms.maps.model.MarkerOptions;
        import com.google.android.gms.maps.model.PolylineOptions;
        import com.google.android.gms.maps.model.TileOverlay;
        import com.google.android.gms.maps.model.TileOverlayOptions;
        import com.google.android.gms.maps.model.TileProvider;
        import com.google.android.gms.maps.model.UrlTileProvider;

        import java.net.MalformedURLException;
        import java.net.URL;

        import static android.view.FrameMetrics.ANIMATION_DURATION;
        import static technex.mapup.R.id.map;


public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {
// ,GoogleMap.OnMarkerClickListener

    private static final String TAG = MapsActivity.class.getSimpleName();
    //  private static final LatLng CENTER_MP = new LatLng(23.786683, 92.562416);
    private static final LatLng WEST_BENG = new LatLng(19.831878, 75.903721);
    private static final LatLng AHMEDABAD = new LatLng(20.133228, 75.822871);
    private static final LatLng HIMACHAL_TOP = new LatLng(20.543667, 75.747941);//
    private static final LatLng HYDER_SOUTH = new LatLng(20.656386, 75.695408);
    private static final LatLng MIZORAM_EAST = new LatLng(20.977515, 75.645371);
    private static final LatLng MUMBAI = new LatLng(21.219211, 75.652879);
    private static final LatLng NAG_RAJASTHAN = new LatLng(21.601164, 75.884302);
    private static final LatLng BIHAR = new LatLng(21.874551, 75.941858);

    private static final LatLng START_RES = new LatLng(19.537065, 75.769825);

    private static final LatLng SAN = new LatLng(37.777030, -122.431464);

    int height = 470;
    int width = 420;

    private Marker mCENTER_MP;
    private Marker mWEST_BENG;
    private Marker mAHMEDABAD;
    private Marker mHIMACHAL_TOP;
    private Marker mHYDER_SOUTH;
    private Marker mMIZORAM_EAST;
    private Marker mMUMBAI;
    private Marker mNAG_RAJASTHAN;
    private Marker mBIHAR;
    private Marker mSAN;

    private Marker mSTART_RES;

    private GoogleMap mMap;
    // float mCameraTilt = (float) 67.5;

    int camzoom = 22;     //21;
    // int cambear = 10;
    double x = 19.537065;
    double y = 75.769825;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(map);
        mapFragment.getMapAsync(this);
    }


    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        mMap.setBuildingsEnabled(true);
        mMap.setIndoorEnabled(true);
        BitmapDrawable bitmapDrawnews =(BitmapDrawable)getResources().getDrawable(R.drawable.newspin);
        Bitmap bnews=bitmapDrawnews.getBitmap();
        Bitmap smallMarkernews = Bitmap.createScaledBitmap(bnews,width,height,false);
        mMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
        mSAN = mMap.addMarker(new MarkerOptions()
                .position(SAN)
                .title("NEWS") .icon(BitmapDescriptorFactory.fromBitmap(smallMarkernews)));
        mSAN.setTag(2);
        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(SAN,50));
        CameraPosition positiond = new CameraPosition.Builder()
                .target(SAN)
                .zoom(50)
                .bearing(0)
                .tilt((int)67.5)
                .build();

        try {
            // Customise the styling of the base map using a JSON object defined
            // in a raw resource file.
            boolean success = googleMap.setMapStyle(
                    MapStyleOptions.loadRawResourceStyle(
                            this, R.raw.trymap));

            if (!success) {
                Log.e(TAG, "Style parsing failed.");
            }
        } catch (Resources.NotFoundException e) {
            Log.e(TAG, "Can't find style. Error: ", e);
        }
/*
        GroundOverlayOptions newarkMap = new GroundOverlayOptions()
                .image(BitmapDescriptorFactory.fromResource(R.drawable.savageicon))
                .position(START_RES, 8600f, 6500f);
        mMap.addGroundOverlay(newarkMap);

        GroundOverlayOptions newarkMapa = new GroundOverlayOptions()
                .image(BitmapDescriptorFactory.fromResource(R.drawable.savageicon))
                .position(WEST_BENG, 8600f, 6500f);
        mMap.addGroundOverlay(newarkMapa);

        GroundOverlayOptions newarkMapb = new GroundOverlayOptions()
                .image(BitmapDescriptorFactory.fromResource(R.drawable.savageicon))
                .position(AHMEDABAD, 8600f, 6500f);
        mMap.addGroundOverlay(newarkMapb);

        GroundOverlayOptions newarkMapc = new GroundOverlayOptions()
                .image(BitmapDescriptorFactory.fromResource(R.drawable.savageicon))
                .position(HIMACHAL_TOP, 8600f, 6500f);
        mMap.addGroundOverlay(newarkMapc);

        GroundOverlayOptions newarkMapd = new GroundOverlayOptions()
                .image(BitmapDescriptorFactory.fromResource(R.drawable.savageicon))
                .position(HYDER_SOUTH, 8600f, 6500f);
        mMap.addGroundOverlay(newarkMapd);

        GroundOverlayOptions newarkMape = new GroundOverlayOptions()
                .image(BitmapDescriptorFactory.fromResource(R.drawable.savageicon))
                .position(MIZORAM_EAST, 8600f, 6500f);
        mMap.addGroundOverlay(newarkMape);

        GroundOverlayOptions newarkMapf = new GroundOverlayOptions()
                .image(BitmapDescriptorFactory.fromResource(R.drawable.savageicon))
                .position(MUMBAI, 8600f, 6500f);
        mMap.addGroundOverlay(newarkMapf);

        GroundOverlayOptions newarkMapg = new GroundOverlayOptions()
                .image(BitmapDescriptorFactory.fromResource(R.drawable.savageicon))
                .position(NAG_RAJASTHAN, 8600f, 6500f);
        mMap.addGroundOverlay(newarkMapg);

        GroundOverlayOptions newarkMaph = new GroundOverlayOptions()
                .image(BitmapDescriptorFactory.fromResource(R.drawable.savageicon))
                .position(BIHAR, 8600f, 6500f);
        mMap.addGroundOverlay(newarkMaph);


        BitmapDrawable bitmapDraw=(BitmapDrawable)getResources().getDrawable(R.drawable.schedulepin);
        Bitmap b=bitmapDraw.getBitmap();
        Bitmap smallMarker = Bitmap.createScaledBitmap(b,width,height,false);


        BitmapDrawable bitmapDrawnews =(BitmapDrawable)getResources().getDrawable(R.drawable.newspin);
        Bitmap bnews=bitmapDrawnews.getBitmap();
        Bitmap smallMarkernews = Bitmap.createScaledBitmap(bnews,width,height,false);


        BitmapDrawable bitmapDrawpeople=(BitmapDrawable)getResources().getDrawable(R.drawable.peoplepin);
        Bitmap bpeople=bitmapDrawpeople.getBitmap();
        Bitmap smallMarkerpeople = Bitmap.createScaledBitmap(bpeople,width,height,false);

        BitmapDrawable bitmapDrawprizes=(BitmapDrawable)getResources().getDrawable(R.drawable.prizepin);
        Bitmap bprizes=bitmapDrawprizes.getBitmap();
        Bitmap smallMarkerprizes = Bitmap.createScaledBitmap(bprizes,width,height,false);

        BitmapDrawable bitmapDrawweb=(BitmapDrawable)getResources().getDrawable(R.drawable.webpin);
        Bitmap bweb=bitmapDrawweb.getBitmap();
        Bitmap smallMarkerweb = Bitmap.createScaledBitmap(bweb,width,height,false);

        BitmapDrawable bitmapDrawabout=(BitmapDrawable)getResources().getDrawable(R.drawable.aboutpin);
        Bitmap babout=bitmapDrawabout.getBitmap();
        Bitmap smallMarkerabout = Bitmap.createScaledBitmap(babout,width,height,false);

        BitmapDrawable bitmapDrawwinner=(BitmapDrawable)getResources().getDrawable(R.drawable.winnerpin);
        Bitmap bwinner=bitmapDrawwinner.getBitmap();
        Bitmap smallMarkerwinner = Bitmap.createScaledBitmap(bwinner,width,height,false);

        BitmapDrawable bitmapDrawdev=(BitmapDrawable)getResources().getDrawable(R.drawable.devpin);
        Bitmap bdev=bitmapDrawdev.getBitmap();
        Bitmap smallMarkerdev= Bitmap.createScaledBitmap(bdev,width,height,false);






        mWEST_BENG = mMap.addMarker(new MarkerOptions()
                .position(WEST_BENG)
                .title("SCHEDULES").icon(BitmapDescriptorFactory.fromBitmap(smallMarker)));
        mWEST_BENG.setTag(1);

        mAHMEDABAD = mMap.addMarker(new MarkerOptions()
                .position(AHMEDABAD)
                .title("NEWS") .icon(BitmapDescriptorFactory.fromBitmap(smallMarkernews)));
        mAHMEDABAD.setTag(2);


        mHIMACHAL_TOP = mMap.addMarker(new MarkerOptions()
                .position(HIMACHAL_TOP)
                .title("PEOPLE") .icon(BitmapDescriptorFactory.fromBitmap(smallMarkerpeople)));
        mHIMACHAL_TOP.setTag(3);

        mHYDER_SOUTH = mMap.addMarker(new MarkerOptions()
                .position(HYDER_SOUTH)
                .title("PRIZES") .icon(BitmapDescriptorFactory.fromBitmap(smallMarkerprizes)));
        mHYDER_SOUTH.setTag(4);

        mMIZORAM_EAST = mMap.addMarker(new MarkerOptions()
                .position(MIZORAM_EAST)
                .title("WEB") .icon(BitmapDescriptorFactory.fromBitmap(smallMarkerweb)));
        mMIZORAM_EAST.setTag(5);


        mMUMBAI = mMap.addMarker(new MarkerOptions()
                .position(MUMBAI)
                .title("ABOUT") .icon(BitmapDescriptorFactory.fromBitmap(smallMarkerabout)));
        mMUMBAI.setTag(6);


        mNAG_RAJASTHAN = mMap.addMarker(new MarkerOptions()
                .position(NAG_RAJASTHAN)
                .title("WINNERS") .icon(BitmapDescriptorFactory.fromBitmap(smallMarkerwinner)));
        mNAG_RAJASTHAN.setTag(7);


        mBIHAR = mMap.addMarker(new MarkerOptions()
                .position(BIHAR)
                .title("DEVELOPERS") .icon(BitmapDescriptorFactory.fromBitmap(smallMarkerdev)));
        mBIHAR.setTag(8);



        mSTART_RES = mMap.addMarker(new MarkerOptions()
                .position(START_RES)
                .title("MORPHOSIS") .icon(BitmapDescriptorFactory.fromBitmap(smallMarker)));
        mSTART_RES.setTag(0);


//Adding polylines btw given coordinates



        Circle circle = mMap.addCircle(new CircleOptions()
                .center(START_RES)
                .radius(1000)
                .strokeColor(R.color.colorLoc)
                .fillColor(R.color.colorLocedge)
        );

        Circle circlewest = mMap.addCircle(new CircleOptions()
                .center(WEST_BENG)
                .radius(1000)
                .strokeColor(R.color.colorLoc)
                .fillColor(R.color.colorLocedge)
        );
        Circle circleahm = mMap.addCircle(new CircleOptions()
                .center(AHMEDABAD)
                .radius(1000)
                .strokeColor(R.color.colorLoc)
                .fillColor(R.color.colorLocedge)
        );
        Circle circlehim = mMap.addCircle(new CircleOptions()
                .center(HIMACHAL_TOP)
                .radius(1000)
                .strokeColor(R.color.colorLoc)
                .fillColor(R.color.colorLocedge)
        );
        Circle circlehyd = mMap.addCircle(new CircleOptions()
                .center(HYDER_SOUTH)
                .radius(1000)
                .strokeColor(R.color.colorLoc)
                .fillColor(R.color.colorLocedge)
        );
        Circle circlemz = mMap.addCircle(new CircleOptions()
                .center(MIZORAM_EAST)
                .radius(1000)
                .strokeColor(R.color.colorLoc)
                .fillColor(R.color.colorLocedge)
        );
        Circle circlemum = mMap.addCircle(new CircleOptions()
                .center(MUMBAI)
                .radius(1000)
                .strokeColor(R.color.colorLoc)
                .fillColor(R.color.colorLocedge)
        );

        Circle circleraj = mMap.addCircle(new CircleOptions()
                .center(NAG_RAJASTHAN)
                .radius(1000)
                .strokeColor(R.color.colorLoc)
                .fillColor(R.color.colorLocedge)
        );

        Circle circlebihar = mMap.addCircle(new CircleOptions()
                .center(BIHAR)
                .radius(1000)
                .strokeColor(R.color.colorLoc)
                .fillColor(R.color.colorLocedge)
        );




        mMap.addPolyline(new PolylineOptions().add(

                    START_RES,
                    new LatLng(19.679041, 75.820701),
                    new LatLng(19.789562, 75.857780),

                    WEST_BENG


                )
                .width(30)
                .color(Color.BLACK)


        );


        mMap.addPolyline(new PolylineOptions().add(

                WEST_BENG,
                new LatLng(19.984436, 75.874192),
                new LatLng(20.085070, 75.836427),

                AHMEDABAD


                )
                        .width(30)
                        .color(Color.BLACK)


        );



        mMap.addPolyline(new PolylineOptions().add(

                AHMEDABAD,
                new LatLng(20.366147, 75.728715),
                new LatLng(20.497410, 75.738328),

                HIMACHAL_TOP


                )
                        .width(30)
                        .color(Color.BLACK)


        );






        mMap.addPolyline(new PolylineOptions().add(

                HIMACHAL_TOP,
                new LatLng(20.596020, 75.722239),
                new LatLng(20.635223, 75.711596),
                HYDER_SOUTH




                )
                        .width(30)
                        .color(Color.BLACK)


        );







        mMap.addPolyline(new PolylineOptions().add(

                HYDER_SOUTH,
                new LatLng(20.795756, 75.659197),
                new LatLng(20.911256, 75.645464),
                MIZORAM_EAST




                )
                        .width(30)
                        .color(Color.BLACK)


        );



        mMap.addPolyline(new PolylineOptions().add(

                MIZORAM_EAST,
                new LatLng(21.117427, 75.665925),
                new LatLng(21.200032, 75.661119),
                MUMBAI




                )
                        .width(30)
                        .color(Color.BLACK)


        );



        mMap.addPolyline(new PolylineOptions().add(

                MUMBAI,
                new LatLng(21.430594, 75.764574),
                new LatLng(21.569867, 75.868944),
                NAG_RAJASTHAN




                )
                        .width(30)
                        .color(Color.BLACK)


        );





        mMap.addPolyline(new PolylineOptions().add(

                NAG_RAJASTHAN,
                new LatLng(21.736154, 75.910028),
                new LatLng(21.856014, 75.929941),
                BIHAR




                )
                        .width(30)
                        .color(Color.BLACK)


        );

        //   mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(CENTER_MP,18));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(WEST_BENG,10));




        CameraPosition positiona = new CameraPosition.Builder()
                .target(AHMEDABAD)
                .zoom(camzoom)
                .bearing(cambear)
                .tilt(mCameraTilt)
                .build();
        CameraPosition positionb = new CameraPosition.Builder()
                .target(HIMACHAL_TOP)
                .zoom(camzoom)
                .bearing(cambear)
                .tilt(mCameraTilt)
                .build();
        CameraPosition positionc = new CameraPosition.Builder()
                .target(HYDER_SOUTH)
                .zoom(camzoom)
                .bearing(cambear)
                .tilt(mCameraTilt)
                .build();
        CameraPosition positiond = new CameraPosition.Builder()
                .target(MIZORAM_EAST)
                .zoom(camzoom)
                .bearing(cambear)
                .tilt(mCameraTilt)
                .build();
        CameraPosition positione = new CameraPosition.Builder()
                .target(MUMBAI)
                .zoom(camzoom)
                .bearing(cambear)
                .tilt(mCameraTilt)
                .build();
        CameraPosition positionf = new CameraPosition.Builder()
                .target(NAG_RAJASTHAN)
                .zoom(camzoom)
                .bearing(cambear)
                .tilt(mCameraTilt)
                .build();
        CameraPosition positiong = new CameraPosition.Builder()
                .target(BIHAR)
                .zoom(camzoom)
                .bearing(cambear)
                .tilt(mCameraTilt)
                .build();
        CameraPosition positionh = new CameraPosition.Builder()
                .target(START_RES)
                .zoom(camzoom)
                .bearing(cambear)
                .tilt(mCameraTilt)
                .build();


        mMap.moveCamera(CameraUpdateFactory.newCameraPosition(positiona));
        mMap.moveCamera(CameraUpdateFactory.newCameraPosition(positionb));
        mMap.moveCamera(CameraUpdateFactory.newCameraPosition(positionc));
        mMap.moveCamera(CameraUpdateFactory.newCameraPosition(positiond));
        mMap.moveCamera(CameraUpdateFactory.newCameraPosition(positione));
        mMap.moveCamera(CameraUpdateFactory.newCameraPosition(positionf));
        mMap.moveCamera(CameraUpdateFactory.newCameraPosition(positiong));
        mMap.moveCamera(CameraUpdateFactory.newCameraPosition(positionh));




        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(START_RES,10));


        // Set a listener for marker click.
        mMap.setOnMarkerClickListener(this);



        //JSON STYLED MAP

       try {
            // Customise the styling of the base map using a JSON object defined
            // in a raw resource file.
            boolean success = googleMap.setMapStyle(
                    MapStyleOptions.loadRawResourceStyle(
                            this, R.raw.trymap));

            if (!success) {
                Log.e(TAG, "Style parsing failed.");
            }
        } catch (Resources.NotFoundException e) {
            Log.e(TAG, "Can't find style. Error: ", e);
        }



    }

    @Override
    public boolean onMarkerClick(final Marker marker) {
        // Retrieve the data from the marker.
        Integer clickCount = (Integer) marker.getTag();

        // Check if a click count was set, then display the click count.
        if (clickCount != null) {
            clickCount = clickCount + 1;
            marker.setTag(clickCount);
            Toast.makeText(this,
                    marker.getTitle() +
                            " has been clicked " + clickCount + " times.",
                    Toast.LENGTH_SHORT).show();
             }
             return false;
    }


*/

 //   }

//}




































/*  mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(AHMEDABAD,10));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(HIMACHAL_TOP,10));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(HYDER_SOUTH,10));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(MIZORAM_EAST,10));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(MUMBAI,10));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(NAG_RAJASTHAN,10));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(BIHAR,10));


        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(START_RES,10));*/































/*  mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(AHMEDABAD,10));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(HIMACHAL_TOP,10));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(HYDER_SOUTH,10));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(MIZORAM_EAST,10));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(MUMBAI,10));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(NAG_RAJASTHAN,10));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(BIHAR,10));


        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(START_RES,10));*/



