package com.example.jgli.swipeapplication;

import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v13.app.FragmentPagerAdapter;

/**
 * Created by jgli on 16/07/2014.
 */
public class CoursePagerAdapter extends FragmentPagerAdapter {
    String mCourseTitles[], mCourseDescriptions[],mCourseShortTitles[];
    public static final String ARG_SECTION_NUMBER = "section_number";
    public static final String COURSE_TITLE = "course_title";
    public static final String COURSE_DESCRIPTION = "course_description";

    public CoursePagerAdapter(FragmentManager fm, Context context) {
        super(fm);
        Resources resources = context.getResources();
        mCourseTitles = resources.getStringArray(R.array.course_titles);
        mCourseShortTitles = resources.getStringArray(R.array.course_short_titles);
        mCourseDescriptions = resources.getStringArray(R.array.course_description);
    }


    @Override
    public Fragment getItem(int position) {
        /** getItem is called to instantiate the fragment for the given page. */
        CourseFragment fragment = new CourseFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_SECTION_NUMBER, position);
        args.putString(COURSE_TITLE, mCourseTitles[position]);
        args.putString(COURSE_DESCRIPTION,mCourseDescriptions[position]);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public int getCount() {
        /** determine how many pages will be shown */
        return mCourseTitles.length;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mCourseShortTitles[position];    /** show the tile in the PagerTitleStrip*/
    }
}
