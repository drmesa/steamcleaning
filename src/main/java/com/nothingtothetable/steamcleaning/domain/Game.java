package com.nothingtothetable.steamcleaning.domain;

import java.util.Date;

public class Game {
	private String title;
	private Source source;
	private Integer timesPlayed;
	private Double rating;
	private Date firstPicked;
	private Date lastPicked;

	public String getTitle()
	{
		return title;
	}

	public void setTitle(String title)
	{
		this.title = title;
	}

	public Source getSource()
	{
		return source;
	}

	public void setSource(Source source)
	{
		this.source = source;
	}

	public Integer getTimesPlayed()
	{
		return timesPlayed;
	}

	public void setTimesPlayed(Integer timesPlayed)
	{
		this.timesPlayed = timesPlayed;
	}

	public Double getRating()
	{
		return rating;
	}

	public void setRating(Double rating)
	{
		this.rating = rating;
	}

	public Date getFirstPicked()
	{
		return firstPicked;
	}

	public void setFirstPicked(Date firstPicked)
	{
		this.firstPicked = firstPicked;
	}

	public Date getLastPicked()
	{
		return lastPicked;
	}

	public void setLastPicked(Date lastPicked)
	{
		this.lastPicked = lastPicked;
	}
}