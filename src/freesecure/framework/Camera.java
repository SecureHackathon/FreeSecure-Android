package freesecure.framework;

import java.util.List;
import freesecure.framework.interfaces.IActivityDataManager;
import freesecure.framework.models.BaseModel;
import freesecure.framework.proccessors.CameraProcessor;
import freesecure.framework.utils.AsyncRequest;
import android.app.Activity;
import android.os.Bundle;
import android.widget.Toast;

public class Camera extends Activity implements IActivityDataManager {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cameras);
        loadCameras();
    }
    
	private void loadCameras() {
		CameraProcessor processor = new CameraProcessor(this);
		AsyncRequest asyncRequest = new AsyncRequest(processor);
		asyncRequest.execute("camera");
	}

	@Override
	public void processViewData(List<BaseModel> data) {
		Toast.makeText(getApplicationContext(), "Got some JSON back", Toast.LENGTH_LONG).show();
	}

	@Override
	public void onPreProcessingData() {
		Toast.makeText(getApplicationContext(), "This is the beginning", Toast.LENGTH_LONG).show();
	}

	@Override
	public void onProcessingDataComplete(boolean successful) {
		Toast.makeText(getApplicationContext(), "This processing is complete", Toast.LENGTH_LONG).show();
	}

	@Override
	public void onProcessingDataError(Exception exception) {
		// TODO Auto-generated method stub
		Toast.makeText(getApplicationContext(), exception.getMessage(), Toast.LENGTH_LONG).show();
	}
}
