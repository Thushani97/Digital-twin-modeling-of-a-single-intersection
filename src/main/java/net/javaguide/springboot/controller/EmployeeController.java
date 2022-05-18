package net.javaguide.springboot.controller;

import net.javaguide.springboot.exception.ResourceNotFoundException;
import net.javaguide.springboot.model.Employee;
import net.javaguide.springboot.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*") // any client can access this RestAPI.
@RestController
@RequestMapping("/api/v1/employees")
public class EmployeeController {
    @Autowired
    private EmployeeRepository employeeRepository;

    @GetMapping
    // This is call as a restAPI
    public List<Employee> getAllEmployee(){
        return employeeRepository.findAll();
    }

    // Build create REST API
    @PostMapping
    public Employee createEmployee(@RequestBody Employee employee){
        return employeeRepository.save(employee);
    }

    // Build get employee by id REST API
    @GetMapping("{id}")
    public ResponseEntity<Employee> getEmployeeById( @PathVariable long id) {
        try {
            Employee employee = employeeRepository.findById(id).get();
            return ResponseEntity.ok(employee);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    //Build update employee REST API
    @PutMapping("{id}")
    public  ResponseEntity<Employee> updateEmployee(@PathVariable long id, @RequestBody Employee employeeDetails){
        // Retrieved employee object from the database using id
        Employee updateEmployee = employeeRepository.findById(id).get();
        // update the employee details using received details from client side
        updateEmployee.setFirstName(employeeDetails.getFirstName());
        updateEmployee.setLastName(employeeDetails.getLastName());
        updateEmployee.setEmailId(employeeDetails.getEmailId());

        //Save updated employee data in database
        employeeRepository.save(updateEmployee);

        // Return updated value to the UI
        return ResponseEntity.ok(updateEmployee);
    }
}
