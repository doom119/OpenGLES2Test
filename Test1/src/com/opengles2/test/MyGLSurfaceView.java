package com.opengles2.test;

import android.content.Context;
import android.opengl.GLSurfaceView;

public class MyGLSurfaceView extends GLSurfaceView {

	public MyGLSurfaceView(Context context) {
		super(context);
		
		this.setEGLContextClientVersion(2);
		this.setRenderer(new MyRenderer());
	}

}
