package freesecure.framework;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        ImageView detection_image = (ImageView)findViewById(R.id.detection_image);
        detection_image.setOnClickListener(detectionOnClickListener());
        
        ImageView camera_image = (ImageView)findViewById(R.id.cameras_image);
        camera_image.setOnClickListener(cameraOnClickListener());
        
    }
    
    private OnClickListener detectionOnClickListener() {
    	return new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(getApplicationContext(), Detection.class);
		    	startActivity(intent);
			}
		};
    }
    
    private OnClickListener cameraOnClickListener() {
    	return new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(getApplicationContext(), Camera.class);
		    	startActivity(intent);
			}
		};
    	
    }
       
}
