package com.example.maria;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
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
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        switch (id){

            case R.id.nav_casa:
                Uri casa = Uri.parse("geo:0,0?q=petrolina+rua+rio+ipojuca");
                Intent itcasa = new Intent(Intent.ACTION_VIEW,casa);
                startActivity(itcasa);
                break;
            case R.id.nav_upa:
                Uri upa = Uri.parse("geo:0,0?q=UPAE+PETROLINA");
                Intent itupa = new Intent(Intent.ACTION_VIEW,upa);
                startActivity(itupa);
                break;
            case R.id.nav_fisio:
                Uri fisio = Uri.parse("geo:0,0?q=Polícia+Militar+do+Pernambuco+5BATALHAO");
                Intent itfisio = new Intent(Intent.ACTION_VIEW,fisio);
                startActivity(itfisio);
                break;
            case R.id.nav_bradesco:
                Uri bradesco = Uri.parse("geo:0,0?q=bradesco+petrolina+agencia+1122");
                Intent itbradesco = new Intent(Intent.ACTION_VIEW,bradesco);
                startActivity(itbradesco);
                break;

            case R.id.nav_shopping:
                Uri shopping = Uri.parse("geo:0,0?q=river+shopping+petrolina");
                Intent itshopping = new Intent(Intent.ACTION_VIEW,shopping);
                startActivity(itshopping);
                break;
        }


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
