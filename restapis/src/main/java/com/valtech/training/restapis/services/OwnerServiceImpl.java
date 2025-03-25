package com.valtech.training.restapis.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.valtech.training.restapis.entities.Owner;
import com.valtech.training.restapis.repos.OwnerRepo;
import com.valtech.training.restapis.repos.WatchRepo;
import com.valtech.training.restapis.vos.OwnerVO;
import com.valtech.training.restapis.vos.WatchVO;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class OwnerServiceImpl implements OwnerService {
	
	@Autowired
	private OwnerRepo ownerRepo;
	
	@Autowired
	private WatchRepo watchRepo;
	
	
	/*
	 * from OwnerVO get the owner
	 * create Owner on DB
	 * create OwnerVO from owner
	 * return OwnerVO
	 */
	@Override
	public OwnerVO createOwner(OwnerVO o) {
		return OwnerVO.from(ownerRepo.save(o.toOwner()));
	}
	/*
	 * Get Owners from Owner
	 * get the ownerVO from owner
	 * 
	 */
	@Override
	public List<OwnerVO> getOwners(){
		return OwnerVO.toOwnerVO(ownerRepo.findAll());
	}
	
	@Override
	public OwnerVO getOwner(Long id) {
		return OwnerVO.from(ownerRepo.getReferenceById(id));
	}
	
	/*
	 * get the owner from db
	 * set the owner to OwnerVO
	 * save the 
	 */
	@Override
	public OwnerVO updateOwner(Long id , OwnerVO o) {
		Owner owner = ownerRepo.getReferenceById(id);
		o.updateWatchFromVO(owner);
		return OwnerVO.from(ownerRepo.save(owner));
	}
	@Override
	public OwnerVO addWatchesToOwner(long id, List<Long> watches) {
		Owner owner = ownerRepo.getReferenceById(id);
		watches.stream().forEach(wid -> owner.addWatch(watchRepo.getReferenceById(wid)));
		Owner owner1 = ownerRepo.save(owner);
		return OwnerVO.from(owner1);
	}

}
