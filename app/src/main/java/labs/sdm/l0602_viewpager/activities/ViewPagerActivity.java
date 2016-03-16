/*
 * Copyright (c) 2016. David de Andrés and Juan Carlos Ruiz, DISCA - UPV, Development of apps for mobile devices.
 */

package labs.sdm.l0602_viewpager.activities;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.PagerTabStrip;
import android.support.v4.view.PagerTitleStrip;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;

import labs.sdm.l0602_viewpager.R;
import labs.sdm.l0602_viewpager.adapters.CustomFragmentPagerAdapter;

/**
 * Displays different Fragments using a ViewPager to enable lateral navigation (swipe).
 */
public class ViewPagerActivity extends AppCompatActivity {

    // Hold a reference to the ViewPager
    ViewPager pager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_pager);

        // Get a reference to the ViewPager
        pager = (ViewPager) findViewById(R.id.pager);
        // Create a new PageAdapter and associate it to the ViewPager
        pager.setAdapter(new CustomFragmentPagerAdapter(getSupportFragmentManager(), this));

        /*
        * Used to create the layout parameters for Views added to the ViewPager
        *   android:layout_width = "match_parent"
        *   android:layout_width = "wrap_content"
        *   android:layout_gravity="top"
        * */
        ViewPager.LayoutParams params = new ViewPager.LayoutParams();
        params.width = ViewGroup.LayoutParams.MATCH_PARENT;
        params.height = ViewGroup.LayoutParams.WRAP_CONTENT;
        params.gravity = Gravity.TOP;

        // Determine which component should display the Fragment labels on top of the ViewPager
        switch (getIntent().getIntExtra("strip", 0)) {

            // No labels will be shown
            case DashboardActivity.NO_STRIP:
                break;

            /*
            * Use a TitleStrip to display the labels. It is not interactive.
            * It is added to the ViewPager by code, although it could also be directly included
            * in the layout as follows:
            *   <android.support.v4.view.PagerTitleStrip
            *      android:id="@+id/titleStrip"
            *      android:layout_width="match_parent"
            *      android:layout_height="wrap_content" />
            * */
            case DashboardActivity.TITLE_STRIP:
                // Add a TitleStrip to the ViewPager with the required parameters
                // Titles are provided by the associated PagerAdapter
                pager.addView(new PagerTitleStrip(this), params);
                break;

            /*
            * Use a TabStrip to display the labels. It is interactive.
            * It is added to the ViewPager by code, although it could also be directly included
            * in the layout as follows:
            *   <android.support.v4.view.PagerTitleStrip
            *      android:id="@+id/tabStrip"
            *      android:layout_width="match_parent"
            *      android:layout_height="wrap_content" />
            * */
            case DashboardActivity.TAB_STRIP:
                // Add a TabStrip to the ViewPager with the required parameters
                // Titles are provided by the associated PagerAdapter
                pager.addView(new PagerTabStrip(this), params);
                break;

            /*
            * Use a TabLayout to display the labels. It is interactive.
            * It is has been directly included in the layout, but as an invisible component.
            * */
            case DashboardActivity.TAB_LAYOUT:
                // Get a reference to the TabLayout component
                TabLayout tabLayout = (TabLayout) findViewById(R.id.tabLayout);
                // Make it visible
                tabLayout.setVisibility(View.VISIBLE);
                // Associate the TabLayout with the ViewPager,
                // so any changes in one of them are automatically reflected on the other
                tabLayout.setupWithViewPager(pager);
                break;
        }

    }
}
