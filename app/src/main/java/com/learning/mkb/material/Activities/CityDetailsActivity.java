package com.learning.mkb.material.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.learning.mkb.material.R;

import java.sql.BatchUpdateException;

public class CityDetailsActivity extends AppCompatActivity {

    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_city_details);

        Bundle bundle = getIntent().getExtras();
       String city = (String)bundle.get("City");

        textView = findViewById(R.id.cityTextView);

       textView.setText(city);
    }
}
