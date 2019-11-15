package com.project.cat;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    private Tab1Fragment tab1Fragment;
    private Tab2Fragment tab2Fragment;
    private ImageView tab1;
    private ImageView tab2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

         tab1 =findViewById(R.id.tab1);
         tab2 =findViewById(R.id.tab2);


        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        if(tab1Fragment== null){
            tab1Fragment= new Tab1Fragment();
            transaction.add(R.id.framlayout, tab1Fragment);
        }
        if(tab2Fragment== null){
            tab2Fragment= new Tab2Fragment();
            transaction.add(R.id.framlayout, tab2Fragment);
        }
        hideFragment(transaction);
        transaction.show(tab1Fragment);
        transaction.commit();
        tab1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tab1.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
                tab2.setBackgroundColor(getResources().getColor(R.color.aaaaaa));
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                hideFragment(transaction);
                transaction.show(tab1Fragment).commit();
            }
        });
        tab2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tab1.setBackgroundColor(getResources().getColor(R.color.aaaaaa));
                tab2.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                hideFragment(transaction);
                transaction.show(tab2Fragment).commit();
            }
        });
    }

    private void hideFragment(FragmentTransaction transaction) {
        transaction.hide(tab1Fragment);
        transaction.hide(tab2Fragment);
    }
}
