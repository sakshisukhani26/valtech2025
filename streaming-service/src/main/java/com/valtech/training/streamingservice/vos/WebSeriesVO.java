package com.valtech.training.streamingservice.vos;

import com.valtech.training.streamingservice.entities.WebSeries;

public record WebSeriesVO(long id,String name,String genre,String language,long costPerView,int episodeCount,long episodeDuration) {
	
	public static WebSeriesVO from(WebSeries w) {
		return new WebSeriesVO(w.getId(),w.getName(),w.getGenre(),w.getLanguage(),w.getCostPerView(),w.getEpisodeCount(),w.getEpisodeDuration());
	}
	
	public WebSeries to() {
		return new WebSeries(name,genre,language,costPerView,episodeCount,episodeDuration);
	}

}
