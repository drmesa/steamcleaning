package com.nothingtothetable.steamcleaning.util;

import java.util.List;

import com.nothingtothetable.steamcleaning.domain.Game;

public interface InputReader {
	public List<Game> readGameListFile();
}
