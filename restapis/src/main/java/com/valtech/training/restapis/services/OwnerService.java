package com.valtech.training.restapis.services;

import java.util.List;

import com.valtech.training.restapis.vos.OwnerVO;

public interface OwnerService {

	OwnerVO createOwner(OwnerVO o);

	List<OwnerVO> getOwners();

	OwnerVO getOwner(Long id);

	OwnerVO updateOwner(Long id, OwnerVO o);

	OwnerVO addWatchesToOwner(long id, List<Long> watches);

}