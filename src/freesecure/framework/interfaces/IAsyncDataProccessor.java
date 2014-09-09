package freesecure.framework.interfaces;

import org.json.JSONArray;

public interface IAsyncDataProccessor {
	
	
	void onPreProcess();
	
	void onProcessComplete(boolean successful);

	void processAsyncData(JSONArray jsonArray);
	
	void processAsyncDataError(Exception exception);
}
