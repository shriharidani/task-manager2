package com.example.shrihari.navbar.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.example.shrihari.navbar.Fragment.CardSwipe;
import com.example.shrihari.navbar.R;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {


    private void displayInitialFragament(){

        getSupportFragmentManager().beginTransaction().replace(R.id.container,CardSwipe.getInstance()).commit();
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.app_bar_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        displayInitialFragament();
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

        if (id == R.id.nav_share) {

//            Intent intent = new Intent();
//            PendingIntent pendingIntent = PendingIntent.getActivity(MainActivity.this,0,intent,0);
//            Notification.Builder notification = new Notification.Builder(this)
//                                        .setTicker("Ticker Title")
//                                        .setContentTitle("Content Title")
//                                        .setContentText("Hello this is a message")
//                                        .setSmallIcon(R.drawable.ic_menu_gallery)
//                                        .setContentIntent(pendingIntent);
//
//            TaskStackBuilder stackBuilder = TaskStackBuilder.create(MainActivity.this);
//            //stackBuilder.addParentStack()
//
//            NotificationManager mnotificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
//            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
//                mnotificationManager.notify(0,notification.build());
//            }


            Intent intent = new Intent(this,AddTaskActivity.class);
            intent.putExtra("NEW Activity","Add Task");
            startActivity(intent);



        } else if (id == R.id.nav_crtGroup) {
//
//            NotificationCompat.Builder mBuilder = (NotificationCompat.Builder) new NotificationCompat.Builder(this)
//                                                    .setSmallIcon(R.drawable.ic_menu_send)
//                                                    .setContentTitle("Event tracker")
//                                                    .setContentText("Events received");
//            NotificationCompat.InboxStyle inboxStyle = new NotificationCompat.InboxStyle();
//
//            String[] events = new String[6];
//            inboxStyle.setBigContentTitle("Event tracker detail ");
//            for (int i=0; i < events.length; i++) {
//
//                inboxStyle.addLine(events[i]);
//            }
//
//            mBuilder.setStyle(inboxStyle);
//
//            NotificationManager nm = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
//            nm.notify(0,mBuilder.build());

            Intent  newintent= new Intent(this,CreateGroup.class);
            newintent.putExtra("CreateGroupFromMainActivity","WillOpencreateGroup");
            startActivity(newintent);

           // getSupportFragmentManager().beginTransaction().replace(R.id.container, CreateGroupFragment.getInstance()).commit();

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
