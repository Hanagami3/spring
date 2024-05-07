package be.intecbrussel.service;

import be.intecbrussel.model.Employee;
import be.intecbrussel.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    private final EmployeeRepository er;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository er) {
        this.er = er;
    }

    //private employeeRepository employeeRepository

    @Override
    public List<Employee> getAllEmployee() {
        return er.findAll();
    }

    @Override
    public void saveEmployee(Employee employee) {
        Optional<Employee> optionalEmployee = er.findById(employee.getId());
        if (optionalEmployee.isPresent()){
            throw new IllegalStateException("Employee n°" + employee.getId() + " already exists");
        }
        er.save(employee);
    }

    public void saveEmp(Employee employee) {
        this.er.save(employee);
    }
    @Override
    public Employee getEmployeeById(Long id) {
        boolean employeePresent = er.existsById(id);
        if (!employeePresent){
            throw new IllegalStateException("Employee n°" + id + " does not exist");
        }
        return er.getById(id);
    }

    public Employee getEmpById(Long id) {
        Optional<Employee> optional=er.findById(id);
        Employee employee = null;
        if (optional.isPresent()){
            employee = optional.get();
        } else {
            throw new RuntimeException("Employee not found for id:" + id);
        }
        return employee;
    }

    @Override
    public void deleteEmployeeByID(Long id) {
        boolean employeePresent = er.existsById(id);
        if (!employeePresent){
            throw new IllegalStateException("Employee n°" + id + " does not exist");
        }
        er.deleteById(id);
    }

    public void delEmployeeById(Long id){
        this.er.deleteById(id);
    }
}
