package com.example.essaydesign4;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {
DrawerLayout drawerLayout;
NavigationView navigationView;
Toolbar toolbar;
BottomNavigationView bnView;
FloatingActionButton fab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        drawerLayout = findViewById(R.id.drawerLayout);
        navigationView = findViewById(R.id.navigationView);
        toolbar = findViewById(R.id.toolbar);
        bnView = findViewById(R.id.bnView);
        fab = findViewById(R.id.fab);

        //Setting Toolbar
        setSupportActionBar(toolbar);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.OpenDrawer, R.string.CloseDrawer);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Camera", Toast.LENGTH_SHORT).show();
                loadFragment(new CameraFragment(),false);
            }
        });

        //Applying click behaviour on navigation view
        navigationView.setNavigationItemSelectedListener(item -> {
            int id = item.getItemId();

            if (id == R.id.optHome) {
                Toast.makeText(MainActivity.this, "Home", Toast.LENGTH_SHORT).show();
                loadFragment(new AFragment(), false);
            } else if (id == R.id.optideas) {
                Toast.makeText(MainActivity.this, "ideas", Toast.LENGTH_SHORT).show();
                loadFragment(new BFragment(), false);
            } else if (id == R.id.optCategory) {
                Toast.makeText(MainActivity.this, "category", Toast.LENGTH_SHORT).show();
                loadFragment(new CFragment(), false);
            } else if (id == R.id.optMylibrary) {
                Toast.makeText(MainActivity.this, "MyLibrary", Toast.LENGTH_SHORT).show();
                loadFragment(new DFragment(), false);
            } else if (id==R.id.optAbout) {
                Toast.makeText(MainActivity.this, "About", Toast.LENGTH_SHORT).show();
                loadFragment(new EFragment(), false);
            } else{
                    Toast.makeText(MainActivity.this, "Manual", Toast.LENGTH_SHORT).show();
                    loadFragment(new F(), false);
                }


            //For automatic closing the drawer
            drawerLayout.closeDrawer(GravityCompat.START);

            return true;
        });


        bnView.setOnNavigationItemSelectedListener(item -> {
           int id =item.getItemId();
           if(id==R.id.optHome){
               Toast.makeText(MainActivity.this,"Home", Toast.LENGTH_SHORT).show();
               loadFragment(new AFragment(),false);
           }else if(id==R.id.optideas){
               Toast.makeText(MainActivity.this,"ideas", Toast.LENGTH_SHORT).show();
               loadFragment(new BFragment(),false);
            }else if(id==R.id.optCategory){
               Toast.makeText(MainActivity.this,"category", Toast.LENGTH_SHORT).show();
               loadFragment(new CFragment(),false);
           }
           else {
                Toast.makeText(MainActivity.this,"My Library", Toast.LENGTH_SHORT).show();
                loadFragment(new DFragment(),false);
            }

            return true;
        });
        bnView.setSelectedItemId(R.id.optHome);

    }

    //on backPress closing the drawer
    @Override
    public void onBackPressed() {
        if(drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START);
        }else{
            super.onBackPressed();
        }
    }
    private void loadFragment(Fragment fragment,boolean flag) {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        if(flag)
             ft.add(R.id.container,fragment);
        else
            ft.replace(R.id.container,fragment);
        ft.commit();
    }


    }
