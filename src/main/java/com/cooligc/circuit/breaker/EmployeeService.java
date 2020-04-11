package com.cooligc.circuit.breaker;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixException;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.concurrent.CopyOnWriteArrayList;

@Service
public class EmployeeService {

    private static final  CopyOnWriteArrayList<Employee>  EMPLOYEES = new CopyOnWriteArrayList<>();

    @PostConstruct
    public void init(){
        for (long i = 1; i <= 10; i++) {
            EMPLOYEES.add(Employee.builder().id(i).dept("Dept"+(i%4)).name("Employee"+i).build());
        }
    }


    @HystrixCommand(fallbackMethod = "getDefaultEmployee",raiseHystrixExceptions = {HystrixException.RUNTIME_EXCEPTION})
    public Employee getEmployee(Long id) {
       return EMPLOYEES.stream().filter(employee -> employee.getId().equals(id)).findAny().orElseThrow(RuntimeException::new);
    }

    public Employee getDefaultEmployee(Long id){
        System.out.println("I got invoked");
        return Employee.builder().id(id)
                .name("EMPLOYEE-INVALID")
                .dept("DEPT-INVALID")
                .build();
    }

}
