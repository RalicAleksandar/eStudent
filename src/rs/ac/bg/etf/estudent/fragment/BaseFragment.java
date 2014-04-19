package rs.ac.bg.etf.estudent.fragment;

import java.util.ArrayList;
import java.util.Map;

import rs.ac.bg.etf.estudent.http.ServerAsyncTask;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.view.View;
import android.widget.Toast;

public class BaseFragment extends Fragment {

	public String TAG;
	protected View mContentView;
	protected View mSpinnerView;
	private Handler mHandler = new Handler();
	protected Context mContext;
	protected ServerAsyncTask mServerAsyncTask;

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onActivityCreated(savedInstanceState);
		mContext = this.getActivity();
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
	}

	public void processResponse(ArrayList<Map<String, String>> list) {
	};

	public void showSpinner(boolean show) {
		mSpinnerView.setVisibility(show ? View.VISIBLE : View.GONE);
		mContentView.setVisibility(show ? View.GONE : View.VISIBLE);
	}

	public synchronized void postToast(final String message) {
		mHandler.post(new Runnable() {

			@Override
			public void run() {
				Toast.makeText(mContext, message, Toast.LENGTH_LONG).show();
			}
		});
	}

	public void stopAsyncTask() {
		if (mServerAsyncTask != null) {
			mServerAsyncTask.cancel(true);
		}
	}
}
