package freesecure.framework.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;
import org.json.JSONException;

public class FreeSecureHttpRequest {
	
	private String endpointUrl;
	private String url = "http://freesecure.apphb.com/api/";
	private HttpUriRequest request = null;
	
	public FreeSecureHttpRequest(String endpointUrl) {
		this.endpointUrl = endpointUrl;
	}
	
	public JSONArray requestJson() {
		
		request = new HttpGet(url+endpointUrl);
		HttpClient httpclient = new DefaultHttpClient();
		HttpResponse response = null;
		String json = null;
		
		try {
			 response = httpclient.execute(request);
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
		
		try {
			  InputStream content = response.getEntity().getContent(); 
		      BufferedReader reader = new BufferedReader(new InputStreamReader(
		         content , "iso-8859-1"), 8);
		      StringBuilder sb = new StringBuilder();
		      String line = null;
		      while ((line = reader.readLine()) != null) {
		        sb.append(line + "n");
		      }
		      content.close();
		      json = sb.toString();
		    } catch (Exception e) {
		     e.printStackTrace();
		     return null;
	    }
		
	    try {
		      return new JSONArray(json);
		    } catch (JSONException e) {
		      return null;
		}
	}		

}
