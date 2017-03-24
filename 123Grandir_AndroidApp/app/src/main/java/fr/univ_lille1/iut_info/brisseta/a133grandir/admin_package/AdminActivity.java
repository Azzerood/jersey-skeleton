package fr.univ_lille1.iut_info.brisseta.a133grandir.admin_package;

import android.content.Intent;
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

import fr.univ_lille1.iut_info.brisseta.a133grandir.ImagePickerActivity;
import fr.univ_lille1.iut_info.brisseta.a133grandir.SendMessageActivity;
import fr.univ_lille1.iut_info.brisseta.a133grandir.client_packge.Gallery;
import fr.univ_lille1.iut_info.brisseta.a133grandir.MessageFlowActivity;
import fr.univ_lille1.iut_info.brisseta.a133grandir.R;

public class AdminActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
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
        getMenuInflater().inflate(R.menu.admin, menu);
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

        if (id == R.id.nav_camera) { //envoyer photo
            // Handle the camera action
            Intent intent = new Intent(AdminActivity.this,ImagePickerActivity.class );//passage a Gallery //TODO
            startActivity(intent);
        } else if (id == R.id.nav_gallery) { //Envoyer video
            Intent intent = new Intent(AdminActivity.this,ImagePickerActivity.class );//passage a Gallery //TODO
            startActivity(intent);
        } else if (id == R.id.nav_manage) { //OPTIONS
            Intent intent = new Intent(AdminActivity.this,SettingsActivity.class );//passage a settings //TODO
            startActivity(intent);
        } else if (id == R.id.nav_share) { //voir  messages
            Intent intent = new Intent(AdminActivity.this,MessageFlowActivity.class );//passage a settings //TODO
            startActivity(intent);
        } else if (id == R.id.nav_send) { // envoyer image
            Intent intent = new Intent(AdminActivity.this,SendMessageActivity.class );//passage a envoyer Message //TODO
            startActivity(intent);
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
