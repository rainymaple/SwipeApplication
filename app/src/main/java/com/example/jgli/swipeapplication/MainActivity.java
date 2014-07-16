package com.example.jgli.swipeapplication;

import java.util.Locale;

import android.app.Activity;
import android.app.ActionBar;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.res.Resources;
import android.support.v13.app.FragmentPagerAdapter;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


public class MainActivity extends Activity {

    /**
     * The {@link android.support.v4.view.PagerAdapter} that will provide
     * fragments for each of the sections. We use a
     * {@link FragmentPagerAdapter} derivative, which will keep every
     * loaded fragment in memory. If this becomes too memory intensive, it
     * may be best to switch to a
     * {@link android.support.v13.app.FragmentStatePagerAdapter}.
     */
    CoursePagerAdapter mSectionsPagerAdapter;

    /**
     * The {@link ViewPager} that will host the section contents.
     */
    ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /** Create the adapter that will return a fragment for each of
         the primary sections of the activity.    */

        mSectionsPagerAdapter = new CoursePagerAdapter(getFragmentManager(),this);

        /** Set up the ViewPager with the sections adapter.*/
        mViewPager = (ViewPager) findViewById(R.id.pager);
        mViewPager.setAdapter(mSectionsPagerAdapter);

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
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    

    /**
     * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
     * one of the sections/tabs/pages.


     public class SectionsPagerAdapter extends FragmentPagerAdapter {

        String mCourseTitles[], mCourseDescriptions[],mCourseShortTitles[];
        public static final String ARG_SECTION_NUMBER = "section_number";
        public static final String COURSE_TITLE = "course_title";
        public static final String COURSE_DESCRIPTION = "course_description";

        public SectionsPagerAdapter(FragmentManager fm, Context context) {
            super(fm);
            Resources resources = context.getResources();
            mCourseTitles = resources.getStringArray(R.array.course_titles);
            mCourseShortTitles = resources.getStringArray(R.array.course_short_titles);
            mCourseDescriptions = resources.getStringArray(R.array.course_description);
        }


        @Override
        public Fragment getItem(int position) {
            // getItem is called to instantiate the fragment for the given page.
            PlaceholderFragment fragment = new PlaceholderFragment();
            Bundle args = new Bundle();
            args.putInt(ARG_SECTION_NUMBER, position);
            args.putString(COURSE_TITLE, mCourseTitles[position]);
            args.putString(COURSE_DESCRIPTION,mCourseDescriptions[position]);
            fragment.setArguments(args);
            return fragment;
        }

        @Override
        public int getCount() {
            //determine how many pages will be shown
            return mCourseTitles.length;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mCourseShortTitles[position];    // show the tile in the PagerTitleStrip
        }
    }    */

    /**
     * A placeholder fragment containing a simple view.

    public static class PlaceholderFragment extends Fragment {
        public PlaceholderFragment() {}

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_main, container, false);

            Bundle args = getArguments();
            if (args != null) {
                String courseTitle = args.getString(SectionsPagerAdapter.COURSE_TITLE);
                String courseDescription = args.getString(SectionsPagerAdapter.COURSE_DESCRIPTION);
                int sectionNumber = args.getInt(SectionsPagerAdapter.ARG_SECTION_NUMBER);
                int topCardId = 0;

                switch (sectionNumber) {
                    case 0:  topCardId = R.drawable.angularjs; break;
                    case 1:  topCardId = R.drawable.csharp; break;
                    case 2:  topCardId = R.drawable.logging; break;
                    case 3:  topCardId = R.drawable.nodejs; break;
                    case 4:  topCardId = R.drawable.mvc; break;
                }
                displayValues(rootView, courseTitle, courseDescription, topCardId);
            }

            return rootView;
        }

        private void displayValues(View rootView, String courseTitle, String courseDescription, int topCardId) {
            TextView courseTitleTextView = (TextView) rootView.findViewById(R.id.courseTitle);
            TextView courseDescriptionTextView = (TextView) rootView.findViewById(R.id.courseDescription);
            ImageView topCardImageView = (ImageView) rootView.findViewById(R.id.topCard);

            courseTitleTextView.setText(courseTitle);
            courseDescriptionTextView.setText(courseDescription);
            topCardImageView.setImageResource(topCardId);
        }
    }*/

}
