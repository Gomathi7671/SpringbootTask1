package com.example.SpringDataMongodbdemo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.example.SpringDataMongodbdemo.Repository.EmployeeRepository;
import com.example.SpringDataMongodbdemo.model.Employee;

import java.util.List;
import java.util.Optional;

@Controller
public class EmployeeController {

    @Autowired
    private EmployeeRepository employeeRepository;

    // Show form page
    @GetMapping("/add")
    public String showForm(Model model) {
        model.addAttribute("employee", new Employee());
        return "index";
    }

    // Handle form submission
    @PostMapping("/add")
    public String addEmployee(@ModelAttribute Employee employee) {
        employeeRepository.save(employee);
        return "redirect:/all";
    }

    // Show all employees in a table
    @GetMapping("/all")
    public String getAllEmployees(Model model) {
        List<Employee> employees = employeeRepository.findAll();
        model.addAttribute("employees", employees);
        return "displayAll";
    }

    // Show employee by ID
    @GetMapping("/display/{id}")
    public String getEmployeeById(@PathVariable("id") String employeeId, Model model) {
        Optional<Employee> employee = employeeRepository.findById(employeeId);
        employee.ifPresent(value -> model.addAttribute("employee", value));
        return "displayById";
    }
}
