package com.opengles2.test;

import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.Menu;

public class MainActivity extends Activity {

	private MyGLSurfaceView mView;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		mView = new MyGLSurfaceView(getApplicationContext());
		setContentView(mView);

	}
	
	@Override
	protected void onPause() {
		super.onPause();
		
		mView.onPause();
	}
	
	@Override
	protected void onResume() {
		super.onResume();
		
		mView.onResume();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
