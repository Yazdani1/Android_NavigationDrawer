package androidsqlite.com.navigationdrwaerbyyaz;


import android.app.FragmentManager;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;


public class MainActivity extends AppCompatActivity

        implements NavigationView.OnNavigationItemSelectedListener {




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drwer = (DrawerLayout) findViewById(R.id.drawer_layout_id);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drwer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close
        );

        drwer.addDrawerListener(toggle);
        toggle.syncState();


        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        displaySelectedScreen(R.id.nav_menu1);
    }

    @Override
    public void onBackPressed() {

        DrawerLayout drwer = (DrawerLayout) findViewById(R.id.drawer_layout_id);

        if (drwer.isDrawerOpen(GravityCompat.START)) {
            drwer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }

    }


    private void displaySelectedScreen(int itemId) {

        //creating fragment object
        Fragment fragment = null;

        //initializing the fragment object which is selected
        switch (itemId) {
            case R.id.nav_menu1:
                fragment=new OneFragment();
                break;
            case R.id.nav_menu2:
                fragment=new TwoFragment();
                break;
            case R.id.nav_menu3:
                fragment=new ThreeFragment();
                break;
            case R.id.nav_menu4:
                fragment = new FourFragment();
                break;
        }

        //replacing the fragment
        if (fragment != null) {
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.frame_content, fragment);
            ft.commit();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout_id);
        drawer.closeDrawer(GravityCompat.START);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        displaySelectedScreen(item.getItemId());

        return true;
    }


}
