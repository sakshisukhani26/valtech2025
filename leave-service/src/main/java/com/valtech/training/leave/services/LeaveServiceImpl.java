package com.valtech.training.leave.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.valtech.training.leave.commons.LeaveStatus;
import com.valtech.training.leave.entities.Leave;
import com.valtech.training.leave.entities.LeaveMaster;
import com.valtech.training.leave.repos.LeaveMasterRepo;
import com.valtech.training.leave.repos.LeaveRepo;
import com.valtech.training.leave.vos.ApproveLeaveVO;
import com.valtech.training.leave.vos.EmployeeVO;
import com.valtech.training.leave.vos.LeaveMasterVO;
import com.valtech.training.leave.vos.LeaveVO;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class LeaveServiceImpl implements LeaveService {

	@Autowired
	private LeaveRepo leaveRepo;
	
	@Autowired
	private LeaveMasterRepo leaveMasterRepo;
	
	@Autowired
	private EmployeeClient employeeClient;
	
	/*
	 * getting the leave by the leaveID
	 * from the leave i get the employeeId using the employeeClient get his manager
	 * check if the manager is valid:
	 *     update the leave master
	 *     set the leave status to approved
	 *     update the leave and return
	 */
	@Override
	public LeaveVO approveLeave(ApproveLeaveVO vo) {
		Leave leave = leaveRepo.getReferenceById(vo.leaveId());
		//we have to call the employeeMicroService to understand the manager.
		long manager = employeeClient.getEmployeeAsManager(leave.getEmployeeId()).managerId();
		System.out.println("manager ----- "+manager);//get from the employee service.
		if(manager == vo.manager()) {
			System.out.println("service impl   ---  "+leaveMasterRepo.findByEmployeeId(leave.getEmployeeId()));
			LeaveMaster lm = leaveMasterRepo.findByEmployeeId(leave.getEmployeeId());
			lm.takeLeaves(leave);
			leaveMasterRepo.save(lm);
			leave.approveLeave(lm,manager);
			leave.updateLeave(vo.comments());
		}else {
			leave.updateLeave("You are not the manager to approves");
		}
		
		leave = leaveRepo.save(leave);
		return LeaveVO.from(leave);
	}
	
	@Override
	public LeaveVO applyLeave(LeaveVO vo) {
		Leave leave = vo.to();
		System.out.println("VO---------"+vo);
		leave.setLeaveStatus(LeaveStatus.APPLIED);
		System.out.println("leaveMasterRepo----------"+leaveMasterRepo.findByEmployeeId(vo.employeeId()));
		leave.checkLeaveApplicationAndUpdateStatus(leaveMasterRepo.findByEmployeeId(vo.employeeId()));
		
		leaveRepo.save(leave);
		return LeaveVO.from(leave);
	}
	
	@Override
	public List<LeaveVO> getLeavesByEmployee(long emp){
		List<Leave> leaves = leaveRepo.findAllByEmployeeId(emp);
		return LeaveVO.to(leaves);
	}
	
	@Override
	public List<LeaveVO> getAllLeaves(){
		return leaveRepo.findAll().stream().map(l -> LeaveVO.from(l)).collect(Collectors.toList());
	}
	
	@Override
	public LeaveVO getLeave(long id) {
		return LeaveVO.from(leaveRepo.getReferenceById(id));
	}
	
	/*
	 * get the fields from leave
	 * save the fields
	 * and return it to leaveVO
	 */
	@Override
	public LeaveVO saveOrUpdateLeave(LeaveVO vo) {
		Leave l = vo.to();
		l = leaveRepo.save(l);
		return LeaveVO.from(l);
	}
	
	@Override
	public List<LeaveMasterVO> getAllLeaveMasters(){
		return leaveMasterRepo.findAll().stream().map(lm -> LeaveMasterVO.from(lm)).collect(Collectors.toList());
		// returning a collection thats why stream
	}
	
	@Override
	public LeaveMasterVO saveOrUpdateLeaveMaster(LeaveMasterVO vo) {
		LeaveMaster lm = vo.to();
		lm = leaveMasterRepo.save(lm);
		return LeaveMasterVO.from(lm);
	}
	
	@Override
	public  LeaveMasterVO getLeaveMaster(long employeeId) {
		LeaveMaster lm = leaveMasterRepo.findByEmployeeId(employeeId);
		return LeaveMasterVO.from(lm);
	}

	@Override
	public LeaveVO update(LeaveVO vo, long id) {
		Leave leave = leaveRepo.getReferenceById(id);
		vo.updateTo(leave);
		leave = leaveRepo.save(leave);
		return LeaveVO.from(leave);
	}

	@Override
	public EmployeeVO getManager(long employeeId) {
		return employeeClient.getEmployeeAsManager(employeeId);
	}
}
