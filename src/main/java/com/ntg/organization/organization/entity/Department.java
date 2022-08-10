package com.ntg.organization.organization.entity;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity(name = "department")
public class Department {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@Column(name = "dept_name", length = 100, nullable = false)
	private String deptName;



	@OneToMany(mappedBy = "department" ,cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Set<Employee>employees=new HashSet<>();

	public void assignEmployee(Employee employee) {
		employees.add(employee);
	}
}
