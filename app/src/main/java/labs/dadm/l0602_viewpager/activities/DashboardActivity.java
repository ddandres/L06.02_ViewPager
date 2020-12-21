/*
 * Copyright (c) 2016. David de Andrés and Juan Carlos Ruiz, DISCA - UPV, Development of apps for mobile devices.
 */

package labs.dadm.l0602_viewpager.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import labs.dadm.l0602_viewpager.R;

/**
 * Gives access to an activity showing different Fragments through a ViewPager.
 * The titles identifying each Fragment can be displayed using different components.
 */
public class DashboardActivity extends AppCompatActivity {

    // Constants defining how to display the labels for each fragment
    public static final int NO_STRIP = 0;
    public static final int TITLE_STRIP = 1;
    public static final int TAB_STRIP = 2;
    public static final int TAB_LAYOUT = 3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
    }

    /**
     * Starts the different activities of the application.
     */
    public void buttonClicked(View view) {

        Intent intent = new Intent(this, ViewPagerActivity.class);
        // Determine what to do depending on the Button clicked
        final int clickedButton = view.getId();
        if (clickedButton == R.id.bViewPager) {
            // Do not display any title
            intent.putExtra("strip", NO_STRIP);
        } else if (clickedButton == R.id.bViewPagerTitleStrip) {
            // Display titles using a TitleStrip
            intent.putExtra("strip", TITLE_STRIP);
        } else if (clickedButton == R.id.bViewPagerTabStrip) {
            // Display titles using a TabStrip
            intent.putExtra("strip", TAB_STRIP);
        } else if (clickedButton == R.id.bViewPagerTabLayout) {
            // Display titles using a TableLayout
            intent.putExtra("strip", TAB_LAYOUT);
        }
        // Launch the activity containing the ViewPager
        startActivity(intent);
    }

}
