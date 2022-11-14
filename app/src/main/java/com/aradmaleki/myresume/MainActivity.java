package com.aradmaleki.myresume;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.switchmaterial.SwitchMaterial;

import de.hdodenhof.circleimageview.CircleImageView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SwitchMaterial switchMaterial = findViewById(R.id.switch_button);
        TextView textView = findViewById(R.id.switch_button_text);
        CircleImageView circleImageView = findViewById(R.id.profile_image);

        switchMaterial.setOnCheckedChangeListener((compoundButton, isChecked) -> {
            if (isChecked) {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
                textView.setText(getString(R.string.dark_mode));
                circleImageView.setBorderColor(Color.WHITE);
            } else {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
                textView.setText(getString(R.string.light_mode));
                circleImageView.setBorderColor(Color.BLACK);
            }
        });
    }

    public void callMe(View view) {
        String phoneNumber = "tel:" + getString(R.string.phone_number);
        Intent intent = new Intent(Intent.ACTION_DIAL);
        intent.setData(Uri.parse(phoneNumber));
        startActivity(intent);
    }

}