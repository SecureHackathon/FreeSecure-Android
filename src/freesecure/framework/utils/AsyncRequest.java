package freesecure.framework.utils;

import org.json.JSONArray;

import freesecure.framework.interfaces.IAsyncDataProccessor;

import android.os.AsyncTask;

public class AsyncRequest extends AsyncTask<String, String, JSONArray> {

	IAsyncDataProccessor processor;
	public AsyncRequest(IAsyncDataProccessor processor) {
		this.processor = processor;
	}
	
	@Override
	protected JSONArray doInBackground(String... params) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	protected void onPostExecute(JSONArray json) { 
		try {
			processor.processAsyncData(json);
		} catch (Exception exception) {
			processor.processAsyncDataError(exception);
		}
	}

}