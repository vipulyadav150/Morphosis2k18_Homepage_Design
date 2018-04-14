package technex.mapup;


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


public class MapsActivity extends FragmentActivity implements OnMapReadyCallback,GoogleMap.OnMarkerClickListener {


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

    private static final LatLng START_RES= new LatLng(19.537065, 75.769825);

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

    private Marker mSTART_RES;

    private GoogleMap mMap;
    float mCameraTilt = (float)67.5;

    int camzoom = 21;
    int cambear = 10;
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


      /*  TileProvider tileProvider = new UrlTileProvider(256, 256) {
            @Override
            public URL getTileUrl(int x, int y, int zoom) {

    /* Define the URL pattern for the tile images */
         /*       String s = String.format("https://maps.googleapis.com/maps/api/staticmap?sensor=false&size=640x640&visual_refresh=true&scale=2&center=28.208608,65.643776&zoom=3&maptype=satellite", zoom, x, y);

                if (!checkTileExists(x, y, zoom)) {
                    return null;
                }

                try {
                    return new URL(s);
                } catch (MalformedURLException e) {
                    throw new AssertionError(e);
                }
            }


             * Check that the tile server supports the requested x, y and zoom.
             * Complete this stub according to the tile range you support.
             * If you support a limited range of tiles at different zoom levels, then you
             * need to define the supported x, y range at each zoom level.

            private boolean checkTileExists(int x, int y, int zoom) {
                int minZoom = 10;
                int maxZoom = 21;

                if ((zoom < minZoom || zoom > maxZoom)) {
                    return false;
                }

                return true;
            }
        };

        TileOverlay tileOverlay = mMap.addTileOverlay(new TileOverlayOptions()
                .tileProvider(tileProvider));


        */




        // CameraPosition cameraPosition = new CameraPosition.Builder().zoom(10).tilt(45).build();
       // mMap.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));


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


      /*  mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(AHMEDABAD,10));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(HIMACHAL_TOP,10));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(HYDER_SOUTH,10));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(MIZORAM_EAST,10));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(MUMBAI,10));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(NAG_RAJASTHAN,10));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(BIHAR,10));


        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(START_RES,10));*/

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




}


