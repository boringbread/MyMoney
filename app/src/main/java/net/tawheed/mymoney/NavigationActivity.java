package net.tawheed.mymoney;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentManager;
import android.view.MenuInflater;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

public class NavigationActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        //untuk bagian yang atas (appbar)
        getMenuInflater().inflate(R.menu.navigation, menu);
        MenuInflater mi = getMenuInflater();

        Toolbar toolbar;
//        setSupportActionBar(toolbar);
//        toolbar.inflateMenu(R.menu.navigation);
//        toolbar.inflateMenu(R.menu.activity_navigation_drawer);

        //untuk bagian yang bawah (toolbar)
        toolbar = (Toolbar) findViewById(R.id.top_bar);
        setSupportActionBar(toolbar);
        toolbar.inflateMenu(R.menu.fragment_bar_name);

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

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        Toolbar tb ;
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_stat) {

        } else if (id == R.id.nav_zis) {

        } else if (id == R.id.nav_pemasukan) {
            setTitle("Pemasukan / Pengeluaran");
            pemasukanPengeluaran p = new pemasukanPengeluaran();
            FragmentManager fm = getSupportFragmentManager();
            fm.beginTransaction().replace(R.id.fragment, p).commit();
            tb = (Toolbar) findViewById(R.id.top_bar);
            setSupportActionBar(tb);
            getSupportActionBar().setTitle("Income/Outcome");

        } else if (id == R.id.nav_hutang) {
            setTitle("Hutang / Piutang");
            hutangPiutang hp = new hutangPiutang();
            FragmentManager fm = getSupportFragmentManager();
            fm.beginTransaction().replace(R.id.fragment, hp).commit();
            tb = (Toolbar) findViewById(R.id.top_bar);
            setSupportActionBar(tb);
            getSupportActionBar().setTitle("Loan");
        } else {
            id = R.id.nav_pemasukan;
        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
