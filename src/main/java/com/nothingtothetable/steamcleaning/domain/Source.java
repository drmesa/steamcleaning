package com.nothingtothetable.steamcleaning.domain;

import java.util.HashMap;
import java.util.Map;

public enum Source {
	STEAM_DANIEL("Steam(Dan)"),
	STEAM_DAVID("Steam(David)"),
	STEAM_LEE("Steam(Lee)"),
	STEAM_MIN("Steam(Min)"),
	ORIGIN_DANIEL("Origin(Dan)"),
	BATTLENET_DANIEL("Battle.Net(Dan)");
	
	private String sourceString;
	
	Source(String source)
	{
		this.sourceString = source;
	}

	public String getSourceString()
	{
		return sourceString;
	}
	
	private static final Map<String, Source> lookup = new HashMap<String, Source>();
	
	static 
	{
		for(Source s : Source.values())
		{
			lookup.put(s.getSourceString(), s);
		}
	}
	
	public static Source get(String source)
	{
		return lookup.get(source);
	}
}


/*


private static EnumLookerUpper<InventoryCampaignCode> HELPER = new EnumLookerUpper<InventoryCampaignCode>(InventoryCampaignCode.class);
@FactoryMethod
	public static InventoryCampaignCode lookup(String campaignName)
	{
		return HELPER.lookup(campaignName);
	}
*/