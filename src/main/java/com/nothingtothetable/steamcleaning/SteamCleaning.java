package com.nothingtothetable.steamcleaning;

import java.util.List;
import java.util.Random;

import com.nothingtothetable.steamcleaning.domain.Game;
import com.nothingtothetable.steamcleaning.util.InputReader;
import com.nothingtothetable.steamcleaning.util.impl.GameListReader;

public class SteamCleaning {

	public static void main(String[] args) {
		InputReader ir = new GameListReader();
		
		List<Game> gamesList = ir.readGameListFile();
		
		Random rand = new Random(System.currentTimeMillis());
		int index = rand.nextInt(gamesList.size());
		
		System.out.println("bzzt");
		System.out.println("ding!");
		System.out.println("next game is");
		System.out.println("...");
		System.out.println(gamesList.get(index).getTitle());
		System.out.println("located in");
		System.out.println(gamesList.get(index).getSource());
		System.out.println("enjoy!");
		System.out.println("bzzt");
	}

}
