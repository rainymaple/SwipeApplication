package com.example.jgli.swipeapplication;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


public class CourseFragment extends Fragment {
    public CourseFragment() {}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_main, container, false);

        Bundle args = getArguments();
        if (args != null) {
            String courseTitle = args.getString(CoursePagerAdapter.COURSE_TITLE);
            String courseDescription = args.getString(CoursePagerAdapter.COURSE_DESCRIPTION);
            int sectionNumber = args.getInt(CoursePagerAdapter.ARG_SECTION_NUMBER);
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
}
