package be.intecbrussel.controller;

import be.intecbrussel.model.Employee;
import be.intecbrussel.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;





@Controller
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/")
    public String viewHomePage(Model model){
        model.addAttribute("listEmployees", employeeService.getAllEmployee());
        return "index";
    }

    @GetMapping("/showNewEmployeeForm")
    public String showNewEmployeeForm(Model model){
        Employee employee = new Employee();
        model.addAttribute("employee", employee);
        return "new_employee";
    }

    @PostMapping("/saveEmployee")
    public String saveEmployee(@ModelAttribute("employee") Employee employee){
        employeeService.saveEmployee(employee);
        return "redirect:/";
    }

    @GetMapping("/showFormForUpdate/{id}")
    public String showFormForUpdate(@PathVariable (value = "id") Long id, Model model){

        Employee employee = employeeService.getEmployeeById(id);

        model.addAttribute("employee", employee);
        return "update_employee";
    }

    @GetMapping("/deleteEmployee/{id}")
    public String deleteEmployee(@PathVariable (value = "id") Long id){
        this.employeeService.deleteEmployeeByID(id);
        return "redirect:/";
    }
}



/*
@RestController
@RequestMapping(path = "api/v1/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService es;

    @GetMapping
    public List<Employee> getEmployees(){
        return es.getAllEmployee();
    }

    @GetMapping(path = "{employeeId}")
    public Employee getEmployeeById(@PathVariable("employeeId") Long employeeId){
       return es.getEmployeeById(employeeId);
    }

    @PostMapping(path = "savesEmployee")
    public void registerNewEmployee(@RequestBody Employee employee){
        es.saveEmployee(employee);
    }
    @DeleteMapping(path = "{employeeId}")
    public void deleteEmployee(@PathVariable("employeeId") Long employeeId){
        es.deleteEmployeeByID(employeeId);
    }

}*/