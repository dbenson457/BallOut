package uk.aston.ballout;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends AppCompatActivity implements OnMapReadyCallback, GoogleMap.OnInfoWindowClickListener {

    private static final int REQUEST_LOCATION_PERMISSION = '6';
    private GoogleMap mMap;

    private final LatLng ASP = new LatLng(52.49294566788942, -1.9346396232146283);
    private final LatLng BRP = new LatLng(52.49878482265995, -1.931534825725685);
    private final LatLng BSP = new LatLng(52.50234394537593, -1.9477637553102993);
    private final LatLng BuSP = new LatLng(52.499732532321396, -1.9095909118349061);
    private final LatLng CVCP = new LatLng(52.519750718186316, -1.789307114656127);
    private final LatLng CG = new LatLng(52.4752332162509, -1.9277238946061277);
    private final LatLng CHRP = new LatLng(52.50817581249928, -1.9090306150015404);
    private final LatLng CP = new LatLng(52.420991874830946, -1.9276329215207262);
    private final LatLng DSP = new LatLng(52.47811883801278, -1.8562303996361857);
    private final LatLng FP = new LatLng(52.46474174775808, -1.8718581700503871);
    private final LatLng GP = new LatLng(52.499536375762396, -1.9137615121273694);
    private final LatLng GiP = new LatLng(52.46527628525982, -1.802822677280337);
    private final LatLng HBP = new LatLng(52.473055587062746, -1.852306405049815);
    private final LatLng LHP = new LatLng(52.42168644793194, -1.9797671270593806);
    private final LatLng LP = new LatLng(52.49432363086415, -1.7612687704811796);
    private final LatLng NCP = new LatLng(52.49029823204169, -1.7707811780319298);
    private final LatLng ORG = new LatLng(52.46632491878677, -1.818223963680507);
    private final LatLng PRP = new LatLng(52.45127174872902, -1.8575124169783173);
    private final LatLng PHP = new LatLng(52.52325032055217, -1.913480559641286);
    private final LatLng SP = new LatLng(52.43668537705867, -1.9862228705844631);
    private final LatLng SFP = new LatLng(52.43600271719133, -1.9582797117262132);
    private final LatLng SHP = new LatLng(52.46639256123608, -1.853664415339958);
    private final LatLng TCP = new LatLng(52.478687288181476, -1.7628058408307914);

    private Marker markerASP;
    private Marker markerBRP;
    private Marker markerBSP;
    private Marker markerBuSP;
    private Marker markerCVCP;
    private Marker markerCG;
    private Marker markerCHRP;
    private Marker markerCP;
    private Marker markerDSP;
    private Marker markerFP;
    private Marker markerGP;
    private Marker markerGiP;
    private Marker markerHBP;
    private Marker markerLHP;
    private Marker markerLP;
    private Marker markerNCP;
    private Marker markerORG;
    private Marker markerPRP;
    private Marker markerPHP;
    private Marker markerSP;
    private Marker markerSFP;
    private Marker markerSHP;
    private Marker markerTCP;



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
        googleMap.setOnInfoWindowClickListener(this);


        // Add a marker At Location and move the camera
        enableMyLocation();
        LatLng birmingham = new LatLng(52.48626032533539, -1.8903967830899198);
        int zoom = 12;
        mMap.moveCamera(CameraUpdateFactory.newLatLng(birmingham));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(birmingham, zoom));

        markerASP = mMap.addMarker(new MarkerOptions()
                .snippet("Central Park Drive, Soho, Birmingham")
                .position(ASP)
                .title("All Saints Park"));

        markerBRP = mMap.addMarker(new MarkerOptions()
                .snippet("Bacchus Road, Soho, Birmingham")
                .position(BRP)
                .title("Bacchus Road Public Open Space"));

        markerBSP = mMap.addMarker(new MarkerOptions()
                .snippet("149 to 159 Booth Street, Birmingham, B21 0PU")
                .position(BSP)
                .title("Booth Street Public Open Space"));

        markerBuSP = mMap.addMarker(new MarkerOptions()
                .snippet("Anglesey Street, Birmingham, B19 1RA")
                .position(BuSP)
                .title("Burbury Street Public Open Space"));

        markerCVCP = mMap.addMarker(new MarkerOptions()
                .snippet("Tangmere Drive, Castle Vale, Birmingham, B35 6QS")
                .position(CVCP)
                .title("Castle Vale Centre Park"));

        markerCG = mMap.addMarker(new MarkerOptions()
                .snippet("Monument Road, Birmingham, B16 8JL")
                .position(CG)
                .title("Chamberlain Gardens"));

        markerCHRP = mMap.addMarker(new MarkerOptions()
                .snippet("Church Hill Road, Birmingham, B20 3PG")
                .position(CHRP)
                .title("Church Hill Road Play Area"));

        markerCP = mMap.addMarker(new MarkerOptions()
                .snippet("Cotteridge Park, off Franklin Road, Birmingham, B30 2HE")
                .position(CP)
                .title("Cotteridge Park"));

        markerDSP = mMap.addMarker(new MarkerOptions()
                .snippet("Denbigh Street, Birmingham, B9 4UQ")
                .position(DSP)
                .title("Denbigh Street Public Open Space"));

        markerFP = mMap.addMarker(new MarkerOptions()
                .snippet("Dearman Road, Birmingham, B11 1HH")
                .position(FP)
                .title("Farm Park"));

        markerGP = mMap.addMarker(new MarkerOptions()
                .snippet("Wills Street, Birmingham, B19 1PP")
                .position(GP)
                .title("Georges Park"));

        markerGiP = mMap.addMarker(new MarkerOptions()
                .snippet("Moat Lane, Birmingham, B26 1PL")
                .position(GiP)
                .title("Gilbertstone Park"));

        markerHBP = mMap.addMarker(new MarkerOptions()
                .snippet("Grange Road, Bordesley Green, Birmingham")
                .position(HBP)
                .title("Henry Barber Park"));

        markerLHP = mMap.addMarker(new MarkerOptions()
                .snippet("Ley Hill Recreation Ground, Holloway, Birmingham, B31 1TT")
                .position(LHP)
                .title("Ley Hill Park"));

        markerLP = mMap.addMarker(new MarkerOptions()
                .snippet("Longmeadow Crescent, Birmingham, B34 7NN")
                .position(LP)
                .title("Longmeadow Park"));

        markerNCP = mMap.addMarker(new MarkerOptions()
                .snippet("Packington Avenue, Birmingham, B34 7RB")
                .position(NCP)
                .title("Norman Chamberlain Playing Field"));

        markerORG = mMap.addMarker(new MarkerOptions()
                .snippet("Hob Moor Road, Birmingham, B25 8UB")
                .position(ORG)
                .title("Oaklands Recreation Ground"));

        markerPRP = mMap.addMarker(new MarkerOptions()
                .snippet("Percy Road, Birmingham, B11 3JS")
                .position(PRP)
                .title("Percy Road Park"));

        markerPHP = mMap.addMarker(new MarkerOptions()
                .snippet("Perry Ave, Perry Barr, Birmingham B42 1RS")
                .position(PHP)
                .title("Perry Hall Park"));

        markerSP = mMap.addMarker(new MarkerOptions()
                .snippet("Senneleys Park Road, Birmingham, B31")
                .position(SP)
                .title("Senneleys Park"));

        markerSFP = mMap.addMarker(new MarkerOptions()
                .snippet("Shenley Fields Road, Birmingham, B29 5AL")
                .position(SFP)
                .title("Shenley Fields Playing Fields"));

        markerSHP = mMap.addMarker(new MarkerOptions()
                .snippet("Small Heath, Yardley, Birmingham, B10 0PL")
                .position(SHP)
                .title("Small Heath Park"));

        markerTCP = mMap.addMarker(new MarkerOptions()
                .snippet("Tile Cross Rd, Birmingham, B33 0LS")
                .position(TCP)
                .title("Tile Cross Park"));

    }

    public void enableMyLocation(){
        if (ContextCompat.checkSelfPermission(this,
                Manifest.permission.ACCESS_FINE_LOCATION)
                == PackageManager.PERMISSION_GRANTED) {
            mMap.setMyLocationEnabled(true);
        } else {
            ActivityCompat.requestPermissions(this, new String[]
                            {Manifest.permission.ACCESS_FINE_LOCATION},
                    REQUEST_LOCATION_PERMISSION);
        }
    }

    @Override
    public void onInfoWindowClick(Marker marker) {
        Toast.makeText(this, "Info window clicked",
                Toast.LENGTH_SHORT).show();
    }

}