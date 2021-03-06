/*
 * Copyright (c) 2016. David de Andrés and Juan Carlos Ruiz, DISCA - UPV, Development of apps for mobile devices.
 */

package labs.dadm.l0602_viewpager.activities;

import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.PagerTabStrip;
import androidx.viewpager.widget.PagerTitleStrip;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;

import labs.dadm.l0602_viewpager.R;
import labs.dadm.l0602_viewpager.adapters.CustomFragmentPagerAdapter;

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
        pager = findViewById(R.id.pager);
        // Create a new PageAdapter and associate it to the ViewPager
        pager.setAdapter(new CustomFragmentPagerAdapter(
                ViewPagerActivity.this,
                getSupportFragmentManager(),
                FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT));

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
                getSupportActionBar().setTitle(R.string.button_view_pager);
                break;

            /*
             * Use a TitleStrip to display the labels. It is not interactive.
             * It is added to the ViewPager by code, although it could also be directly included
             * in the layout as follows:
             *   <androidx.viewpager.widget.PagerTitleStrip
             *      android:id="@+id/titleStrip"
             *      android:layout_width="match_parent"
             *      android:layout_height="wrap_content" />
             * */
            case DashboardActivity.TITLE_STRIP:
                getSupportActionBar().setTitle(R.string.button_view_pager_title_strip);
                // Add a TitleStrip to the ViewPager with the required parameters
                // Titles are provided by the associated PagerAdapter
                pager.addView(new PagerTitleStrip(this), params);
                break;

            /*
             * Use a TabStrip to display the labels. It is interactive.
             * It is added to the ViewPager by code, although it could also be directly included
             * in the layout as follows:
             *   <androidx.viewpager.widget.PagerTabStrip
             *      android:id="@+id/tabStrip"
             *      android:layout_width="match_parent"
             *      android:layout_height="wrap_content" />
             * */
            case DashboardActivity.TAB_STRIP:
                getSupportActionBar().setTitle(R.string.button_view_pager_tab_strip);
                // Add a TabStrip to the ViewPager with the required parameters
                // Titles are provided by the associated PagerAdapter
                pager.addView(new PagerTabStrip(this), params);
                break;

            /*
             * Use a TabLayout (com.google.android.material.tabs.TabLayout) to display the labels.
             * It is interactive. It is has been directly included in the layout,
             * but as an invisible component.
             */
            case DashboardActivity.TAB_LAYOUT:
                getSupportActionBar().setTitle(R.string.button_view_pager_tab_layout);
                // Get a reference to the TabLayout component
                TabLayout tabLayout = findViewById(R.id.tabLayout);
                // Make it visible
                tabLayout.setVisibility(View.VISIBLE);
                // Associate the TabLayout with the ViewPager,
                // so any changes in one of them are automatically reflected on the other
                tabLayout.setupWithViewPager(pager);
                break;
        }

    }
}
