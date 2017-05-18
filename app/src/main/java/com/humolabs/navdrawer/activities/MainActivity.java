package com.humolabs.navdrawer.activities;

import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.humolabs.navdrawer.R;
import com.humolabs.navdrawer.fragments.ContactenosFragment;
import com.humolabs.navdrawer.fragments.PrimariasFragment;
import com.humolabs.navdrawer.fragments.SecundariasFragment;
import com.humolabs.navdrawer.fragments.TecnicasFragment;

public class MainActivity extends AppCompatActivity {

    private DrawerLayout mDrawerLayout;
    private NavigationView mNavView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setToolbar();

        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mNavView = (NavigationView) findViewById(R.id.nav_view);

        setFragmentByDefault();

        mNavView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                boolean mFragmentTransaction = false;
                Fragment mFragment = null;

                switch (item.getItemId()){
                    case R.id.menu_primarias:
                        mFragment = new PrimariasFragment();
                        mFragmentTransaction = true;
                        break;
                    case R.id.menu_secundarias:
                        mFragment = new SecundariasFragment();
                        mFragmentTransaction = true;
                        break;
                    case R.id.menu_tecnicas:
                        mFragment = new TecnicasFragment();
                        mFragmentTransaction = true;
                        break;
                    case R.id.menu_contacto:
                        mFragment = new ContactenosFragment();
                        mFragmentTransaction = true;
                        break;
                }

                if (mFragmentTransaction){
                    changeFragment(mFragment, item);
                    mDrawerLayout.closeDrawers();
                }

                return true;
            }
        });
    }

    private void setToolbar(){
        Toolbar mToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_home);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("tomoCargo");
    }

    private void changeFragment(Fragment fragment, MenuItem item){
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.content_frame, fragment)
                .commit();
        item.setChecked(true);
        getSupportActionBar().setTitle(item.getTitle());
    }

    private void setFragmentByDefault(){
        changeFragment(new PrimariasFragment(), mNavView.getMenu().getItem(0));
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                mDrawerLayout.openDrawer(GravityCompat.START);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
