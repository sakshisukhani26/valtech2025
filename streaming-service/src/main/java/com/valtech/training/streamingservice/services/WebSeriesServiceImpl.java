package com.valtech.training.streamingservice.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.valtech.training.streamingservice.entities.WebSeries;
import com.valtech.training.streamingservice.repos.WebSeriesRepo;
import com.valtech.training.streamingservice.vos.WebSeriesVO;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class WebSeriesServiceImpl implements WebSeriesService {

	@Autowired
	private WebSeriesRepo webSeriesRepo;
	
	@Override
	public WebSeriesVO saveOrUpdateWebSeries(WebSeriesVO vo) {
		WebSeries ws = vo.to();
		webSeriesRepo.save(ws);
		return WebSeriesVO.from(ws);
	}
	
	@Override
	public WebSeriesVO getWebSeriesById(long id) {
		return WebSeriesVO.from(webSeriesRepo.getReferenceById(id));
	}
	
	@Override
	public List<WebSeriesVO> getAllWebSeries(){
		return webSeriesRepo.findAll().stream().map(ws -> WebSeriesVO.from(ws)).collect(Collectors.toList());
	}
	
	@Override
	public List<WebSeriesVO> getAllByEpisodeCount(int episodeCount){
		return webSeriesRepo.findAllByEpisodeCount(episodeCount).stream().map(ws -> WebSeriesVO.from(ws)).collect(Collectors.toList());
	}
	
	@Override
	public List<WebSeriesVO> getAllByEpisodeDuration(int episodeDuration){
		return webSeriesRepo.findAllByEpisodeDuration(episodeDuration).stream().map(ws -> WebSeriesVO.from(ws)).collect(Collectors.toList());
	}
}
