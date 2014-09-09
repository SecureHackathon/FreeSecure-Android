package freesecure.framework.interfaces;

import java.util.List;

import freesecure.framework.models.BaseModel;

public interface IActivityDataManager {
	
	void onPreProcessingData();
	
	void processViewData(List<BaseModel> data);
	
	void onProcessingDataError(Exception exception);
	
	void onProcessingDataComplete(boolean successful);

}
