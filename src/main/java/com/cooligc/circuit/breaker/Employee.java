package com.cooligc.circuit.breaker;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Builder
public class Employee {
    private Long id;
    private String name;
    private String dept;
}
