
package com.javaproject.controller;

import com.javaproject.service.ApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/application")
public class ApplicationController {

    private final ApplicationService applicationService;

    @Autowired
    public ApplicationController(ApplicationService applicationService) {
        this.applicationService = applicationService;
    }

    @GetMapping("/verifyDocument")
    public String verifyDocument() {
        applicationService.verifyDocument();
        return "Document verification completed.";
    }

    @GetMapping("/evaluateCredit")
    public String evaluateCredit() {
        applicationService.evaluateCredit();
        return "Credit evaluation completed.";
    }
}
