package com.ttp.androidcore.lifecycle;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.ttp.androidcore.MainActivity;
import com.ttp.androidcore.R;

public class LifeCycleActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_life_cycle);

        getLifecycle().addObserver(new MyObserver(getLifecycle()));
    }

    public void lifeCycle(View view) {
        Intent intent = new Intent(LifeCycleActivity.this, MainActivity.class);
        startActivity(intent);
    }
}
