package com.opengles2.test;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

import android.opengl.GLES20;

public class Square
{
	private int mVertexShader;
	private int mFragmentShader;
	private float vertexCoords[] = {
			-0.5f, 0.5f, 0.0f,
			-0.5f, -0.5f, 0.0f, 
			0.5f, 0.5f, 0.0f,
			0.5f, 0.5f, 0.0f,
			-0.5f, -0.5f, 0.0f,
			0.5f, -0.5f, 0.0f
	};
	private FloatBuffer mVertexBuffer;
	
	public Square(int program)
	{
		ByteBuffer bb = ByteBuffer.allocateDirect(vertexCoords.length*4);
		bb.order(ByteOrder.nativeOrder());
		mVertexBuffer = bb.asFloatBuffer();
		mVertexBuffer.put(vertexCoords);
		mVertexBuffer.position(0);
		
		mVertexShader = MyRenderer.loadShaderFromAssets(GLES20.GL_VERTEX_SHADER, "vertex_shader_1.glsl");
		mFragmentShader = MyRenderer.loadShaderFromAssets(GLES20.GL_FRAGMENT_SHADER, "fragment_shader_1.glsl");
		
		
	}
	
	public void draw(int program)
	{
		GLES20.glUseProgram(program);
		
		int vertexHandle = GLES20.glGetAttribLocation(program, "a_position");
		GLES20.glEnableVertexAttribArray(vertexHandle);
		GLES20.glVertexAttribPointer(vertexHandle, 3, GLES20.GL_FLOAT, false, 0, mVertexBuffer);
		
		GLES20.glDrawArrays(GLES20.GL_TRIANGLES, 0, 2);
		
		GLES20.glDisableVertexAttribArray(vertexHandle);
	}
}
