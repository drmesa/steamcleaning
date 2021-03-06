package com.nothingtothetable.steamcleaning;

import java.util.Date;
import java.util.List;
import java.util.Random;

import com.nothingtothetable.steamcleaning.domain.Game;
import com.nothingtothetable.steamcleaning.filter.GameFilter;
import com.nothingtothetable.steamcleaning.util.InputReader;
import com.nothingtothetable.steamcleaning.util.OutputWriter;
import com.nothingtothetable.steamcleaning.util.impl.GameJSONReader;
import com.nothingtothetable.steamcleaning.util.impl.GameJSONWriter;

public class SteamCleaning {

	public static void main(String[] args) {
		InputReader ir = new GameJSONReader();
		
		List<Game> gamesList = ir.readGames();
		
		GameFilter filter = new GameFilter();
		
		filter.setMinPlayed(0);
		filter.setMaxPlayed(10);
		filter.setRatingThreshold(0.0);
		
		List<Game> filteredList = filter.filter(gamesList);
		
		Random rand = new Random(System.currentTimeMillis());
		int index = rand.nextInt(filteredList.size());
		
		Game selection = filteredList.get(index);
		
		System.out.println("bzzt");
		System.out.println("ding!");
		System.out.println("next game is");
		System.out.println("...");
		System.out.println(selection.getTitle());
		System.out.println("located in");
		System.out.println(selection.getSource());
		System.out.println("enjoy!");
		System.out.println("bzzt");
		
		if(selection.getFirstPicked() == null)
		{
			selection.setFirstPicked(new Date());
		}
		
		selection.setLastPicked(new Date());
	
		if(selection.getTimesPlayed() == null)
		{
			selection.setTimesPlayed(1);
		}
		else
		{
			int played = selection.getTimesPlayed();
			selection.setTimesPlayed(played + 1);
		}
		
		OutputWriter ow = new GameJSONWriter();
		
		ow.writeGames(gamesList);
	}

}
