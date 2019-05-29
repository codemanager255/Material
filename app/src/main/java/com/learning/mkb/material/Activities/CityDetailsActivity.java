package com.learning.mkb.material.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
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

        Button done = findViewById(R.id.done);

        done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent returnIntent = new Intent();
                returnIntent.putExtra("result","Hi");
                setResult(CityDetailsActivity.RESULT_OK,returnIntent);
                finish();
            }
        });
    }

    @Override
    protected void onStop() {
        super.onStop();


    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
