package com.shivish20.employeemanager.service;

import com.shivish20.employeemanager.exception.UserNotFoundException;
import com.shivish20.employeemanager.model.Employee;
import com.shivish20.employeemanager.repo.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

import javax.transaction.Transactional;
@Transactional
@Service
public class EmployeeService {
    private final EmployeeRepo employeeRepo;
    @Autowired
    public EmployeeService(EmployeeRepo employeeRepo) {
        this.employeeRepo = employeeRepo;
    }

    public Employee addEmployee(Employee employee)
    {
        employee.setEmployeeCode(UUID.randomUUID().toString());
        return employeeRepo.save(employee);
    }

    public List<Employee> findAllEmployees() {
        return employeeRepo.findAll();
    }
    public Employee updateEmployee(Employee employee)
    {
        return employeeRepo.save(employee);
    }

    public Employee findEmployeeById(Long id){
        return employeeRepo.findById(id).
                orElseThrow(()->new UserNotFoundException("User by id "+id+" was not found"));
    }
    public void deleteEmployee(Long id){
        employeeRepo.deleteEmployeeById( id);
    }
}
