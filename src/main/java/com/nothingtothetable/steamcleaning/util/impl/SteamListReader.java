package com.nothingtothetable.steamcleaning.util.impl;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import com.nothingtothetable.steamcleaning.domain.Game;
import com.nothingtothetable.steamcleaning.util.InputReader;

public class SteamListReader implements InputReader {

	public List<Game> readGameListFile()
	{
		try(BufferedReader br = new BufferedReader(new FileReader("")))
		{
			
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		
		return null;
	}

	
}
