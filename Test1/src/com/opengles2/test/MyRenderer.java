package com.opengles2.test;

import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

import android.content.Context;
import android.opengl.GLES20;
import android.opengl.GLSurfaceView.Renderer;
import android.util.Log;

public class MyRenderer implements Renderer
{
	private static Context mContext;
	private int mProgram;
	private Square mSquare;

	public MyRenderer(Context context)
	{
		mContext = context;
	}

	@Override
	public void onDrawFrame(GL10 gl)
	{
		GLES20.glClear(GLES20.GL_COLOR_BUFFER_BIT | GLES20.GL_DEPTH_BUFFER_BIT);

		mSquare.draw(mProgram);
	}

	@Override
	public void onSurfaceChanged(GL10 gl, int width, int height)
	{
		GLES20.glViewport(0, 0, width, height);
	}

	@Override
	public void onSurfaceCreated(GL10 gl, EGLConfig config)
	{
		GLES20.glClearColor(0.0f, 0.0f, 0.0f, 1.0f);

		int program = GLES20.glCreateProgram();
		Log.d("MyRenderer", "onSurfaceCreated,program" + program);

		if (program != 0)
		{
			mSquare = new Square(program);
		}

		GLES20.glLinkProgram(program);
		GLES20.glUseProgram(program);

		mProgram = program;
	}

	public static int loadShaderFromAssets(int type, String filename)
	{
		int shader = -1;
		String shaderContent = FileUtils.loadFileFromAssets(mContext, filename);
		shader = GLES20.glCreateShader(type);
		if (shader != 0)
		{
			GLES20.glShaderSource(shader, shaderContent);
			GLES20.glCompileShader(shader);
		}
		Log.d("MyRenderer", "loadShader,shader:" + shader);
		return shader;
	}

	public static int loadTextureFromResource(int resId)
	{
		int handle = TexUtils.loadTextureFromResource(mContext, resId);
		Log.d("MyRenderer", "loadTextureFromResource, texture data handle:"
				+ handle);
		return handle;
	}

}
