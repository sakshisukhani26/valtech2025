package com.valtech.training.streamingservice.services;

import java.util.List;

import com.valtech.training.streamingservice.vos.WebSeriesVO;

public interface WebSeriesService {

	WebSeriesVO saveOrUpdateWebSeries(WebSeriesVO vo);

	WebSeriesVO getWebSeriesById(long id);

	List<WebSeriesVO> getAllWebSeries();

	List<WebSeriesVO> getAllByEpisodeCount(int episodeCount);

	List<WebSeriesVO> getAllByEpisodeDuration(int episodeDuration);

}