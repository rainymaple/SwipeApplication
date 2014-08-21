package com.example.jgli.swipeapplication;

import android.app.ActionBar;
import android.app.Activity;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.widget.DrawerLayout;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

/**
 * Created by jgli on 15/08/2014.
 */
public class NavigationDrawerHelper {
    DrawerLayout mDrawerLayout;
    ListView mDrawerListView;
    ActionBarDrawerToggle mDrawerToggle;

    public void init(Activity theActivity, ListView.OnItemClickListener listener){
        mDrawerLayout = (DrawerLayout) theActivity.findViewById(R.id.drawer_layout);
        mDrawerListView = (ListView) theActivity.findViewById(R.id.drawer_list);

        String[] navigationDrawerOptions
                = theActivity.getResources().getStringArray(R.array.navigation_drawer_options);
        ArrayAdapter<String> navigationDrawerAdapter
                =new ArrayAdapter<String>(theActivity,R.layout.drawer_option_item,navigationDrawerOptions);
        mDrawerListView.setAdapter(navigationDrawerAdapter);
        mDrawerListView.setOnItemClickListener(listener);

        mDrawerListView.setItemChecked(0,true);
        setupActionBar(theActivity);
    }

    private void setupActionBar(Activity theActivity){
        final Activity activity = theActivity;
        ActionBar actionBar = theActivity.getActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        mDrawerToggle = new ActionBarDrawerToggle(
                theActivity,
                mDrawerLayout,
                R.drawable.ic_drawer,
                R.string.open_drawer_message,
                R.string.close_drawer_message){
            @Override
            public void onDrawerClosed(View drawerView) {
                /** invalidateOptionsMenu declare that the options menu has changed,
                 *  so should be recreated. The onCreateOptionsMenu(Menu)
                 *  method will be called the next time it needs to be displayed. */
                activity.invalidateOptionsMenu();
                super.onDrawerClosed(drawerView);
            }

            @Override
            public void onDrawerOpened(View drawerView) {
                activity.invalidateOptionsMenu();
                super.onDrawerOpened(drawerView);
            }
        };
    }
    /** Enable/disable the list items according to the drawer is shown or not */
    public void handleOnPrepareOptionMenu(Menu menu){
        boolean itemVisible = !mDrawerLayout.isDrawerOpen(mDrawerListView);
        for (int i=0;i<menu.size();i++){
            menu.getItem(i).setEnabled(itemVisible);
        }
    }

    /** This method should be called by your Activity's onOptionsItemSelected method.*/
    public void handleOnOptionsItemSelected(MenuItem menuItem) {
        mDrawerToggle.onOptionsItemSelected(menuItem);
    }

    /** Synchronize the state of the drawer indicator/affordance with the linked DrawerLayout.*/
    public void syncState(){
        mDrawerToggle.syncState();
    }

    public void setSelection(int option){
        mDrawerListView.setItemChecked(option,true);
    }

    public void handledSelect(int option){
        mDrawerListView.setItemChecked(option,true);
        mDrawerLayout.closeDrawer(mDrawerListView);
    }
}














