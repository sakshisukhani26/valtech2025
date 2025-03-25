package com.valtech.training.streamingservice.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.valtech.training.streamingservice.services.WebSeriesService;
import com.valtech.training.streamingservice.vos.WebSeriesVO;

@RestController
@RequestMapping("/api/v1/WebSeries")
public class WebServiceController {

	@Autowired
	private WebSeriesService webSeriesService;
	
	@PostMapping("/")
	public WebSeriesVO createWebSeries(@RequestBody WebSeriesVO vo) {
		return webSeriesService.saveOrUpdateWebSeries(vo);
	}
	
	@GetMapping("/{id}")
	public WebSeriesVO findWebSeriesById(@PathVariable long id) {
		return webSeriesService.getWebSeriesById(id);
	}
	
	@GetMapping("/")
	public List<WebSeriesVO> findAllWebSeries(){
		return webSeriesService.getAllWebSeries();
	}
}
