package com.ateam.lacys.activity;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.GestureDetector;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.ateam.lacys.R;
import com.ateam.lacys.adapter.CategoryAdapter;
import com.ateam.lacys.fragment.AccountFragment;
import com.ateam.lacys.fragment.BagDialogFragment;
import com.ateam.lacys.fragment.HomeFragment;
import com.ateam.lacys.fragment.KidsFragment;
import com.ateam.lacys.fragment.MensFragment;
import com.ateam.lacys.fragment.ShareFragment;
import com.ateam.lacys.fragment.WomensFragment;

import org.w3c.dom.Text;

public class MainActivity extends ActionBarActivity {

    //First We Declare Titles And Icons For Our Navigation Drawer List View
    //This Icons And Titles Are holded in an Array as you can see

    String TITLES[] = {"Home", "Mens", "Womens", "Kids", "Account", "Share"};
    int ICONS[] = {R.drawable.star, R.drawable.star, R.drawable.star,
            R.drawable.star, R.drawable.star, R.drawable.star};

    boolean drawerIsOpen = false;

    //Similarly we Create a String Resource for the name and email in the header view
    //And we also create a int resource for profile picture in the header
    //This is a new comment

    String NAME = "LACYS";
    String SLOGAN = "Start Shopping Now, Hot Deals!";
    //int PROFILE = R.drawable.aka;

    private Toolbar toolbar;                              // Declaring the Toolbar Object

    RecyclerView mRecyclerView;                           // Declaring RecyclerView
    RecyclerView.Adapter mAdapter;                        // Declaring Adapter For Recycler View
    RecyclerView.LayoutManager mLayoutManager;            // Declaring Layout Manager as a linear layout manager
    DrawerLayout Drawer;                                  // Declaring DrawerLayout

    ActionBarDrawerToggle mDrawerToggle;                  // Declaring Action Bar Drawer Toggle

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        HomeFragment home = new HomeFragment();
        fragmentTransaction.add(R.id.container, home, "Home");
        fragmentTransaction.commit();

        /* Assinging the toolbar object to the view
            and setting the the Action bar to our toolbar*/

        toolbar = (Toolbar) findViewById(R.id.tool_bar);
        setSupportActionBar(toolbar);

        mRecyclerView = (RecyclerView) findViewById(R.id.RecyclerView); // Assigning the RecyclerView Object to the xml View

        mRecyclerView.addItemDecoration(new DividerItemDecoration(this, null));
        mRecyclerView.setHasFixedSize(true);                            // Letting the system know that the list objects are of fixed size
        //mRecyclerView.setBackgroundResource(R.drawable.list_background);

        mAdapter = new CategoryAdapter(TITLES, ICONS, NAME, SLOGAN, this);       // Creating the Adapter of CategoryAdapter class(which we are going to see in a bit)
        // And passing the titles,icons,header view name, header view email,
        // and header view profile picture

        mRecyclerView.setAdapter(mAdapter); // Setting the adapter to RecyclerView

        final GestureDetector mGestureDetector = new GestureDetector(MainActivity.this, new GestureDetector.SimpleOnGestureListener() {

            @Override
            public boolean onSingleTapUp(MotionEvent e) {
                return true;
            }
        });

        mRecyclerView.addOnItemTouchListener(new RecyclerView.OnItemTouchListener() {
            @Override
            public boolean onInterceptTouchEvent(RecyclerView recyclerView, MotionEvent motionEvent) {
                View child = recyclerView.findChildViewUnder(motionEvent.getX(), motionEvent.getY());

                FragmentManager fragmentManager = getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

                if (child != null && mGestureDetector.onTouchEvent(motionEvent)) {
                    Drawer.closeDrawers();
                    int position = recyclerView.getChildPosition(child);
                    Context context = child.getContext();

                    HomeFragment home = new HomeFragment();
                    fragmentTransaction.add(R.id.container, home, "Home");
                    fragmentTransaction.remove(home);

                    retrievePosition(child, position);
                    return true;
                }
                return false;
            }

            @Override
            public void onTouchEvent(RecyclerView recyclerView, MotionEvent motionEvent) {

            }
        });

        mLayoutManager = new LinearLayoutManager(this);                 // Creating a layout Manager
        mRecyclerView.setLayoutManager(mLayoutManager);                 // Setting the layout Manager

        Drawer = (DrawerLayout) findViewById(R.id.drawer_layout);        // Drawer object Assigned to the view
        mDrawerToggle = new ActionBarDrawerToggle(this, Drawer, toolbar, R.string.drawer_open, R.string.drawer_close) {

            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
                drawerView.setBackgroundColor(Color.WHITE);
                // code here will execute once the drawer is opened( As I dont want anything happened whe drawer is
                // open I am not going to put anything here)
            }

            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
                drawerView.setBackgroundColor(Color.WHITE);
                // Code here will execute once drawer is closed
            }

        }; // Drawer Toggle Object Made
        Drawer.setDrawerListener(mDrawerToggle); // Drawer Listener set to the Drawer toggle
        mDrawerToggle.syncState();               // Finally we set the drawer toggle sync State
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
       getMenuInflater().inflate(R.menu.menu_main, menu);
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

    public void retrievePosition(View child, int position) {

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        switch (position) {
            case 1:
                HomeFragment home = new HomeFragment();
                fragmentTransaction.replace(R.id.container,home);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
                break;
            case 2:
                MensFragment mens = new MensFragment();
                fragmentTransaction.replace(R.id.container,mens);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
                break;
            case 3:
                WomensFragment womens = new WomensFragment();
                fragmentTransaction.replace(R.id.container,womens);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
                break;
            case 4:
                KidsFragment kids = new KidsFragment();
                fragmentTransaction.replace(R.id.container,kids);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
                break;
            case 5:
                AccountFragment account = new AccountFragment();
                fragmentTransaction.replace(R.id.container,account);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
                break;
            case 6:
                ShareFragment share = new ShareFragment();
                fragmentTransaction.replace(R.id.container,share);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
                break;
        }

    }

}
