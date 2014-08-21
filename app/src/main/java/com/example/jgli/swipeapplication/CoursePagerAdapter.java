package com.example.jgli.swipeapplication;

import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v13.app.FragmentPagerAdapter;
import android.support.v13.app.FragmentStatePagerAdapter;
import android.widget.Toast;

/**
 * Created by jgli on 16/07/2014.
 */
public class CoursePagerAdapter extends FragmentStatePagerAdapter {

    String mCourseTitles[], mCourseDescriptions[],mCourseShortTitles[];
    int mCourseCategoryImageId;
    public static final String ARG_SECTION_NUMBER = "section_number";
    public static final String COURSE_TITLE = "course_title";
    public static final String COURSE_DESCRIPTION = "course_description";
    public static final String COURSE_CATEGORY = "course_category";
    public static final int COURSE_LIB_WEB = 0;
    public static final int COURSE_LIB_SERVER = 1;
    public static final int COURSE_LIB_DATABASE = 2;
    private Context mContext;

    public CoursePagerAdapter(FragmentManager fm, Context context) {
        super(fm);
        mContext = context;
        Resources resources = context.getResources();
        mCourseTitles = resources.getStringArray(R.array.web_course_titles);
        mCourseShortTitles = resources.getStringArray(R.array.web_course_short_titles);
        mCourseDescriptions = resources.getStringArray(R.array.web_course_description);
    }

    /** Override getItemPosition in this way, when you call notifyDataSetChanged(),
     * the view pager will remove all views and reload them all.
     * As so the reload effect is obtained.
     * */
    @Override
    public int getItemPosition(Object object) {
        return POSITION_NONE;
    }

    @Override
    public Fragment getItem(int position) {
        /** getItem is called to instantiate the fragment for the given page. */
        CourseFragment fragment = new CourseFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_SECTION_NUMBER, position);
        args.putString(COURSE_TITLE, mCourseTitles[position]);
        args.putString(COURSE_DESCRIPTION,mCourseDescriptions[position]);
        args.putInt(COURSE_CATEGORY,mCourseCategoryImageId);
        fragment.setArguments(args);
        return fragment;
    }

    public void setCourseLib(int courseLib){
        boolean isValid = true;
        Resources resources = mContext.getResources();

        switch (courseLib){
            case COURSE_LIB_WEB:
                mCourseTitles = resources.getStringArray(R.array.web_course_titles);
                mCourseShortTitles = resources.getStringArray(R.array.web_course_short_titles);
                mCourseDescriptions = resources.getStringArray(R.array.web_course_description);
                mCourseCategoryImageId = R.drawable.web_development;
                break;
            case COURSE_LIB_SERVER:
                mCourseTitles = resources.getStringArray(R.array.server_course_titles);
                mCourseShortTitles = resources.getStringArray(R.array.server_course_short_titles);
                mCourseDescriptions = resources.getStringArray(R.array.server_course_description);
                mCourseCategoryImageId = R.drawable.server_development;
                break;
            case COURSE_LIB_DATABASE:
                mCourseTitles = resources.getStringArray(R.array.database_course_titles);
                mCourseShortTitles = resources.getStringArray(R.array.database_course_short_titles);
                mCourseDescriptions = resources.getStringArray(R.array.database_course_description);
                mCourseCategoryImageId = R.drawable.database_development;
                break;
            default:
                Toast.makeText(mContext,"Invalid library name",Toast.LENGTH_LONG).show();
                isValid = false;
                break;
        }
        if(isValid){
            notifyDataSetChanged();
        }
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
