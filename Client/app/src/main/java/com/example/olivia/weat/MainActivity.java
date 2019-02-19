package com.example.olivia.weat;

import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity implements SelectRestaurantFragment.OnFragmentInteractionListener {


    boolean blnButtonRotation = true;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                    Fragment selectedFragment = null;

                    switch (menuItem.getItemId()){
                        case R.id.navigation_selectrestaurant:
                            selectedFragment = new SelectRestaurantFragment();
                            break;
                        case R.id.navigation_cookyourself:
                            selectedFragment = new SelectIngredientFragment();
                            break;
                        case R.id.navigation_blog:
                            selectedFragment = new LoginFragment();
                            break;
                    }

                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, selectedFragment).addToBackStack(null).commit();

                    return true;
                }
            };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new SelectRestaurantFragment()).addToBackStack(null).commit();

        PaintView paintView = new PaintView(this);
    }


    @Override
    public void onFragmentInteraction(Uri uri) {
        Toast.makeText(this,uri.toString(),Toast.LENGTH_LONG).show();
//        passvaluetocv(uri);
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction transaction = fm.beginTransaction();
        RouletteFragment bf2 = new RouletteFragment();
        transaction.replace(R.id.fragment_container, bf2);
        transaction.addToBackStack(null);
        transaction.commit();
    }
//    public void passvaluetocv(Uri uri){
//        PaintView paintView = findViewById(R.id.PaintView);
//        paintView.setString(uri.toString());
//    }


}
