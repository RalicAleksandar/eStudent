package rs.ac.bg.etf.estudent.fragment;

import java.util.ArrayList;
import java.util.Map;

import rs.ac.bg.etf.estudent.R;
import rs.ac.bg.etf.estudent.http.ServerAsyncTask;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.SimpleAdapter;

public class ScholarShipFragment extends BaseFragment {

	private ArrayList<Map<String, String>> mSchList = null;
	private ListView mSchoolarshipList;
	private SimpleAdapter mScholarshipAdapter;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setRetainInstance(true);
		TAG = "SCH_FRAG";

		mServerAsyncTask = new ServerAsyncTask();
		mServerAsyncTask.execute(this);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		View view = inflater.inflate(R.layout.fragment_scholar_ship, container,
				false);
		mContentView = view.findViewById(R.id.scholarship_table);
		mSchoolarshipList = (ListView) mContentView;
		mSpinnerView = view.findViewById(R.id.load_progress);

		return view;
	}

	@Override
	public void onStart() {
		// TODO Auto-generated `method stub
		super.onStart();
		if (mSchList != null) {
			loadData();
		}
	}

	private void loadData() {

		mScholarshipAdapter = new SimpleAdapter(mContext, mSchList,
				R.layout.schshp_list_item, new String[] { "skolskaGodina",
						"godinaStudija", "statusUpisa", "nacinUpisa",
						"akronimProfil", "nazivProfil", "datumUpisa",
						"espbOsvojeno", "kojiPut", "rata", "brojRata", "iznos",
						"rokUplate" }, new int[] { R.id.schship_year,
						R.id.schship_study_year, R.id.schship_status,
						R.id.schship_method, R.id.schship_acronym_profile,
						R.id.schship_profile, R.id.schship_enroll_date,
						R.id.schship_espb, R.id.schship_times, R.id.schship_installment,
						R.id.schship_inst_number, R.id.schship_amount,
						R.id.schship_deadline });

		mSchoolarshipList.setAdapter(mScholarshipAdapter);
		showSpinner(false);
	}

	@Override
	public void processResponse(ArrayList<Map<String, String>> list) {
		mSchList = list;
		loadData();
	}
}
