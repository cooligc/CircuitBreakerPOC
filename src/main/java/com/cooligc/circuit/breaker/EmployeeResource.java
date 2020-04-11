package com.cooligc.circuit.breaker;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/employees")
public class EmployeeResource {

    @Autowired
    private EmployeeService employeeService;


    @GetMapping("/{id}")
    public Employee getEmployee(@PathVariable("id") Long id){
        return employeeService.getEmployee(id);
    }


}
