package rs.ac.bg.etf.estudent.activity;

import rs.ac.bg.etf.estudent.R;
import rs.ac.bg.etf.estudent.util.Data;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.TargetApi;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.View;

public class LogoutActivity extends ActionBarActivity {
	
	
	private View mLoginStatusView;
	
	/**
	 * Keep track of the login task to ensure we can cancel it if requested.
	 */
	private UserLogoutTask mAuthTask = null;
	
	/**
	 *  We must jump to LoginActivity after logout
	 */
	private Intent intent;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_logout);
		
		mLoginStatusView = findViewById(R.id.logout_status);
		
		intent = new Intent(this, LoginActivity.class);
		showProgress(true);
		mAuthTask = new UserLogoutTask();
		mAuthTask.execute((Void) null);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.logout, menu);
		return true;
	}
	
	/**
	 * Shows the progress UI and hides the login form.
	 */
	@TargetApi(Build.VERSION_CODES.HONEYCOMB_MR2)
	private void showProgress(final boolean show) {
		// On Honeycomb MR2 we have the ViewPropertyAnimator APIs, which allow
		// for very easy animations. If available, use these APIs to fade-in
		// the progress spinner.
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB_MR2) {
			int shortAnimTime = getResources().getInteger(
					android.R.integer.config_shortAnimTime);

			mLoginStatusView.setVisibility(View.VISIBLE);
			mLoginStatusView.animate().setDuration(shortAnimTime)
					.alpha(show ? 1 : 0)
					.setListener(new AnimatorListenerAdapter() {
						@Override
						public void onAnimationEnd(Animator animation) {
							mLoginStatusView.setVisibility(show ? View.VISIBLE
									: View.GONE);
						}
					});
		}else{
			// The ViewPropertyAnimator APIs are not available, so simply show
						// and hide the relevant UI components.
						mLoginStatusView.setVisibility(show ? View.VISIBLE : View.GONE);
		}
	}
	
	public class UserLogoutTask extends AsyncTask<Void, Void, Boolean> {
		@Override
		protected Boolean doInBackground(Void... params) {
			// TODO: attempt authentication against a network service.

			try {
				// Simulate network access.
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				return false;
			}

			// TODO: register the new account here.
			return true;
		}

		@Override
		protected void onPostExecute(final Boolean success) {
			mAuthTask = null;

			if (success) {
				Data.IS_LOGED_IN = false;
				Data.USERNAME = null;
				Data.PASSWORD = null;
				startActivity(intent);
				//showProgress(false);
				finish();
			} else {
				//TODO: Something smart	
				
			}
		}

		@Override
		protected void onCancelled() {
			mAuthTask = null;
			showProgress(false);
		}
	}


}
