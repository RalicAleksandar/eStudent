package rs.ac.bg.etf.estudent.fragment;

import rs.ac.bg.etf.estudent.R;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class SPAFragment extends Fragment {

	private SPAAdapter mSPAAdapter;
	private ViewPager mViewPager;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);

	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		Log.i("SPAFrag", "onCreateView");
		ActionBarActivity a = (ActionBarActivity) inflater.getContext();
		mSPAAdapter = new SPAAdapter(a.getSupportFragmentManager());
		

		View view = inflater.inflate(R.layout.fragment_spa, container, false);

		mViewPager = (ViewPager) view.findViewById(R.id.pager);
		mViewPager.setAdapter(mSPAAdapter);
		return view;
	}

	private static class SPAAdapter extends FragmentPagerAdapter {

		private String[] mStringArray = { "Skolarine", "Uplate", "Stanje" };

		public SPAAdapter(FragmentManager fm) {
			super(fm);
			Log.i("SPAFrag", "SPAAdapterConstructor");
		}

		@Override
		public Fragment getItem(int i) {
			Log.i("getItem",Integer.toString(i));
			switch (i) {
			case 0:
				return new ScholarShipFragment();
			case 1:
				return new PaymentFragment();
			case 2:
				return new AccountFragment();
			default:
				return null;
			}
		}

		@Override
		public int getCount() {
			return 3;
		}

		@Override
		public CharSequence getPageTitle(int position) {
			return mStringArray[position];
		}
	}

	@Override
	public void onStop() {
		// TODO Auto-generated method stub
		super.onStop();
		for (int i = 0; i < mSPAAdapter.getCount(); i++) {
			((BaseFragment) mSPAAdapter.getItem(i)).stopAsyncTask();
		}
		mSPAAdapter = null;
		
	}
}
