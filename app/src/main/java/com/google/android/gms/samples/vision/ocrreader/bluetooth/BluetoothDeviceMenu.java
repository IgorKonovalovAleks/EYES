package com.google.android.gms.samples.vision.ocrreader.bluetooth;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.google.android.gms.samples.vision.ocrreader.R;

import java.util.ArrayList;

import static android.R.layout.simple_list_item_1;

public class BluetoothDeviceMenu extends AppCompatActivity {


    ArrayList<String> pairedDeviceArrayList;

    ListView listViewPairedDevice;

    ArrayAdapter pairedDeviceAdapter;

    TextView label, tseNeConstanta;
    Button start;
    ImageView image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bluetooth_device_menu);
        listViewPairedDevice = findViewById(R.id.pairedlist);
        start = findViewById(R.id.button);
        image = findViewById(R.id.imageView9);
        label = findViewById(R.id.textInfo);
        label.setText("Выберите устройство:");
        pairedDeviceArrayList = getIntent().getStringArrayListExtra("DEVICES");
        pairedDeviceAdapter = new ArrayAdapter<>(this, simple_list_item_1, pairedDeviceArrayList);
        listViewPairedDevice.setAdapter(pairedDeviceAdapter);
        listViewPairedDevice.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent i = new Intent();
                i.putExtra("RESULT", pairedDeviceArrayList.get(position));
                Log.d("DEBUG", pairedDeviceArrayList.get(position));

                setResult(RESULT_OK, i);
                finish();
            }
        });
        label.setVisibility(View.GONE);
        listViewPairedDevice.setVisibility(View.GONE);
        start.getBackground().setAlpha(0);
        image.setVisibility(View.VISIBLE);

        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                label.setVisibility(View.VISIBLE);
                start.setVisibility(View.GONE);
                image.setVisibility(View.GONE);
                listViewPairedDevice.setVisibility(View.VISIBLE);
            }
        });



    }
}
