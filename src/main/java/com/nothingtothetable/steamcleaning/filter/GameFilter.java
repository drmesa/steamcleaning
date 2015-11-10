package com.nothingtothetable.steamcleaning.filter;

import java.util.ArrayList;
import java.util.List;

import com.nothingtothetable.steamcleaning.domain.Game;

public class GameFilter 
{
	private Double ratingThreshold = .5;
	private Integer maxPlayed = 10;
	private Integer minPlayed = 0;
	
	public List<Game> filter(List<Game> gameList)
	{
		List<Game> filteredList = new ArrayList<Game>();
		
		for(Game game : gameList)
		{
			if(passesRatingThreshold(game) && inPlayedRange(game))
			{
				filteredList.add(game);
			}
		}
		
		return filteredList;
	}
	
	private boolean passesRatingThreshold(Game game)
	{
		if(game.getRating() == null)
		{
			game.setRating(0.0);
		}
		
		if(game.getRating() >= ratingThreshold)
		{
			return true;
		}
		
		return false;
	}
	
	private boolean inPlayedRange(Game game)
	{
		if(game.getTimesPlayed() == null)
		{
			game.setTimesPlayed(0);
		}
		
		if(game.getTimesPlayed() >= minPlayed && (maxPlayed == 0 || game.getTimesPlayed() < maxPlayed))
		{
			return true;
		}
	
		return false;
	}

	public Double getRatingThreshold()
	{
		return ratingThreshold;
	}

	public void setRatingThreshold(Double ratingThreshold)
	{
		this.ratingThreshold = ratingThreshold;
	}

	public Integer getMaxPlayed()
	{
		return maxPlayed;
	}

	public void setMaxPlayed(Integer maxPlayed)
	{
		this.maxPlayed = maxPlayed;
	}

	public Integer getMinPlayed()
	{
		return minPlayed;
	}

	public void setMinPlayed(Integer minPlayed)
	{
		this.minPlayed = minPlayed;
	}
}
