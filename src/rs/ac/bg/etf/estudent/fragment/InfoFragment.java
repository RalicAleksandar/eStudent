package rs.ac.bg.etf.estudent.fragment;

import java.util.ArrayList;
import java.util.Map;

import rs.ac.bg.etf.estudent.R;
import rs.ac.bg.etf.estudent.http.ServerAsyncTask;
import rs.ac.bg.etf.estudent.util.Constants;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.SimpleAdapter;

public class InfoFragment extends BaseFragment {

	private ArrayList<Map<String, String>> mInfoList = null;
	private SimpleAdapter mAdapter;
	private ListView mListViewInfo;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setRetainInstance(true);
		TAG = "INFO_FRAG";
		Log.i("InfoFrag", "onCreate");
		mServerAsyncTask = new ServerAsyncTask();
		mServerAsyncTask.execute(this);

	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		View view = inflater.inflate(R.layout.fragment_info, container, false);

		mContentView = view.findViewById(R.id.info_list);
		mListViewInfo = (ListView) mContentView;
		mSpinnerView = view.findViewById(R.id.load_progress);
		return view;
	}

	@Override
	public void onStart() {
		// TODO Auto-generated method stub
		super.onStart();
		if (mInfoList != null) {
			loadData(mInfoList);
		}
	}

	private void loadData(ArrayList<Map<String, String>> list) {
		// ArrayList<Map<String, String>> list =
		// RequestGenerator.getObavestenja();
		// .getObavestenja(13);
		mAdapter = new SimpleAdapter(mContext, list, R.layout.info_list_item,
				new String[] { Constants.NASLOV, Constants.DATUM_OD,
						Constants.DATUM_DO, Constants.ZAJEDNICKI_TEKST,
						Constants.POJEDINACNI_TEKST, Constants.IME,
						Constants.PREZIME }, new int[] { R.id.info_title,
						R.id.info_date_from, R.id.info_date_to,
						R.id.info_content_common, R.id.info_content_exclusive,
						R.id.info_name, R.id.info_surname });

		mListViewInfo.setAdapter(mAdapter);

		showSpinner(false);

	}

	@Override
	public void processResponse(ArrayList<Map<String, String>> list) {
		mInfoList = list;
		loadData(list);

	}

	@Override
	public void onStop() {
		// TODO Auto-generated method stub
		super.onStop();
		stopAsyncTask();
	}
	
	@Override
	public void onConfigurationChanged(Configuration newConfig) {
		// TODO Auto-generated method stub
		super.onConfigurationChanged(newConfig);
	}
}
