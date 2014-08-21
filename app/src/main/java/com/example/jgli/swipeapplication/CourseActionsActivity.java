package com.example.jgli.swipeapplication;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.jgli.swipeapplication.R;

public class CourseActionsActivity extends Activity
    implements ListView.OnItemClickListener
{
    public static final String COURSE_ACTION = "course_action";
    public static final String COURSE_TITLE = "course_title";
    public static final String TOP_CARD = "top_card";

    Button button;
    String mCourseAction;
    NavigationDrawerHelper mNavigationDrawerHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course_actions);

        Bundle bundle = getIntent().getExtras();
        int mTopCardResourceId = bundle.getInt(TOP_CARD);
        String mCourseTitle = bundle.getString(COURSE_TITLE);
        mCourseAction = bundle.getString(COURSE_ACTION);

        ActionBar actionBar = getActionBar();
        //actionBar.setDisplayHomeAsUpEnabled(true);

        ImageView topCardImageView = (ImageView) findViewById(R.id.action_topCard);
        button = (Button) findViewById(R.id.button);
        TextView viewCourse = (TextView) findViewById(R.id.action_label);

        topCardImageView.setImageResource(mTopCardResourceId);
        button.setText(mCourseAction);
        viewCourse.setText(mCourseTitle);

        setActions();
        mNavigationDrawerHelper = new NavigationDrawerHelper();
        mNavigationDrawerHelper.init(this,this);
    }

    private void setActions(){
        setTitle(mCourseAction);
        button.setOnClickListener(
                new View.OnClickListener() {
                   @Override
                   public void onClick(View view) {
                       Intent intent = new Intent(view.getContext(),ThirdLayer.class);
                       startActivity(intent);
                   }
               }
        );
    }



    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int optionLib, long l) {
        Intent intent = new Intent(this,MainActivity.class);
        intent.putExtra(MainActivity.EXTRA_COURSE_LIB,optionLib);
        startActivity(intent);
    }

    @Override // ActionBar Menu Items
    public boolean onOptionsItemSelected(MenuItem item) {
        mNavigationDrawerHelper.handleOnOptionsItemSelected(item);

        int id = item.getItemId();
        if (id == R.id.showThirdLayer) {
            Intent intent = new Intent(this,ThirdLayer.class);
            startActivity(intent);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.course_actions, menu);
        return true;
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        mNavigationDrawerHelper.syncState();
    }

    @Override   // to enable/disable list items
    public boolean onPrepareOptionsMenu(Menu menu) {
        mNavigationDrawerHelper.handleOnPrepareOptionMenu(menu);
        return super.onPrepareOptionsMenu(menu);
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        mNavigationDrawerHelper.syncState();
        super.onConfigurationChanged(newConfig);
    }
}




















