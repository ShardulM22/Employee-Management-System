package com.employee.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.employee.model.Employee;

import jakarta.transaction.Transactional;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
	@Modifying
    @Transactional
    @Query("UPDATE Employee e SET e.name = :name, e.age = :age, e.salary = :salary, e.dept = :dept WHERE e.id = :id")
    void updateEmployee(@Param("id") int id, @Param("name") String name, @Param("age") int age,
                        @Param("salary") double salary, @Param("dept") String dept);
}

