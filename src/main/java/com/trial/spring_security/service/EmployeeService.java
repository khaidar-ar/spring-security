package com.trial.spring_security.service;

import java.util.List;
import java.util.Map;

import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.stereotype.Service;

import com.trial.spring_security.domain.Employee;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class EmployeeService {

    private Map<String, Employee> data = Map.of(
            "john", Employee.builder().name("John Wick").jobs(List.of("vice president", "manager", "ceo"))
                    .roles(List.of("read")).build(),
            "paul", Employee.builder().name("paul mc cartney").jobs(List.of("singer", "artist")).roles(List.of("write"))
                    .build());

    @PostAuthorize("returnObject.roles.contains('write')")
    public Employee getEmployeeDetails(String name) {
        log.info("service -----------------------  employee details");
        return data.get(name);
    }

}
