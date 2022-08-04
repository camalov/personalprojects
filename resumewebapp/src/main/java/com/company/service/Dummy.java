package com.company.service;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.stereotype.Service;

@Service
public class Dummy {

    @PreAuthorize("hasRole('ADMIN')")
    public void foo() {
        System.out.println("foo method");
    }
}
