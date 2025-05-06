package com.sulta.spring.springboot.spring_course_springboot.dao;

import com.sulta.spring.springboot.spring_course_springboot.entity.Employee;

import java.util.List;

public interface EmployeeDAO {

    public List<Employee> getAllEmployees();

    public void saveEmployee(Employee employee);

    public Employee getEmployeeById(int id);

    void deleteEmployee(int id);

}
