package com.learning.mkb.material.Activities;

import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabItem;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.learning.mkb.material.Adapters.HomeTabPageAdapter;
import com.learning.mkb.material.Model.MovieResponce;
import com.learning.mkb.material.Network.APIClient;
import com.learning.mkb.material.Network.APIInterface;
import com.learning.mkb.material.View.Chat;
import com.learning.mkb.material.R;
import com.learning.mkb.material.View.SettingFragment;
import com.learning.mkb.material.View.StatusFragment;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements Chat.OnFragmentInteractionListener, StatusFragment.OnFragmentInteractionListener,SettingFragment.OnFragmentInteractionListener {


    private static final String API_KEY = "55fa25ae93e0d012adafaa39fc905e31";
    Toolbar toolbar;
    TabLayout homePageTabLaout;
    ViewPager homePageViewPager;
    TabItem   chatTabItem;
    TabItem   statusTabItem;
    TabItem   settingTabItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
         toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                toolbar.setTitle("Home1");
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        homePageTabLaout = (TabLayout) findViewById(R.id.homeTab);
        homePageViewPager = (ViewPager) findViewById(R.id.homeTabViewPager);
        chatTabItem = (TabItem) findViewById(R.id.chatTabItem);
        statusTabItem = (TabItem) findViewById(R.id.statusTabItem);
        settingTabItem = (TabItem) findViewById(R.id.settingTabItem);


        HomeTabPageAdapter adapter = new HomeTabPageAdapter(getSupportFragmentManager(),homePageTabLaout.getTabCount());
        homePageViewPager.setAdapter(adapter);


        homePageViewPager.setOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(homePageTabLaout));

        homePageTabLaout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                homePageViewPager.setCurrentItem(tab.getPosition());

                switch (tab.getPosition()) {
                    case 0 :
                        tab.setIcon(R.drawable.ic_chat);
                        break;
                    case 1 :
                        tab.setIcon(R.drawable.ic_status);
                        break;

                    case 2 :
                        tab.setIcon(R.drawable.ic_settings_black_24dp);
                        break;


                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                switch (tab.getPosition()) {
                    case 0 :
                        tab.setIcon(R.drawable.ic_chat_not_selected);
                        break;

                    case 1 :
                        tab.setIcon(R.drawable.ic_star_not_selected);
                        break;

                    case 2 :
                        tab.setIcon(R.drawable.ic_settings_not_selected);
                        break;


                }

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });


        APIInterface apiService = APIClient.getClient().create(APIInterface.class);

        Call<MovieResponce> call = apiService.getTopRatedMovies(API_KEY);

        call.enqueue(new Callback<MovieResponce>() {
            @Override
            public void onResponse(Call<MovieResponce> call, Response<MovieResponce> response) {

                Log.d("Result",response.body().getMovies().toString());

                Toast.makeText(getApplicationContext(),response.body().toString(),Toast.LENGTH_LONG).show();
            }

            @Override
            public void onFailure(Call<MovieResponce> call, Throwable t) {

                Log.d("Result",t.toString());

            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();

        toolbar.setTitle("Home");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }

    public  void area(int side) {

    }

    public  void area(String length ) {

    }

}


