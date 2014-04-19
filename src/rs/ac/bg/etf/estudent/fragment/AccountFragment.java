package rs.ac.bg.etf.estudent.fragment;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import rs.ac.bg.etf.estudent.R;
import rs.ac.bg.etf.estudent.http.ServerAsyncTask;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.SimpleAdapter;

public class AccountFragment extends BaseFragment {

	private ArrayList<Map<String, String>> mAccList = null;
	private ListView mAccountList;
	private SimpleAdapter mAccountAdapter;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setRetainInstance(true);
		TAG = "ACC_FRAG";

		mServerAsyncTask = new ServerAsyncTask();
		mServerAsyncTask.execute(this);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		View view = inflater.inflate(R.layout.fragment_account, container,
				false);
		mContentView = view.findViewById(R.id.account_table);
		mAccountList = (ListView) mContentView;
		mSpinnerView = view.findViewById(R.id.load_progress);
		return view;
	}

	@Override
	public void onStart() {
		// TODO Auto-generated `method stub
		super.onStart();
		if (mAccList != null) {
			loadData();
		}
	}

	private void loadData() {
		mAccList = new ArrayList<Map<String, String>>();
		HashMap<String, String> map = new HashMap<String, String>();

		map.put("trenutakPromene", "2.3.2013 14:32");
		map.put("opis",
				"Pocetno stanje na racunu kreiranje pocetnog stanja na racunu");
		map.put("uplataIznos", "0.00");
		map.put("isplataIznos", "");
		map.put("iznosNaRacunu", "0.00");
		map.put("tipPromeneNaRacunu", "Uplata na racun");

		mAccList.add(map);
		mAccList.add(map);
		mAccList.add(map);
		mAccList.add(map);
		mAccList.add(map);

		mAccountAdapter = new SimpleAdapter(getActivity(), mAccList,
				R.layout.account_list_item, new String[] { "trenutakPromene",
						"opis", "uplataIznos", "isplataIznos", "iznosNaRacunu",
						"tipPromeneNaRacunu" }, new int[] {
						R.id.account_change_time, R.id.account_detail,
						R.id.account_in, R.id.account_out, R.id.account_state,
						R.id.account_change_type });
		mAccountList.setAdapter(mAccountAdapter);
		showSpinner(false);
	}

	@Override
	public void processResponse(ArrayList<Map<String, String>> list) {
		mAccList = list;
		loadData();
	}
}
