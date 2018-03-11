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
import com.google.android.gms.maps.model.Circle;
import com.google.android.gms.maps.model.CircleOptions;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.MapStyleOptions;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolylineOptions;

import static android.view.FrameMetrics.ANIMATION_DURATION;


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


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }



    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;


      //  bitmapmarker = BitmapDescriptorFactory.fromResource(R.drawable.aboutpin);

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




/*      Horizontal Limits


        //lets limit the region.........................................................................

        LatLng one = new LatLng(21.565823, 69.758580);
        LatLng two = new LatLng(24.787048, 94.389926);

        LatLngBounds.Builder builder = new LatLngBounds.Builder();

        //add them to builder
        builder.include(one);
        builder.include(two);


        LatLngBounds bounds = builder.build();

        //get width and height to current display screen
        int width = getResources().getDisplayMetrics().widthPixels;
        int height = getResources().getDisplayMetrics().heightPixels;

        // 20% padding
        int padding = (int) (width * 0.20);

        //set latlong bounds
        mMap.setLatLngBoundsForCameraTarget(bounds);

        //move camera to fill the bound to screen
        mMap.moveCamera(CameraUpdateFactory.newLatLngBounds(bounds, width, height, padding));

        //set zoom to level to current so that you won't be able to zoom out viz. move outside bounds
        mMap.setMinZoomPreference(mMap.getCameraPosition().zoom);









        //.............................................................................................


        */




//Lets try vertical limitations............................................................................
        //.................................................................................................


     // mMap.setMinZoomPreference(4.6f);
       // mMap.setMaxZoomPreference(14.0f);


       //LatLng one = new LatLng(22.364054, 69.456477);
        //LatLng two = new LatLng(25.332917, 94.890349);



        //Setting bounds outside mizoram

       /* !-----------------------------------------------------------------------------------------

        LatLng one = new LatLng(23.942509, 92.211017);
        LatLng two = new LatLng(23.676149, 94.4027894);



        LatLngBounds.Builder builder = new LatLngBounds.Builder();

        //add them to builder
        builder.include(one);
        builder.include(two);


        LatLngBounds bounds = builder.build();

        //get width and height to current display screen
        int width = getResources().getDisplayMetrics().widthPixels;
        int height = getResources().getDisplayMetrics().heightPixels;

        // 20% padding
        int padding = (int) (width * 0.2);

        //set latlong bounds
        mMap.setLatLngBoundsForCameraTarget(bounds);

        //move camera to fill the bound to screen
        mMap.moveCamera(CameraUpdateFactory.newLatLngBounds(bounds, width, height, padding));

        //set zoom to level to current so that you won't be able to zoom out viz. move outside bounds
        mMap.setMinZoomPreference(mMap.getCameraPosition().zoom);

        //.......................................................................................
        //.......................................................................................

!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!*/

       //UNDER ANY PROBLEM UNCOMMENT THE ABOVE CODE






/*
// Create a LatLngBounds that includes the city of Adelaide in Australia.
        LatLngBounds INDIA = new LatLngBounds(
                new LatLng(34.043843, 76.031773), new LatLng(11.551208, 78.877102));
// Constrain the camera target to the Adelaide bounds.
        mMap.setLatLngBoundsForCameraTarget(INDIA);
*/





        // Add some markers to the map, and add a data object to each marker.
   //     mCENTER_MP = mMap.addMarker(new MarkerOptions()
     //           .position(CENTER_MP)
       //         .title("MORPHOSIS") .icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_launcher)));
        //mCENTER_MP.setTag(0);

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
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(WEST_BENG,12));


        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(AHMEDABAD,12));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(HIMACHAL_TOP,12));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(HYDER_SOUTH,12));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(MIZORAM_EAST,12));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(MUMBAI,12));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(NAG_RAJASTHAN,12));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(BIHAR,12));


        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(START_RES,12));


        // Set a listener for marker click.
        mMap.setOnMarkerClickListener(this);



        //JSON STYLED MAP

       try {
            // Customise the styling of the base map using a JSON object defined
            // in a raw resource file.
            boolean success = googleMap.setMapStyle(
                    MapStyleOptions.loadRawResourceStyle(
                            this, R.raw.darkblue));

            if (!success) {
                Log.e(TAG, "Style parsing failed.");
            }
        } catch (Resources.NotFoundException e) {
            Log.e(TAG, "Can't find style. Error: ", e);
        }

      /*!!!!!!!!!!!!!!!!!!!!!!!!!IN CASE PROBLEM !UNCOMMENT ABOVE JSON*/









    /*@Override
    public void onPolygonClick(Polygon polygon) {

    }*/



 /*   @Override
    public void onPolylineClick(Polyline polyline) {

    }*/




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

//This code is used to create a POLYGON SHAPED AREA SELECTION!

/*public class MapsActivity extends FragmentActivity implements OnMapReadyCallback,GoogleMap.OnPolylineClickListener,
        GoogleMap.OnPolygonClickListener {


    private static final int COLOR_BLACK_ARGB = 0xff000000;
    private static final int POLYLINE_STROKE_WIDTH_PX = 12;
    private GoogleMap mMap;
    private static final String TAG = MapsActivity.class.getSimpleName();





}*/


    //Methods



   /* @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    private void stylePolyline(Polyline polyline) {
        String type = "";
        // Get the data object stored with the polyline.
        if (polyline.getTag() != null) {
            type = polyline.getTag().toString();
        }

        switch (type) {
            // If no type is given, allow the API to use the default.
            case "A":
                // Use a custom bitmap as the cap at the start of the line.
                polyline.setStartCap(
                        new CustomCap(
                                BitmapDescriptorFactory.fromResource(R.drawable.ic_arrow_drop_down_black_24dp), 10));
                break;
            case "B":
                // Use a round cap at the start of the line.
                polyline.setStartCap(new RoundCap());
                break;
        }

        polyline.setEndCap(new RoundCap());
        polyline.setWidth(POLYLINE_STROKE_WIDTH_PX);
        polyline.setColor(COLOR_BLACK_ARGB);
        polyline.setJointType(JointType.ROUND);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {

        // Add polylines and polygons to the map. This section shows just
        // a single polyline. Read the rest of the tutorial to learn more.
        Polyline polyline1 = googleMap.addPolyline(new PolylineOptions()
                .clickable(true)
                .add(
                        new LatLng(-35.016, 143.321),
                        new LatLng(-34.747, 145.592),
                        new LatLng(-34.364, 147.891),
                        new LatLng(-33.501, 150.217),
                        new LatLng(-32.306, 149.248),
                        new LatLng(-32.491, 147.309)));

        // Position the map's camera near Alice Springs in the center of Australia,
        // and set the zoom factor so most of Australia shows on the screen.
        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(-23.684, 133.903), 4));

        // Set listeners for click events.
        googleMap.setOnPolylineClickListener(this);
        googleMap.setOnPolygonClickListener(this);
    }

    private static final PatternItem DOT = new Dot();
    private static final float PATTERN_GAP_LENGTH_PX = 20;

    private static final PatternItem GAP = new Gap(PATTERN_GAP_LENGTH_PX);
    //
// Create a stroke pattern of a gap followed by a dot.
    private static final List<PatternItem> PATTERN_POLYLINE_DOTTED = Arrays.asList(GAP, DOT);

    @Override
    public void onPolylineClick(Polyline polyline) {
        // Flip from solid stroke to dotted stroke pattern.
        if ((polyline.getPattern() == null) || (!polyline.getPattern().contains(DOT))) {
            polyline.setPattern(PATTERN_POLYLINE_DOTTED);
        } else {
            // The default pattern is a solid stroke.
            polyline.setPattern(null);
        }

        Toast.makeText(this, "Route type " + polyline.getTag().toString(),
                Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onPolygonClick(Polygon polygon) {

    }
}




*/

  //PRESERVED
        /*   LatLng events = new LatLng(19.084145, 72.864008);
        mMap.addMarker(new MarkerOptions().position(events).title("EVENTS!"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(events));

        try {
            // Customise the styling of the base map using a JSON object defined
            // in a raw resource file.
            boolean success = googleMap.setMapStyle(
                    MapStyleOptions.loadRawResourceStyle(
                            this, R.raw.vip));

            if (!success) {
                Log.e(TAG, "Style parsing failed.");
            }
        } catch (Resources.NotFoundException e) {
            Log.e(TAG, "Can't find style. Error: ", e);
        }
    }
*/

