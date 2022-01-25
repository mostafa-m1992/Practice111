package com.shia.practice111;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.shia.practice111.fragments1.FragmentFive;
import com.shia.practice111.fragments1.FragmentFour;
import com.shia.practice111.fragments1.FragmentOne;
import com.shia.practice111.fragments1.FragmentThree;
import com.shia.practice111.fragments1.FragmentTwo;

public class MainActivity extends AppCompatActivity {

    Toolbar toolbar;
    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.setTitle("Page One");

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        toolbar.setSubtitle("this is a practice for Grid and Table Layouts");
        toolbar.setLogo(R.drawable.ic_baseline_10k_24);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        bottomNavigationView = findViewById(R.id.bottomNavigation);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                int myId = item.getItemId();

                switch (myId) {
                    case R.id.item1:
                        FragmentOne one = new FragmentOne();
                        FragmentManager manager = getSupportFragmentManager();
                        FragmentTransaction transaction = manager.beginTransaction();
                        transaction.replace(R.id.frameLayout, one);
                        transaction.commit();
                        break;
                    case R.id.item2:
                        FragmentTwo two = new FragmentTwo();
                        FragmentManager manager1 = getSupportFragmentManager();
                        FragmentTransaction transaction1 = manager1.beginTransaction();
                        transaction1.replace(R.id.frameLayout, two);
                        transaction1.commit();
                        break;
                    case R.id.item3:
                        FragmentThree three = new FragmentThree();
                        FragmentManager manager2 = getSupportFragmentManager();
                        FragmentTransaction transaction2 = manager2.beginTransaction();
                        transaction2.replace(R.id.frameLayout, three);
                        transaction2.commit();
                        break;
                    case R.id.item4:
                        FragmentFour four = new FragmentFour();
                        FragmentManager manager3 = getSupportFragmentManager();
                        FragmentTransaction transaction3 = manager3.beginTransaction();
                        transaction3.replace(R.id.frameLayout, four);
                        transaction3.commit();
                        break;
                    case R.id.item5:
                        FragmentFive five = new FragmentFive();
                        FragmentManager manager4 = getSupportFragmentManager();
                        FragmentTransaction transaction4 = manager4.beginTransaction();
                        transaction4.replace(R.id.frameLayout, five);
                        transaction4.commit();
                        break;
                }

                return true;
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.option_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            onBackPressed();
        } else if (item.getItemId() == R.id.page2) {
            startActivity(new Intent(MainActivity.this, MainActivity2.class));
        }

        return super.onOptionsItemSelected(item);
    }
}