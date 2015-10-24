package com.nothingtothetable.steamcleaning;

import com.nothingtothetable.steamcleaning.util.InputReader;
import com.nothingtothetable.steamcleaning.util.impl.GameListReader;

public class SteamCleaning {

	public static void main(String[] args) {
		InputReader ir = new GameListReader();
		
		ir.readGameListFile();
	}

}
