package com.amplifier.amplifierelectronics;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;


import com.amplifier.amplifierelectronics.databinding.ActivityMainBinding;
import com.iammert.library.readablebottombar.ReadableBottomBar;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.content , new Home_Fragment());
        transaction.commit();


        binding.readableBottomBar.setOnItemSelectListener(new ReadableBottomBar.ItemSelectListener() {
            @Override
            public void onItemSelected(int i) {
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

                switch (i) {
                    case 0:
                        transaction.replace(R.id.content, new Home_Fragment());

                        break;

                    case 1:
                        transaction.replace(R.id.content, new About_Fragment());
                        break;

                    case 2:
                        transaction.replace(R.id.content, new Portfolio_Fragment());
                        break;

                    case 3:
                        transaction.replace(R.id.content, new Service_Fragment());
                        break;

                }
                transaction.commit();
            }
        });
    }
}