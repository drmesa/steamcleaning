package com.nothingtothetable.steamcleaning.util.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.google.gson.Gson;
import com.nothingtothetable.steamcleaning.domain.Game;
import com.nothingtothetable.steamcleaning.util.InputReader;

public class GameJSONReader implements InputReader{

	@Override
	public List<Game> readGames()
	{
		List<Game> gameList = new ArrayList<Game>();
		//Get file from resources folder
		ClassLoader classLoader = getClass().getClassLoader();
		File file = new File("F:\\Dan\\gameJSON.txt");
		
		try(Scanner scanner = new Scanner(new FileInputStream(file), "UTF-8"))
		{
			String currLine;
			
			while(scanner.hasNextLine())
			{
				currLine = scanner.nextLine();
				//System.out.println("READ!" + currLine);
				Game game = new Game();
				game = createGameFromJSON(currLine, game);
				gameList.add(game);
				//System.out.println("FROM!: " + test.getTitle() + ", " + test.getSource());
			}
			
			scanner.close();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		
		return gameList;
	}

	private Game createGameFromJSON(String currLine, Game test)
	{
		Gson gson = new Gson();
		test = gson.fromJson(currLine, Game.class);
		//System.out.println("Title " + test.getTitle());
		
		return test;
	}

}
/*
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

	public List<Game> readGames()
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
				Game test = new Game();
				createGameFromString(currLine, test);
				gameList.add(test);
				//System.out.println(test.getTitle() + ", " + test.getSource());
			}
			
			scanner.close();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		
		return gameList;
	}

	private Game createGameFromString(String gameString, Game game)
	{
		String[] gameParts = gameString.split(",");
		
		//Game game = new Game();
		
		if(gameParts.length > 1)
		{
			game.setSource(Source.get(gameParts[gameParts.length - 1]));
			String title = "";
			StringBuilder sb = new StringBuilder();
			
			for(int i = 0; i < gameParts.length -1; i++)
			{
				sb.append(gameParts[i]);
			}
			
			title = sb.toString();
			
			game.setTitle(title);
		}
		
		return game;
	}
}

*/