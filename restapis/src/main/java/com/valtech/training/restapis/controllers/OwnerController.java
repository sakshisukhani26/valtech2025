package com.valtech.training.restapis.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.valtech.training.restapis.entities.Owner;
import com.valtech.training.restapis.services.OwnerService;
import com.valtech.training.restapis.vos.OwnerVO;

@RestController
@RequestMapping("/api/v1/owners")
public class OwnerController {

	@Autowired
	private OwnerService ownerService;
	
	@PutMapping("/{id}/watches")
	public OwnerVO updateWatches(@PathVariable("id") long id,@RequestBody List<Long> watches) {
		return ownerService.addWatchesToOwner(id,watches);
	}
	
	
	@PostMapping("/")
	public OwnerVO createOwner(@RequestBody OwnerVO owner) {
		return ownerService.createOwner(owner);
	}
	
	@GetMapping("/{id}")
	public OwnerVO getOwner(@PathVariable("id") long id) {
		return ownerService.getOwner(id);
	}
	
	@PutMapping("/{id}")
	public OwnerVO updateOwner(@PathVariable("id") long id,@RequestBody OwnerVO owner) {
		return ownerService.updateOwner(id, owner);
	}
	
	@GetMapping("/")
	public List<OwnerVO> getOwners() {
		return ownerService.getOwners();
	}
	
	@DeleteMapping
	public void deleteOwner(long id) {
		
	}
}
