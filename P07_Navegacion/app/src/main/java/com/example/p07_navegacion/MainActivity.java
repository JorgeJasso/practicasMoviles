package com.example.p07_navegacion;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void activity2(View vista){
        Intent intent=new Intent(this,Activity2.class); //Se le indica a que activity se dirigira
        intent.putExtra("nombre","Jorge"); //Se enviarà esta información al nuevo activity
        startActivity(intent); //Se dirige al activity
    }
}
