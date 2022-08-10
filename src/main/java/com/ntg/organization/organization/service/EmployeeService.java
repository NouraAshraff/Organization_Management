package com.ntg.organization.organization.service;

import java.util.List;

import com.ntg.organization.organization.entity.Department;
import com.ntg.organization.organization.respository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ntg.organization.organization.entity.Employee;
import com.ntg.organization.organization.respository.EmployeeRepository;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;
	@Autowired
	private DepartmentRepository departmentRepository;

	public List<Employee> getAllEmployee() {

		return (List<Employee>) employeeRepository.findAll();
	}

	public Employee createNewEmployee(Employee newEmp) {
		if (newEmp != null) {
			return employeeRepository.save(newEmp);
		}
		return null;
	}

	public boolean deleteEmployeeById(Long id) {
		if (id != null) {
			employeeRepository.deleteById(id);
			return true;
		}

		return false;
	}

	public Employee getEmployeeByName(String name, String email) {
		return employeeRepository.findByNameAndEmail(name, email);
	}

    public Employee assignDept(Long empId, Long deptId) {
		Employee employee=employeeRepository.findById(empId).get();
		Department department=  departmentRepository.findById(deptId).get();
		employee.assignDepartment(department);
		return employeeRepository.save(employee);
    }
}
