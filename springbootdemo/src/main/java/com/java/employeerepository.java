package com.java;

import org.springframework.data.jpa.repository.JpaRepository;

public interface employeerepository extends JpaRepository<Employee, Long> { 
	

}
