package com.trial.spring_security.domain;

import java.util.List;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Employee {
    private String name;
    private List<String> jobs;
    private List<String> roles;

}
