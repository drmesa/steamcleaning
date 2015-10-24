package com.nothingtothetable.steamcleaning.util.impl;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.nothingtothetable.steamcleaning.domain.Game;
import com.nothingtothetable.steamcleaning.domain.Source;
import com.nothingtothetable.steamcleaning.util.InputReader;

public class GameListReader implements InputReader {

	public List<Game> readGameListFile()
	{
		List<Game> gameList = new ArrayList<Game>();
		//Get file from resources folder
		ClassLoader classLoader = getClass().getClassLoader();
		File file = new File(classLoader.getResource("gameList.txt").getFile());
		
		try(Scanner scanner = new Scanner(file))
		{
			String currLine;
			
			while(scanner.hasNextLine())
			{
				currLine = scanner.nextLine();
				System.out.println(currLine);
				Game test = createGameFromString(currLine);
				gameList.add(test);
				System.out.println(test.getTitle() + ", " + test.getSource());
			}
			
			scanner.close();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		
		return gameList;
	}

	private Game createGameFromString(String gameString)
	{
		String[] gameParts = gameString.split(",");
		
		Game game = new Game();
		
		if(gameParts.length > 1)
		{
			game.setSource(Source.valueOf(gameParts[gameParts.length - 1]));
			String title = "";
			StringBuilder sb = new StringBuilder();
			
			for(int i = 0; i < gameParts.length -1; i++)
			{
				sb.append(gameParts[i]);
			}
			
			title = sb.toString();
			
			game.setTitle(title);
		}
		
		return null;
	}
}
