package freesecure.framework.interfaces;

import org.json.JSONArray;

public interface IAsyncDataProccessor {

	void processAsyncData(JSONArray jsonArray);
	
	void processAsyncDataError(Exception exception);
}
