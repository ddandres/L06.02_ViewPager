/*
 * Copyright (c) 2016. David de Andrés and Juan Carlos Ruiz, DISCA - UPV, Development of apps for mobile devices.
 */

package labs.dadm.l0602_viewpager.adapters;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import labs.dadm.l0602_viewpager.R;
import labs.dadm.l0602_viewpager.fragments.GridImageFragment;
import labs.dadm.l0602_viewpager.fragments.ListStringFragment;
import labs.dadm.l0602_viewpager.fragments.LogInFragment;
import labs.dadm.l0602_viewpager.fragments.SignInFragment;

/**
 * Maintains each page as a Fragment that is kept in the FragmentManager.
 * Useful as there is a small number of Fragments to be displayed (could require too much memory).
 */
public class CustomFragmentPagerAdapter extends FragmentPagerAdapter {

    final private Context context;

    public CustomFragmentPagerAdapter(Context context, @NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
        this.context = context;
    }

    /**
     * Returns the Fragment associated to a given position.
     */
    @NonNull
    @Override
    public Fragment getItem(int position) {
        Fragment result;

        switch (position) {
            case 1:
                result = new SignInFragment();
                break;
            case 2:
                result = new ListStringFragment();
                break;
            case 3:
                result = new GridImageFragment();
                break;
            // Default case includes position == 0
            default:
                result = LogInFragment.newInstance("David");
                break;
        }
        return result;
    }

    /**
     * Number of Fragments available.
     */
    @Override
    public int getCount() {
        return 4;
    }

    /**
     * Returns the title of the Fragment associated to a given position.
     */
    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return (context.getResources().getString(R.string.title_login_fragment));
            case 1:
                return (context.getResources().getString(R.string.title_signin_fragment));
            case 2:
                return (context.getResources().getString(R.string.title_list_fragment));
            case 3:
                return (context.getResources().getString(R.string.title_grid_fragment));
        }
        return super.getPageTitle(position);
    }
}
