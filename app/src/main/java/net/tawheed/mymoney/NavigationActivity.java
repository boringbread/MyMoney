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
import android.view.WindowManager;

public class NavigationActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
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

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.inflateMenu(R.menu.navigation);

        toolbar = findViewById(R.id.top_bar);
//        setSupportActionBar(toolbar);
        toolbar.inflateMenu(R.menu.fragment_bar_name);

        toolbar = findViewById(R.id.mm_choose_bar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("");
        toolbar.inflateMenu(R.menu.month_bar);

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        onNavigationItemSelected(navigationView.getMenu().getItem(0).getSubMenu().getItem(0));
        navigationView.setCheckedItem(R.id.nav_pemasukan);
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

        Toolbar tb;
//        tb = findViewById(R.id.top_bar);
//        setSupportActionBar(tb);
//        tb.inflateMenu(R.menu.fragment_bar_name);

        tb = findViewById(R.id.mm_choose_bar);
        setSupportActionBar(tb);
        getSupportActionBar().setTitle("");
        tb.inflateMenu(R.menu.month_bar);
//        setSupportActionBar(toolbar);
//        toolbar.inflateMenu(R.menu.navigation);
//        toolbar.inflateMenu(R.menu.activity_navigation_drawer);

        //untuk bagian yang bawah (toolbar)
//        toolbar = (Toolbar) findViewById(R.id.top_bar);
//        setSupportActionBar(toolbar);
//        toolbar.inflateMenu(R.menu.fragment_bar_name);

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
        Toolbar tb;
        tb = (Toolbar) findViewById(R.id.top_bar);
        setSupportActionBar(tb);
        FloatingActionButton fab = findViewById(R.id.fab);
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_stat) {
            getSupportActionBar().setTitle("Statistik");
            tb.getMenu().setGroupVisible(R.id.grup1, false);
            tb = findViewById(R.id.mm_choose_bar);
            setSupportActionBar(tb);
            Statistik s = new Statistik();
            FragmentManager fm = getSupportFragmentManager();
            fm.beginTransaction().replace(R.id.fragment, s).commit();
            fab.hide();

        } else if (id == R.id.nav_zis) {
            getSupportActionBar().setTitle("ZIS");
            tb.getMenu().setGroupVisible(R.id.grup1, false);
            tb = findViewById(R.id.mm_choose_bar);
            setSupportActionBar(tb);
            ZIS z = new ZIS();
            FragmentManager fm = getSupportFragmentManager();
            fm.beginTransaction().replace(R.id.fragment, z).commit();
            fab.hide();

        } else if (id == R.id.nav_pemasukan) {
            getSupportActionBar().setTitle("Income/Outcome");
            tb.getMenu().setGroupVisible(R.id.grup1, true);
            tb = findViewById(R.id.mm_choose_bar);
            setSupportActionBar(tb);
            PemasukanPengeluaran p = new PemasukanPengeluaran();
            FragmentManager fm = getSupportFragmentManager();
            fm.beginTransaction().replace(R.id.fragment, p).commit();
            fab.show();

        } else if (id == R.id.nav_hutang) {
            getSupportActionBar().setTitle("Loan");
            tb.getMenu().setGroupVisible(R.id.grup1, true);
            tb = findViewById(R.id.mm_choose_bar);
            setSupportActionBar(tb);
            HutangPiutang hp = new HutangPiutang();
            FragmentManager fm = getSupportFragmentManager();
            fm.beginTransaction().replace(R.id.fragment, hp).commit();
            fab.show();

        } else if (id == R.id.nav_both) {
            getSupportActionBar().setTitle("Both");
            tb.getMenu().setGroupVisible(R.id.grup1, true);
            tb = findViewById(R.id.mm_choose_bar);
            setSupportActionBar(tb);
            Both b = new Both();
            FragmentManager fm = getSupportFragmentManager();
            fm.beginTransaction().replace(R.id.fragment, b).commit();
            fab.hide();
        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
