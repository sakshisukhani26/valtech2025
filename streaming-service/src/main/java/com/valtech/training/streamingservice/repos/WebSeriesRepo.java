package com.valtech.training.streamingservice.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.valtech.training.streamingservice.entities.WebSeries;

public interface WebSeriesRepo extends JpaRepository<WebSeries, Long>{

	List<WebSeries> findAllByEpisodeCount(int episodeCount);
	List<WebSeries> findAllByEpisodeDuration(long episodeDuration);
}
