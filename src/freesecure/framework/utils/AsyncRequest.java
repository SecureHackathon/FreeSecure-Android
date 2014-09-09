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
	public void onPreExecute() {
		processor.onPreProcess();
	}
	
	@Override
	protected JSONArray doInBackground(String... params) {
		return new FreeSecureHttpRequest(params[0]).requestJson();
	}
	
	@Override
	protected void onPostExecute(JSONArray json) {
		boolean successful = true;
		try {
			processor.processAsyncData(json);
		} catch (Exception exception) {
			successful = false;
			processor.processAsyncDataError(exception);
		}
		processor.onProcessComplete(successful);
	}

}
