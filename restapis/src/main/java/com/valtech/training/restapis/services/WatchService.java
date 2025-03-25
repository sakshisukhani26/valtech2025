package com.valtech.training.restapis.services;

import java.util.List;

import com.valtech.training.restapis.vos.WatchVO;

public interface WatchService {

	WatchVO createWatch(WatchVO w);

	List<WatchVO> getWatches();

	WatchVO updateWatch(long id, WatchVO w);

	WatchVO getWatch(long id);

	List<WatchVO> getWatchesByBrand(String brand);

}