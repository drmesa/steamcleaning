package com.nothingtothetable.steamcleaning.util;

import java.util.List;

import com.nothingtothetable.steamcleaning.domain.Game;

public interface OutputWriter {
	public void writeGames(List<Game> gameList);
}
