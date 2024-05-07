package be.intecbrussel.service;

import be.intecbrussel.model.Employee;

import java.util.List;

public interface EmployeeService {

    List<Employee> getAllEmployee();
    void saveEmployee (Employee employee);
    Employee getEmployeeById(Long id);

    void deleteEmployeeByID(Long id);
}
