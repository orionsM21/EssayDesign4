package com.example.essaydesign4;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class splash_screen extends AppCompatActivity {


    private static final int timer =9000;
ImageView imageView;
TextView textView1,textView2;
Animation upperanimation,bottomanimation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_splash_screen);

        imageView = findViewById(R.id.imageView);
        textView1 = findViewById(R.id.textView1);
        textView2 = findViewById(R.id.textView2);

        upperanimation = AnimationUtils.loadAnimation(this,R.anim.upper_animation);
        bottomanimation = AnimationUtils.loadAnimation(this,R.anim.bottom_animation);

        imageView.setAnimation(upperanimation);
        textView1.setAnimation(bottomanimation);
        textView2.setAnimation(bottomanimation);

        new Handler().postDelayed(() -> {
            Intent intent = new Intent(splash_screen.this, MainActivity.class);
            startActivity(intent);
            finish();
        },timer);
    }
}