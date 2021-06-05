package com.CRUDEmployee.springboot.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.CRUDEmployee.springboot.model.Employee;
import com.CRUDEmployee.springboot.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	private EmployeeRepository employerepository;
	
	@Override
	public List<Employee> getAllEmployees() {
		return employerepository.findAll();		
	}
	
	@Override
	public void saveEmployee(Employee employee) {
		this.employerepository.save(employee);
	}

	@Override
	public Employee getEmployeeById(long id) {
		Optional<Employee> optional = employerepository.findById(id);
		Employee employee = null;
		if(optional.isPresent())
		{
			employee = optional.get();
		}
		else
		{
			throw new RuntimeException("Employee Not Found"+id);
		}
		return employee;
	}

	@Override
	public void deleteEmployeeById(long id) {
		this.employerepository.deleteById(id);		
	}

}
