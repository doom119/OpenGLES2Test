package com.opengles2.test;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.opengl.GLES20;
import android.opengl.GLUtils;

public class TexUtils
{
	public static int loadTextureFromResource(Context context, int resId)
	{
		final int textureHandle[] = new int[1];
		
		GLES20.glGenTextures(1, textureHandle, 0);
		if(textureHandle[0] != 0)
		{
			final BitmapFactory.Options op = new BitmapFactory.Options();
			op.inScaled = false;
			final Bitmap bmp = BitmapFactory.decodeResource(context.getResources(), resId, op);
			
			GLES20.glBindTexture(GLES20.GL_TEXTURE_2D, textureHandle[0]);
			
			GLES20.glTexParameteri(GLES20.GL_TEXTURE_2D, GLES20.GL_TEXTURE_MIN_FILTER, GLES20.GL_NEAREST);
			GLES20.glTexParameteri(GLES20.GL_TEXTURE_2D, GLES20.GL_TEXTURE_MAG_FILTER, GLES20.GL_NEAREST);
			
			GLUtils.texImage2D(GLES20.GL_TEXTURE_2D, 0, bmp, 0);
		}
		else
		{
			throw new RuntimeException("Error Loading Texture");
		}
		
		return textureHandle[0];
	}
}
