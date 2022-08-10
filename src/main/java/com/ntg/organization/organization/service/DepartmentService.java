package com.ntg.organization.organization.service;

import com.ntg.organization.organization.entity.Department;
import com.ntg.organization.organization.entity.Employee;
import com.ntg.organization.organization.respository.DepartmentRepository;
import com.ntg.organization.organization.respository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DepartmentService {
    @Autowired
    private DepartmentRepository departmentRepository;
    @Autowired
    private EmployeeRepository employeeRepository;


    public List<Department> getAllDepartment() {
       return (List<Department>) departmentRepository.findAll();

    }
    public Optional<Department> getDepartmentById(long id) {
        return departmentRepository.findById(id);
    }

    public Department getDepartmentByName(String deptName) {
       return departmentRepository.findByDeptName(deptName);
    }



    public Department createNewEmployee(Department newDept) {
        if (newDept != null) {
            return departmentRepository.save(newDept);

        }
        return null;
    }

    public Boolean deleteDepartmentByID(Long id) {
        if (id != null) {
            departmentRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public Department update(Long id, String name) {

        Department department= departmentRepository.findById(id).get();
        department.setDeptName(name);
        return departmentRepository.save(department);


    }

    public Department assignemployee(Long deptId, Long empId) {
        Employee employee=employeeRepository.findById(empId).get();
        Department department=  departmentRepository.findById(deptId).get();
        department.assignEmployee(employee);
        employee.assignDepartment(department);
        employeeRepository.save(employee);
        return departmentRepository.save(department);
    }
}
