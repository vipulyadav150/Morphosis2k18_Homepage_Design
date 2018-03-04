package technex.mapup;


import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.widget.Toast;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MapStyleOptions;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;



public class MapsActivity extends FragmentActivity implements OnMapReadyCallback,GoogleMap.OnMarkerClickListener {


    private static final String TAG = MapsActivity.class.getSimpleName();
    private static final LatLng CENTER_MP = new LatLng(23.525258, 79.507292);
    private static final LatLng WEST_BENG = new LatLng(23.000416, 86.055143);
    private static final LatLng AHMEDABAD = new LatLng(23.015353, 72.562736);
    private static final LatLng HIMACHAL_TOP = new LatLng(31.972245, 76.134489);
    private static final LatLng HYDER_SOUTH = new LatLng(16.974366, 76.903532);
    private static final LatLng MIZORAM_EAST = new LatLng(22.757487, 92.504117);
    private static final LatLng MUMBAI = new LatLng(19.078304, 72.883920);
    private static final LatLng NAG_RAJASTHAN = new LatLng(26.933380, 73.212126);
    private static final LatLng BIHAR = new LatLng(25.870638, 86.395719);

    private Marker mCENTER_MP;
    private Marker mWEST_BENG;
    private Marker mAHMEDABAD;
    private Marker mHIMACHAL_TOP;
    private Marker mHYDER_SOUTH;
    private Marker mMIZORAM_EAST;
    private Marker mMUMBAI;
    private Marker mNAG_RAJASTHAN;
    private Marker mBIHAR;

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


        // Add some markers to the map, and add a data object to each marker.
        mCENTER_MP = mMap.addMarker(new MarkerOptions()
                .position(CENTER_MP)
                .title("MORPHOSIS"));
        mCENTER_MP.setTag(0);

        mWEST_BENG = mMap.addMarker(new MarkerOptions()
                .position(WEST_BENG)
                .title("SCHEDULES"));
        mWEST_BENG.setTag(0);

        mAHMEDABAD = mMap.addMarker(new MarkerOptions()
                .position(AHMEDABAD)
                .title("GAMES"));
        mAHMEDABAD.setTag(0);


        mHIMACHAL_TOP = mMap.addMarker(new MarkerOptions()
                .position(HIMACHAL_TOP)
                .title("WORKSHOPS"));
        mHIMACHAL_TOP.setTag(0);

        mHYDER_SOUTH = mMap.addMarker(new MarkerOptions()
                .position(HYDER_SOUTH)
                .title("PRIZES"));
        mHYDER_SOUTH.setTag(0);

        mMIZORAM_EAST = mMap.addMarker(new MarkerOptions()
                .position(MIZORAM_EAST)
                .title("WEB"));
        mMIZORAM_EAST.setTag(0);


        mMUMBAI = mMap.addMarker(new MarkerOptions()
                .position(MUMBAI)
                .title("ABOUT"));
        mMUMBAI.setTag(0);


        mNAG_RAJASTHAN = mMap.addMarker(new MarkerOptions()
                .position(NAG_RAJASTHAN)
                .title("WINNERS"));
        mNAG_RAJASTHAN.setTag(0);


        mBIHAR = mMap.addMarker(new MarkerOptions()
                .position(BIHAR)
                .title("DEVELOPERS"));
        mBIHAR.setTag(0);

        // Set a listener for marker click.
        mMap.setOnMarkerClickListener(this);



        //JSON STYLED MAP

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

