package uk.aston.ballout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class SessionView extends AppCompatActivity {

    private TextView listText;
    public String[] sessions;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_session_view);

        listText = findViewById(R.id.listView);

        try {
            if(readFromFile() != null)
            {
                String sessionsText = readFromFile();
                String[] sessionArray = makeArray(sessionsText);
                listText.setText(setFormat(sessionArray));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
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

    private String[] makeArray(String s){
        return s.split("\\r?\\n|\\r");
    }

    private String setFormat(String[] array){
        String format = "";
        for (int i = 1; i < array.length; i++){
            String[] temp = array[i].split(",");
            format += "Name: " + temp [0]
            + "\n"
            + "Date: " + temp[1]
            + "\n"
            + "Time Taken " + temp[2]
                    + "\n"
                    + "\n" ;
        }

        return format;
    }

    public void deleteAll(View view) {
        try {
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(openFileOutput("sessionList.txt",
                    Context.MODE_PRIVATE));
            outputStreamWriter.write("");
            outputStreamWriter.close();

        } catch(FileNotFoundException e)
        {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Intent intent = new Intent(this, Menu.class);
        startActivity(intent);
    }
}