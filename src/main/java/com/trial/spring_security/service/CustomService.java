package com.trial.spring_security.service;

import java.util.List;
import java.util.Map;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class CustomService {

    private Map<String, List<String>> job = Map.of(
            "john", List.of("vice president"),
            "paul", List.of("employee", "internship"));

    @PreAuthorize("hasAuthority('write')")
    public String getDetails() {
        log.info("service ------ write only");
        SecurityContext ctx = SecurityContextHolder.getContext();
        Authentication auth = ctx.getAuthentication();
        return String.format("name : %s\nauthorities : %s\n", auth.getName(), auth.getAuthorities());
    }

    @PreAuthorize("#name ==  authentication.principal.username")
    public List<String> getJobs(String name) {
        log.info("service ----------------------- get-jobs");
        return job.get(name);
    }

}
