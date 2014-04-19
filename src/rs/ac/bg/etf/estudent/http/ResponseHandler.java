package rs.ac.bg.etf.estudent.http;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.jboss.resteasy.client.ClientResponse;

import rs.ac.bg.etf.estudnet.beans.Bean;
import android.util.Log;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.TypeFactory;

public class ResponseHandler {

	public static ArrayList<Map<String, String>> handleResponseObavestenja(
			ClientResponse<String> response) {
		ArrayList<Map<String, String>> infoList = null;

		Log.i("ResponseHandler", "handleResponseObavestenja");

		try {

			ObjectMapper mapper = new ObjectMapper();

			TypeFactory typeFactory = mapper.getTypeFactory();

			infoList = mapper.readValue(response.getEntity(), typeFactory
					.constructCollectionType(ArrayList.class, HashMap.class));

		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return infoList;
	}

	public static ArrayList<Map<String, String>> handleResponseSkolarine() {// ClientResponse<String>
																			// response)
																			// {
		String responseHard = "[{\"upis\": { \"skolskaGodina\": \"2011/12\",\"godinaStudija\": \"3\",\"statusUpisa\": \"С\","
				+ "\"nacinUpisa\": \"стандардно\",\"akronimProfil\": \"ИР 2006\",\"nazivProfil\": \"модул Рачунарска техника и информатика\","
				+ "\"datumUpisa\": null,\"espbOsvojeno\": null,\"kojiPut\": 2},\"rata\": 1,\"brojRata\": 1,\"iznos\": 0,"
				+ "\"rokUplate\": \"01.10.2011.\"},{\"upis\": { \"skolskaGodina\": \"2011/12\",\"godinaStudija\": \"3\",\"statusUpisa\": \"С\","
				+ "\"nacinUpisa\": \"стандардно\",\"akronimProfil\": \"ИР 2006\",\"nazivProfil\": \"модул Рачунарска техника и информатика\","
				+ "\"datumUpisa\": null,\"espbOsvojeno\": null,\"kojiPut\": 2},\"rata\": 1,\"brojRata\": 1,\"iznos\": 0,"
				+ "\"rokUplate\": \"01.10.2011.\"},{\"upis\": { \"skolskaGodina\": \"2011/12\",\"godinaStudija\": \"3\",\"statusUpisa\": \"С\","
				+ "\"nacinUpisa\": \"стандардно\",\"akronimProfil\": \"ИР 2006\",\"nazivProfil\": \"модул Рачунарска техника и информатика\","
				+ "\"datumUpisa\": null,\"espbOsvojeno\": null,\"kojiPut\": 2},\"rata\": 1,\"brojRata\": 1,\"iznos\": 0,"
				+ "\"rokUplate\": \"01.10.2011.\"},{\"upis\": { \"skolskaGodina\": \"2011/12\",\"godinaStudija\": \"3\",\"statusUpisa\": \"С\","
				+ "\"nacinUpisa\": \"стандардно\",\"akronimProfil\": \"ИР 2006\",\"nazivProfil\": \"модул Рачунарска техника и информатика\","
				+ "\"datumUpisa\": null,\"espbOsvojeno\": null,\"kojiPut\": 2},\"rata\": 1,\"brojRata\": 1,\"iznos\": 0,"
				+ "\"rokUplate\": \"01.10.2011.\"}]";

		Log.i("ResponseHandler", "handleResponseSkolarine");
		ArrayList<Map<String, String>> scholarList = new ArrayList<Map<String, String>>();

		try {
			ObjectMapper mapper = new ObjectMapper();

			JsonFactory f = new JsonFactory();
			JsonParser jp = f.createParser(responseHard);

			jp.nextToken();
			while (jp.nextToken() == JsonToken.START_OBJECT) {
				Bean bean = mapper.readValue(jp, Bean.class);
				scholarList.add(bean.getMap());
			}
		} catch (JsonParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return scholarList;
	}

	public static ArrayList<Map<String, String>> handleResponseUplate(
			ClientResponse<String> response) {
		ArrayList<Map<String, String>> payList = null;

		Log.i("ResponseHandler", "handleResponseUplate");
		try {

			ObjectMapper mapper = new ObjectMapper();

			TypeFactory typeFactory = mapper.getTypeFactory();

			payList = mapper.readValue(response.getEntity(), typeFactory
					.constructCollectionType(ArrayList.class, HashMap.class));

		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return payList;
	}

	public static ArrayList<Map<String, String>> handleResponseStanje(
			ClientResponse<String> response) {
		ArrayList<Map<String, String>> accList = null;

		Log.i("ResponseHandler", "handleResponseStanje");

		try {

			ObjectMapper mapper = new ObjectMapper();

			TypeFactory typeFactory = mapper.getTypeFactory();

			accList = mapper.readValue(response.getEntity(), typeFactory
					.constructCollectionType(ArrayList.class, HashMap.class));

		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return accList;
	}
}
