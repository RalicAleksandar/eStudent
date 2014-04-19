package rs.ac.bg.etf.estudent.http;

import java.util.ArrayList;
import java.util.Map;

import rs.ac.bg.etf.estudent.fragment.BaseFragment;
import android.os.AsyncTask;
import android.util.Log;

public class ServerAsyncTask extends
		AsyncTask<BaseFragment, Void, ArrayList<Map<String, String>>> {

	private BaseFragment fragment = null;

	@Override
	protected ArrayList<Map<String, String>> doInBackground(
			BaseFragment... params) {
		fragment = params[0];
		return makeRequest(params[0]);
	}

	private ArrayList<Map<String, String>> makeRequest(BaseFragment frag) {
		Log.i("ServerAsyncTask", frag.TAG);
		switch (frag.TAG) {
		case "INFO_FRAG":
			return RequestGenerator.getObavestenja(frag);
		case "SCH_FRAG":
			return RequestGenerator.getSkolarine(frag);
		case "PAY_FRAG":
			return RequestGenerator.getUplate(frag);
		case "ACC_FRAG":
			return RequestGenerator.getStanje(frag);
		}
		return null;
	}

	@Override
	protected void onPostExecute(ArrayList<Map<String, String>> result) {
		fragment.processResponse(result);
	}

}
