package rs.ac.bg.etf.estudent.activity;

import rs.ac.bg.etf.estudent.R;
import rs.ac.bg.etf.estudent.fragment.AccountFragment;
import rs.ac.bg.etf.estudent.fragment.InfoFragment;
import rs.ac.bg.etf.estudent.fragment.PaymentFragment;
import rs.ac.bg.etf.estudent.fragment.SPAFragment;
import rs.ac.bg.etf.estudent.fragment.ScholarShipFragment;
import rs.ac.bg.etf.estudent.fragment.WelcomeFragment;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class DrawerActivityMain extends ActionBarActivity {

	private DrawerLayout mDrawerLayout;
	private ListView mDrawerList;
	private ActionBarDrawerToggle mDrawerToggle;

	private String[] listTitles;

	private String myAppTitle = "Obaveštenja";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_drawer_main);

		listTitles = getResources().getStringArray(R.array.my_list_items);
		mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);

		if (mDrawerLayout != null) {

			mDrawerList = (ListView) findViewById(R.id.drawer_item_list);
			mDrawerList.setAdapter(new ArrayAdapter<String>(this,
					R.layout.drawer_list_item, listTitles));

			mDrawerLayout.setDrawerShadow(R.drawable.drawer_shadow,
					GravityCompat.START);
			mDrawerList.setOnItemClickListener(new DrawerItemClickListener());
			mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout,
					R.drawable.ic_drawer, R.string.app_name, R.string.app_name) {
				@Override
				public void onDrawerClosed(View drawerView) {
					super.onDrawerClosed(drawerView);
				}

				@Override
				public void onDrawerOpened(View drawerView) {
					super.onDrawerOpened(drawerView);
				}
			};
			mDrawerLayout.setDrawerListener(mDrawerToggle);
		}

		if (savedInstanceState == null) {
			// During initial setup, plug in the file list fragment.
			getSupportFragmentManager().beginTransaction()
					.replace(R.id.content_frame, new InfoFragment())
					.commit();
			getSupportActionBar().setTitle(myAppTitle);

		} else {
			Fragment f = getSupportFragmentManager().findFragmentById(
					R.id.content_frame);
			if (f != null) {
				getSupportFragmentManager().beginTransaction()
						.replace(R.id.content_frame, f).commit();
			}
		}

		if (savedInstanceState != null)
			myAppTitle = savedInstanceState.getString("appTitle");
		getSupportActionBar().setTitle(myAppTitle);

		getSupportActionBar().setDisplayHomeAsUpEnabled(true);
		getSupportActionBar().setHomeButtonEnabled(true);
		getSupportActionBar().setDisplayShowTitleEnabled(true);

	}

	@Override
	protected void onPostCreate(Bundle savedInstanceState) {
		super.onPostCreate(savedInstanceState);
		// Sync the toggle state after onRestoreInstanceState has occurred.
		mDrawerToggle.syncState();
	}

	@Override
	public void onConfigurationChanged(Configuration newConfig) {
		super.onConfigurationChanged(newConfig);
		// Pass any configuration change to the drawer toggls
		mDrawerToggle.onConfigurationChanged(newConfig);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.drawer_activity_menu, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {

		// Intent intent;
		switch (item.getItemId()) {

		case android.R.id.home:
			// Pass the event to ActionBarDrawerToggle, if it returns
			// true, then it has handled the app icon touch event
			Intent intent;
			if (mDrawerToggle.onOptionsItemSelected(item)) {
				return true;

			}
			// return true;
		case R.id.logout_action:
			// We need to logout user and commit changes
			intent = new Intent(this, LogoutActivity.class);
			startActivity(intent);
			finish();
		}
		return super.onOptionsItemSelected(item);
	}

	private class DrawerItemClickListener implements
			ListView.OnItemClickListener {
		@Override
		public void onItemClick(AdapterView<?> parent, View view, int position,
				long id) {
			selectItem(position);
		}
	}

	private void selectItem(int position) {
		// update the main content by replacing fragments

		Fragment fragment;

		switch (position) {

		case 0:
			fragment = new InfoFragment();
			setMyAppTitle("Obavestenja");
			break;
		case 1:
			fragment = new SPAFragment();
			setMyAppTitle("SPA");
			break;
		case 2:
			fragment = new ScholarShipFragment();
			setMyAppTitle("Skolarine");
			break;
		case 3:
			fragment = new PaymentFragment();
			setMyAppTitle("Uplate");
			break;
		case 4:
			fragment = new AccountFragment();
			setMyAppTitle("Stanje racuna");
			break;
		default:
			fragment = new WelcomeFragment();
		}
		if (fragment != null) {
			getSupportFragmentManager().beginTransaction()
					.replace(R.id.content_frame, fragment).commit();
		}

		// update selected item and title, then close the drawer
		mDrawerList.setItemChecked(position, true);
		mDrawerLayout.closeDrawer(mDrawerList);
		getSupportActionBar().setTitle(getMyAppTitle());

	}

	@Override
	protected void onSaveInstanceState(Bundle outState) {
		super.onSaveInstanceState(outState);
		outState.putString("appTitle", getMyAppTitle());
		Log.i("NASLOV", getMyAppTitle());
	}

	public String getMyAppTitle() {
		return myAppTitle;
	}

	public void setMyAppTitle(String myAppTitle) {
		this.myAppTitle = myAppTitle;
	}

}
