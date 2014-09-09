package freesecure.framework.proccessors;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import freesecure.framework.models.Camera;
import freesecure.framework.interfaces.IActivityDataManager;
import freesecure.framework.interfaces.IAsyncDataProccessor;
import freesecure.framework.models.BaseModel;

public class CameraProcessor implements IAsyncDataProccessor {
	
	IActivityDataManager manager;
	public CameraProcessor(IActivityDataManager manager) {
		this.manager = manager;
	}
	
	@Override
	public void onPreProcess() {
		manager.onPreProcessingData();
	}
	
	@Override
	public void onProcessComplete(boolean successful) {
		manager.onProcessingDataComplete(successful);
	}
	
	@Override
	public void processAsyncData(JSONArray jsonArray) {
		List<BaseModel> modelList = new ArrayList<BaseModel>();
		for (int index = 0; index < jsonArray.length(); index++) {
			try {
				JSONObject model = jsonArray.getJSONObject(index);
				String id = model.getString("Id");
				String name = model.getString("Name");
				boolean active = model.getBoolean("Active");
				Camera cam = new Camera(id, name, active);
				modelList.add(cam);
			} catch (JSONException exception) {
				processAsyncDataError(exception);
			}
		}
		manager.processViewData(modelList);
	}
	
	@Override
	public void processAsyncDataError(Exception exception) {
		manager.onProcessingDataError(exception);
	}

}
