package com.example.baitap03_bt1;

import android.app.Activity;
import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.constraintLayout1), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        ConstraintLayout bg =  findViewById(R.id.constraintLayout1);

        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(R.drawable.bg01);
        arrayList.add(R.drawable.bg02);
        arrayList.add(R.drawable.bg03);
        arrayList.add(R.drawable.bg04);
        arrayList.add(R.drawable.bg05);

        Random random = new Random();
        int vitri = random.nextInt(arrayList.size());

        bg.setBackgroundResource(arrayList.get(vitri));

        Switch sw = findViewById(R.id.switchChangeBackground);
        sw.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if(isChecked){
                    bg.setBackgroundResource(R.drawable.bg06);
                    Toast.makeText(MainActivity.this,"Đã thay đổi background",Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}