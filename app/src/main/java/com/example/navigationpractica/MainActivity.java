package com.example.navigationpractica;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.navigationpractica.databinding.ActivityMainBinding;
import com.example.navigationpractica.databinding.FragmentTabbed1Binding;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    private NavController navController3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView((binding = ActivityMainBinding.inflate(getLayoutInflater())).getRoot());

        setSupportActionBar(binding.toolbar);

        //Aquí se crea lo que sería la clase Drawer Activity
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.drawer1Fragment, R.id.drawer2Fragment
        )
                .setOpenableLayout(binding.drawerLayout)
                .build();

        NavController navController = ((NavHostFragment) getSupportFragmentManager().findFragmentById(R.id.nav_host_draw)).getNavController();
        NavigationUI.setupWithNavController(binding.navView, navController);
        NavigationUI.setupWithNavController(binding.toolbar, navController, appBarConfiguration);

        //Aquí se crea lo que sería la clase Bottom Activity
        NavController navController2 = ((NavHostFragment) getSupportFragmentManager().findFragmentById(R.id.nav_host_bottom)).getNavController();
        NavigationUI.setupWithNavController(binding.bottomNavView, navController2);
        NavigationUI.setupWithNavController(binding.toolbar, navController2);

        //Aquí se crea lo que sería la clase Option Activity
        AppBarConfiguration appBarConfiguration2 = new AppBarConfiguration.Builder(
                R.id.options1Fragment, R.id.options2Fragment
        )
                .build();

        navController3 = ((NavHostFragment) getSupportFragmentManager().findFragmentById(R.id.nav_host_options)).getNavController();
        NavigationUI.setupWithNavController(binding.toolbar, navController3, appBarConfiguration2);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.options_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return NavigationUI.onNavDestinationSelected(item, navController3)
                || super.onOptionsItemSelected(item);
    }
}
