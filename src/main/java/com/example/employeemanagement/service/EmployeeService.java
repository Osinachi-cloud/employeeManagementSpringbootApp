package com.example.employeemanagement.service;

import com.example.employeemanagement.exception.UserNotFoundException;
import com.example.employeemanagement.model.Employee;

import java.util.List;
import java.util.UUID;

public interface EmployeeService {

    public Employee addEmployee(Employee employee);

    public Employee updateEmployee(Employee employee);

    public Employee getEmployeeById(Long id);

    public List<Employee> getAllEmployees();

    public void deleteEmployeeById(Long id);
}
