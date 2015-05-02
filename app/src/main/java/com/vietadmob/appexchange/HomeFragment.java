package com.vietadmob.appexchange;

import com.vietadmob.appexchange.fragment.TabsPagerAdapter;

import android.annotation.SuppressLint;
import android.app.ActionBar;
import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.app.ActionBar.Tab;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public  class HomeFragment extends Fragment implements
ActionBar.TabListener {
	
	private ViewPager viewPager;
	private TabsPagerAdapter mAdapter;
	private ActionBar actionBar;
	private FragmentActivity context;

	// Tab titles
	private String[] tabs = { "Top Rated", "Games", "Movies" };

	@SuppressLint("NewApi")
	protected void onCreate(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
		 
		View rootView = inflater.inflate(R.layout.fragment_home, container, false);

		// Initilization
		viewPager = (ViewPager) rootView.findViewById(R.id.pager);
		//actionBar = getActionBar();
		actionBar = getActivity().getActionBar();

		mAdapter = new TabsPagerAdapter(context.getSupportFragmentManager());

		viewPager.setAdapter(mAdapter);
		actionBar.setHomeButtonEnabled(false);
		actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);		

		// Adding Tabs
		for (String tab_name : tabs) {
			actionBar.addTab(actionBar.newTab().setText(tab_name)
					.setTabListener(this));
		}

		/**
		 * on swiping the viewpager make respective tab selected
		 * */
		viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {

			@Override
			public void onPageSelected(int position) {
				// on changing the page
				// make respected tab selected
				actionBar.setSelectedNavigationItem(position);
			}

			@Override
			public void onPageScrolled(int arg0, float arg1, int arg2) {
			}

			@Override
			public void onPageScrollStateChanged(int arg0) {
			}
		});
	}

	@Override
	public void onTabReselected(Tab tab, FragmentTransaction ft) {
	}

	@Override
	public void onTabSelected(Tab tab, FragmentTransaction ft) {
		// on tab selected
		// show respected fragment view
		viewPager.setCurrentItem(tab.getPosition());
	}
	
	@Override
	public void onAttach(Activity activity) {
//	    context = (FragmentActivity) activity;
	    super.onAttach(activity);
	}
	
	

	@Override
	public void onTabUnselected(Tab tab, FragmentTransaction ft) {
	}
}
