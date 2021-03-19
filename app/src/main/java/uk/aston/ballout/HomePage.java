package uk.aston.ballout;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class HomePage extends AppCompatActivity {

    private static final String LOG_TAG =
            HomePage.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
    }

    public void launchMenuActivity(View view) {
        Intent intent = new Intent(this, Menu.class);
        startActivity(intent);

    }

    private String readFromFile() throws IOException {
        String result = "";
        InputStream inputStream = openFileInput("sessionList.txt");
        if(inputStream != null)
        {
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            String temp = "";
            StringBuilder stringBuilder = new StringBuilder();

            while((temp = bufferedReader.readLine()) != null)
            {
                stringBuilder.append(temp);
                stringBuilder.append("\n");
            }

            inputStream.close();
            result = stringBuilder.toString();
        }
        return result;
    }
}