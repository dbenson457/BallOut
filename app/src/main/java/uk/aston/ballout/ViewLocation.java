package uk.aston.ballout;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.text.BreakIterator;
import java.util.Date;

public class ViewLocation extends AppCompatActivity implements OnMapReadyCallback {

    private LatLng $location;
    private String $title;
    private String $description;
    private GoogleMap mMap;
    public Chronometer stopwatch ;
    private long $pausedTime = 0;

    private Button stopButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_location);
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.locationMap);
        mapFragment.getMapAsync(this);

        Intent intent = getIntent();
        $location = intent.getParcelableExtra("locLat");
        $title = intent.getStringExtra("title");
        $description = intent.getStringExtra("desc");

        setTitle($title);
        TextView lTitle = findViewById(R.id.location_title);
        lTitle.setText($title);
        TextView lDesc = findViewById(R.id.location_desc);
        lDesc.setText($description);

        stopwatch = (Chronometer) findViewById(R.id.stopwatch);

        stopButton = findViewById(R.id.session_stop);

        stopButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!stopwatch.getText().toString().equals(""))
                {
                    String timeTaken = stopwatch.getText().toString();
                    writeToFile($title + "," + new Date().toString() + "," +  timeTaken);
                    Toast.makeText(ViewLocation.this, "Saved!", Toast.LENGTH_LONG).show();
                }

            }
        });


    }

    private void writeToFile(String message)
    {
        try {
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(openFileOutput("sessionList.txt",
                    Context.MODE_APPEND));
            outputStreamWriter.write(message);
            outputStreamWriter.write("\n");
            outputStreamWriter.close();

        } catch(FileNotFoundException e)
        {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        // Add a marker At Location and move the camera

        int zoom = 12;
        mMap.moveCamera(CameraUpdateFactory.newLatLng($location));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom($location, zoom));

        Marker marker = mMap.addMarker(new MarkerOptions()
                .snippet($description)
                .position($location)
                .title($title));
    }

    public void toggleTimer (View view){
        Button $toggleBtn=(Button)findViewById(R.id.session_toggle);

        String $text = $toggleBtn.getText().toString();

        Button $StopBtn=(Button)findViewById(R.id.session_stop);
        stopwatch.start();


        if ($text.equals("Start Session") || $text.equals("Resume Session")) {

            $StopBtn.setVisibility(View.VISIBLE);
            $toggleBtn.setText("Pause Session");
            stopwatch.setBase(SystemClock.elapsedRealtime() - $pausedTime);

        }
        else if ($text.equals("Pause Session")) {
            stopwatch.stop();
            $pausedTime = SystemClock.elapsedRealtime() - stopwatch.getBase();
            $toggleBtn.setText("Resume Session");
        }


    }

    public void stopTimer(View v){

    }

    }