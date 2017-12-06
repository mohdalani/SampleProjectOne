package com.example.mohda.sampleprojectone;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.mohda.sampleprojectone.controller.Converter;

public class MainActivity extends AppCompatActivity {

    private Converter controller;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        controller = new Converter();
    }

    public void convert(View view) {
        EditText text = (EditText) findViewById(R.id.user_input);
        Double input = Double.valueOf(text.getText().toString());
        Toast toast = Toast.makeText(this, String.valueOf(controller.fromGtoKG(input)), Toast.LENGTH_LONG);
        toast.show();
    }
}
