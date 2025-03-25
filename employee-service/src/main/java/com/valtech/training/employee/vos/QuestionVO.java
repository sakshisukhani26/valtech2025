package com.valtech.training.employee.vos;

import com.valtech.training.employee.entities.Employee;

public record QuestionVO(long id,String name,long mobile,String email,long managerId) {

	public static QuestionVO from(Employee e) {
		long manId = e.getManager()==null ? 0 : e.getManager().getId();
		return new QuestionVO(e.getId(),e.getName(),e.getMobile(),e.getEmail(),manId);
	}
	
	public Employee to(Employee manager) {
		
		Employee e = new Employee(id,name,mobile,email);
		e.setManager(manager);
		return e;
	}
}
