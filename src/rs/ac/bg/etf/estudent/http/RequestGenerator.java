package rs.ac.bg.etf.estudent.http;

import java.util.ArrayList;
import java.util.Map;

import org.jboss.resteasy.client.ClientRequest;
import org.jboss.resteasy.client.ClientResponse;

import rs.ac.bg.etf.estudent.fragment.BaseFragment;
import rs.ac.bg.etf.estudent.util.Constants;
import android.util.Log;

public class RequestGenerator {

	public static ArrayList<Map<String, String>> getObavestenja(
			final BaseFragment frag) {

		try {

			Log.i("RequestGenerator", "getObavestenja");
			ClientRequest request = new ClientRequest(Constants.PATH
					+ Constants.OBAVESTENJA + "102138");
			request.header("Accept", "application/json;");
			request.header("Content-Type", "application/json;");
			request.header("Authorization", "Basic ZXN0dWRlbnQ6YW5kcm9pZA==;");
			ClientResponse<String> response = request.get(String.class);

			if (response.getStatus() != 200) {
				throw new RuntimeException("Failed : HTTP error code : "
						+ response.getStatus());
			}

			return ResponseHandler.handleResponseObavestenja(response);

		} catch (final Exception e) {

			Log.e("greska", e.getMessage());
			frag.postToast(e.getMessage());
		}
		return new ArrayList<Map<String, String>>();
	}

	public static ArrayList<Map<String, String>> getSkolarine(BaseFragment frag) {
		try {

			Log.i("RequestGenerator", "getSkolarine");
			/*
			 * ClientRequest request = new ClientRequest(Constants.PATH +
			 * Constants.SKOLARINE + "102138"); request.header("Accept",
			 * "application/json;"); request.header("Content-Type",
			 * "application/json;"); request.header("Authorization",
			 * "Basic ZXN0dWRlbnQ6YW5kcm9pZA==;"); ClientResponse<String>
			 * response = request.get(String.class);
			 * 
			 * if (response.getStatus() != 200) { throw new
			 * RuntimeException("Failed : HTTP error code : " +
			 * response.getStatus()); }
			 */
			return ResponseHandler.handleResponseSkolarine();// response);

		} catch (final Exception e) {

			Log.e("greska", e.getMessage());
			frag.postToast(e.getMessage());
		}
		return new ArrayList<Map<String, String>>();
	}

	public static ArrayList<Map<String, String>> getUplate(BaseFragment frag) {
		try {

			Log.i("RequestGenerator", "getUplate");
			ClientRequest request = new ClientRequest(Constants.PATH
					+ Constants.UPLATE + "102138");
			request.header("Accept", "application/json;");
			request.header("Content-Type", "application/json;");
			request.header("Authorization", "Basic ZXN0dWRlbnQ6YW5kcm9pZA==;");
			ClientResponse<String> response = request.get(String.class);

			if (response.getStatus() != 200) {
				throw new RuntimeException("Failed : HTTP error code : "
						+ response.getStatus());
			}

			return ResponseHandler.handleResponseUplate(response);

		} catch (final Exception e) {

			Log.e("greska", e.getMessage());
			frag.postToast(e.getMessage());
		}
		return new ArrayList<Map<String, String>>();
	}

	public static ArrayList<Map<String, String>> getStanje(BaseFragment frag) {
		try {

			Log.i("RequestGenerator", "getStanje");
			ClientRequest request = new ClientRequest(Constants.PATH
					+ Constants.STANJE + "102138");
			request.header("Accept", "application/json;");
			request.header("Content-Type", "application/json;");
			request.header("Authorization", "Basic ZXN0dWRlbnQ6YW5kcm9pZA==;");
			ClientResponse<String> response = request.get(String.class);

			if (response.getStatus() != 200) {
				throw new RuntimeException("Failed : HTTP error code : "
						+ response.getStatus());
			}

			return ResponseHandler.handleResponseStanje(response);

		} catch (final Exception e) {

			Log.e("greska", e.getMessage());
			frag.postToast(e.getMessage());
		}
		return new ArrayList<Map<String, String>>();
	}
}
