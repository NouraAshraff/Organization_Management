package com.ntg.organization.organization.controller;

import com.ntg.organization.organization.entity.Department;
import com.ntg.organization.organization.entity.Employee;
import com.ntg.organization.organization.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/dept/v1")
public class DepartmentController {
    @Autowired
    private DepartmentService departmentService;

    @GetMapping(value = ("/all"))
    public List<Department> getAllDepartment(){
        return departmentService.getAllDepartment();
    }
    @GetMapping(value = "/getById/{id}")
    public Optional<Department> getDepartmentById (@PathVariable long id){
        return  departmentService.getDepartmentById(id);
    }
    @GetMapping(value = "/getByName/{name}")
    public Department getDepartmentByName ( @PathVariable String name){

        return  departmentService.getDepartmentByName(name);
    }
    @PostMapping(value = "/add")
    public Department createNewDepartment(@RequestBody Department newDept) {
        return departmentService.createNewEmployee(newDept);
    }
    @DeleteMapping(value = "/del/{id}")
    public Boolean deleteDepartment (@PathVariable Long id){
        return departmentService.deleteDepartmentByID(id);
    }

    @PutMapping(value = "/update/{id}/{name}")
    public Department updateDepartmentName (@PathVariable Long id, @PathVariable String name){
        return departmentService.update(id,name);

    }
    @PutMapping(value = "/department/{deptId}/employee/{empId}")
    Department assignEmployeeToDepartment(@PathVariable Long deptId, @PathVariable Long empId){
        return departmentService.assignemployee(deptId,empId);
    }




}
