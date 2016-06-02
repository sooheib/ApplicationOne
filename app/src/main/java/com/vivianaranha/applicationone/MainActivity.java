package com.vivianaranha.applicationone;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    EditText messgaeBox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        messgaeBox = (EditText) findViewById(R.id.editText);
    }

    public void saveFile(View v) {
        File file = null;
        String text = messgaeBox.getText().toString();
        FileOutputStream fileOutputStream = null;

        try {
            file = getFilesDir();
            fileOutputStream = openFileOutput("myFile.txt", Context.MODE_PRIVATE);
            fileOutputStream.write(text.getBytes());
            Toast.makeText(this, "File saved at " + file, Toast.LENGTH_LONG).show();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
