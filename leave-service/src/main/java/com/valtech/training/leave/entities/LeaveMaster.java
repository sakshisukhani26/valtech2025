package com.valtech.training.leave.entities;

import java.time.temporal.ChronoUnit;

import com.valtech.training.leave.commons.LeaveType;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;

@Entity
public class LeaveMaster {

	@Id @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "leave_seq")
	@SequenceGenerator(name = "leave_seq",sequenceName = "leave_seq",allocationSize = 1)
	private long id;
	private int casualLeaves;
	private int sickLeave;
	private int otherLeaves;
	private long employeeId;
	
	public LeaveMaster() {}

	public LeaveMaster(long id, int casualLeaves, int sickLeave, int otherLeaves,long empId) {
		this.id = id;
		this.casualLeaves = casualLeaves;
		this.sickLeave = sickLeave;
		this.otherLeaves = otherLeaves;
		this.employeeId = empId;
	}

	public long getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(long employeeId) {
		this.employeeId = employeeId;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getCasualLeaves() {
		return casualLeaves;
	}

	public void setCasualLeaves(int casualLeaves) {
		this.casualLeaves = casualLeaves;
	}

	public int getSickLeave() {
		return sickLeave;
	}

	public void setSickLeave(int sickLeave) {
		this.sickLeave = sickLeave;
	}

	public int getOtherLeaves() {
		return otherLeaves;
	}

	public void setOtherLeaves(int otherLeaves) {
		this.otherLeaves = otherLeaves;
	}

	public void takeLeaves(Leave leave) {
		if(leave.getLeaveType()== LeaveType.CASUAL) {
			casualLeaves -= leave.leaveInDays();
			return;
		}
		if(leave.getLeaveType()== LeaveType.SICK) {
			sickLeave -= leave.leaveInDays();
			return;
		}
		if(leave.getLeaveType()== LeaveType.OTHERS) {
			otherLeaves -= leave.leaveInDays();
			return;
		}
	}
	
}
