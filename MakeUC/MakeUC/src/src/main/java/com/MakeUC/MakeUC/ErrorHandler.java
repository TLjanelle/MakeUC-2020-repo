package com.MakeUC.MakeUC;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ErrorHandler implements ErrorController {
    @GetMapping("/error")
    public String error() {
        return "Error";
    }
    @Override
    public String getErrorPath() {
        return "/error";
    }
}
