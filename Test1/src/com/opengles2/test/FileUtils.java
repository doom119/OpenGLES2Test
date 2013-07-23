package com.opengles2.test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import android.content.Context;

public class FileUtils 
{
	public static String loadFileFromAssets(Context context, String filename)
	{
		String content = "";
		BufferedReader reader = null;
		try 
		{
			InputStream inStream = context.getResources().getAssets().open(filename);
			reader = new BufferedReader(new InputStreamReader(inStream));
			String tempStr = null;
			while((tempStr = reader.readLine()) != null)
			{
				content += tempStr;
			}
			reader.close();
		} 
		catch (FileNotFoundException e) 
		{
			e.printStackTrace();
		} 
		catch (IOException e)
		{
			e.printStackTrace();
		}
		return content;
	}

}
