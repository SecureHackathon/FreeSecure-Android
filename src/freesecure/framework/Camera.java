package freesecure.framework;

import org.json.JSONArray;

import freesecure.framework.interfaces.IAsyncDataProccessor;
import freesecure.framework.utils.AsyncRequest;
import android.app.Activity;
import android.os.Bundle;
import android.widget.Toast;

public class Camera extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cameras);
        loadCameras();
    }
    
	private void loadCameras() {
		
		IAsyncDataProccessor dataproccessor = new IAsyncDataProccessor() {
			
			@Override
			public void processAsyncDataError(Exception exception) {
				Toast.makeText(getApplicationContext(), exception.getMessage(), Toast.LENGTH_LONG);
			}
			
			@Override
			public void processAsyncData(JSONArray jsonArray) {
				Toast.makeText(getApplicationContext(), "Got some JSON back", Toast.LENGTH_LONG);
			}
		};
		
		AsyncRequest asyncRequest = new AsyncRequest(dataproccessor);
		asyncRequest.execute("camera");
	}
}
