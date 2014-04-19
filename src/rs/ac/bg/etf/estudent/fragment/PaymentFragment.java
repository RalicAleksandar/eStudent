package rs.ac.bg.etf.estudent.fragment;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import rs.ac.bg.etf.estudent.R;
import rs.ac.bg.etf.estudent.http.ServerAsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.SimpleAdapter;

public class PaymentFragment extends BaseFragment {

	private ArrayList<Map<String, String>> mPayList = null;
	private ListView mPaymentList;
	private SimpleAdapter mPaymentAdapter;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setRetainInstance(true);
		TAG = "PAY_FRAG";
		mServerAsyncTask = new ServerAsyncTask();
		mServerAsyncTask.execute(this);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		View view = inflater.inflate(R.layout.fragment_payment, container,
				false);

		mContentView = view.findViewById(R.id.payment_table);
		mPaymentList = (ListView) mContentView;
		mSpinnerView = view.findViewById(R.id.load_progress);
		return view;
	}

	@Override
	public void onStart() {
		// TODO Auto-generated `method stub
		super.onStart();
		if (mPayList != null) {
			loadData();
		}
	}

	private void loadData() {
		mPayList = new ArrayList<Map<String, String>>();
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("tipUplate","skolarina");
		map.put("datumUplate", "1.1.2013");
		map.put("iznosUplate", "33000");
		map.put("specifikacija", "Rata za skolarinu");

		mPayList.add(map);
		mPayList.add(map);
		mPayList.add(map);

		mPaymentAdapter = new SimpleAdapter(getActivity(), mPayList,
				R.layout.payment_list_item, new String[] { "tipUplate", "datumUplate",
						"iznosUplate", "specifikacija" }, new int[] { R.id.payment_type,
						R.id.payment_date, R.id.payment_amount,
						R.id.payment_specification });

		mPaymentList.setAdapter(mPaymentAdapter);
		showSpinner(false);

	}

	@Override
	public void processResponse(ArrayList<Map<String, String>> list) {
		mPayList = list;
		loadData();
	}
}
