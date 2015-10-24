package com.nothingtothetable.steamcleaning.domain;

public enum Source {
	STEAM_DANIEL("Steam(Dan)"),
	STEAM_DAVID("Steam(David)"),
	STEAM_LEE("Steam(Lee)"),
	ORIGIN_DANIEL("Origin(Dan)");
	
	private String source;
	
	Source(String source)
	{
		this.source = source;
	}

	public String getSource()
	{
		return source;
	}
}