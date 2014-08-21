package com.example.jgli.swipeapplication;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


public class CourseFragment extends Fragment {
    public CourseFragment() {}

    String mCourseTitle, mCourseDescription;
    int mTopCardResourceId;
    public static final int COURSE_ACTION_NOT_SET = 0;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_main, container, false);

        Bundle args = getArguments();
        if (args != null) {
            mCourseTitle = args.getString(CoursePagerAdapter.COURSE_TITLE);
            mCourseDescription = args.getString(CoursePagerAdapter.COURSE_DESCRIPTION);
            mTopCardResourceId = args.getInt(CoursePagerAdapter.COURSE_CATEGORY);
            /**int sectionNumber = args.getInt(CoursePagerAdapter.ARG_SECTION_NUMBER);
             switch (sectionNumber) {
                case 0:  mTopCardResourceId = R.drawable.angularjs; break;
                case 1:  mTopCardResourceId = R.drawable.csharp; break;
                case 2:  mTopCardResourceId = R.drawable.logging; break;
                case 3:  mTopCardResourceId = R.drawable.nodejs; break;
                case 4:  mTopCardResourceId = R.drawable.mvc; break;
            }*/
            displayValues(rootView, mCourseTitle, mCourseDescription, mTopCardResourceId);
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

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        boolean handled = true;
        int courseActionResourceId = COURSE_ACTION_NOT_SET;

        switch (item.getItemId()) {
            case R.id.action_view:
                courseActionResourceId =R.string.action_view;
                break;
            case R.id.action_contents:
                courseActionResourceId =R.string.action_contents;
                break;
            case R.id.action_description:
                courseActionResourceId =R.string.action_description;
                break;
            case R.id.action_exercises:
                courseActionResourceId =R.string.action_exercises;
                break;
            default:
                handled = false;// super.onOptionsItemSelected(item);
                break;
        }

        if(courseActionResourceId!=COURSE_ACTION_NOT_SET){
            showActionActivity(courseActionResourceId);
        }
        super.onOptionsItemSelected(item);
        return handled;
    }

    private void showActionActivity(int courseActionResourceId){
        Intent intent = new Intent(getActivity(),CourseActionsActivity.class);
        intent.putExtra(CourseActionsActivity.COURSE_ACTION,getString(courseActionResourceId));
        intent.putExtra(CourseActionsActivity.COURSE_TITLE, mCourseTitle);
        intent.putExtra(CourseActionsActivity.TOP_CARD, mTopCardResourceId);

        startActivity(intent);
    }
}
