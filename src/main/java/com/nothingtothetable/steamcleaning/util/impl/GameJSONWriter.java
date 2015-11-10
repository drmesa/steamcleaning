package com.nothingtothetable.steamcleaning.util.impl;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.List;

import com.google.gson.Gson;
import com.nothingtothetable.steamcleaning.domain.Game;
import com.nothingtothetable.steamcleaning.util.OutputWriter;

public class GameJSONWriter implements OutputWriter {

	@Override
	public void writeGames(List<Game> gameList)
	{
		try
		{
			File fileDir = new File("F:\\Dan\\gameJSON.txt");
			Writer out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fileDir), "UTF8"));
			
			for(Game game : gameList)
			{
				String jsonString = createJSONString(game); 
				//System.out.println(jsonString);
				out.append(jsonString).append("\r\n");	
			}
			
			out.flush();
			out.close();
		}
		catch(IOException e)
		{
			System.out.println(e.getMessage());
		}
		
		
	}
	
	private String createJSONString(Game game)
	{
		Gson gson = new Gson();
		
		
		return gson.toJson(game);
	}
}